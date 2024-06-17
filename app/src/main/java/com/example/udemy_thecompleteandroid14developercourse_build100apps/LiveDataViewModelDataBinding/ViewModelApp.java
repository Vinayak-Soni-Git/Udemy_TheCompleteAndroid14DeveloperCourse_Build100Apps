package com.example.udemy_thecompleteandroid14developercourse_build100apps.LiveDataViewModelDataBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class ViewModelApp extends AppCompatActivity {

    MyViewModel viewModel;
    Button counterButton;
    TextView counterText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_app);

        counterText = findViewById(R.id.counterText);
        counterButton = findViewById(R.id.viewModelCounterButton);

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.increaseCounter();
            }
        });

        //Observing the live data
        viewModel.getCounter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                counterText.setText(getString(R.string._0, integer));
            }
        });

    }
}