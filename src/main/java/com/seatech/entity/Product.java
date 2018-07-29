package com.seatech.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_PRODUCT")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private String productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "DELETED")
    private char deleted;
    @Column(name = "PRICE")
    private Float price;
    @Column(name = "DESCRIPTION")
    private String description;

    @JoinColumn(name = "GROUP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public char getDeleted() {
        return deleted;
    }

    public void setDeleted(char deleted) {
        this.deleted = deleted;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
