package com.example.submissionexpert1.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submissionexpert1.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Movie> movies;

    private OnItemClickListener onItemClickListener;

    public Adapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            final Movie movie = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.name.setText(movie.getName());

            if (movie.getDescription().length() > 50) {
                genericViewHolder.description.setText(movie.getDescription().substring(0, 52) + "...");
            } else {
                genericViewHolder.description.setText(movie.getDescription());
            }

            genericViewHolder.photo.setImageResource(movie.getPhoto());
        }
    }

    private Movie getItem(int position) {
        return movies.get(position);
    }

    public void SetOnItemClickListener(final OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemCLick(View view, int position, Movie movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, description;
        private ImageView photo;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.list_name);
            description = itemView.findViewById(R.id.list_description);
            photo = itemView.findViewById(R.id.list_photo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.OnItemCLick(itemView, getAdapterPosition(), movies.get(getAdapterPosition()));
                }
            });
        }
    }
}
