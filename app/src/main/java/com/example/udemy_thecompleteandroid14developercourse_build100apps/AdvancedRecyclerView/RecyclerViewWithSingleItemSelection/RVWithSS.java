package com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithSingleItemSelection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;

public class RVWithSS extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private ArrayList<Employee> employees = new ArrayList<>();
    private SSRVAdapter adapter;
    private Button getSelectionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_with_single_item_selection);
        
        recyclerView = findViewById(R.id.singleItemSelectionRecyclerView);
        getSelectionButton = findViewById(R.id.getSelectionButton);
        
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new SSRVAdapter(this, employees);
        recyclerView.setAdapter(adapter);
        createList();
        
        
        
        getSelectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getSelected() != null){
                    showToast(adapter.getSelected().getName());
                } else {
                    showToast("No Selection");
                }
            }
        });
        
        
    }
    
    private void createList(){
        employees = new ArrayList<>();
        for (int i=0;i<20;i++){
            Employee employee = new Employee();
            employee.setName("Employee "+(i+1));
            employees.add(employee);
        }
        adapter.setEmployees(employees);
    }
    
    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}