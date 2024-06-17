package com.example.udemy_thecompleteandroid14developercourse_build100apps.AdaptersInAndroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] items;

    public CustomAdapter(Context context, String[] items){
        this.context = context;
        this.items = items;
    }
    

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            //convertView is a recycled view that you can reuse to
            //improve the performance of your list.
            convertView = LayoutInflater.from(context).inflate(R.layout.customized_list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.planetName);
            convertView.setTag(viewHolder);
        }
        else {
            // Reusing the view (that's recycled)
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(items[position]);

        return convertView;
    }

    static class ViewHolder{
        //Holds references to the views within an item layout
        TextView textView;

    }
}
