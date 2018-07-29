package com.seatech.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_PRODUCT_GROUP")
public class Group {
    @Id
    @Column(name = "GROUP_ID")
    private String groupId;
    @Column(name = "GROUP_NAME")
    private String groupName;

    @OneToMany(mappedBy = "group")
    private Set<Product> products;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
