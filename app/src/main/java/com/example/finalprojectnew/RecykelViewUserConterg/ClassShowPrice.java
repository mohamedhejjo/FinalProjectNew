package com.example.finalprojectnew.RecykelViewUserConterg;

import java.io.Serializable;

public class ClassShowPrice implements Serializable {
    private String name;
    private int image;
    private String price;
    private String pro;
private String femal;

    public String getFemal() {
        return femal;
    }

    public void setFemal(String femal) {
        this.femal = femal;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }
    public ClassShowPrice(String name, int image, String price,String pro) {
        this.name = name;
        this.image = image;
        this.pro = pro;
        this.price = price;}
    public ClassShowPrice(String name, int image, String price,String pro,String femal) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.pro = pro;
        this.femal=femal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
