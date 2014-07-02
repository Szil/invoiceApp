package controller;

import model.Currency;
import model.Product;

import java.text.DecimalFormat;

/**
 * Created by Gergo on 2014.06.27..
 */
public class Formatter {

    String pattern;
    double value;

    public Formatter(String pattern) {
        this.pattern = pattern;
    }

    public Formatter() {
        this.pattern = "###,###.00";
    }

    public String prettyPrintDouble(double value) {
        DecimalFormat prettyFormat = new DecimalFormat(this.pattern);
        String out = prettyFormat.format(value);
        return out;
    }

    public String prettyPrintDouble(String format, double value) {
        DecimalFormat prettyFormat = new DecimalFormat(format);
        String out = prettyFormat.format(value);
        return out;
    }

    public String prettyPrintCurrency(Currency currency, double value) {
        this.pattern = "###,###.00 " + currency.getSymbol();
        DecimalFormat prettyFormat = new DecimalFormat(this.pattern);
        String out = prettyFormat.format(value);
        return out;
    }

    public String prettyPrintProductMeasure(Product product, double value) {
        this.pattern = "## " + product.getUnitOfMeasure();
        DecimalFormat prettyFormat = new DecimalFormat(this.pattern);
        String out = prettyFormat.format(value);
        return out;
    }
}
