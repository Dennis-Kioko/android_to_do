    package com.dennis.todoapp.Settings;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefConfig {

   private SharedPreferences sharedPreferences;
   private Context context;
   private static final String SHARED_PREF_NAME = "com.dennis.todoapp.Settings.PREF_NAME";
   private static final String LOGIN_STATUS = "com.dennis.todoapp.Settings.login";
   private static final String LOGIN_NAME= "com.dennis.todoapp.Settings.name";
   private static final String LOGIN_EMAIL = "com.dennis.todoapp.Settings.email";
   private static final String LOGIN_NUMBER = "com.dennis.todoapp.Settings.number";
   private static final String LOGIN_PASSWORD= "com.dennis.todoapp.Settings.password";

    public SharedPrefConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(LOGIN_STATUS,false);
    }

    public void setLoggingInStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(LOGIN_STATUS, status);
        editor.apply();
    }

    public void setUserInfo(String name, String email, String number, String password){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LOGIN_NAME, name);
        editor.putString(LOGIN_EMAIL, email);
        editor.putString(LOGIN_NUMBER, number);
        editor.putString(LOGIN_PASSWORD, password);
        editor.apply();



    }
}
