package com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FashionApp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.AnimationAndMaterialDesign.FashionApp.models.FashionModel;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.List;

public class FashionAdapter extends RecyclerView.Adapter<FashionAdapter.FashionViewHolder> {

    Context mContext;
    List<FashionModel> mData;

    //Constructor
    public FashionAdapter(Context mContext, List<FashionModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public FashionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fashion_item_layout,
                parent, false);
        return new FashionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FashionViewHolder holder, int i) {

        // Binding image here
        // USING GLIDE LIBRARY

        Glide.with(mContext)
                .load(mData.get(i).getImg())
                .into(holder.img);

        // Binding TextView with data
        holder.title.setText(mData.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    // Let's Create a class called: ImageViewHolder
    public class FashionViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {

        ImageView img;
        TextView title;


        public FashionViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textView2);


            // Click Listeners
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            // Adding Here the Click Events on cards

            if (getLayoutPosition() == 0) {
                Toast.makeText(mContext, "You Clicked first Item", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
