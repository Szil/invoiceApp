package controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Currency;

import java.net.URL;
import java.util.List;

/**
 * Created by Gergo on 2014.06.27..
 */
public class CurrencyConverter {
    @Deprecated
    Currency from;
    @Deprecated
    Currency to;

    Double conversionRate;


    public CurrencyConverter() {
    }

    private JsonNode rateJson(List<Currency> currencies) {


        return null;
    }

    public Double getCurrencyFromYahoo(Currency from, Currency to) {
        if (from.getIsoCode().equals(to.getIsoCode())) {
            this.conversionRate = 1.0;
            return this.conversionRate;
        } else {
            try {
                URL url = new URL("https://query.yahooapis.com/v1/public/yql?q=select%20Rate%20from%20yahoo.finance.xchange" +
                        "%20where%20pair%20in%20(%22" + from.getIsoCode() + to.getIsoCode() + "%22)&format=json" +
                        "&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
                ObjectMapper mapper = new ObjectMapper();
                JsonNode json = mapper.readTree(url);
                this.conversionRate = json.findValue("Rate").asDouble();
                return this.conversionRate;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //
        return null;
    }

    /*
    https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USDHUF%22)&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=
    https://query.yahooapis.com/v1/public/yql?q=select%20Rate%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USDHUF%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=
    "http://rate-exchange.appspot.com/currency?from=" + from.getIsoCode() + "&to=" + to.getIsoCode()
    //All currency
    https://query.yahooapis.com/v1/public/yql?q=select%20id%2C%20Rate%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USDHUF%22,%22HUFUSD%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys
     */

    @Deprecated
    public Double getCurrencyFromYahoo() {
        if (from.getIsoCode().equals(to.getIsoCode())) {
            this.conversionRate = 1.0;
        } else {
            try {
                URL url = new URL("https://query.yahooapis.com/v1/public/yql?q=select%20Rate%20from%20yahoo.finance.xchange" +
                        "%20where%20pair%20in%20(%22" + from.getIsoCode() + to.getIsoCode() + "%22)&format=json" +
                        "&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
                ObjectMapper mapper = new ObjectMapper();
                JsonNode json = mapper.readTree(url);
                this.conversionRate = json.findValue("Rate").asDouble();
                return this.conversionRate;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }


}
