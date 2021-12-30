package com.example.dictionarysocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dictionarysocial.Adapter.LanguageSpinnerAdapter;
import com.example.dictionarysocial.Service.Firebase.LocalJson.JsonService;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    private Spinner spinner;
    private ImageView user_imageView,back_imageView;
    private TextView user_name;
    private TextInputEditText descriptionEditText;
    private Button button_shared;
    private LanguageSpinnerAdapter spinnerAdapter;
    private ArrayList<String> spinnerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        spinner=findViewById(R.id.spinner);
        user_imageView=findViewById(R.id.profile_image_post);
        user_name=findViewById(R.id.username_post);
        descriptionEditText=findViewById(R.id.description_edittext);
        button_shared=findViewById(R.id.shared_Button);
        back_imageView=findViewById(R.id.back);
        spinnerList= JsonService.get(this).getJsonFileFromLocallyData();
        spinnerAdapter=new LanguageSpinnerAdapter(this,spinnerList);
        spinner.setAdapter(spinnerAdapter);
        back_imageView.setOnClickListener(v -> {
            Intent intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
        });
    }
}