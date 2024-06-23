package com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithMultipleViewTypes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;

public class RVWithMVTypes extends AppCompatActivity {
    
    RecyclerView recyclerView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_with_multiple_views);
        
        recyclerView = findViewById(R.id.recyclerViewWithMultipleViewTypes);
        
        insertDataToRecyclerView();
    }
    
    public void insertDataToRecyclerView(){
        ArrayList<MultiEmployee> employees = new ArrayList<>();
        
        MultiEmployee employee1 = new MultiEmployee();
        employee1.setName("Mohammad");
        employee1.setAddress("New York");
        employee1.setPhone("+012345678");
        employees.add(employee1);

        MultiEmployee employee2 = new MultiEmployee();
        employee2.setName("Ali");
        employee2.setAddress("London");
        employee2.setEmail("ali@gmail.com");
        employees.add(employee2);

        MultiEmployee employee3 = new MultiEmployee();
        employee3.setName("Jack");
        employee3.setAddress("Dritan");
        employee3.setPhone("jack@gmail.com");
        employees.add(employee3);

        MultiEmployee employee4 = new MultiEmployee();
        employee4.setName("Ryan");
        employee4.setAddress("Canada");
        employee4.setEmail("ryan@gmail.com");
        employees.add(employee4);
        
        MRVVTAdapter adapter = new MRVVTAdapter(this, employees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}