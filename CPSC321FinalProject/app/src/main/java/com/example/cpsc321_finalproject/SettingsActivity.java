package com.example.cpsc321_finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.cpsc321_finalproject.databinding.ActivityHomeBinding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class SettingsActivity extends AppCompatActivity {

    static final String TAG = "SettingsActivity";

    AppUtils utils = new AppUtils();

    String username = null;
    TextView messageUser = null;

    Button changeTeamButton = null;
    Button changePasswordButton = null;
    EditText curPassword = null;
    EditText newPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.setting_toolbar);
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

        // Get data from intent
        username = getIntent().getStringExtra("username");

        // Get message text
        messageUser = findViewById(R.id.settings_message);
        // Get Buttons
        changeTeamButton = findViewById(R.id.change_team_button);
        changePasswordButton = findViewById(R.id.change_pass_button);
        // Get EditTexts
        curPassword = findViewById(R.id.cur_password_input);
        newPassword = findViewById(R.id.new_password_input);

        // Set up onClick for the changeTeamButton (launches the PickTeamActivity)
        changeTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Make sure user wants to change their favorite team with alertDialogue
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(SettingsActivity.this);
                dialogBuilder.setTitle("Change Team")
                        .setMessage("Are you sure you want to change your favorite team?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Launch the PickTeamActivity
                                Intent intent = new Intent(SettingsActivity.this, PickTeamActivity.class);
                                intent.putExtra("username", username);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel", null);
                dialogBuilder.show();
            }
        });

        // Set up onClick for the changePasswordButton
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // Check inputs
                if(curPassword.getText().toString().isEmpty() || newPassword.getText().toString().isEmpty()) {
                    // Message user
                    messageUser.setTextColor(getResources().getColor(R.color.red));
                    messageUser.setTextSize(22);
                    messageUser.setText("Please fill out the password input boxes if you wish to change your password");
                }
                else if(!(utils.checkValidPassword(newPassword.getText().toString()))) {
                    // Password does not meet the requirements, send message to user
                    messageUser.setTextColor(getResources().getColor(R.color.red));
                    messageUser.setTypeface(null, Typeface.BOLD);
                    messageUser.setTextSize(18);
                    messageUser.setText("Please input a password that is at least 8 characters long " +
                            "contains at least one number, one uppercase letter, and one lower case letter");
                }
                else {
                    // Make sure user wants to update their password
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(SettingsActivity.this);
                    dialogBuilder.setTitle("Change Password")
                            .setMessage("Are you sure you want to change your password?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Change the users password
                                    UpdatePasswordTask updatePassword = new UpdatePasswordTask();
                                    try {
                                        int updateStatus = updatePassword.execute().get();
                                        if (updateStatus == 1) {
                                            // Current password was not a match
                                            messageUser.setTextColor(getResources().getColor(R.color.red));
                                            messageUser.setTextSize(22);
                                            messageUser.setText("Check that your current password is correct.");
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            })
                            .setNegativeButton("Cancel", null);
                    dialogBuilder.show();
                }
            }
        });
    }

    private class UpdatePasswordTask extends AsyncTask<Void, Void, Integer> {

        String strCurPassword;
        String strNewPassword;
        String query;
        @Override
        protected Integer doInBackground(Void... voids) {
            Connection cn;
            Statement st;
            ResultSet rs;
            try {
                // Hash the current password
                strCurPassword = utils.hashPassword(curPassword.getText().toString());
                // Check that the current password is a match
                cn = utils.makeConnection();
                st = cn.createStatement();
                query = "SELECT password FROM User WHERE user_name='" + username + "'";
                rs = st.executeQuery(query);
                Boolean goodPassword = false;
                while(rs.next()) {
                    if(strCurPassword.equals(rs.getString("password"))) {
                        goodPassword = true;
                    }
                }
                if(goodPassword) {
                    // Hash and update the user's password
                    strNewPassword = utils.hashPassword(newPassword.getText().toString());
                    query = "UPDATE User SET password=? WHERE user_name='" + username + "'";
                    PreparedStatement ps = cn.prepareStatement(query);
                    ps.setString(1, strNewPassword);
                    ps.execute();
                    // Close connection
                    cn.close();
                    return 0;
                }
                else {
                    // Password was not a match
                    cn.close();
                    return 1;
                }

            } catch (Exception e) {
                Log.println(Log.DEBUG, TAG, e.toString());
                Log.println(Log.DEBUG, TAG, String.valueOf(e.getCause()));
            }
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }
    }

}