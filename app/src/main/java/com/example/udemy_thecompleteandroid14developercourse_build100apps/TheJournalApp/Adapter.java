package com.example.udemy_thecompleteandroid14developercourse_build100apps.TheJournalApp;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.List;

import javax.annotation.Nonnull;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private Context context;
    private List<Journal> journalList;

    public Adapter(Context context, List<Journal> journalList){
        this.context = context;
        this.journalList = journalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.journal_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Journal currentJournal = journalList.get(position);
        holder.title.setText(currentJournal.getTitle());
        holder.thoughts.setText(currentJournal.getThoughts());
        holder.name.setText(currentJournal.getUserName());

        String imageUrl = currentJournal.getImageUrl();
        String timeAgo = (String) DateUtils.getRelativeTimeSpanString(
                currentJournal.getTimeAdded().getSeconds()*1000
        );
        holder.dateAdded.setText(timeAgo);
        Glide.with(context)
                .load(imageUrl)
                .fitCenter()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return journalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title, thoughts, dateAdded, name;
        public ImageView image, shareButton;
        public String userId, userName;

        public ViewHolder(@Nonnull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.journalTitle);
            thoughts = itemView.findViewById(R.id.journalThought);
            dateAdded = itemView.findViewById(R.id.journalTimestamp);
            image = itemView.findViewById(R.id.journalImage);
            name = itemView.findViewById(R.id.journalUserName);
            shareButton = itemView.findViewById(R.id.journalShareButton);

            shareButton.setOnClickListener(view -> {

            });
        }

    }
}
