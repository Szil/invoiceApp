package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Currency;

import java.net.URL;
import java.util.Map;

/**
 * Created by Gergo on 2014.06.27..
 */
public class CurrencyConverter {

    Currency from;
    Currency to;
    Double conversionRate;

    public CurrencyConverter(Currency from) {
        this.from = from;
        Currency to = new Currency();
        to.setCurrency_key("HUF");
        if (from.getCurrency_key() == to.getCurrency_key()) {
            this.conversionRate = 1.0;
        } else {
            conversionRate = getCurrencyFromGoogle(from, to);
        }
    }

    public CurrencyConverter(Currency from, Currency to) {
        if (from.getCurrency_key() == to.getCurrency_key()) {
            conversionRate = 1.0;
        } else {
            this.from = from;
            this.to = to;
            this.conversionRate = getCurrencyFromGoogle(from, to);
        }
    }

    public Double getCurrencyFromGoogle(Currency from, Currency to) {
        this.from = from;
        this.to = to;
        if (from.getCurrency_key() == to.getCurrency_key()) {
            this.conversionRate = 1.0;
        } else {
            try {
                URL url = new URL("http://rate-exchange.appspot.com/currency?from=" + from.getCurrency_key() + "&to=" + to.getCurrency_key());
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> json = mapper.readValue(url, Map.class);
                conversionRate = (Double) json.get("rate");
                return conversionRate;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Currency getFrom() {
        return from;
    }

    public void setFrom(Currency from) {
        this.from = from;
    }

    public Currency getTo() {
        return to;
    }

    public void setTo(Currency to) {
        this.to = to;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }
}
