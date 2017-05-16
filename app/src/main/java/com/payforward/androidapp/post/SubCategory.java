package com.payforward.androidapp.post;

/**
 * @author Eitan created on 5/16/2017.
 */

class SubCategory implements CategoryInterface {
    // Instance Variables
    private int id;  // Should be final
    private String description;

    // Constructors
    public SubCategory(int ID, String description) {
        id = ID;
        this.description = description;
    }

    public SubCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
