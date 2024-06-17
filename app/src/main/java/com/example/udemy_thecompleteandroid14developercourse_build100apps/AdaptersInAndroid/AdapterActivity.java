package com.example.udemy_thecompleteandroid14developercourse_build100apps.AdaptersInAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class AdapterActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        //1 - AdapterView: ListView
        listView = findViewById(R.id.listView);

        //2 - Data source: String array
        String[] countries = {"USA", "Germany", "Saudi Arabia", "France"};

        //3 - Adapter: acts as a bridge between the
        //    'data source' and the 'AdapterView'

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries);

        // Link listview with the adapter
        listView.setAdapter(adapter);
    }
}