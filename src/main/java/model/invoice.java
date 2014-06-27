package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Gergo on 2014.06.11..
 */
@Entity
public class Invoice implements Serializable, Comparable {

    @Id
    private Integer invoiceId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "organisation", joinColumns = @JoinColumn(name = "orgId"))
    private Organisation issuer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "partner", joinColumns = @JoinColumn(name = "partnerId"))
    private Partner partner;

    @OneToOne(cascade = CascadeType.ALL)
    private Currency currency;

    private Date fullfilDate;

    private Date issueDate;

    private Date dueDate;

    private Integer numberOfCopies;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Products> productsList;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Organisation getIssuer() {
        return issuer;
    }

    public void setIssuer(Organisation issuer) {
        this.issuer = issuer;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getFullfilDate() {
        return fullfilDate;
    }

    public void setFullfilDate(Date fullfilDate) {
        this.fullfilDate = fullfilDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }


    @Override
    public int compareTo(Object o) {
        Invoice ci = (Invoice) o;
        if (this.getInvoiceId() > ci.getInvoiceId()) return 1;
        if (this.getInvoiceId() < ci.getInvoiceId()) return -1;
        else return 0;
    }
}
