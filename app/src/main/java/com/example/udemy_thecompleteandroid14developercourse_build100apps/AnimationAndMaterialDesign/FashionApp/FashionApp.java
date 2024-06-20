package com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FashionApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FashionApp.adapters.FashionAdapter;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FashionApp.models.FashionModel;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;
import java.util.List;

public class FashionApp extends AppCompatActivity {

    //I WILL ADD SOME DRAWBALES
    // All Drawables and XD FILES ARE AVAILABLE IN the description below
    // ALSO THE SOURCE CODE of ANDROID STUDIO
    int[] covers = new int[]{
            R.drawable.fash1,
            R.drawable.fash2,
            R.drawable.fash3,
            R.drawable.fash4,
            R.drawable.fash5,
            R.drawable.fash6
    };
    // Widgets and Variables
    private RecyclerView staggeredRV;
    private FashionAdapter adapter;
    private StaggeredGridLayoutManager manager;



    // Images for cards
    private List<FashionModel> appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_app);

        // 1- initializing the views
        staggeredRV = findViewById(R.id.fashionRecyclerView2);

        // 2- Getting data
        appList = new ArrayList<>();

        // 3- Creating Adapter
        adapter = new FashionAdapter(this,appList);
        manager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);

        // 4- set layoutManager
        staggeredRV.setLayoutManager(manager);

        // 5- Set an adapter
        staggeredRV.setAdapter(adapter);

        // 6- inserting data
        IntializeDataIntoRecyclerView();


        // 7- Run the app and see if there is an error

        // Amazing. let's add the final touches


    }

    private void IntializeDataIntoRecyclerView() {

        FashionModel a = new FashionModel(covers[0], "Box Tee");
        appList.add(a);

        a = new FashionModel(covers[1], "Boyfriend Tee");
        appList.add(a);

        a = new FashionModel(covers[2], "Boyfriend Tee");
        appList.add(a);

        a = new FashionModel(covers[3], "Shirt Sleeve");
        appList.add(a);

        a = new FashionModel(covers[4], "Boyfriend Tee");
        appList.add(a);

        a = new FashionModel(covers[5], "Shirt Sleeve");
        appList.add(a);

        adapter.notifyDataSetChanged();
    }
}