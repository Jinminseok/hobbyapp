package com.example.life;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
public class OutsideBoard extends AppCompatActivity {

    private ImageButton btnBall;
    private ImageButton btnBicycle;
    private ImageButton btnMoutain;
    private ImageButton btnFishing;
    private ImageButton btnCamping;
    private ImageButton btnInquiry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outside_board);
        getSupportActionBar().setTitle("                         실외 게시판");

        btnBall = findViewById(R.id.ballboard);
        btnBicycle = findViewById(R.id.bicycleboard);
        btnMoutain = findViewById(R.id.mountainboard);
        btnFishing = findViewById(R.id.fishingboard);
        btnCamping = findViewById(R.id.cmapingboard);
        btnInquiry = findViewById(R.id.btn_inquiry);

        // ImageButton으로 버튼 변경
        btnBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  BallBoard.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        btnBicycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  BicycleBoard.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        btnMoutain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  Mountainboard.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        btnFishing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  FishingBoard.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        btnCamping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  CampingBoard.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        btnInquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  Inquiry.class);
                startActivity(intent);
            }
        });
    }
}