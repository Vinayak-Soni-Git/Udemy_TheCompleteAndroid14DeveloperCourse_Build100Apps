package com.example.udemy_thecompleteandroid14developercourse_build100apps.QuadraticEquationsSolverApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.EquationSolver;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityMainEquationsSolverAppBinding;

public class MainEquationsSolverApp extends AppCompatActivity {
    
    ActivityMainEquationsSolverAppBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_equations_solver_app);
        
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_equations_solver_app);
        
        EquationSolver equationSolver = new EquationSolver(binding);
        
        binding.setEquation(equationSolver);
    }
}