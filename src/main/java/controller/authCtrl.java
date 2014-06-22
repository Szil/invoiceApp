package controller;

import com.avaje.ebean.Ebean;
import model.user;

import javax.swing.*;

/**
 * Created by Gergo on 2014.06.21..
 */
public class authCtrl extends session{

    /* --- Components --- */
    private JOptionPane badLoginDiag = new JOptionPane();
    private session newSession = new session();

    /* --- Login --- */

    public session loginUser(String uName, String uPass) {
        newSession.currentUser = authUser(uName, uPass);
        if(newSession.currentUser == null) {
            badLoginDiag.showMessageDialog(null, "Hibás felhasználó név vagy jelszó!", "", JOptionPane.WARNING_MESSAGE);
        } else {
            return newSession;
        }
        return null;
    }

    public user authUser(String uName, String uPass){
        return Ebean.find(user.class).
                where()
                    .eq("email", uName)
                    .eq("password", uPass)
                    .findUnique();
    }

    public session getNewSession() {
        return newSession;
    }
}
