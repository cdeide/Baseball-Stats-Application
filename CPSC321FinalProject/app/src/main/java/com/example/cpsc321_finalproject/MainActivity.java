package com.example.cpsc321_finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.*;
import java.util.concurrent.ExecutionException;

/**
 * This activity is the first to load on the launch of this application. It is a simple user
 * login/registration page.
 */
public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";

    AppUtils utils = new AppUtils();
    Intent intent = null;

    EditText username = null;
    EditText user_password = null;
    Button loginButton = null;
    TextView message_user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load logo image from drawables folder
        ImageView appLogo = findViewById(R.id.logoImage);
        appLogo.setImageResource(R.drawable.app_logo);
        // get input fields
        username = findViewById(R.id.username_input);
        user_password = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_button);
        // get Message TextView
        message_user = findViewById(R.id.message_user);

        // Set button onClick to connect with the database and check for valid input
        loginButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view){
//                //Temporary bypass
//                Intent intent = new Intent(MainActivity.this, PickTeamActivity.class);
//                startActivity(intent);

                // Check for valid input fields
                if(username.getText().toString().equals("") || user_password.getText().toString().equals("")) {
                    // An input is empty, send message to user
                    message_user.setTextColor(getResources().getColor(R.color.red));
                    message_user.setTypeface(null, Typeface.BOLD);
                    message_user.setTextSize(22);
                    message_user.setText("Please input a username and password");
                    return;
                }
                else if(!(utils.checkValidPassword(user_password.getText().toString()))) {
                    // Password does not meet the requirements, send message to user
                    message_user.setTextColor(getResources().getColor(R.color.red));
                    message_user.setTypeface(null, Typeface.BOLD);
                    message_user.setTextSize(18);
                    message_user.setText("Please input a password that is at least 8 characters long " +
                            "contains at least one number, one uppercase letter, and one lower case letter");
                    return;
                }

                // Check if the user is already in the database and handle accordingly
                // Need to connect to the database off of the UI Thread
                CheckCredentialsTask checkCredentials = new CheckCredentialsTask();
                int credentialStatus = 0;
                try {
                    credentialStatus = checkCredentials.execute().get();
                    Log.println(Log.DEBUG, TAG, String.valueOf(credentialStatus));
                    if(credentialStatus == 0) {
                        // Credentials are a match, launch the HomeActivity
                        intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                    else if(credentialStatus == 1) {
                        Log.println(Log.DEBUG, TAG, "ENTERED");
                        // username does not match meaning a new user, ask user if they would like
                        // to register new account
                        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                        dialogBuilder.setTitle("Register User")
                                .setMessage("Looks like you're a new user! Would you like to register this account?")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Add user to the Database and launch the HomeActivity
                                        AddUserTask addUser = new AddUserTask();
                                        try {
                                            addUser.execute();
                                            // If user is successfully added, launch the PickTeamActivity
                                            Intent intent = new Intent(MainActivity.this, PickTeamActivity.class);
                                            intent.putExtra("username", username.getText().toString());
                                            startActivity(intent);
                                        } catch (Exception e) {
                                            message_user.setTextColor(getResources().getColor(R.color.red));
                                            message_user.setTypeface(null, Typeface.BOLD);
                                            message_user.setTextSize(18);
                                            message_user.setText("There was a problem connecting to the Database");
                                            e.printStackTrace();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancel", null);
                        dialogBuilder.show();
                    }
                    else if(credentialStatus == 2) {
                        // Password does not match a valid user's password, message the user for
                        // an incorrect password
                        message_user.setTextColor(getResources().getColor(R.color.red));
                        message_user.setTypeface(null, Typeface.BOLD);
                        message_user.setTextSize(18);
                        message_user.setText("Incorrect Password: \n" +
                                "The password input does not match the password for this username");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @SuppressLint("StaticFieldLeak")
    private class CheckCredentialsTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            Boolean userMatch = false;
            Connection cn;
            try {
                cn = utils.makeConnection();
                Statement st = cn.createStatement();
                // Check that the username is present in the database
                String query = "SELECT user_name FROM User";
                ResultSet rs = st.executeQuery(query);
                while(rs.next()) {
                    Log.println(Log.DEBUG, TAG, rs.getString("user_name"));
                    if(username.getText().toString().equals(rs.getString("user_name"))) {
                        userMatch = true;
                        break;
                    }
                }
                if(userMatch) {
                    // Check that input password matches password on file
                    query = "SELECT password FROM User WHERE user_name=" + "'" + username.getText().toString() + "'";
                    Log.println(Log.DEBUG, TAG, query);
                    rs = st.executeQuery(query);
                    while(rs.next()) {
                        if (utils.hashPassword(user_password.getText().toString()).equals(rs.getString("password"))) {
                            // Matching password, return credentialStatus = 0
                            // Denotes valid credentials
                            cn.close();
                            return 0;
                        }
                    }
                    // Password does not match, return credentialStatus = 2
                    // Denotes incorrect password
                    cn.close();
                    return 2;
                }
                else {
                    // If user is not a match return credentialStatus = 1
                    // Denotes a new user
                    cn.close();
                    return 1;
                }
            } catch (Exception e) {
                Log.println(Log.DEBUG, TAG, e.toString());
                Log.println(Log.DEBUG, TAG, String.valueOf(e.getCause()));
            }
            return 0;
        }

        @Override
        protected void onPostExecute(Integer credentialStatus) {
            // Return the credential status to the UI Thread
            super.onPostExecute(credentialStatus);
        }
    }

    private class AddUserTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Connection cn;
            try {
                // Hash the users password
                String hashedPassword = utils.hashPassword(user_password.getText().toString());
                // Make connection
                cn = utils.makeConnection();
                // Insert the new user into the database
                Log.println(Log.DEBUG, TAG, "HERE");
                String query = " INSERT INTO User (user_name, password, fav_team)" +
                        " VALUES (?, ?, ?)";
                PreparedStatement ps = cn.prepareStatement(query);
                ps.setString(1, username.getText().toString());
                ps.setString(2, hashedPassword);
                ps.setString(3, null);
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
