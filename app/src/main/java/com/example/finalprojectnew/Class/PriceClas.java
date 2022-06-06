package com.example.finalprojectnew.Class;

import java.io.Serializable;

public class PriceClas implements Serializable {
    private  String id;
    private  String namepyar;
    private  String passpyar;
    private  String name;
    private String price;
    private  String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PriceClas(){

    }
    public PriceClas(String id, String namepyar, String passpyar, String name, String price) {
        this.id = id;
        this.namepyar = namepyar;
        this.passpyar = passpyar;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamepyar() {
        return namepyar;
    }

    public void setNamepyar(String namepyar) {
        this.namepyar = namepyar;
    }

    public String getPasspyar() {
        return passpyar;
    }

    public void setPasspyar(String passpyar) {
        this.passpyar = passpyar;
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
}
