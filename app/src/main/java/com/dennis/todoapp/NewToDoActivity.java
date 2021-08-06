package com.dennis.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.dennis.todoapp.models.Note;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

import io.objectbox.Box;

public class NewToDoActivity extends AppCompatActivity {


    TextInputEditText editTitle;
    private Box<Note> noteBox;
    TextInputEditText editDetails, editSubtasks;
    Note newNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        noteBox = ObjectBox.get().boxFor(Note.class);


        setContentView(R.layout.activity_new_to_do);

        Button btnCancel = findViewById(R.id.btnCancel);

        Button btnCreateTask = findViewById(R.id.btnCreateTask);


        ImageButton btnAddSubtask = findViewById(R.id.btnAddSubtask);


        ImageView imgFirstFile = findViewById(R.id.imgFirstFile);

        ImageView imgSecondFile = findViewById(R.id.imgSecondFile);


        editTitle = findViewById(R.id.editTitle);

        editDetails = findViewById(R.id.editDetails);

        editSubtasks = findViewById(R.id.editSubtasks);




        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();


            }
        });


        btnCreateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newNote.setTittle(editTitle.getText().toString());
                newNote.setDescription(editDetails.getText().toString());

                long id = noteBox.put(newNote);  // creates a new note in the database


                Intent intent = new Intent(NewToDoActivity.this, ToDoDetailActivity.class);
                intent.putExtra("ID", id);

                startActivity(intent);


            }


        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (getIntent().hasExtra("ID")) {

            newNote = noteBox.get(getIntent().getLongExtra("ID", 0));

            editTitle.setText(newNote.getTittle());
            editDetails.setText(newNote.getDescription());
            newNote.setUpdated_at(new Date().toString());

        }

        else {
            newNote = new Note();
            newNote.setCreated_at(new Date().toString());
            newNote.setUpdated_at(new Date().toString());
        }

    }



    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (editTitle.getText().toString().trim().isEmpty()){

            Toast.makeText(this,"Nothing to save", Toast.LENGTH_SHORT).show();
        }

        else {

            Toast.makeText(this,"Not saved to draft", Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}