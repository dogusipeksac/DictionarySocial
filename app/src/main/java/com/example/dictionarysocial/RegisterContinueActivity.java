package com.example.dictionarysocial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.dictionarysocial.Adapter.LanguageLevelSpinnerAdapter;
import com.example.dictionarysocial.Adapter.LanguageSpinnerAdapter;
import com.example.dictionarysocial.Service.Firebase.LocalJson.JsonService;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class RegisterContinueActivity extends AppCompatActivity {
    private Spinner languageSpinner,languageLevelSpinner;
    private TextInputEditText full_nameInput,descriptionInput;
    private ImageView userImage,userImageIcon;
    private Button button;


    private LanguageSpinnerAdapter languageSpinnerAdapter;
    private ArrayList<String> languageSpinnerList;

    private LanguageLevelSpinnerAdapter languageLevelSpinnerAdapter;
    private ArrayList<String> languageLevelSpinnerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_continue);
        languageSpinner=findViewById(R.id.language_spinner);
        languageLevelSpinner=findViewById(R.id.language_level_spinner);
        full_nameInput=findViewById(R.id.full_name_edittext);
        descriptionInput=findViewById(R.id.description_register);
        userImage=findViewById(R.id.user_image_register);
        userImageIcon=findViewById(R.id.chose_icon);
        button=findViewById(R.id.save_register);

        ///////////////////
        //language spinner
        languageSpinnerList= JsonService.get(this).getJsonFileFromLocallyData();
        languageSpinnerAdapter=new LanguageSpinnerAdapter(this,languageSpinnerList);
        languageSpinner.setAdapter(languageSpinnerAdapter);



        ///////////////////
        //language level spinner
        languageLevelSpinnerList=JsonService.get(this).getJsonFileFromLocallyDataLevel();
        languageLevelSpinnerAdapter=new LanguageLevelSpinnerAdapter(this,languageLevelSpinnerList);
        languageLevelSpinner.setAdapter(languageLevelSpinnerAdapter);


    }
}