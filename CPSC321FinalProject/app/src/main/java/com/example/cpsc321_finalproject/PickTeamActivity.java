package com.example.cpsc321_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.nio.channels.AsynchronousChannelGroup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PickTeamActivity extends AppCompatActivity {

    static final String TAG = "PickTeamActivity";

    AppUtils utils = new AppUtils();

    String username = null;
    Spinner teamSpinner = null;
    Button goButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_team);

        // Get data from intent
        username = getIntent().getStringExtra("username");

        // Load logo image from drawables folder
        ImageView appLogo = findViewById(R.id.logoImage);
        appLogo.setImageResource(R.drawable.app_logo);
        // Get spinner and button
        teamSpinner = (Spinner) findViewById(R.id.team_spinner);
        goButton = findViewById(R.id.go_button);

        // Need to query the database for all of the teams to fill the spinner
        GetTeamsTask getTeams = new GetTeamsTask();
        try {
            List<String> teams = getTeams.execute().get();
            // On success, fill the spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, teams);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            teamSpinner.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set goButton onClick() to INSERT the favorite team into the DB and launch the HomeActivity
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the team selected in the spinner
                String[] team_name = {(String) teamSpinner.getSelectedItem()};
                // Insert into DB
                UpdateTeamTask updateTeam = new UpdateTeamTask();
                updateTeam.execute(team_name);
                // Launch the HomeActivity
                Intent intent = new Intent(PickTeamActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private class GetTeamsTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            Connection cn;
            // Build array of team names
            ArrayList<String> teams = new ArrayList<String>();
            try {
                cn = utils.makeConnection();
                Statement st = cn.createStatement();
                // Get the team names from the DB
                String query = "SELECT name FROM Team";
                ResultSet rs = st.executeQuery(query);
                while(rs.next()) {
                    //Log.println(Log.DEBUG, TAG, rs.getString("name"));
                    teams.add(rs.getString("name"));
                }
            } catch (Exception e) {
                Log.println(Log.DEBUG, TAG, e.toString());
                Log.println(Log.DEBUG, TAG, String.valueOf(e.getCause()));
            }
            return teams;
        }

        @Override
        protected void onPostExecute(ArrayList<String> teams) {
            // Returns the string of team names
            super.onPostExecute(teams);
        }
    }

    private class UpdateTeamTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... team_name) {
            Connection cn;
            try {
                // Make connection
                cn = utils.makeConnection();
                // Update the favorite team
                String query = "UPDATE User SET fav_team=? WHERE user_name='" + username + "'";
                PreparedStatement ps = cn.prepareStatement(query);
                ps.setString(1, team_name[0]);
                ps.execute();
                // Close connection
                cn.close();
            } catch (Exception e) {
                Log.println(Log.DEBUG, TAG, e.toString());
                Log.println(Log.DEBUG, TAG, String.valueOf(e.getCause()));
            }
            return null;
        }
    }
}

