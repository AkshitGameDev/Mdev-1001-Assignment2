package com.example.assignment2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList movie_id, movie_title, movie_studio, movie_genre;
    CustomAdapter(Context context, ArrayList movie_id, ArrayList movie_title, ArrayList movie_studio, ArrayList movie_genre){
        this.context = context;
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_studio = movie_studio;
        this.movie_genre = movie_genre;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.movie_id_txt.setText(String.valueOf(movie_id.get(position)));
        holder.movie_title_txt.setText(String.valueOf(movie_title.get(position)));
        holder.movie_studio_txt.setText(String.valueOf(movie_studio.get(position)));
        holder.movie_genre_txt.setText(String.valueOf(movie_genre.get(position)));
    }

    @Override
    public int getItemCount() {
        return movie_id.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView movie_id_txt, movie_title_txt, movie_studio_txt, movie_genre_txt;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_id_txt = itemView.findViewById(R.id.movie_id_text);
            movie_title_txt = itemView.findViewById(R.id.movie_title_txt);
            movie_studio_txt = itemView.findViewById(R.id.movie_studio_txt);
            movie_genre_txt = itemView.findViewById(R.id.movie_genre_txt2);
        }

    }


}
