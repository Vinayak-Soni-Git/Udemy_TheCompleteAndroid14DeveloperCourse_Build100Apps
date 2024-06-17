package com.example.udemy_thecompleteandroid14developercourse_build100apps.PhoneBookApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.User;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.databinding.PhoneBookCardViewItemLayoutBinding;

import java.util.ArrayList;

public class PhoneBookAdapter extends RecyclerView.Adapter<PhoneBookAdapter.UserViewHolder> {
    
    private Context context;
    private ArrayList<User> userArrayList;
    
    public PhoneBookAdapter(Context context, ArrayList<User> userArrayList){
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PhoneBookCardViewItemLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.phone_book_card_view_item_layout,
                parent,
                false
        );
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User currentUser = userArrayList.get(position);
        holder.phoneBookCardViewItemLayoutBinding.setUser(currentUser);
        
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder{
        private PhoneBookCardViewItemLayoutBinding phoneBookCardViewItemLayoutBinding;

        public UserViewHolder(PhoneBookCardViewItemLayoutBinding phoneBookCardViewItemLayoutBinding) {
            super(phoneBookCardViewItemLayoutBinding.getRoot());
            this.phoneBookCardViewItemLayoutBinding = phoneBookCardViewItemLayoutBinding;
            
            phoneBookCardViewItemLayoutBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                }
            });
            
        }
    }
}
