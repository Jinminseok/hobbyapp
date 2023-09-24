package com.example.life;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class ProfileUpdate extends AppCompatActivity {
    private ImageView uploadImageButton;
    private Button saveButton;
    private EditText nicknameEditText;

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri selectedImageUri; // 이미지 Uri를 저장할 변수
    private Bitmap selectedImageBitmap; // 선택한 이미지를 비트맵으로 저장할 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);
        getSupportActionBar().setTitle("                         프로필 수정");

        uploadImageButton = findViewById(R.id.updateImage);
        saveButton = findViewById(R.id.saveButton);
        nicknameEditText = findViewById(R.id.nicknameEditText);

        uploadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newNickname = nicknameEditText.getText().toString();
                // 닉네임 수정 기능 구현

                // 이미지 데이터를 MypageFragment로 전달
                Intent intent = new Intent();
                intent.putExtra("nickname", newNickname);

                if (selectedImageUri != null) {
                    intent.putExtra("imageUri", selectedImageUri.toString());
                }

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);

                // 선택한 이미지를 저장
                selectedImageUri = imageUri;
                selectedImageBitmap = bitmap;

                // 이미지 업로드 및 화면에 표시
                uploadImageButton.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 이미지가 선택되어 있을 경우, 유지 및 표시
        if (selectedImageBitmap != null) {
            uploadImageButton.setImageBitmap(selectedImageBitmap);
        }
    }
}
