package com.example.dictionarysocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText email,password;
    private TextView goto_register;
    private Button login_button;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email_edittext_login);
        password=findViewById(R.id.password_edittext_login);
        goto_register=findViewById(R.id.goto_register);
        login_button=findViewById(R.id.Login_button);



        CheckLogin();
    }

    public void CheckLogin(){

        login_button.setOnClickListener(v -> {
            isAllFieldsChecked = CheckAllFields();
            if (isAllFieldsChecked) {
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
            }
        });



    }
    private boolean CheckAllFields() {
        if (email.length() == 0 && password.length() == 0) {
            email.setError("Email is required");
            password.setError("Password is required");
            return false;
        }

        if(email.length() == 0){
            email.setError("Email is required");
            return false;
        }
        if(password.length() == 0){
            password.setError("Password is required");
            return false;
        }
        else if (password.length() < 8) {
            password.setError("Password must be minimum 8 characters");
            return false;
        }

        // after all validation return true.
        return true;
    }



}