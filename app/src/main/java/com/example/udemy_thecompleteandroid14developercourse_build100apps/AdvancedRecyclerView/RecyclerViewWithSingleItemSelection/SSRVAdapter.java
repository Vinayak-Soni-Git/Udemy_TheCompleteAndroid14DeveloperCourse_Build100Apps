package com.example.udemy_thecompleteandroid14developercourse_build100apps.AdvancedRecyclerView.RecyclerViewWithSingleItemSelection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;

public class SSRVAdapter extends RecyclerView.Adapter<SSRVAdapter.SingleViewHolder> {
    
    private Context context;
    private ArrayList<Employee> employees;
    private int checkedPosition = 0;
    
    public SSRVAdapter(Context context, ArrayList<Employee> employees){
        this.context = context;
        this.employees = employees;
    }
    
    public void setEmployees(ArrayList<Employee> employees){
        this.employees = new ArrayList<>();
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SingleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee_layout, parent, false);
        return new SingleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleViewHolder holder, int position) {
        holder.bind(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public Employee getSelected(){
        if (checkedPosition != -1){
            return employees.get(checkedPosition);
        }
        return null;
    }
    

    class SingleViewHolder extends RecyclerView.ViewHolder{
        
        private TextView textView;
        private ImageView imageView;
        
        public SingleViewHolder(@NonNull View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.employeeName);
            imageView = itemView.findViewById(R.id.employeePicture);
        }
        
        void bind(final Employee employee){
            if (checkedPosition == -1){
                imageView.setVisibility(View.GONE);
            } else {
                if (checkedPosition == getAdapterPosition()){
                    imageView.setVisibility(View.VISIBLE);
                }else {
                    imageView.setVisibility(View.GONE);
                }
            }
            
            textView.setText(employee.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageView.setVisibility(View.VISIBLE);
                    if (checkedPosition != getAdapterPosition()){
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                    }
                }
            });
        }
        
        
    }
}
