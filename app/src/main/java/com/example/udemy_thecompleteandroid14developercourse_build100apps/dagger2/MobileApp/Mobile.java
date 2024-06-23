package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.MobileApp;

import javax.inject.Inject;

public class Mobile {
    Battery battery;
    MemoryCard memoryCard;
    CPU cpu;
    
    @Inject
    public Mobile(){
        
    }
    
    public void ringNow(){
        System.out.println("Ringing");
    }
}
