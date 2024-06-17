package com.example.udemy_thecompleteandroid14developercourse_build100apps.MVVMAndRoomDB;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.Contacts;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Contacts> contactsArrayList;

    public Adapter(ArrayList<Contacts> contactsArrayList){
        this.contactsArrayList = contactsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.contact_list_item,
                parent,
                false);
        return new ViewHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contacts currentContact = contactsArrayList.get(position);
        holder.contactListItemBinding.setContact(currentContact);

    }

    @Override
    public int getItemCount() {
        return contactsArrayList.size();
    }

    public void setContactsArrayList(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ContactListItemBinding contactListItemBinding;
        public ViewHolder(@NonNull ContactListItemBinding contactListItemBinding){
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
        }

    }
}
