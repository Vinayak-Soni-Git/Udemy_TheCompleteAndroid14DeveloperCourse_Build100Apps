package com.example.udemy_thecompleteandroid14developercourse_build100apps.RecyclerViewTheGroceryApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;
import java.util.List;

public class GroceryApp extends AppCompatActivity implements GroceryItemClickListener{
    //1-AdapterView
    RecyclerView recyclerView;
    //2-Data source
    List<Grocery> groceryList;
    //3-Adapter
    GroceryAdapter groceryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_app);

        recyclerView = findViewById(R.id.groceriesRecyclerView);
        groceryList = new ArrayList<>();

        Grocery item1 = new Grocery(R.drawable.fruit, "Fruits", "Fresh fruits from the garden");
        Grocery item2 = new Grocery(R.drawable.vegitables, "Vegetables", "Delicious Vegetables");
        Grocery item3 = new Grocery(R.drawable.bread, "Bakery", "Bread, Wheat and Beans");
        Grocery item4 = new Grocery(R.drawable.beverage, "Beverage", "Juice, Tea, Coffee");
        Grocery item5 = new Grocery(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt");
        Grocery item6 = new Grocery(R.drawable.popcorn, "Snacks", "Pop corn, Donut and drinks");

        groceryList.add(item1);
        groceryList.add(item2);
        groceryList.add(item3);
        groceryList.add(item4);
        groceryList.add(item5);
        groceryList.add(item6);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        groceryAdapter = new GroceryAdapter(groceryList);
        recyclerView.setAdapter(groceryAdapter);

        groceryAdapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(this, "You choose: "+groceryList.get(position).getGroceryName(), Toast.LENGTH_SHORT).show();
    }
}