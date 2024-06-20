package com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FurnitureApp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FurnitureApp.model.ProductModel;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;

public class AdapterOne extends RecyclerView.Adapter<AdapterOne.OneViewHolder>{

    // Variables
    private ArrayList<ProductModel> dataSet;
    private Context mContext;


    // Constructor:
    public AdapterOne(ArrayList<ProductModel> dataSet, Context mContext) {
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public OneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.furniture_card_view_item, parent, false);        // We Will Create the Item_cardview layout
        OneViewHolder myViewHolder = new OneViewHolder(view);
        return myViewHolder;
    }
    
    @Override
    public void onBindViewHolder(final OneViewHolder holder, final int position) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        // Adding the data for textviews
        textViewName.setText(dataSet.get(position).getName());
        textViewVersion.setText(dataSet.get(position).getVersion());


        // Adding the data for imageView
        // Adding Glide Library

        Glide.with(mContext)
                .load(dataSet.get(position).getImage())
                .apply(RequestOptions.bitmapTransform
                        (new RoundedCorners(20)))
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    // Let's Create a ViewHolder Class
    public static class OneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;
        //ItemClickListener itemClickListener;  let's save it for later use

        public OneViewHolder(View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.textViewName);
            this.textViewVersion = itemView.findViewById(R.id.textViewVersion);
            this.imageViewIcon = itemView.findViewById(R.id.imageView);
            //itemView.setOnClickListener((View.OnClickListener) this);
        }

        @Override
        public void onClick(View view) {

        }
    }
    
}
