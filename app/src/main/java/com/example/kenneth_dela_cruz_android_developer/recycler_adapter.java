package com.example.kenneth_dela_cruz_android_developer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class recycler_adapter extends RecyclerView.Adapter<recycler_adapter.ViewHolder> {

    private final Context context;
    private List<made_for_you_class> uriArrayLists;
    String id;
    String breederID;

    public recycler_adapter( Context context) {
        this.uriArrayLists = new ArrayList<>();
        this.context = context;

    }
    public void addImage(List<made_for_you_class> uriArrayList){
        this.uriArrayLists = uriArrayList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.made_for_you_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        made_for_you_class made =  uriArrayLists.get(position);
        if(made.image != 0)
        Picasso.get()
                .load(made.getImage())
                .placeholder(R.drawable.icon_noimage)
                .into(holder.imageView);

        holder.title.setText(made.getTitle());
        holder.message.setText(made.getMessage());
    }

    @Override
    public int getItemCount() {
        return uriArrayLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, message;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            message = itemView.findViewById(R.id.message);
            imageView = itemView.findViewById(R.id.image);

        }
    }
}
