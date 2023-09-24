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


public class OpenchatFragment extends Fragment {

    private View view;
    private String TAG = "HumanFragment";
    private ImageButton openbtn;

    @Nullable
    @Override
    public View onCreateView( @Nullable LayoutInflater inflater,  @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "onCreatView");
        view = inflater.inflate(R.layout.fragment_openchat, container, false);
        openbtn = (ImageButton) view.findViewById(R.id.openbtn);  //fragment에서 findViewByid는 view.을 이용해서 사용

        openbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Openchatroom.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        return view;
    }
}