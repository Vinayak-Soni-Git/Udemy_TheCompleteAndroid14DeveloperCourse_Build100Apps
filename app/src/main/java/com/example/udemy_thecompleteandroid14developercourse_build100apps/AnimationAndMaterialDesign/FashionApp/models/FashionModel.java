package com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FashionApp.models;

public class FashionModel {
    private int img;
    private String title;

    //Constructor:
    public FashionModel(int img, String title) {
        this.img = img;
        this.title = title;
    }


    public FashionModel(){}

    // Gettters
    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }
}
