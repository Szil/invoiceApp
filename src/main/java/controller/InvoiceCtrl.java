package controller;

/**
 * Created by Gergo on 2014.06.21..
 */
public class InvoiceCtrl {

    private static InvoiceCtrl instance = null;

    protected InvoiceCtrl() {
    }

    public static InvoiceCtrl getInstance() {
        if (instance == null) {
            instance = new InvoiceCtrl();
        }
        return instance;
    }


}
