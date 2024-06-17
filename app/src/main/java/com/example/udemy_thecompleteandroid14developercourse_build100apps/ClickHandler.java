package com.example.udemy_thecompleteandroid14developercourse_build100apps;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class ClickHandler {
    Context context;

    public ClickHandler(Context context){
        this.context = context;
    }

    public void onFabClicked(View view){
        Intent intent = new Intent(view.getContext(), AddNewContactActivity.class);
        context.startActivity(intent);
    }
}
