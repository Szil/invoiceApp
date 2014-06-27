package model;

import controller.Formatter;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
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
    private DefaultTableModel tetelekModel;
    private List<Object> tetelRow;
    private List<Products> productsList;

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

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

    public List<Object> getTetelRow() {
        return tetelRow;
    }

    public InvoiceDetails() {
        productsList = new ArrayList<>();
    }

    public InvoiceDetails(Currency invoiceCurrency) {
        InvoiceCurrency = invoiceCurrency;
        productsList = new ArrayList<>();
    }

    public InvoiceDetails(Invoice invoice) {
        osszTableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"27%", null, null, null},
                        {"ÁFA részletezése:", null, null, null}
                },
                new String[]{
                        "Összesen:", "ÁFA alap", "ÁFA összege", "Bruttó érték"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };

        tetelekModel = new DefaultTableModel(new Object[][]{}, new String[]{"Cikkszám", "Megnevezés", "Mennyiség / Egys.", "Egységár", "Nettó", "ÁFA%", "ÁFA", "Bruttó"});
        this.setInvoiceCurrency(invoice.getCurrency());
        List<Products> productsList = invoice.getProductsList();
        for (Products p : productsList) {
            Product item = p.getProdId();

        }
    }

    public void addProduct(Products pr) {
        tetelRow = new ArrayList<>();
        productsList.add(pr);
        Formatter prettyString = new Formatter();
        Product prod = pr.getProdId();
        double netto = prod.getUnitPrice() * pr.getQuantity();
        tetelRow.add(prod.getSku());
        tetelRow.add(prod.getProdName());
        tetelRow.add(String.valueOf(pr.getQuantity()) + prod.getUnitOfMeasure());
        tetelRow.add(prettyString.prettyPrintDouble(prod.getUnitPrice()));
        tetelRow.add(prettyString.prettyPrintDouble(netto));
        tetelRow.add(prettyString.prettyPrintDouble("##%", prod.getTax_Percent()));
        tetelRow.add(prettyString.prettyPrintDouble(netto * prod.getTax_Percent()));
        tetelRow.add(prettyString.prettyPrintDouble(netto * (prod.getTax_Percent() + 1)));
    }

}
