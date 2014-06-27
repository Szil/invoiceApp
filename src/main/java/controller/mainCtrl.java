package controller;

import com.avaje.ebean.EbeanServer;
import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * Created by Gergo on 2014.06.22..
 */
public class MainCtrl implements Runnable {

    protected EbeanServer defServer;
    protected InvoiceMain mWindow;
    protected SzamlaKeszitesDialog szamlaDialog;
    protected NewKiallDialog newKiallDialog;
    protected SztornozasDialog sztornoDialog;
    protected User currentUser;
    protected Invoice currentInvoice;
    protected List<Product> currentProdList;
    protected List<Invoice> invoices;
    protected List<Currency> currencyList;
    protected List<Object> invProducts;
    protected Products prodToAdd;
    protected Vector<Vector<Object>> tableModel;

    protected UjTetel ujTetel;
    protected UjTetelDialog ujTetelDialog;

    public MainCtrl(EbeanServer defServer, InvoiceMain view) {
        this.defServer = defServer;
        this.mWindow = view;
        run();
    }

    @Override
    public void run() {
        mWindow.showWindow();
        mWindow.addLoginListener(new LoginListener());
        mWindow.addBtnListener(new MWbtnListener());
        currencyList = getCurrencies();

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
        return defServer.find(Product.class).findList();
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
            currentUser = authUser(mWindow.getLoginName(), mWindow.getLoginPass());
            if (currentUser != null) {
                mWindow.setTxtLoginInfo("Belépve, mint: " + currentUser.getName());
                mWindow.applyRole(String.valueOf(currentUser.getU_role()));
            } else {
                mWindow.showWarningDialog("Sikertelen belépés!");
            }
        }
    }

    class MWbtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();

            switch (source) {
                case "btnUjSzla":
                    szamlaDialog = new SzamlaKeszitesDialog(mWindow, mWindow.isRootCheckingEnabled());
                    szamlaDialog.addSzamlazasListener(new SzamlaKeszitoListener());
                    szamlaDialog.fillCurrencies(currencyList);
                    szamlaDialog.fillCBKiallito(getOrganisations());
                    szamlaDialog.fillCBPartner(getPartners());
                    szamlaDialog.setTxtSzlaSzam(String.valueOf(getNewInvoiceID()));
                    szamlaDialog.setVisible(true);
                    break;
                case "btnFrissit":

                    break;
                case "btnUjKiallito":
                    newKiallDialog = new NewKiallDialog(mWindow, mWindow.isRootCheckingEnabled());
                    newKiallDialog.addUjKiallitoListener(new UjKiallitoDialogListener());
                    newKiallDialog.setVisible(true);
                    break;
                case "miKilepes":
                    mWindow.showKilepesPromt();
                    break;
                case "btnSztorno":
                    sztornoDialog = new SztornozasDialog(mWindow, mWindow.isRootCheckingEnabled());
                    sztornoDialog.setVisible(true);
                    break;
                case "miUjSzamla":
                    szamlaDialog = new SzamlaKeszitesDialog(mWindow, mWindow.isRootCheckingEnabled());
                    szamlaDialog.addSzamlazasListener(new SzamlaKeszitoListener());
                    szamlaDialog.setVisible(true);
                    break;
            }
        }
    }

    class UjKiallitoDialogListener implements ActionListener {
        Organisation newOrganisation;

        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();

            switch (source) {
                case "btnMentes":
                    newOrganisation = newKiallDialog.getSortOfValidatedData();
                    if (newOrganisation == null) {
                        newKiallDialog.showInfoDialog("Mezők kitöltése kötelező");
                    } else if (defServer.find(Organisation.class).where().eq("taxId", newOrganisation.getTaxId()).findUnique() != null) {
                        newKiallDialog.showInfoDialog("A cég már létezik!");
                    } else {
                        defServer.save(newOrganisation);
                        mWindow.setLbInfoBar("Új kiállitó hozzáadva, " + newOrganisation.getName() + "!");
                        newKiallDialog.disposeKiallDialog();
                    }
                    break;
                case "btnMegse":
                    newKiallDialog.disposeKiallDialog();
                    break;
            }
        }
    }

    /*class ProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();

            switch (source) {
                case "btnUjTermek":
                    ujTetelDialog = new UjTetelDialog(mWindow, true);
                    ujTetelDialog.addUjTetelListener(new UjTetelListener());
                    ujTetelDialog.setVisible(true);
                    break;
                case "ccbTermekek":
                    System.out.println(ujTetel.getUjTetel());
                    break;
                case "buttonOK":

                    break;
            }
        }
    }*/

    class UjTetelListener implements ActionListener {
        Product product;

        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();

            switch (source) {
                case "btnMentes":
                    product = ujTetelDialog.getSortOfValidatedData();
                    if (product == null) {
                        ujTetelDialog.showInfoDialog("Mezők kitöltése kötelező");
                    } else if (defServer.find(Product.class).where().eq("sku", product.getSku()).findUnique() != null) {
                        ujTetelDialog.showInfoDialog("Termék ezzel a cikkszámmal már létezik");
                    } else {
                        defServer.save(product);
                        currentProdList.add(product);
                        mWindow.setLbInfoBar("Új terméket hozzáadva, " + product.getProdName());
                        ujTetelDialog.disposeTetelDialog();
                        ujTetel.fillTermekBox(currentProdList);
                    }
                    break;
                case "btnMegse":
                    ujTetelDialog.disposeTetelDialog();
                    break;
            }
        }
    }

    class SzamlaKeszitoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();

            switch (source) {
                case "btnUjTetel":
                    ujTetel = new UjTetel(szamlaDialog);
                    ujTetel.addUjTetelListener(new NewProdListener());
                    currentProdList = getProductList();
                    ujTetel.fillTermekBox(currentProdList);
                    ujTetel.showUjTetel();
                    break;
            }
        }
    }

    class NewProdListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();

            switch (source) {
                case "btnAddTermek":
                    ujTetelDialog = new UjTetelDialog(mWindow, true);
                    ujTetelDialog.addUjTetelListener(new UjTetelListener());
                    ujTetelDialog.fillCurrencies(currencyList);
                    ujTetelDialog.setVisible(true);
                    break;
                case "ccbTermekek":

                    break;
                case "btnOK":
                    Vector<Object> lcPr = new Vector<>();
                    prodToAdd = ujTetel.getUjTetel();
                    Formatter prettyString = new Formatter();
                    Product prod = prodToAdd.getProdId();
                    double netto = prod.getUnitPrice() * prodToAdd.getQuantity();
                    lcPr.add(prod.getSku());
                    lcPr.add(prod.getProdName());
                    lcPr.add(String.valueOf(prodToAdd.getQuantity()) + prod.getUnitOfMeasure());
                    lcPr.add(prettyString.prettyPrintDouble(prod.getUnitPrice()));
                    lcPr.add(prettyString.prettyPrintDouble(netto));
                    lcPr.add(prettyString.prettyPrintDouble("##%", prod.getTax_Percent()));
                    lcPr.add(prettyString.prettyPrintDouble(netto * prod.getTax_Percent()));
                    lcPr.add(prettyString.prettyPrintDouble(netto * (prod.getTax_Percent() + 1)));
                    //tableModel.add(lcPr);

                    //invProducts.add(prodToAdd);
                    szamlaDialog.addTetelToTable(lcPr);
                    ujTetel.disposeUjTetel();
                    break;
                case "btnCancel":
                    ujTetel.disposeUjTetel();
                    break;
            }
        }
    }
}