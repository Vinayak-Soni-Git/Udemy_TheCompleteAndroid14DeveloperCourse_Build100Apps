package com.example.udemy_thecompleteandroid14developercourse_build100apps.ViewsAndWidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class UnitConverterApp extends AppCompatActivity {

    EditText weightEditText;
    Button convertButton;
    TextView convertResultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter_app);

        weightEditText = findViewById(R.id.weightEditText);
        convertButton = findViewById(R.id.convertButton);
        convertResultText = findViewById(R.id.convertResultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = weightEditText.getText().toString();
                double kilos = Double.parseDouble(inputText);

                double pounds = makeConversion(kilos);
                convertResultText.setText(""+pounds);

            }
        });

    }
    public double makeConversion(double kilos){
        return kilos*2.20462;
    }
}