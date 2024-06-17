package com.example.udemy_thecompleteandroid14developercourse_build100apps.RecyclerViewTheGroceryApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.List;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.ViewHolder> {
    private final List<Grocery> groceryList;

    public GroceryItemClickListener clickListener;
    public void setClickListener(GroceryItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    public GroceryAdapter(List<Grocery> groceryList){
        this.groceryList = groceryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_for_rv, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Grocery grocery = groceryList.get(position);
        holder.title.setText(grocery.getGroceryName());
        holder.description.setText(grocery.getGroceryDescription());
        holder.groceryImage.setImageResource(grocery.getGroceryImage());
    }

    @Override
    public int getItemCount() {
        return groceryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView groceryImage;
        TextView title;
        TextView description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            groceryImage = itemView.findViewById(R.id.groceryImage);
            title = itemView.findViewById(R.id.groceryName);
            description = itemView.findViewById(R.id.groceryDescription);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null){
                clickListener.onClick(v, getAdapterPosition());
            }
        }
    }
}
