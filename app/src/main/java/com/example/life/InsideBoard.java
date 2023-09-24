package com.example.life;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.life.MovieAdd.MovieBoard;

public class InsideBoard extends AppCompatActivity {

    private ImageButton btnMovie;
    private ImageButton btnBook;
    private ImageButton btnTv;
    private ImageButton btnMusic;
    private ImageButton btnGame;
    private ImageButton btnInquiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_board);
        getSupportActionBar().setTitle("                         실내 게시판");

        btnMovie = findViewById(R.id.btn_movie);
        btnBook = findViewById(R.id.btn_book);
        btnTv = findViewById(R.id.btn_tv);
        btnMusic = findViewById(R.id.btn_music);
        btnGame = findViewById(R.id.btn_game);
        btnInquiry = findViewById(R.id.btn_inquiry);

        // ImageButton으로 버튼 변경
        btnMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  MovieBoardActivity.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  BookBoard.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        btnTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  TvBoard.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  MusicBoard.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  GameBoard.class);
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
