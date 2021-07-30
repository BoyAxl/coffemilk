package com.axlboy.coffemilk.model.entity;

import com.axlboy.coffemilk.utils.FormatUtils;

import javax.persistence.*;

@Entity
@Table(name = "Producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Category category;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    private boolean valid = true;
    private String remark;

    public Product() {
    }

    public Product(Category category, String name, int price, String remark) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPriceStr(){
        return FormatUtils.formatNumber(price);
    }

    public String getValidStr(){
        return valid? "Si" : "No";
    }
}
