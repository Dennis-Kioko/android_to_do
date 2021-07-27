package com.dennis.todoapp.Settings;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefConfig {

    private SharedPreferences sharedPreferences;
    private Context context;
    private  static final String SHARED_PREF_NAME = "com.dennis.todoapp.Settings.SHARED_PREF";
    private static final  String LOGIN_STATUS = "com.dennis.todoapp.Settings.login";


    public SharedPrefConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        }


    public void setLoggingInStatus(boolean status){
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putBoolean(LOGIN_STATUS, status);
    editor.apply();
    }

    public boolean isLoggedIn(){

        return sharedPreferences.getBoolean(LOGIN_STATUS, false);

    }



}
