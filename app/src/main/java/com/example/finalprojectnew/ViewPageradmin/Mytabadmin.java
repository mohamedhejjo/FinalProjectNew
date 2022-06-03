package com.example.finalprojectnew.ViewPageradmin;

import androidx.fragment.app.Fragment;

public class Mytabadmin {
    private Fragment fr;
    private String title;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Fragment getFr() {
        return fr;
    }

    public void setFr(Fragment fr) {
        this.fr = fr;
    }

    public Mytabadmin( Fragment fr,String title) {
        this.fr = fr;
        this.title=title;
    }
}


