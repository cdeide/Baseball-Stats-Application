package com.example.cpsc321_finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlayerSearchActivity extends AppCompatActivity {

    CustomAdapter adapter;

    // Load the settings menu icon into the toolbar and set the onClick event
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_subpage, menu);
        MenuItem item = menu.findItem(R.id.menu_home);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                Intent intent = new Intent(PlayerSearchActivity.this, HomeActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_search);

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.playersearch_toolbar);
        setSupportActionBar(toolbar);
        // Set up back button
        toolbar.setNavigationIcon(R.drawable.ic__arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the current activity
                finish();
            }
        });

        // Set up the recyclerView
        RecyclerView recyclerView = findViewById(R.id.search_recycler_view);
        // Set up the layoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // Set up the adapter
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);

        // Set message to invisible once user has added a filter
        TextView addItemsMessage = findViewById(R.id.addItemsMessage);

    }

    class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

        TextView searchItemTitle;
        EditText minItemInput;
        EditText maxItemInput;
        Button searchButton;

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(PlayerSearchActivity.this)
                    .inflate(R.layout.search_view_item, parent, false);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public CustomViewHolder(View view) {
                super(view);
                searchItemTitle = view.findViewById(R.id.search_item_title);
                minItemInput = view.findViewById(R.id.item_min_input);
                maxItemInput = view.findViewById(R.id.item_max_input);
                searchButton = findViewById(R.id.search_button);
            }

            @Override
            public void onClick(View v) {
                return;
            }
        }
    }
}