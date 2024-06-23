package com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithMultipleViewTypes;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;

public class MRVVTAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    
    private static int TYPE_CALL = 1;
    private static int TYPE_EMAIL = 2;
    private Context context;
    private ArrayList<MultiEmployee> employees;
    
    
    
    public MRVVTAdapter(Context context, ArrayList<MultiEmployee> employees){
        this.context = context;
        this.employees = employees;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_CALL){
            view = LayoutInflater.from(context).inflate(R.layout.item_call, parent, false);
            return new CallViewHolder(view);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.item_email_layout, parent, false);
            return new EmailViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(employees.get(position).getEmail())){
            return TYPE_CALL;
        } else {
            return TYPE_EMAIL;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_CALL){
            ((CallViewHolder) holder).setCallDetails(employees.get(position));
        } else {
            ((EmailViewHolder) holder).setEmailDetails(employees.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class CallViewHolder extends RecyclerView.ViewHolder{
        
        private TextView textName;
        private TextView textAddress;
        

        public CallViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.txtName);
            textAddress = itemView.findViewById(R.id.txtAddress);
        }
        void setCallDetails(MultiEmployee multiEmployee){
            textName.setText(multiEmployee.getName());
            textAddress.setText(multiEmployee.getAddress());
        }
    }
    
    class EmailViewHolder extends RecyclerView.ViewHolder{
        private TextView textName;
        private TextView textAddress;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.txtName);
            textAddress = itemView.findViewById(R.id.txtAddress);
        }
        void setEmailDetails(MultiEmployee multiEmployee){
            textName.setText(multiEmployee.getName());
            textAddress.setText(multiEmployee.getAddress());
        }
    }
}
