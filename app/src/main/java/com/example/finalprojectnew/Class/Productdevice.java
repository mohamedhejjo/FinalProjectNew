package com.example.finalprojectnew.Class;

import java.io.Serializable;

public class Productdevice implements Serializable {
    private String id;
    private String name;
    private String price;
    private String image;
    private String product;

    public Productdevice() {
    }

    public Productdevice(String id, String name, String price, String image, String product) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
