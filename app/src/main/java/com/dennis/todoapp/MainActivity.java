 package com.dennis.todoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dennis.todoapp.Settings.SharedPrefConfig;
import com.dennis.todoapp.auth.ui.login.LoginActivity;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mainButton = findViewById(R.id.btn_main);

        mainButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                SharedPrefConfig myPreferenceStorage = new SharedPrefConfig(getApplicationContext());

                if (myPreferenceStorage.isLoggedIn()){


                    Intent intent = new Intent(MainActivity.this, ToDoActivity.class);
                    startActivity(intent);
                }

                else{
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            }
        });

    }


 }