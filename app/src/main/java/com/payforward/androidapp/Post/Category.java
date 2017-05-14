package com.payforward.androidapp.Post;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author Eitan created on 5/11/2017.
 */

class Category {

    // Instance Variables
    private int id;  // Should be final
    private String description;
    private String helper;
    private Drawable image;

    // Constructors
    public Category(int ID, String description, String helper, Drawable image) {
        id = ID;
        this.description = description;
        this.helper = helper;
        this.image = image;
    }

    public Category(String description, String helper) {
        this.description = description;
        this.helper = helper;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHelper() {
        return helper;
    }

    public void setHelper(String helper) {
        this.helper = helper;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
