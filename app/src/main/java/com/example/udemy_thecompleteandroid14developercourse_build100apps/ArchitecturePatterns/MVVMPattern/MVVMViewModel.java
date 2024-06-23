package com.example.udemy_thecompleteandroid14developercourse_build100apps.ArchitecturePatterns.MVVMPattern;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MVVMViewModel extends ViewModel {
    
    LiveData<String> liveData;
    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
    
    private MVVMModel getAppFromDatabase(){
        return new MVVMModel("Master Coding App", 9000000, 4);
    }
    public void getAppName(){
        String appName = getAppFromDatabase().getAppName();
        mutableLiveData.setValue(appName);
    }
}
