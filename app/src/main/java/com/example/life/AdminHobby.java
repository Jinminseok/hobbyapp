package com.example.life;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.life.Admin_Book.AdminBook;
import com.example.life.Admin_Music.AdminMusic;
import com.example.life.Admin_movie.AdminMovie;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;


public class AdminHobby extends AppCompatActivity {
    private ImageButton AMmovie;
    private ImageButton AMmusic;
    private ImageButton AMbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_hobby);
        getSupportActionBar().setTitle("                       홈화면 업데이트");

        AMmovie = findViewById(R.id.ammovie);
        AMmusic = findViewById(R.id.ammusic);
        AMbook = findViewById(R.id.ambook);


        // ImageButton으로 버튼 변경
        AMmovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminMovie.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        AMmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminMusic.class);
                startActivity(intent);
            }
        });
        // ImageButton으로 버튼 변경
        AMbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminBook.class);
                startActivity(intent);
            }
        });
    }
}