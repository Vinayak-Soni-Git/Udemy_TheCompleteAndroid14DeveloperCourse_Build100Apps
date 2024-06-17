package com.example.udemy_thecompleteandroid14developercourse_build100apps.MasteringAdapterAndGridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;

public class ShapeAdapter extends ArrayAdapter<Shape> {
    private ArrayList<Shape> shapesArrayList;
    Context context;

    public ShapeAdapter(ArrayList<Shape> shapesArrayList, Context context){
        super(context, R.layout.grid_item_layout, shapesArrayList);
        this.shapesArrayList = shapesArrayList;
        this.context = context;
    }
    //View Holder: Used to cache references to the views within an item layout
    public static class ViewHolder{
        TextView shapeName;
        ImageView shapeImage;
    }

    // GetView(): Used to create and return a view for a specific item in grid.


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1- Get the shape object for the current position
        Shape shapes = getItem(position);

        //2-Inflating Layout
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false
            );

            // Finding the views
            viewHolder.shapeName = (TextView) convertView.findViewById(R.id.shapeName);
            viewHolder.shapeImage = (ImageView) convertView.findViewById(R.id.shapeImage);

            convertView.setTag(viewHolder);

        } else {
            //A view went off-screen --> reuse it
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.shapeName.setText(shapes.getShapeName());
        viewHolder.shapeImage.setImageResource(shapes.getShapeImage());

        return convertView;
    }
}
