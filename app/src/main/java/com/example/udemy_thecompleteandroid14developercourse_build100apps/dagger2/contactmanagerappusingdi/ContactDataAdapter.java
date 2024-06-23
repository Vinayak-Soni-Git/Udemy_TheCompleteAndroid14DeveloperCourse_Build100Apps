package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.contactmanagerappusingdi;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class ContactDataAdapter extends RecyclerView.Adapter<ContactDataAdapter.ContactViewHolder> {


    private ArrayList<Contact> contacts;


    public ContactDataAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).
//                inflate(R.layout.contact_list_item,parent, false);
//        return new ContactViewHolder(itemView);

        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.contact_list_item, parent, false);

        return new ContactViewHolder(contactListItemBinding);

    }


    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int i) {
        Contact currentContact = contacts.get(i);
//        holder.name.setText(currentContact.getName());
//        holder.email.setText(currentContact.getEmail());


//        holder.contactListItemBinding.setContact(currentContact);

    }

    @Override
    public int getItemCount() {
        if (contacts != null){
            return contacts.size();
        }else{
            return 0;
        }

    }

    public void setContacts(ArrayList<Contact> contacts){
        this.contacts = contacts;
        notifyDataSetChanged();
    }


    class ContactViewHolder extends RecyclerView.ViewHolder{

        private ContactListItemBinding contactListItemBinding;

        //private TextView name, email;

        public ContactViewHolder(@NonNull ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());

            this.contactListItemBinding = contactListItemBinding;

//            this.name = itemView.findViewById(R.id.tvName);
//            this.email = itemView.findViewById(R.id.tvEmail);
        }
    }


}
