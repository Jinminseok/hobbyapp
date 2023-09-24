package com.example.life;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.IOException;

public class MypageFragment extends Fragment {
    private Button editProfileButton;
    private ListView listView;
    private String[] itemList = {"☞ 내가 찜한 게시글", "☞ 자주 들렸던 게시판"};
    private Button profileBtn;
    private ImageView profileImage;
    private TextView usernameText;

    private static final int PROFILE_UPDATE_REQUEST_CODE = 1;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        sharedPreferences = getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        profileImage = view.findViewById(R.id.profileImage);
        usernameText = view.findViewById(R.id.usernameText);
        profileBtn = view.findViewById(R.id.editProfileButton);

        // 저장된 닉네임 가져오기
        String savedNickname = sharedPreferences.getString("nickname", "");
        usernameText.setText(savedNickname);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileUpdate.class);
                startActivityForResult(intent, PROFILE_UPDATE_REQUEST_CODE);
            }
        });

        // 저장된 이미지 URI 가져오기
        String savedImageUri = sharedPreferences.getString("imageUri", "");

        listView = view.findViewById(R.id.myList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedBoard = itemList[position];
                Intent intent;

                if (position == 0) {
                    // "내가 찜한 게시글" 항목을 클릭한 경우
                    intent = new Intent(requireContext(), LikeBoard.class);
                } else {
                    // "자주 들렸던 게시판" 항목을 클릭한 경우
                    intent = new Intent(requireContext(), MovieBoardActivity.class);
                }

                intent.putExtra("selectedBoard", selectedBoard);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PROFILE_UPDATE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String newNickname = data.getStringExtra("nickname");

                usernameText.setText(newNickname);

                // SharedPreferences에 닉네임 저장
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nickname", newNickname); // "nickname" 키로 값을 저장
                editor.apply();

                // 프로필 이미지 업데이트
                String imageUriString = data.getStringExtra("imageUri");
                if (imageUriString != null) {
                    Uri imageUri = Uri.parse(imageUriString);
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageUri);
                        profileImage.setImageBitmap(bitmap);
                        profileImage.setBackground(getResources().getDrawable(R.drawable.oval_shape));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // SharedPreferences에 이미지 URI 저장
                    editor = sharedPreferences.edit();
                    editor.putString("imageUri", imageUriString); // "imageUri" 키로 값을 저장
                    editor.apply();
                } else {
                    // 이미지가 없는 경우 기본 이미지 설정
                    profileImage.setImageResource(R.drawable.profile);
                    profileImage.setBackground(null);

                    // SharedPreferences에서 이미지 URI 제거
                    editor = sharedPreferences.edit();
                    editor.remove("imageUri"); // "imageUri" 키의 값을 제거
                    editor.apply();
                }
            }
        }
    }
}
