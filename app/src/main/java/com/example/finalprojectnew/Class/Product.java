package com.example.finalprojectnew.Class;

public class Product {
    private String name;
    private String price;
    private String sex;
    public String image;
    private String product;

    public Product(String name, String price, String sex, String image, String product) {
        this.name = name;
        this.price = price;
        this.sex = sex;
        this.image = image;
        this.product = product;
    }

    public Product(String name, String price, String image, String product) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.product = product;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
