package com.payforward.androidapp.post;

import android.graphics.drawable.Drawable;

/**
 * @author Eitan created on 5/11/2017.
 */

class Category implements CategoryInterface {

    // Instance Variables
    private String title;
    private String subTitle;
    private Drawable image;

    // Constructors
    public Category(String title, String subTitle, Drawable image) {
        this.title = title;
        this.subTitle = subTitle;
        this.image = image;
    }

    public Category(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    // Methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
