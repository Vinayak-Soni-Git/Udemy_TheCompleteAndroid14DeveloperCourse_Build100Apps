package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.MobileApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class PureDIApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pure_diapp);
        
//        Battery battery = new Battery(100);
//        MemoryCard memoryCard = new MemoryCard(1024);
//        Processor processor = new Processor("intel");
//        CPU cpu = new CPU(processor);
//        
//        Mobile mobile = new Mobile(battery, memoryCard, cpu);
//        
//        mobile.battery.setPowerPercentage(90);
//        processor.processorType = "AMD";
//        
//        mobile.printMobileSpecs();

        Mobile mobile;
        MobileComponent mobileComponent = DaggerMobileComponent.create();
        mobile = mobileComponent.getMobile();
        mobile.ringNow();
        
        
    }
}