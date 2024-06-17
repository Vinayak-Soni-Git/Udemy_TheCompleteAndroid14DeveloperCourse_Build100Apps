package com.example.udemy_thecompleteandroid14developercourse_build100apps.MasteringAdapterAndGridView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class SphereActivity extends AppCompatActivity {

    EditText sphereRadius;
    TextView title, result;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        sphereRadius = findViewById(R.id.radius);
        title = findViewById(R.id.sphereVolumeText);
        result = findViewById(R.id.result);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = sphereRadius.getText().toString();
                int radiusInt = Integer.parseInt(radius);
                double volume = (4/3)*Math.PI*radiusInt*radiusInt*radiusInt;
                result.setText("V = "+volume+" m^3");

            }
        });

    }
}