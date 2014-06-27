package model;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Created by Gergo on 2014.06.27..
 */
public class InvoiceDetails {

    private double adoAlap;
    private double ado;
    private double brutto;
    private double ossz;
    private Currency prodCurrency;
    private Currency InvoiceCurrency;
    private double currentTaxP;
    private DefaultTableModel osszTableModel;

    public double getAdoAlap() {
        return adoAlap;
    }

    public void setAdoAlap(double adoAlap) {
        this.adoAlap = adoAlap;
    }

    public double getAdo() {
        return ado;
    }

    public void setAdo(double ado) {
        this.ado = ado;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

    public double getOssz() {
        return ossz;
    }

    public void setOssz(double ossz) {
        this.ossz = ossz;
    }

    public Currency getProdCurrency() {
        return prodCurrency;
    }

    public void setProdCurrency(Currency prodCurrency) {
        this.prodCurrency = prodCurrency;
    }

    public Currency getInvoiceCurrency() {
        return InvoiceCurrency;
    }

    public void setInvoiceCurrency(Currency invoiceCurrency) {
        InvoiceCurrency = invoiceCurrency;
    }

    public double getCurrentTaxP() {
        return currentTaxP;
    }

    public void setCurrentTaxP(double currentTaxP) {
        this.currentTaxP = currentTaxP;
    }

    public InvoiceDetails() {
    }

    public InvoiceDetails(Invoice invoice) {
        this.setInvoiceCurrency(invoice.getCurrency());
        List<Products> productsList = invoice.getProductsList();
        for (Products p : productsList) {
            Product item = p.getProdId();

        }
    }
}
