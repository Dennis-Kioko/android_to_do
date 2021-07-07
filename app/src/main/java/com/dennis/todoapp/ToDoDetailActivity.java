package com.dennis.todoapp;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import com.dennis.todoapp.databinding.ActivityToDoDetailBinding;

public class ToDoDetailActivity extends AppCompatActivity {

    private ActivityToDoDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityToDoDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        Button btnComplete = findViewById(R.id.btn_complete);

      btnComplete.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Snackbar.make(v, "Task added successfully", Snackbar.LENGTH_LONG)
                      .setAction("Action", null).show();
          }
      });

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}