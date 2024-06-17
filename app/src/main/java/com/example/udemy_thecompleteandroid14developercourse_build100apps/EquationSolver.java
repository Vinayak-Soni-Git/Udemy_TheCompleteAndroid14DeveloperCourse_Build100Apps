package com.example.udemy_thecompleteandroid14developercourse_build100apps;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityMainEquationsSolverAppBinding;

public class EquationSolver extends BaseObservable {
    String a;
    String b;
    String c;
    
    ActivityMainEquationsSolverAppBinding binding;
    
    public EquationSolver(ActivityMainEquationsSolverAppBinding binding){
        this.binding = binding;
    }
    
    public EquationSolver(){};
    
    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
    
    public void solverEquation(View view){
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());
        
        double discriminant = ((b*b) - 4*(a*c));
        
        double x1, x2;
        if (discriminant > 0){
            //Two real and distinct roots (solutions)
            x1 = (-b + Math.sqrt(discriminant))/ (2*a);
            x2 = (-b - Math.sqrt(discriminant))/ (2*a);
            
            //Display the result in the textview
            
            binding.solutionText.setText("X1 = "+x1+", X2 = "+x2);
        } else if (discriminant < 0){
            binding.solutionText.setText("No real roots (complex roots)");
        } else {
            //One real solution
            x1 = -b/ (2*a);
            binding.solutionText.setText("x = "+x1);
        }
    }
}
