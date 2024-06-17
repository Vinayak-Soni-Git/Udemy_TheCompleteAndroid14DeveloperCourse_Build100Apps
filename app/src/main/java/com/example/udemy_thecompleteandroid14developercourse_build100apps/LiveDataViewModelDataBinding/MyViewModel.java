package com.example.udemy_thecompleteandroid14developercourse_build100apps.LiveDataViewModelDataBinding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
//    int counter = 0;
    private MutableLiveData<Integer> counter = new MutableLiveData<>();


    public void increaseCounter(){
        //Retrieve the current value from livedata
        int currentValue = counter.getValue() != null ? counter.getValue():0;
        counter.setValue(currentValue+1);
    }

    public LiveData<Integer> getCounter(){
        return counter;
    }
}
