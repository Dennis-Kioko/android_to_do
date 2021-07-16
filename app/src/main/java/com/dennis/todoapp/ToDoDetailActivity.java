package com.dennis.todoapp;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ToDoDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_to_do_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        TextView txtToDoTime = findViewById(R.id.txtToDoTime);

        TextView txtToDoDate = findViewById(R.id.txtToDoDate);

        TextView txtToDoDetails = findViewById(R.id.txtToDoDetails);

        Button btnDelete = findViewById(R.id.btnDelete);

        Button btnComplete = findViewById(R.id.btnComplete);

      btnComplete.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Snackbar.make(v, "Task added successfully", Snackbar.LENGTH_LONG)
                      .setAction("Action", null).show();
          }
      });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}