package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Gergo on 2014.06.24..
 */
@Entity
public class Products implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    private Invoice invoiceId;

    private Product prodId;

    private Integer quantity;

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Product getProdId() {
        return prodId;
    }

    public void setProdId(Product prodId) {
        this.prodId = prodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Products{" +
                "prodId=" + prodId +
                ", quantity=" + quantity +
                '}';
    }
}
