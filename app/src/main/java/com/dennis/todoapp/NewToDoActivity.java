package com.dennis.todoapp;

import androidx.appcompat.app.AppCompatActivity;

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

public class NewToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_to_do);

        Button btnCancel = findViewById(R.id.btnCancel);

        Button btnCreateTask = findViewById(R.id.btnCreateTask);


        ImageButton btnAddSubtask = findViewById(R.id.btnAddSubtask);


        ImageView imgFirstFile = findViewById(R.id.imgFirstFile);

        ImageView imgSecondFile = findViewById(R.id.imgSecondFile);


        TextInputEditText editTitle = findViewById(R.id.editTitle);

        TextInputEditText editDetails = findViewById(R.id.editDetails);

        TextInputEditText editSubtasks = findViewById(R.id.editSubtasks);

        Note newNote= new Note();




        btnCreateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newNote.setTittle(editTitle.getText().toString());
                newNote.setDescription(editDetails.getText().toString());



                Toast.makeText(NewToDoActivity.this,newNote.getTittle(), Toast.LENGTH_SHORT).show();

                Snackbar.make(v, newNote.getDescription(), Snackbar.LENGTH_LONG).show();
            }
        });





    }
}