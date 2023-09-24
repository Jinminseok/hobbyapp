package com.example.life;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;


public class MenuFragment extends Fragment {
    private View view;

    private String TAG = "HumanFragment";

    private ImageButton inquirybtn;
    private ImageButton logoutbtn;
    private ImageButton noticebtn;
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Log.i(TAG, "onCreatView");
        view = inflater.inflate(R.layout.fragment_menu, container, false);

        inquirybtn= (ImageButton) view.findViewById(R.id.inquirybtn);  //fragment에서 findViewByid는 view.을 이용해서 사용

        inquirybtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Inquiry.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        noticebtn= (ImageButton) view.findViewById(R.id.noticebtn);  //fragment에서 findViewByid는 view.을 이용해서 사용

        noticebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Notice.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        logoutbtn = (ImageButton) view.findViewById(R.id. logoutbtn );  //fragment에서 findViewByid는 view.을 이용해서 사용

        logoutbtn .setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Login.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        return view;
    }

}