package com.example.cpsc321_finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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

/**
 * This activity is the first to load on the launch of this application. It is a simple user
 * login/registration page.
 */
public class MainActivity extends AppCompatActivity{

    static final String TAG = "MainActivity";

    AppUtils utils = new AppUtils();

    String url = Credentials.HOST;
    String db_user = Credentials.USER;
    String db_password = Credentials.PASSWORD;

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
                        // username is a match, now check for password
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

                                    }
                                })
                                .setNegativeButton("Cancel", null);
                        dialogBuilder.show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // TODO: Check for credentials match with query
                // Launch the MainMenu Activity if credentials match or new user
//                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                startActivity(intent);
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
                // Close connection
                cn.close();
                st.close();
                rs.close();
            } catch (Exception e) {
                Log.println(Log.DEBUG, TAG, e.toString());
                Log.println(Log.DEBUG, TAG, String.valueOf(e.getCause()));
            }
            // If user is not a match return credentialStatus = 1
            // Denotes a new user
            if(!userMatch) {return 1;}
            // If user is a match, check for a matching password
            else if (userMatch) {

            }
            return 0;
        }

        @Override
        protected void onPostExecute(Integer credentialStatus) {

            super.onPostExecute(credentialStatus);
        }
    }

    private class addUserTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Connection cn;
            try {
                cn = utils.makeConnection();
                Statement st = cn.createStatement();
                // Insert the new user into the database
                String query = "INSERT INTO User VALUES (" + username.getText().toString() + ", " + user_password.getText().toString() + ")";
                st.executeQuery(query);
                // Close connection
                cn.close();
                st.close();
            } catch (Exception e) {
                Log.println(Log.DEBUG, TAG, e.toString());
                Log.println(Log.DEBUG, TAG, String.valueOf(e.getCause()));
            }
            return null;
        }
    }
}
