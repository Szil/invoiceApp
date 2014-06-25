package model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;

/**
 * Created by Gergo on 2014.06.24..
 */
@Entity
public class Products implements Serializable {

    @OneToMany
    private Integer invoiceId;

    private Integer prodId;

    private Integer quantity;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
