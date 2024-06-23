package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityDaggerContactManagerBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class DaggerContactManager extends AppCompatActivity {


    // FIled Injection
    @Inject
    public ContactAppDatabase contactAppDatabase;
    private ArrayList<Contact> contacts = new ArrayList<>();
    private ContactDataAdapter contactDataAdapter;
    // Binding
    private ActivityDaggerContactManagerBinding activityDaggerContactManagerBinding;
    private MainActivityClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data Binding
        activityDaggerContactManagerBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        handlers = new MainActivityClickHandlers(this);
        activityDaggerContactManagerBinding.setClickHandler(handlers);


        RecyclerView recyclerView = activityDaggerContactManagerBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Adapter
        contactDataAdapter = new ContactDataAdapter( contacts);


        // Database
        /**
         * A Major dependency for MainActivity on contactAppDatabase
         * We want to inject contactAppDatabase to MainActivity as Singleton
         *
         *
         *  Congratz!!! we made it!    thanks for your time
         *
         *
         * */

        // Getting the Database dependencies
//        App.getApp().getContactAppComponent().inject(this);

        // Add Data
        LoadData();



        recyclerView.setAdapter(contactDataAdapter);



        // Handling Swiping
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                Contact contact = contacts.get(viewHolder.getAdapterPosition());
                DeleteContact(contact);
            }
        }).attachToRecyclerView(recyclerView);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if (requestCode == 1 && resultCode == RESULT_OK){
            String name = data.getStringExtra("NAME");
            String email = data.getStringExtra("EMAIL");

            Contact contact = new Contact(name, email,0);

            AddNewContact(contact);


        }



    }

    private void DeleteContact(Contact contact) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                // OnBackground
                contactAppDatabase.getContactDao().delete(contact);
                contacts.remove(contact);

                // On Post Execution
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        contactDataAdapter.notifyDataSetChanged();
                    }
                });

            }




        });





    }

    private void LoadData() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                // OnBackground
                contacts.addAll(contactAppDatabase.getContactDao().getAllContacts());

                // On Post Execution
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        contactDataAdapter.setContacts(contacts);
                        contactDataAdapter.notifyDataSetChanged();

                    }
                });

            }
        });



    }


    private void AddNewContact(Contact contact){


        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                // OnBackground
                contactAppDatabase.getContactDao().insert(contact);
                contacts.add(contact);

                // On Post Execution
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        contactDataAdapter.notifyDataSetChanged();
                    }
                });

            }
        });

    }


    public class MainActivityClickHandlers{

        Context context;

        public MainActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onFABClicked(View view){
            Intent i = new Intent(DaggerContactManager.this, DaggerAddNewContact.class);
            startActivityForResult(i, 1);
        }





    }
}