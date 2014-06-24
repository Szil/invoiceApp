package controller;

import com.avaje.ebean.EbeanServer;
import model.user;
import view.InvoiceMain;
import view.NewKiallDialog;
import view.SzamlaKeszitesDialog;
import view.SztornozasDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Gergo on 2014.06.22..
 */
public class MainCtrl implements Runnable {

    protected EbeanServer defServer;
    protected InvoiceMain mWindow;
    protected SzamlaKeszitesDialog szamlaDialog;
    protected NewKiallDialog newKiallDialog;
    protected SztornozasDialog sztornoDialog;
    protected user currentUser;

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

    public user authUser(String uName, String uPass) {
        return defServer.find(user.class).
                where()
                .eq("email", uName)
                .eq("password", uPass)
                .findUnique();
    }

    class LoginListener implements ActionListener {
        private AuthCtrl login;

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
                    szamlaDialog.setVisible(true);
                    break;
                case "btnFrissit":
                    mWindow.showWarningDialog("Frissit");
                    break;
                case "btnUjKiallito":
                    newKiallDialog = new NewKiallDialog(mWindow, mWindow.isRootCheckingEnabled());
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
                    szamlaDialog.setVisible(true);
                    break;
            }
        }
    }
}