package com.example.udemy_thecompleteandroid14developercourse_build100apps.AdaptersInAndroid;

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

public class PlanetCustomAdapter extends ArrayAdapter<Planet> {
    private ArrayList<Planet> planetsArrayList;
    Context context;

    public PlanetCustomAdapter(ArrayList<Planet> planetsArrayList, Context context){
        super(context, R.layout.customized_list_item, planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }
    //View holder class: used to cache references to the views within an item
    //layout, so that they don't need to be repeatedly looked up during scrolling
    private static class ViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImage;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planets = getItem(position);

        ViewHolder viewHolder;
        final View result;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.customized_list_item, parent, false);

            viewHolder.planetName = (TextView) convertView.findViewById(R.id.planetName);
            viewHolder.moonCount = (TextView) convertView.findViewById(R.id.numberOfMoons);
            viewHolder.planetImage = (ImageView) convertView.findViewById(R.id.planetImage);


            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;

            // Getting the data from model class (Planet)
        }
        viewHolder.planetName.setText(planets.getPlanetName());
        viewHolder.moonCount.setText(planets.getMoonCount());
        viewHolder.planetImage.setImageResource(planets.getPlanetImage());
        return result;
    }
}
