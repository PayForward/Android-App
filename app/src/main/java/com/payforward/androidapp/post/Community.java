package com.payforward.androidapp.post;

import android.graphics.drawable.Drawable;
/**
 * Created by jinch on 5/28/2017.
 */

public class Community implements CommunityInterface{

    // Instance variables
    private String title;
    private int members;
    private String comDesc;
    private Drawable image;

    // Constructors
    public Community(String title, int members, String comDesc, Drawable image) {
        this.title = title;
        this.members = members;
        this.comDesc = comDesc;
        this.image = image;
    }

    public Community(String title, int members, String comDesc) {
        this.title = title;
        this.comDesc = comDesc;
        this.members = members;
    }
    // getter and setters
    public String getTitle(){ return title;}
    public void setTitle(String title){ this.title = title; }
    public int getNumberMembers(){ return members;}
    public void setNumberMembers(int data){ this.members = data;}
    public String getCommunityDescription(){ return comDesc; }
    public void setCommunityDescription(String desc){ this.comDesc = desc; }
    public Drawable getImage(){ return image;}
    public void setImage(Drawable i){ this.image = i; }

}
