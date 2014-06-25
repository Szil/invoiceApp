package controller;

import com.avaje.ebean.EbeanServer;
import model.Invoice;
import model.Organisation;
import model.Product;
import model.User;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    protected AddProduct addProductDialog;
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
    }

    public User authUser(String uName, String uPass) {
        return defServer.find(User.class).
                where()
                .eq("email", uName)
                .eq("password", uPass)
                .findUnique();
    }

    public List<Invoice> getInvoiceList() {
        List<Invoice> invoices = defServer.find(Invoice.class).findList();
        return invoices;
    }

    public List<Product> getProductList() {
        List<Product> productList = defServer.find(Product.class).findList();
        return productList;
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

    class ProductListener implements ActionListener {
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

                    break;
                case "buttonOK":

                    break;
            }
        }
    }

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
                        addProductDialog.fillTermekBox(currentProdList);
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
            System.out.println(source);
            switch (source) {
                case "btnUjTetel":
                    addProductDialog = new AddProduct(mWindow);
                    addProductDialog.addProductListener(new ProductListener());
                    currentProdList = getProductList();
                    addProductDialog.fillTermekBox(currentProdList);
                    addProductDialog.showDialog(null);
                    break;
            }
        }
    }
}