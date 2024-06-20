package com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FurnitureApp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FurnitureApp.adapters.AdapterOne;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FurnitureApp.adapters.AdapterTwo;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FurnitureApp.data.ProductsData;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FurnitureApp.data.SliderData;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FurnitureApp.model.ProductModel;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;

public class FurnitureApp extends AppCompatActivity {

    //Primary Cards
    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private static ArrayList<ProductModel> data;
    // Secondary Cards
    private static RecyclerView.Adapter adapter2;
    private static RecyclerView recyclerView2;
    private static ArrayList<ProductModel> data2;
    private RecyclerView.LayoutManager layoutManager;
    private Context mContext;
    private RecyclerView.LayoutManager layoutManager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_app);

        // 1- Create main Cards
        InitiateMainCards();

        // 2- Create secondary cards
        InitiateSecondaryCards();



    }



    private void InitiateMainCards() {
        // This method for primary cards

        recyclerView = findViewById(R.id.recyclerViewPrimary);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,
                false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Getting Data from MyData Class
        data = new ArrayList<ProductModel>();
        for (int i = 0; i < SliderData.nameArray.length; i++) {
            data.add(new ProductModel(
                    SliderData.nameArray[i],
                    SliderData.versionArray[i],
                    SliderData.id_[i],
                    SliderData.drawableArray[i]
            ));
        }

        // Let's Add the Adapter (Custom Adapter - we will create now)
        adapter = new AdapterOne(data, this);
        recyclerView.setAdapter(adapter);

    }



    private void InitiateSecondaryCards() {

        recyclerView2 = findViewById(R.id.recyclerViewSecondary);
        recyclerView2.setHasFixedSize(true);


        layoutManager2 = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,
                false);


        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());


        // Getting Data from MyData Class
        data2 = new ArrayList<ProductModel>(    );
        for (int i = 0; i < ProductsData.nameArray.length; i++) {
            data2.add(new ProductModel(
                    ProductsData.nameArray[i],
                    ProductsData.versionArray[i],
                    ProductsData.id_[i],
                    ProductsData.drawableArray[i]
            ));
        }

        // Let's Add the Adapter (Custom Adapter - we will create now)
        adapter2 = new AdapterTwo(data2, this);
        recyclerView2.setAdapter(adapter2);
        
    }
}