package controller;

import com.avaje.ebean.EbeanServer;
import model.*;
import view.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Gergo on 2014.06.22..
 */
public class MainCtrl implements Runnable {

    protected EbeanServer defServer;
    protected MainWindow mainWindow;
    protected NewInvoice newInvoiceDialog;
    protected NewOrganisation newOrgDialog;
    protected SztornozasDialog sztornoDialog;
    protected User currentUser;
    protected List<Invoice> invoices;
    protected InvoiceDetails invoiceDetail;
    protected List<Product> currentProdList;
    protected List<Currency> currencyList;
    protected Products prodToAdd;
    protected Invoice cInvoice;

    protected NewProducts newProductsDialog;
    protected NewProduct newProductDialog;

    Component asd;
    MouseMotionListener mml;
    ToolTipManager ttp;

    public MainCtrl(EbeanServer defServer, MainWindow view) {
        this.defServer = defServer;
        this.mainWindow = view;
        run();
    }

    @Override
    public void run() {
        mainWindow.showWindow();
        mainWindow.addLoginListener(new LoginListener());
        mainWindow.addBtnListener(new MainWindowListener());
        currencyList = getCurrencies();
        ttp = ToolTipManager.sharedInstance();
        ttp.setInitialDelay(0);
        ttp.setReshowDelay(0);
    }

    public User authUser(String uName, String uPass) {
        return defServer.find(User.class).
                where()
                .eq("email", uName)
                .eq("password", uPass)
                .findUnique();
    }

    public List<Invoice> getInvoiceList() {
        invoices = defServer.find(Invoice.class).findList();
        return invoices;
    }

    public Integer getNewInvoiceID() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        Integer idbase = Integer.parseInt(dateFormat.format(date));
        Integer offset = 10000;
        Integer posID = offset * idbase + 1;
        List<Invoice> invoiceList = defServer.find(Invoice.class).findList();
        List<Invoice> query = defServer.filter(Invoice.class).sort("invoiceId desc").ge("invoiceId", posID).maxRows(3).filter(invoiceList);
        if (query.isEmpty()) {
            return posID;
        } else {
            Invoice lastInv = Collections.max(invoiceList);
            if (posID - lastInv.getInvoiceId() <= 0) return lastInv.getInvoiceId() + 1;
            else {
                return posID;
            }
        }
    }


    public List<Product> getProductList() {
        return defServer.find(Product.class).orderBy("prodName").findList();
    }

    public List<Currency> getCurrencies() {
        return defServer.find(Currency.class).findList();
    }

    public List<Organisation> getOrganisations() {
        return defServer.find(Organisation.class).findList();
    }

    public List<Partner> getPartners() {
        return defServer.find(Partner.class).findList();
    }

    // View listeners

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentUser = authUser(mainWindow.getLoginName(), mainWindow.getLoginPass());
            if (currentUser != null) {
                mainWindow.setTxtLoginInfo("Belépve, mint: " + currentUser.getName());
                mainWindow.applyRole(String.valueOf(currentUser.getU_role()));
            } else {
                mainWindow.showWarningDialog("Sikertelen belépés!");
            }
        }
    }

    class MainWindowListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();

            switch (source) {
                case "btnUjSzla":
                    newInvoiceDialog = new NewInvoice(mainWindow, mainWindow.isRootCheckingEnabled());
                    newInvoiceDialog.addSzamlazasListener(new NewInvoiceListener());
                    newInvoiceDialog.addTableListener(new InvoiceDetailsListener());
                    newInvoiceDialog.fillCurrencies(currencyList);
                    newInvoiceDialog.fillCBKiallito(getOrganisations());
                    newInvoiceDialog.fillCBPartner(getPartners());
                    Integer ujazon = getNewInvoiceID();
                    cInvoice = new Invoice(ujazon);
                    invoiceDetail = new InvoiceDetails();
                    newInvoiceDialog.setTxtSzlaSzam(String.valueOf(ujazon));
                    newInvoiceDialog.setVisible(true);
                    break;
                case "btnFrissit":

                    break;
                case "btnUjKiallito":
                    newOrgDialog = new NewOrganisation(mainWindow, mainWindow.isRootCheckingEnabled());
                    newOrgDialog.addUjKiallitoListener(new NewOrganisationListener());
                    newOrgDialog.setVisible(true);
                    break;
                case "miKilepes":
                    mainWindow.showKilepesPromt();
                    break;
                case "btnSztorno":
                    sztornoDialog = new SztornozasDialog(mainWindow, mainWindow.isRootCheckingEnabled());
                    sztornoDialog.setVisible(true);
                    break;
                case "miUjSzamla":
                    newInvoiceDialog = new NewInvoice(mainWindow, mainWindow.isRootCheckingEnabled());
                    newInvoiceDialog.addSzamlazasListener(new NewInvoiceListener());
                    newInvoiceDialog.setVisible(true);
                    break;
            }
        }
    }

    class NewInvoiceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            final String source = e.getActionCommand();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    switch (source) {
                        case "btnUjTetel":
                            newProductsDialog = new NewProducts(newInvoiceDialog);
                            newProductsDialog.addUjTetelListener(new NewProductsListener());
                            currentProdList = getProductList();
                            newProductsDialog.fillTermekBox(currentProdList);
                            newProductsDialog.showUjTetel();
                            break;
                        case "ccbOrg":
                            newInvoiceDialog.fillOrgData(newInvoiceDialog.getSelectedOrg());
                            break;
                        case "ccbPartner":
                            newInvoiceDialog.fillPartnerData(newInvoiceDialog.getSelectedPartner());
                            break;
                        case "ccbPenznemek":
                            invoiceDetail.setInvoiceCurrency(newInvoiceDialog.getSelectedCurrency());
                            break;
                    }
                }
            });
        }
    }

    //Tételek tábla figyelője -> változik -> új összesités
    class InvoiceDetailsListener implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent e) {
            invoiceDetail.addSubTotal(invoiceDetail.getCurrentProducts());
            newInvoiceDialog.setTblOssz(invoiceDetail.getSummaryTableData());
            newInvoiceDialog.setTxtOsszesen(String.valueOf(invoiceDetail.getPrettySubTotal()));

        }
    }

    class NewOrganisationListener implements ActionListener {
        Organisation newOrganisation;

        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();

            switch (source) {
                case "btnMentes":
                    newOrganisation = MainCtrl.this.newOrgDialog.getSortOfValidatedData();
                    if (newOrganisation == null) {
                        MainCtrl.this.newOrgDialog.showInfoDialog("Mezők kitöltése kötelező");
                    } else if (defServer.find(Organisation.class).where().eq("taxId", newOrganisation.getTaxId()).findUnique() != null) {
                        MainCtrl.this.newOrgDialog.showInfoDialog("A cég már létezik!");
                    } else {
                        defServer.save(newOrganisation);
                        mainWindow.setLbInfoBar("Új kiállitó hozzáadva, " + newOrganisation.getName() + "!");
                        MainCtrl.this.newOrgDialog.disposeKiallDialog();
                    }
                    break;
                case "btnMegse":
                    MainCtrl.this.newOrgDialog.disposeKiallDialog();
                    break;
            }
        }
    }

    class NewProductListener implements ActionListener {
        Product product;

        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();

            switch (source) {
                case "btnMentes":
                    product = newProductDialog.getSortOfValidatedData();
                    if (product == null) {
                        newProductDialog.showInfoDialog("Mezők kitöltése kötelező");
                    } else if (defServer.find(Product.class).where().eq("sku", product.getSku()).findUnique() != null) {
                        newProductDialog.showInfoDialog("Termék ezzel a cikkszámmal már létezik");
                    } else {
                        defServer.save(product);
                        currentProdList.add(product);
                        mainWindow.setLbInfoBar("Új terméket hozzáadva, " + product.getProdName());
                        newProductDialog.disposeTetelDialog();
                        newProductsDialog.fillTermekBox(currentProdList);
                    }
                    break;
                case "btnMegse":
                    newProductDialog.disposeTetelDialog();
                    break;
            }
        }
    }


    class NewProductsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            final String source = e.getActionCommand();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    switch (source) {
                        case "btnAddTermek":
                            newProductDialog = new NewProduct(mainWindow, true);
                            newProductDialog.addUjTetelListener(new NewProductListener());
                            newProductDialog.fillCurrencies(currencyList);
                            newProductDialog.setVisible(true);
                            break;
                        case "ccbTermekek":

                            break;
                        case "btnOK":
                            newInvoiceDialog.addTetelToTable(invoiceDetail.addProductToTable(newProductsDialog.getUjTetel()));
                            newProductsDialog.disposeUjTetel();
                            break;
                        case "btnCancel":
                            newProductsDialog.disposeUjTetel();
                            break;
                    }
                }
            });

        }
    }

}