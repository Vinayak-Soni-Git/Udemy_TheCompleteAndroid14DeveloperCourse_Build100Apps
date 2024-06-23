package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityDaggerAddNewContactBinding;

public class DaggerAddNewContact extends AppCompatActivity {

    Contact contact;
    private ActivityDaggerAddNewContactBinding daggerAddNewContactBinding;
    private AddNewContactActivityClickHandlers addNewContactActivityClickHandlers;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);



        contact = new Contact();
        daggerAddNewContactBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_contact);
        daggerAddNewContactBinding.setContact(contact);

        addNewContactActivityClickHandlers = new AddNewContactActivityClickHandlers(this);
        daggerAddNewContactBinding.setClickHandler(addNewContactActivityClickHandlers);




    }


    public class AddNewContactActivityClickHandlers{
        Context context;

        public AddNewContactActivityClickHandlers(Context context) {
            this.context = context;
        }


        public void onSubmitClicked(View view){

            if (contact.getName() == null){
                Toast.makeText(getApplicationContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent i = new Intent();
                i.putExtra("NAME", contact.getName());
                i.putExtra("EMAIL", contact.getEmail());


                setResult(RESULT_OK, i);
                finish();


            }
        }


    }

}