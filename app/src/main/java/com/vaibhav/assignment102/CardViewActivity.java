package com.vaibhav.assignment102;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class CardViewActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Palette mPalette;
    private RecyclerView mRecyclerView;
    int defaultColor;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        getSupportActionBar().setTitle("Android Versions");


        defaultColor = ContextCompat.getColor(getApplicationContext(), android.R.color.holo_green_dark);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        getPhoto();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final String[] myDataset = {"Alpha", "Beta", "CupCake", "Donut",
                "Eclair", "Froyo", "Gingerbread", "Honeycomb",
                "Ice-Cream Sandwich", "JellyBean", "KitKat", "Lollipop", "MarshMallow", "Nougat"};


        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new CardViewDataAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Toast.makeText(getApplicationContext(),
                                "Data : " + myDataset[position],
                                Toast.LENGTH_SHORT).show();

                    }
                }));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Settings Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "Search Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_add) {
            Toast.makeText(getApplicationContext(), "Add Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_delete) {
            Toast.makeText(getApplicationContext(), "Delete Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getPhoto() {
        Bitmap photo = BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_delete);
        colorize(photo);
    }

    private void colorize(Bitmap photo) {
        mPalette = Palette.generate(photo);
        applyPalette();
    }

    private void applyPalette() {
        getWindow().setBackgroundDrawable(new ColorDrawable(mPalette.getDarkMutedColor(defaultColor)));
        mRecyclerView.setBackgroundColor(mPalette.getLightVibrantColor(defaultColor));
        toolbar.setBackgroundColor(mPalette.getLightVibrantColor(defaultColor));
        fab.setBackgroundTintList(ColorStateList.valueOf(mPalette.getLightVibrantColor(defaultColor)));

    }
}