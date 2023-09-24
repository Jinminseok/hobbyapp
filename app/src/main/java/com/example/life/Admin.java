package com.example.life;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Admin extends AppCompatActivity {

    private ImageButton Btnnotice;
    private ImageButton Btnhobby;

    private ImageButton Btnchat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setTitle("                           관리자");

        Btnhobby = findViewById(R.id.adminhobby);
        Btnnotice = findViewById(R.id.adminnotice);
        Btnchat = findViewById(R.id.adminchat);

        // ImageButton으로 버튼 변경
        Btnhobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminHobby.class);
                startActivity(intent);
            }
        });

        // ImageButton으로 버튼 변경
        Btnnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Adminnotice.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        Btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Adminchat.class);
                startActivity(intent);
            }
        });


    }
}