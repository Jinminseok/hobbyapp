package com.example.life;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {
    BottomNavigationView btnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        btnv = findViewById(R.id.menu_bottom_navigation);

        //처음화면
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new HomeFragment()).commit();

        btnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id) {
                    case R.id.Home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new HomeFragment()).commit();
                        break;
                    case R.id.Board:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new BoardFragment()).commit();
                        break;
                    case R.id. Mypage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new MypageFragment()).commit();
                        break;
                    case R.id.Openchat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new OpenchatFragment()).commit();
                        break;
                    case R.id.Menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new MenuFragment()).commit();
                        break;
                }
                return true;
            }
        });
    }

}