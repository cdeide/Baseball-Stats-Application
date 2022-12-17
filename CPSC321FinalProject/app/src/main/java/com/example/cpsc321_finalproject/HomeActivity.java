package com.example.cpsc321_finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {

    String username;

    ImageView appLogo = null;
    Button playerSearchButton = null;
    Button teamRosterButton = null;
    Button teamHistoryButton = null;
    Button otherTeamsButton = null;

    // Load the settings menu icon into the toolbar and set the onClick event
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        MenuItem item = menu.findItem(R.id.menu_settings);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
                return false;
            }
        });
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);

        // Get username from the intent
        username = getIntent().getStringExtra("username");

        // Load the app logo
        appLogo = findViewById(R.id.home_logoImage);
        appLogo.setImageResource(R.drawable.app_logo);

        // Get buttons
        playerSearchButton = findViewById(R.id.player_search_button);
        teamRosterButton = findViewById(R.id.team_roster_button);
        teamHistoryButton = findViewById(R.id.team_history_button);
        otherTeamsButton = findViewById(R.id.other_teams_button);

        // Set the playerSearchButton onCLick
        playerSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the PlayerSearchActivity
                Intent intent = new Intent(HomeActivity.this, PlayerSearchActivity.class);
                startActivity(intent);
            }
        });

        // Set the teamRosterButton onClick
        // Set the teamHistoryButton onClick
        // Set the otherTeamsButton onClick
    }
}