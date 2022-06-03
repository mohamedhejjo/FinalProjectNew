package com.example.finalprojectnew.RecykelViewuser;

import java.io.Serializable;

public class ClassCotr implements Serializable {
    private  String textview;
    private  int imageview;

    public ClassCotr(String textview, int imageview) {
        this.textview = textview;
        this.imageview = imageview;
    }

    public String getTextview() {
        return textview;
    }

    public void setTextview(String textview) {
        this.textview = textview;
    }

    public int getImageview() {
        return imageview;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }
}
