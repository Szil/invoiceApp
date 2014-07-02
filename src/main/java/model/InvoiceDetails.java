package model;

import controller.CurrencyConverter;
import controller.Formatter;

import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * Created by Gergo on 2014.06.27..
 *
 * Számla tételei és összesitett nyilvántartásához.
 */
public class InvoiceDetails {

    // Összesitett értékek - számla pénzneméhez igazitva
    private double osszAdoAlap;
    private double osszAdo;
    private double osszBrutto;
    private double osszesen;
    private double rate;

    // Számla részletei
    //Állitsad befele mielött meghivod!
    private Currency InvoiceCurrency = null;

    private double currentTaxP;

    //Table modellek..
    private DefaultTableModel summaryTableData;
    private DefaultTableModel tetelekModel;


    private List<Object> tetelRow;

    //Összesitéshez
    private Map<Integer, Double> taxMap;

    //Tételek nyilvántartása
    private List<Products> productsList;

    //Tételek TableModel
    private List<Object> tetelekTableRows;
    private String[] tetelekTableHeader = new String[]{"Cikkszám", "Megnevezés", "Mennyiség / Egys.", "Egységár", "Nettó", "ÁFA%", "ÁFA", "Bruttó"};

    //OsszesTableModel
    private List<Object[]> summaryTableRows;
    private Object[] summaryTableHeader = new Object[]{"Összesen:", "ÁFA alap", "ÁFA összege", "Bruttó érték"};
    private List<Double[]> numericSummaryData;
    private String prettySubTotal;
    /*
    Osszesito table mapping:
    0 - afakulcs
    1 - adoalap
    2 - ado
    3 - brutto
     */
    Products currentProducts;

    public Products getCurrentProducts() {
        return currentProducts;
    }

    public DefaultTableModel getSummaryTableData() {
        return summaryTableData;
    }

    public DefaultTableModel getTetelekModel() {
        return tetelekModel;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public double getOsszAdoAlap() {
        return osszAdoAlap;
    }

    public void setOsszAdoAlap(double osszAdoAlap) {
        this.osszAdoAlap = osszAdoAlap;
    }

    public double getOsszAdo() {
        return osszAdo;
    }

    public void setOsszAdo(double osszAdo) {
        this.osszAdo = osszAdo;
    }

    public double getOsszBrutto() {
        return osszBrutto;
    }

    public void setOsszBrutto(double osszBrutto) {
        this.osszBrutto = osszBrutto;
    }

    public double getOsszesen() {
        return osszesen;
    }

    public void setOsszesen(double osszesen) {
        this.osszesen = osszesen;
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

    public String getPrettySubTotal() {
        return prettySubTotal;
    }

    public InvoiceDetails() {
        productsList = new ArrayList<>();
        taxMap = new HashMap<>();
        numericSummaryData = new ArrayList<>();
        //numericSummaryData.add(new Double[]{0.27, 0.0, 0.0, 0.0});
        numericSummaryData.add(new Double[]{null, 0.0, 0.0, 0.0});
        summaryTableRows = new ArrayList<>();
    }

    public InvoiceDetails(Currency invoiceCurrency) {
        InvoiceCurrency = invoiceCurrency;
        productsList = new ArrayList<>();
        taxMap = new HashMap<>();
        numericSummaryData = new ArrayList<>();
        //numericSummaryData.add(new Double[]{0.27, 0.0, 0.0, 0.0});
        numericSummaryData.add(new Double[]{null, 0.0, 0.0, 0.0});
        summaryTableRows = new ArrayList<>();
    }

    //TODO: Számla szerint Details generálás
    public InvoiceDetails(Invoice invoice) {
        summaryTableData = new javax.swing.table.DefaultTableModel(
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

    //Új tétel hozzáadása a táblázathoz
    public List<Object> addProductToTable(Products pr) {
        currentProducts = pr;
        List<Object> row = new ArrayList<>();
        Product actProduct;
        Formatter prettyString = new Formatter();
        CurrencyConverter CRate = new CurrencyConverter();
        //
        // TODO: Áfakulcs számolása mappelve 50%
        actProduct = pr.getProdId();
        this.rate = CRate.getCurrencyFromYahoo(actProduct.getCurrency(), getInvoiceCurrency());
        System.out.println(rate);
        double netto = (actProduct.getUnitPrice() * rate) * pr.getQuantity();
        osszAdoAlap += netto;
        row.add(actProduct.getSku());
        row.add(actProduct.getProdName());
        row.add(prettyString.prettyPrintProductMeasure(actProduct, pr.getQuantity()));
        row.add(prettyString.prettyPrintCurrency(actProduct.getCurrency(), actProduct.getUnitPrice()));
        row.add(prettyString.prettyPrintCurrency(getInvoiceCurrency(), netto));
        row.add(prettyString.prettyPrintDouble("##%", actProduct.getTax_Percent()));
        double ado = netto * actProduct.getTax_Percent();
        this.osszAdo += ado;
        row.add(prettyString.prettyPrintCurrency(getInvoiceCurrency(), ado));
        double brutto = netto * (actProduct.getTax_Percent() + 1);
        this.osszBrutto += brutto;
        this.prettySubTotal = prettyString.prettyPrintCurrency(getInvoiceCurrency(), this.osszBrutto);
        row.add(prettyString.prettyPrintCurrency(getInvoiceCurrency(), brutto));
        return row;
    }

    //Ne hivd meg mielött nincs Invoice Currency NERD
    public void fillTetelekRows(List<Products> productsList) {
        List<Object> row = new ArrayList<>();
        Product actProduct;
        Formatter prettyString = new Formatter();
        CurrencyConverter CRate = new CurrencyConverter();
        for (Products products : productsList) {
            currentProducts = products;
            // TODO: Áfakulcs számolása mappelve 50%
            actProduct = products.getProdId();
            this.rate = CRate.getCurrencyFromYahoo(actProduct.getCurrency(), getInvoiceCurrency());
            double netto = (actProduct.getUnitPrice() * rate) * products.getQuantity();
            this.osszAdoAlap += netto;
            row.add(actProduct.getSku());
            row.add(actProduct.getProdName());
            row.add(prettyString.prettyPrintProductMeasure(actProduct, products.getQuantity()));
            row.add(prettyString.prettyPrintCurrency(getInvoiceCurrency(), actProduct.getUnitPrice() * rate));
            row.add(prettyString.prettyPrintCurrency(getInvoiceCurrency(), netto));
            row.add(prettyString.prettyPrintDouble("##%", actProduct.getTax_Percent()));
            double ado = netto * actProduct.getTax_Percent();
            this.osszAdo += ado;
            row.add(prettyString.prettyPrintCurrency(getInvoiceCurrency(), ado));
            double brutto = netto * (actProduct.getTax_Percent() + 1);
            this.osszBrutto += brutto;
            row.add(prettyString.prettyPrintCurrency(getInvoiceCurrency(), brutto));
            tetelekTableRows.add(row.toArray());
        }
    }

    public void addSubTotal(Products products) {
        Product p = products.getProdId();
        double taxP = p.getTax_Percent();
        // Ha tartalmaz már ilyen kulcsot ->
        if (taxMap != null) {
            System.out.println("taxMap not null");
            if (taxMap.containsValue(taxP)) {
                System.out.println("taxpercentmapping contains taxP");
                // kulcshoz tartozó sor megkeresése
                for (int i = 0; i < taxMap.size(); i++) {
                    // kulcshoz tartozó sor frissitése
                    if (taxMap.get(i).equals(taxP)) {
                        Double[] updateRow = numericSummaryData.get(i);
                        double netto = (p.getUnitPrice() * rate) * products.getQuantity();
                        updateRow[1] += netto;
                        updateRow[2] += netto * p.getTax_Percent();
                        updateRow[3] += netto * (p.getTax_Percent() + 1);
                        numericSummaryData.set(i, updateRow);
                        System.out.println("kulcshoz tartozo sor update - " + updateRow);
                    } else return;
                }
                // összesitő sor frissitése
                int lastIndex = numericSummaryData.size() - 1;
                Double[] summarySum = numericSummaryData.get(lastIndex);
                for (int i = 0; i < numericSummaryData.size() - 1; i++) {
                    Double[] row = numericSummaryData.get(i);
                    summarySum[1] += row[1];
                    summarySum[2] += row[2];
                    summarySum[3] += row[3];
                    System.out.println("osszesito sor frissitese " + summarySum);
                }
                numericSummaryData.set(lastIndex, summarySum);
            } else {
                System.out.println("nincs ilyen taxP a mappingban");
                // HA nincs ilyen kulcs még a táblázatban
                Collection mapVal = taxMap.values();
                List<Double> values = new ArrayList<>();
                values.addAll(mapVal);
                values.add(taxP);
                Collections.sort(values);
                int vsize = values.size();
                Double[] newRow = new Double[4];
                System.out.println("for vsize: " + vsize);
                for (int i = 0; i < vsize; i++) {
                    if (values.get(i).equals(taxP)) {
                        double netto = (p.getUnitPrice() * rate) * products.getQuantity();
                        System.out.println("else - nincs ilyen sor " + netto);
                        newRow[0] = p.getTax_Percent();
                        //System.out.println(newRow[0]);
                        newRow[1] = netto;
                        //System.out.println(newRow[1]);
                        newRow[2] = netto * p.getTax_Percent();
                        //System.out.println(newRow[2]);
                        newRow[3] = netto * (p.getTax_Percent() + 1);
                        System.out.println(newRow[3]);
                    }
                }
                //Osszesito table rendezese
                System.out.println("lista rendezes");
                int s = numericSummaryData.size() - 1;
                Double[] lastrow = numericSummaryData.get(s);
                //TODO: nem is volt utolsó sor. kéne
                for (Double r : lastrow) {
                    System.out.println("utolso sor: " + r);
                }
                numericSummaryData.remove(s);
                numericSummaryData.add(newRow);
                ListIterator it = numericSummaryData.listIterator();
                int in = 0;
                //Lista rendezése

                while (it.hasNext()) {
                    //System.out.println("while it has next");

                    Double[] one = numericSummaryData.get(in);
                    Double[] two = (Double[]) it.next();
                    if (one[0] > two[0]) {
                        numericSummaryData.set(numericSummaryData.size() - 1, one);
                        //System.out.println("insert last");
                    } else in++;

                }
                //map frissitese
                int mapkey = 0;
                taxMap.clear();
                for (Double[] tm : numericSummaryData) {
                    taxMap.put(mapkey, tm[0]);
                    mapkey++;
                }
                numericSummaryData.add(lastrow);
            }
        }
        setSummaryTableData();
    }

    public void setSummaryTableData() {
        summaryTableRows.clear();
        Formatter form = new Formatter();
        Object[] prettyRow = new Object[4];
        for (Double[] row : numericSummaryData) {
            if (row[0] != null) {
                prettyRow[0] = form.prettyPrintDouble("##%", row[0]);
            } else {
                prettyRow[0] = null;
            }
            //System.out.println("taxrow " +row[0] + "  " + prettyRow[0]);
            prettyRow[1] = form.prettyPrintDouble(row[1]);
            //System.out.println("taxsummaryrow 1 " + prettyRow[1]);
            prettyRow[2] = form.prettyPrintDouble(row[2]);
            //System.out.println("taxsummaryrow 2 " + prettyRow[2]);
            prettyRow[3] = form.prettyPrintDouble(row[3]);
            //System.out.println("taxsummaryrow 3 " + prettyRow[3]);
            summaryTableRows.add(prettyRow);
        }
        int pos = numericSummaryData.size() - 1;
        Double[] lastrow = numericSummaryData.get(pos);
        Object[] prettyLastRow = new Object[4];
        prettyLastRow[0] = "Összesen: ";
        prettyLastRow[1] = form.prettyPrintDouble(lastrow[1]);
        prettyLastRow[2] = form.prettyPrintDouble(lastrow[2]);
        prettyLastRow[3] = form.prettyPrintDouble(lastrow[3]);
        summaryTableRows.add(summaryTableRows.size(), prettyLastRow);
        this.summaryTableData = new DefaultTableModel(new Object[][]{}, summaryTableHeader);

        for (Object[] row : summaryTableRows) {
            this.summaryTableData.addRow(row);
        }
    }
}
