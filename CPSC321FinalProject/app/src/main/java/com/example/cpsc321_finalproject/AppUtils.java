package com.example.cpsc321_finalproject;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppUtils {

    static final String TAG = "AppUtils";

    String url = Credentials.HOST;
    String db_user = Credentials.USER;
    String db_password = Credentials.PASSWORD;

    public boolean checkValidPassword(String password) {
        Boolean upperPresent = false, lowerPresent = false, numberPresent = false;

        // Check length
        if(password.length() < 8) {return false;}
        // Check other password requirements
        for(int idx = 0; idx < password.length(); idx++) {
            if(Character.isUpperCase(password.charAt(idx))) {
                upperPresent = true;
            }
            else if(Character.isLowerCase(password.charAt(idx))) {
                lowerPresent = true;
            }
            else if(Character.isDigit(password.charAt(idx))) {
                numberPresent = true;
            }
        }
        // Return true if password meets all requirements
        if(upperPresent && lowerPresent && numberPresent) {
            return true;
        }
        return false;
    }

    public String hashPassword(String password) {
        String hashedPassword = String.valueOf(password.hashCode());
        return hashedPassword;
    }

    public Connection makeConnection() throws SQLException {
        Connection cn = DriverManager.getConnection(url, db_user, db_password);
        return cn;
    }
}
