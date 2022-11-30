package com.example.cpsc321_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.sql.*;
import java.sql.Driver;
import com.example.cpsc321_finalproject.Credentials;

/**
 * This activity is the first to load on the launch of this application. It is a simple user
 * login/registration page.
 */
public class MainActivity extends AppCompatActivity{

    static final String TAG = "MainActivity";

    EditText username = null;
    EditText password = null;
    Button loginButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load logo image from drawables folder
        ImageView appLogo = findViewById(R.id.logoImage);
        appLogo.setImageResource(R.drawable.app_logo);
        // get input fields
        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_button);


        // Set button onClick to connect with the database and check for valid input
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                // Connect to the database
                try {
                    String url = Credentials.HOST;
                    String user = Credentials.USER;
                    String password = Credentials.PASSWORD;
                    Connection cn = DriverManager.getConnection("jdbc:mysql://cps-database.gonzaga.edu/cdeide_DB", "cdeide", "maY282002Connor");
                    Log.println(Log.DEBUG, TAG, "SUCCESS");
                    Statement st = cn.createStatement();
                } catch (Exception e) {
                    Log.println(Log.DEBUG, TAG, "FAILED");
                    Log.println(Log.DEBUG, TAG, e.toString());
                    Log.println(Log.DEBUG, TAG, e.getMessage());
                }
            }
        });

    }
}