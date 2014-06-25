package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Gergo on 2014.06.11..
 */
@Entity
public class Invoice implements Serializable {

    @Id
    private String invoiceId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "organisation", joinColumns = @JoinColumn(name = "orgId"))
    private Integer issuer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "partner", joinColumns = @JoinColumn(name = "partnerId"))
    private Integer partner;

    @ManyToOne(cascade = CascadeType.ALL)
    private Integer currency;

    private Date fullfilDate;

    private Date issueDate;

    private Date dueDate;

    private Integer numberOfCopies;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Products> productsList;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getIssuer() {
        return issuer;
    }

    public void setIssuer(Integer issuer) {
        this.issuer = issuer;
    }

    public Integer getPartner() {
        return partner;
    }

    public void setPartner(Integer partner) {
        this.partner = partner;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
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


}
