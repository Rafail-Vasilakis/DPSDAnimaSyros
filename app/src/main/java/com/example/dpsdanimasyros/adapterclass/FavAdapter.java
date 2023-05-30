package com.example.dpsdanimasyros.adapterclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dpsdanimasyros.R;
import com.example.dpsdanimasyros.database.DataBaseHelper;
import com.example.dpsdanimasyros.model.FavoriteModel;

import java.util.ArrayList;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FavoriteModel> favArrayList;
    private DataBaseHelper favDB;
    View.OnClickListener onClickListener;
    View.OnClickListener onClickListenerDelete;

    public FavAdapter(Context context, ArrayList<FavoriteModel> favArrayList, View.OnClickListener onClickListenerDelete) {
        this.context = context;
        this.favArrayList = favArrayList;
        this.onClickListenerDelete = onClickListenerDelete;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activityfavitem,parent,false);
        favDB = new DataBaseHelper(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.ViewHolder holder, int position) {
        FavoriteModel themesModel = favArrayList.get(position);
        holder.favImageView.setImageResource(themesModel.getImage());
        holder.title_textView.setText(themesModel.getTitle());
        holder.favImageView.setTag(position);
        holder.favBtn.setImageResource(R.drawable.pinkstar);
        holder.favBtn.setOnClickListener(onClickListenerDelete);
        holder.favBtn.setTag(position);
        holder.favImageView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return favArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView favBtn;
        ImageView favImageView;
        TextView title_textView;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            favBtn = itemView.findViewById(R.id.add_fav_btn);
            favImageView = itemView.findViewById(R.id.imageView);
            title_textView = itemView.findViewById(R.id.titleTextView);
        }

    }

    public void setItems(ArrayList<FavoriteModel> favArraylist)
    {
        this.favArrayList = favArraylist;
    }
    }
