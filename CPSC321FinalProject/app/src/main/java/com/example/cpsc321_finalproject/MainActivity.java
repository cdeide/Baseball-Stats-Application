package com.example.cpsc321_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.sql.*;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/**
 * This activity is the first to load on the launch of this application. It is a simple user
 * login/registration page.
 */
public class MainActivity extends AppCompatActivity{

    static final String TAG = "MainActivity";

    String url = Credentials.HOST;
    String db_user = Credentials.USER;
    String db_password = Credentials.PASSWORD;

    EditText username = null;
    EditText user_password = null;
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
        user_password = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_button);

        // Set button onClick to connect with the database and check for valid input
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                // Connect to the database
                // AsynkTask Approach
                DBConnector connector = new DBConnector();
                connector.execute();

                // Thread Executor Approach
                ExecutorImp connect = new ExecutorImp();

                try {
                    connect.execute(new NewThread());
                } catch (RejectedExecutionException e) {
                    Log.println(Log.DEBUG, TAG, "Rejected");
                    Log.println(Log.DEBUG, TAG, String.valueOf(e.getCause()));
                }

                Log.println(Log.DEBUG, TAG, "SUCCESS");

                // TODO: Check for credentials match with query
                // Launch the MainMenu Activity if credentials match or new user
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    class ExecutorImp implements Executor {
        @Override
        public void execute(Runnable command)
        {
            new Thread(command).start();
        }
    }

    class NewThread implements Runnable {
        @Override
        public void run()
        {
            System.out.println("Thread executed under an executor");
            Connection cn;
            try {
                Log.println(Log.DEBUG, TAG, "CHECK 1");
                Class.forName("com.mysql.jdbc.Driver");
                Log.println(Log.DEBUG, TAG, "CHECK 2");
                cn = DriverManager.getConnection(url, db_user, db_password);
                Log.println(Log.DEBUG, TAG, "CHECK 3");
                Statement st = cn.createStatement();
                Log.println(Log.DEBUG, TAG, "CHECK 4");
            } catch (Exception e) {
                Log.println(Log.DEBUG, TAG, e.toString());
                Log.println(Log.DEBUG, TAG, String.valueOf(e.getCause()));
            }
        }
    }

    private class DBConnector extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.println(Log.DEBUG, TAG, db_user);
            Connection cn;
            try {
                Log.println(Log.DEBUG, TAG, "CHECK 1");
                Class.forName("com.mysql.jdbc.Driver");
                Log.println(Log.DEBUG, TAG, "CHECK 2");
                cn = DriverManager.getConnection(url, db_user, db_password);
                Log.println(Log.DEBUG, TAG, "CHECK 3");
                Statement st = cn.createStatement();
                Log.println(Log.DEBUG, TAG, "CHECK 4");
            } catch (Exception e) {
                Log.println(Log.DEBUG, TAG, e.toString());
                Log.println(Log.DEBUG, TAG, String.valueOf(e.getCause()));
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
        }
    }
}
