package com.example.dpsdanimasyros;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dpsdanimasyros.adapterclass.FavAdapter;
import com.example.dpsdanimasyros.database.DataBaseHelper;
import com.example.dpsdanimasyros.model.FavoriteModel;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataBaseHelper favDB;
    private FavAdapter favAdapter;
    private ArrayList<FavoriteModel> arrayListFav = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);


        LinearLayout navigationBar = findViewById(R.id.navigation_bar);

        // Inflate the new layout
        View newLayout = getLayoutInflater().inflate(R.layout.activity_navbar_layout, navigationBar, false);

        // Remove the existing layout from the LinearLayout
        navigationBar.removeAllViews();

        // Add the new layout to the LinearLayout
        navigationBar.addView(newLayout);


        recyclerView = findViewById(R.id.recyclerviewFav);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        favDB = new DataBaseHelper(this);

        getAllFavorite();

    }

    private void getAllFavorite()
    {
        Cursor cursor = favDB.readAllData3();
        if (cursor.getCount() == 0)
        {
            Toast.makeText(FavoritesActivity.this, "No Data", Toast.LENGTH_SHORT).show();
        }else
        {
            while (cursor.moveToNext())
            {
                FavoriteModel themeModel = new FavoriteModel();
                themeModel.setKey_id(cursor.getString(0));
                themeModel.setTitle(cursor.getString(1));
                themeModel.setImage(cursor.getInt(3));
                arrayListFav.add(themeModel);
            }
            favAdapter = new FavAdapter(FavoritesActivity.this,arrayListFav,onclickListenerDelete);
            recyclerView.setAdapter(favAdapter);
            favAdapter.notifyDataSetChanged();
        }

    }

    View.OnClickListener onclickListenerDelete = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int pos = (int) view.getTag();
            favDB.deleteItem3(arrayListFav.get(pos).getKey_id());
            arrayListFav.remove(arrayListFav.get(pos));
            favAdapter.setItems(arrayListFav);
            favAdapter.notifyDataSetChanged();
        }
    };
}

