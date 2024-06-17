package com.example.udemy_thecompleteandroid14developercourse_build100apps.MasteringAdapterAndGridView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;

public class VolumeAreaApp extends AppCompatActivity {

    //1-AdapterView: GridView
    GridView gridView;

    //2-DataSource: ArrayList<Shape>
    ArrayList<Shape> shapesArrayList;

    //3-Adapter: CustomAdapter
    ShapeAdapter shapeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_area_app);

        gridView = findViewById(R.id.gridView);

        shapesArrayList = new ArrayList<>();
        Shape shape1 = new Shape(R.drawable.sphere, "Sphere");
        Shape shape2 = new Shape(R.drawable.cylinder, "Cylinder");
        Shape shape3 = new Shape(R.drawable.cube, "Cube");
        Shape shape4 = new Shape(R.drawable.prism, "Prism");

        shapesArrayList.add(shape1);
        shapesArrayList.add(shape2);
        shapesArrayList.add(shape3);
        shapesArrayList.add(shape4);

        shapeAdapter = new ShapeAdapter(shapesArrayList, getApplicationContext());

        gridView.setAdapter(shapeAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SphereActivity.class);
                startActivity(intent);
            }
        });

    }
}