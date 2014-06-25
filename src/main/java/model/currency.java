package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Gergo on 2014.06.24..
 */
@Entity
public class Currency implements Serializable {

    @Id
    @GeneratedValue
    private Integer currencyId;

    private String currency_key;

    private String name;

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrency_key() {
        return currency_key;
    }

    public void setCurrency_key(String currency_key) {
        this.currency_key = currency_key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
