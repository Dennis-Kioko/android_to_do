package com.dennis.todoapp.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dennis.todoapp.R;
import com.dennis.todoapp.Settings.SharedPrefConfig;
import com.dennis.todoapp.ToDoActivity;
import com.dennis.todoapp.auth.ui.login.LoginActivity;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText txtConfirmPassword,txtPassword, txtPhoneNumber,  txtEmail, txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtName = findViewById(R.id.input_name);
        txtEmail = findViewById(R.id.input_email);
        txtPhoneNumber = findViewById(R.id.input_phone_no);
        txtPassword = findViewById(R.id.input_password);
        txtConfirmPassword = findViewById(R.id.input_confirm_password);
        Button btnRegister = findViewById(R.id.btn_register);
        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }

        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * Adding function to register a user
                 */

                registerUser();
            }
        });




    }

    private void registerUser() {

        String name, password, confirm, number, email;

        name = txtName.getText().toString().trim();
        password = txtPassword.getText().toString().trim();
        confirm = txtConfirmPassword.getText().toString().trim();
        number = txtPhoneNumber.getText().toString().trim();
        email = txtEmail.getText().toString().trim();

        SharedPrefConfig sharedPrefConfig = new SharedPrefConfig(RegisterActivity.this);
        sharedPrefConfig.setUserInfo(name, email, number, password );

        Toast.makeText(this, "User"+" "+ name+" "+ "registered successfully.", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(RegisterActivity.this, ToDoActivity.class);
        startActivity(intent);




    }
}