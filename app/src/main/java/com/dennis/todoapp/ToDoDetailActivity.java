package com.dennis.todoapp;

import android.content.Intent;
import android.os.Bundle;

import com.dennis.todoapp.models.Note;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import io.objectbox.Box;

public class ToDoDetailActivity extends AppCompatActivity {

    CollapsingToolbarLayout toolBarLayout;
    TextView txtToDoDetails;
    private Box<Note> noteBox;
    long idToUse = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_to_do_detail);

        noteBox = ObjectBox.get().boxFor(Note.class);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolBarLayout = findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        TextView txtToDoTime = findViewById(R.id.txtToDoTime);

        TextView txtToDoDate = findViewById(R.id.txtToDoDate);

        txtToDoDetails = findViewById(R.id.ToDoDetails);

        Button btnDelete = findViewById(R.id.btnDelete);

        Button btnComplete = findViewById(R.id.btnComplete);


      btnComplete.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Snackbar.make(v, "Task added successfully", Snackbar.LENGTH_LONG)
                      .setAction("Action", null).show();
              Intent intent = new Intent(ToDoDetailActivity.this, ToDoActivity.class);
              startActivity(intent);
              finish();
          }
      });



      btnDelete.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //ToDO: Add alert to ask user if he/she really wants to delete this

              if (idToUse == 0){
                  Toast.makeText(ToDoDetailActivity.this, "No Todo Selected", Toast.LENGTH_SHORT).show();


              }

              else{
                  noteBox.remove(idToUse);
                  Snackbar.make(v,"Todo deleted successfully", Snackbar.LENGTH_SHORT).show();
                  Intent intent = new Intent(ToDoDetailActivity.this, ToDoActivity.class);
                  startActivity(intent);
                  finish();
              }



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

    @Override
    protected void onResume() {
        super.onResume();

        if (getIntent().hasExtra("ID")){



            idToUse = getIntent().getLongExtra("ID", 0);
            Note savedNote = noteBox.get(idToUse);

            toolBarLayout.setTitle(savedNote.getTittle());
            txtToDoDetails.setText(savedNote.getDescription());



        }
    }
}