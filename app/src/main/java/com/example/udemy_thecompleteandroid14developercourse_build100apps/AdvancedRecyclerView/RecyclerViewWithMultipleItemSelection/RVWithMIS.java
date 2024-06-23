package com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithMultipleItemSelection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithSingleItemSelection.Employee;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;

public class RVWithMIS extends AppCompatActivity {

    RecyclerView recyclerView;
    Button selectionButton;
    private ArrayList<Employee> employees = new ArrayList<>();
    private MISA adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_with_multiple_item_selection);
        
        recyclerView = findViewById(R.id.multipleItemSelectionRecyclerView);
        selectionButton = findViewById(R.id.getSelectionButton);
        
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        
        adapter = new MISA(this, employees);
        recyclerView.setAdapter(adapter);
        
        createListOfData();
        
        selectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getSelected().size() > 0){
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i=0;i<adapter.getSelected().size();i++){
                        stringBuilder.append(adapter.getSelected().get(i).getName());
                        stringBuilder.append("\n");
                    }
                    showToast(stringBuilder.toString().trim());
                }else {
                    showToast("No selection");
                }
            }
        });
    }

    private void createListOfData() {
        employees = new ArrayList<>();
        for (int i=0;i<20;i++){
            Employee employee = new Employee();
            employee.setName("employee "+(i+1));
            if (i==0){
                employee.setChecked(true);
            }
            
            employees.add(employee);
        }
        adapter.setEmployees(employees);
    }
    
    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}