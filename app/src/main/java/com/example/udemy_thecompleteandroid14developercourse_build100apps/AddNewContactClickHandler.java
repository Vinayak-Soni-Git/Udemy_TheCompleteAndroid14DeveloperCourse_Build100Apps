package com.example.udemy_thecompleteandroid14developercourse_build100apps;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRoomDB.ContactsManagerApp;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRoomDB.ViewModel;

public class AddNewContactClickHandler {
    Contacts contact;
    Context context;
    ViewModel viewModel;

    public AddNewContactClickHandler(Contacts contact, Context context, ViewModel viewModel){
        this.contact = contact;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onSubmitButtonClicked(View view){
        if (contact.getName() == null || contact.getEmail() == null){
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(context, ContactsManagerApp.class);
//            intent.putExtra("ContactName", contact.getName());
//            intent.putExtra("ContactEmail", contact.getEmail());

            Contacts c = new Contacts(contact.getName(), contact.getEmail());
            viewModel.addNewContact(c);

            context.startActivity(intent);
        }
    }
}
