package com.payforward.androidapp.post;

/**
 * @author Eitan created on 5/16/2017.
 */

class SubCategory implements CategoryInterface {
    // Instance Variables
    private String title;

    // Constructors
    public SubCategory(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}
