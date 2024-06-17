package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRoomDB;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.ClickHandler;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.Contacts;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ActivityContactsManagerAppBinding;

import java.util.ArrayList;
import java.util.List;

public class ContactsManagerApp extends AppCompatActivity {
    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();
    private Adapter adapter;

    private ActivityContactsManagerAppBinding activityContactsManagerAppBinding;
    private ClickHandler clickHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_manager_app);

        activityContactsManagerAppBinding = DataBindingUtil.setContentView(this, R.layout.activity_contacts_manager_app);

        clickHandler = new ClickHandler(this);
        activityContactsManagerAppBinding.setClickHandler(clickHandler);

        RecyclerView recyclerView = activityContactsManagerAppBinding.contactsRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        //Database
        contactDatabase = ContactDatabase.getInstance(this);

        //View Model
        ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);

//        Contacts contacts1 = new Contacts("Jack", "Jack@gmail.com");
//        viewModel.addNewContact(contacts1);

        //Loading the data from ROOM DB
        viewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contactsArrayList.clear();
                for (Contacts contact: contacts){
                    Log.v("Tagy", contact.getName());
                    contactsArrayList.add(contact);
                }
                adapter.notifyDataSetChanged();
            }
        });

        //Adapter
        adapter = new Adapter(contactsArrayList);

        recyclerView.setAdapter(adapter);

        // Swiper to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Contacts c = contactsArrayList.get(viewHolder.getAdapterPosition());
                viewModel.deleteContact(c);
            }
        }).attachToRecyclerView(recyclerView);
    }
}