package com.example.dictionarysocial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

public class SplashActivity extends AppCompatActivity {

    //private Toolbar toolbar;
    private ImageView logoImage;
    private Button titleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logoImage=findViewById(R.id.logoImage);
        titleButton=findViewById(R.id.title_Button);


        startAnimation();


        //kod ile corner verme
        /*toolbar=findViewById(R.id.toolbar);
        float radius = 15f;
        MaterialShapeDrawable toolbarBackground = (MaterialShapeDrawable) toolbar.getBackground();
        toolbarBackground.setShapeAppearanceModel(
                toolbarBackground.getShapeAppearanceModel()
                        .toBuilder()
                        .setBottomRightCorner(CornerFamily.ROUNDED,radius)
                        .setBottomLeftCorner(CornerFamily.ROUNDED,radius)
                        .build()
        );*/
    }
    void startAnimation(){
        Thread logoAnimation=new Thread(){
            @Override
            public void run(){
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_into_logo);
                logoImage.startAnimation(animation);
            }
        };
        logoAnimation.start();
        /*Thread titleAnimation=new Thread(){
            @Override
            public void run(){

                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_into_logo);
                titleButton.startAnimation(animation);
            }
        };
        titleAnimation.start();*/
        Thread redirect=new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3500);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        redirect.start();
    }
}