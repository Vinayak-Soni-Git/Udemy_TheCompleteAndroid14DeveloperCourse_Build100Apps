package com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithSingleItemSelection;

import java.io.Serializable;

public class Employee implements Serializable {
    private boolean isChecked = false;
    private String name;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
