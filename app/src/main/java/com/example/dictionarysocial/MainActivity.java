package com.example.dictionarysocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button sign_up_button,sign_in_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sign_up_button=findViewById(R.id.signup_button);
        sign_in_button=findViewById(R.id.signin_button);

        sign_up_button.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
            startActivity(intent);
        });
        sign_in_button.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        });
    }
}