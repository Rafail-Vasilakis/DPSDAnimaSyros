package com.example.dpsdanimasyros.adapterclass;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dpsdanimasyros.InformationProgramActivity;
import com.example.dpsdanimasyros.R;
import com.example.dpsdanimasyros.database.DataBaseHelper;
import com.example.dpsdanimasyros.model.ThemeModel;

import java.util.ArrayList;

public class ThemesAdapter extends RecyclerView.Adapter<ThemesAdapter.viewHolder> {

    private final ArrayList<ThemeModel> themeModels;
    private final Context context;
    private DataBaseHelper favDB;

    public ThemesAdapter(ArrayList<ThemeModel> themeModels, Context context) {
        this.themeModels = themeModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ThemesAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        favDB = new DataBaseHelper(context);
        return new viewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ThemesAdapter.viewHolder holder, int position) {
        final ThemeModel themeModelfav = themeModels.get(position);
        Cursor cursor = favDB.readAllData3();
        if (cursor.getCount() !=0)
        {
            while (cursor.moveToNext())
            {
                ArrayList<String> ids = new ArrayList<>();
                ids.add(cursor.getString(0));
                if (ids.contains(themeModelfav.getKey_id()))
                {
                   holder.favBtn.setImageResource(R.drawable.pinkstar);
                }
            }
        }
        String title = themeModelfav.getTitle();
        int image = themeModelfav.getImage();
        String id = themeModelfav.getKey_id();
        holder.imageView.setImageResource(themeModelfav.getImage());
        holder.titleTextView.setText(themeModelfav.getTitle());
        holder.imageView.setTag(position);

        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkFavorite(title, image, holder.favBtn, id);

            }
        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, InformationProgramActivity.class);
                intent.putExtra("Image", image ); // Pass the position of the clicked item
                intent.putExtra("Title", title ); // Pass the position of the clicked item
                intent.putExtra("ButtonPressed", position); // Pass the position of the clicked item
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return themeModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        ImageView favBtn;
        CardView cardView;

        public viewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            favBtn = itemView.findViewById(R.id.add_fav_btn);
            cardView = itemView.findViewById(R.id.cardViewThemes);
        }

    }

    private void checkFavorite(String title, int image, ImageView favorite, String unique_id)
    {
        Cursor cursor = favDB.readAllData3();

        if (cursor.getCount() != 0)
        {
            while (cursor.moveToNext())
            {
                if (cursor.getString(0).equalsIgnoreCase(unique_id))
                {
                    favDB.deleteItem3(unique_id);
                    favorite.setImageResource(R.drawable.purplestar);
                    return;
                }
            }
        }

        favDB.addScanRecord3(unique_id,title,image);
        favorite.setImageResource(R.drawable.pinkstar);
    }
}
