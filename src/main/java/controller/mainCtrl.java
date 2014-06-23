package controller;

import com.avaje.ebean.EbeanServer;
import model.user;
import view.InvoiceMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Gergo on 2014.06.22..
 */
public class MainCtrl implements Runnable {

    protected EbeanServer defServer;
    protected InvoiceMain mWindow;
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
                    mWindow.showWarningDialog("Új számla");
                    break;
                case "btnFrissit":
                    mWindow.showWarningDialog("Frissit");
                    break;
            }
        }
    }
}