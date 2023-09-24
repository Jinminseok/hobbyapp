package com.example.life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LikeBoard extends AppCompatActivity {

    private TextView titleTextView;
    private TextView contentsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_board);
        getSupportActionBar().setTitle("내가 찜한 게시판");

        titleTextView = findViewById(R.id.title_textview);
        contentsTextView = findViewById(R.id.contents_textview);

        restoreState();

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String contents = intent.getStringExtra("contents");

        if (title != null && contents != null) {
            titleTextView.setText(title);
            contentsTextView.setText(contents);
        }

        Button homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveState();
                finish();
            }
        });
    }

    private void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("title", titleTextView.getText().toString());
        editor.putString("contents", contentsTextView.getText().toString());
        editor.apply();
    }

    private void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        String title = pref.getString("title", "");
        String contents = pref.getString("contents", "");
        titleTextView.setText(title);
        contentsTextView.setText(contents);
    }
}
