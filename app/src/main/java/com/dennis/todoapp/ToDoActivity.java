package com.dennis.todoapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.dennis.todoapp.databinding.ActivityToDoBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ToDoActivity extends AppCompatActivity {


    int numberOfSearches = 0;

    private AppBarConfiguration appBarConfiguration;
    private ActivityToDoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);




        TextInputEditText inputSearch = findViewById(R.id.inputSearch);

        inputSearch.setOnEditorActionListener((v , actionId, event)-> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH){

                Toast.makeText(this, "Number of searches is:" + addNumbers(), Toast.LENGTH_SHORT).show();
                return true;
            }

            return false;
        });
                
        Toolbar toolbar = findViewById(R.id.toolbar);

        CardView singleCard = findViewById(R.id.card_single);
        singleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToDoActivity.this,ToDoDetailActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);

        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToDoActivity.this,NewToDoActivity.class);
                startActivity(intent);

            }
        });
    }



    public int addNumbers()
    {
        return numberOfSearches++;

    }
}