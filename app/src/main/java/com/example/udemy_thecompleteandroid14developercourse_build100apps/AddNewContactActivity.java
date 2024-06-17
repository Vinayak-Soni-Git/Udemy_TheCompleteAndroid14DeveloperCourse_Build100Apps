package com.example.udemy_thecompleteandroid14developercourse_build100apps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRoomDB.ViewModel;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {
    private ActivityAddNewContactBinding activityAddNewContactBinding;
    private AddNewContactClickHandler addNewContactClickHandler;
    private Contacts contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        contacts = new Contacts();
        activityAddNewContactBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_add_new_contact
        );

        ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);


        addNewContactClickHandler = new AddNewContactClickHandler(
                contacts,
                this,
                viewModel
        );

        activityAddNewContactBinding.setContact(contacts);
        activityAddNewContactBinding.setClickHandler(addNewContactClickHandler);
    }
}