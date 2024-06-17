package com.example.udemy_thecompleteandroid14developercourse_build100apps.RecyclerViewTheGroceryApp;

public class Grocery {
    int groceryImage;
    String groceryName;
    String groceryDescription;

    public Grocery(int groceryImage, String groceryName, String groceryDescription){
        this.groceryImage = groceryImage;
        this.groceryName = groceryName;
        this.groceryDescription = groceryDescription;
    }

    public int getGroceryImage() {
        return groceryImage;
    }

    public void setGroceryImage(int groceryImage) {
        this.groceryImage = groceryImage;
    }

    public String getGroceryName() {
        return groceryName;
    }

    public void setGroceryName(String groceryName) {
        this.groceryName = groceryName;
    }

    public String getGroceryDescription() {
        return groceryDescription;
    }

    public void setGroceryDescription(String groceryDescription) {
        this.groceryDescription = groceryDescription;
    }
}
