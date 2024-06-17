package com.example.udemy_thecompleteandroid14developercourse_build100apps.MLKitLanguageTranslatorApp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class MainLanguageTranslatorActivity extends AppCompatActivity {
    
    private static final int REQUEST_CODE = 1;
    String[] fromLanguages = {"from", "English", "Afrikaans", "Arabic", "Belarusian", "Bengali"
    ,"Catalan", "Hindi", "Urdu"};
    String[] toLanguages = {"to", "English", "Afrikaans", "Arabic", "Belarusian", "Bengali"
            ,"Catalan", "Hindi", "Urdu"};
    String languageCode, fromLanguageCode, toLanguageCode;
    private Spinner fromSpinner, toSpinner;
    private EditText sourceEditText;
    private Button translateButton;
    private TextView translatedTextView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_language_translator);
        
        fromSpinner = findViewById(R.id.fromLanguageSpinner);
        toSpinner = findViewById(R.id.toLanguageSpinner);
        sourceEditText = findViewById(R.id.sourceEditText);
        translateButton = findViewById(R.id.translateButton);
        translatedTextView = findViewById(R.id.translatedTextView);
        
        
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromLanguageCode = getLanguageCode(fromLanguages[position]);
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter fromAdapter = new ArrayAdapter(this, R.layout.spinner_item, fromLanguages);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(fromAdapter);
        
        
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toLanguageCode = getLanguageCode(toLanguages[position]);
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        
        ArrayAdapter toAdapter = new ArrayAdapter(this, R.layout.spinner_item, toLanguages);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(toAdapter);
        
        
        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translatedTextView.setText("");
                if (sourceEditText.getText().toString().isEmpty()){
                    Toast.makeText(MainLanguageTranslatorActivity.this, "Please enter you text", Toast.LENGTH_SHORT).show();
                } else if (fromLanguageCode.isEmpty()){
                    Toast.makeText(MainLanguageTranslatorActivity.this, "Please select source language", Toast.LENGTH_SHORT).show();
                }else if (toLanguageCode.isEmpty()){
                    Toast.makeText(MainLanguageTranslatorActivity.this, "Please select target language", Toast.LENGTH_SHORT).show();
                } else {
                    translateText(fromLanguageCode, toLanguageCode, sourceEditText.getText().toString());
                }
            }
        });
    }

    private String getLanguageCode(String language) {
        String languageCode = "";
        switch(language){
            case "English":
                languageCode = TranslateLanguage.ENGLISH;
                break;
            case "Afrikaans":
                languageCode = TranslateLanguage.AFRIKAANS;
                break;
            case "Arabic":
                languageCode = TranslateLanguage.ARABIC;
                break;
            case "Belarusian":
                languageCode = TranslateLanguage.BELARUSIAN;
                break;
            case "Bengali":
                languageCode = TranslateLanguage.BENGALI;
                break;
            case "Catalan":
                languageCode = TranslateLanguage.CATALAN;
                break;
            case "Hindi":
                languageCode = TranslateLanguage.HINDI;
                break;
            case "Urdu":
                languageCode = TranslateLanguage.AFRIKAANS; 
                break;
            default:
                languageCode = "";
                
        }
        return languageCode;
    }
    
    public void translateText(String fromLanguageCode, String toLanguageCode, String source){
        translatedTextView.setText("Downloading language Model...");
        try {
            TranslatorOptions translatorOptions = new TranslatorOptions.Builder().setSourceLanguage(fromLanguageCode)
                    .setTargetLanguage(toLanguageCode).build();
            Translator translator = Translation.getClient(translatorOptions);
            DownloadConditions conditions = new DownloadConditions.Builder().build();
            
            translator.downloadModelIfNeeded(conditions).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    translatedTextView.setText("Translating...");
                    translator.translate(source).addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            translatedTextView.setText(s);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainLanguageTranslatorActivity.this, "Failed to translate", Toast.LENGTH_SHORT).show();
                            
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainLanguageTranslatorActivity.this, "Failed to download the model", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}