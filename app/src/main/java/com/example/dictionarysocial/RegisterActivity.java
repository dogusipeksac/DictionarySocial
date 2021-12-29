package com.example.dictionarysocial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dictionarysocial.Service.Firebase.Authentication;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText email,username,password,confirm_password;
    private TextView gotologin;
    private Button register_button;
    boolean isAllFieldsChecked = false;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=findViewById(R.id.email_edittext);
        username=findViewById(R.id.username_edittext);
        password=findViewById(R.id.password_edittext);
        confirm_password=findViewById(R.id.password_check_edittext);
        gotologin=findViewById(R.id.go_tologin_text);
        register_button=findViewById(R.id.register_button);


        CheckRegister();

    }
    public void CheckRegister(){
        register_button.setOnClickListener(v -> {
            /*progressDialog=new ProgressDialog(RegisterActivity.this);
            progressDialog.setMessage("Please wait..");
            progressDialog.show();*/
            isAllFieldsChecked = CheckAllFields();
            if (isAllFieldsChecked) {
                String e_mail=email.getText().toString();
                String user_name=username.getText().toString();
                String passwords=password.getText().toString();
                Authentication.get(RegisterActivity.this).register(e_mail,passwords,user_name);
            }
        });
    }
    private boolean CheckAllFields() {
        if (email.length() == 0 &&
                password.length() == 0 &&
                username.length()==0 &&
                confirm_password.length()==0) {
            email.setError("Email is required");
            password.setError("Password is required");
            confirm_password.setError("Confirm password required");
            username.setError("Username required");
            return false;
        }

        if(!password.getText().toString().equals(confirm_password.getText().toString())){
            password.setError("Password and Confirm password not equals");
            confirm_password.setError("Password and Confirm password not equals");
            return false;
        }
        if(username.length()==0){
            username.setError("Username required");
            return false;
        }
        if(email.length() == 0){
            email.setError("Email is required");
            return false;
        }
        if(confirm_password.length()==0){
            confirm_password.setError("Confirm password required");
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