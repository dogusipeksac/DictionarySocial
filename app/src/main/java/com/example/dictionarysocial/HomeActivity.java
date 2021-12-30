package com.example.dictionarysocial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dictionarysocial.Fragment.FragmentHome;
import com.example.dictionarysocial.Fragment.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationbar);
        floatingActionButton=findViewById(R.id.fab);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(1).setEnabled(false);
        getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new FragmentHome()).commit();
        floatingActionButton.setOnClickListener(v -> {
            Intent intent=new Intent(this,PostActivity.class);
            startActivity(intent);
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment temp = null;
            switch (item.getItemId())
            {
                case R.id.mHome : temp = new FragmentHome();
                    break;
                case R.id.mPerson : temp = new FragmentProfile();
                    break;


            }
            getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,temp).commit();
            return true;
        });
    }
}