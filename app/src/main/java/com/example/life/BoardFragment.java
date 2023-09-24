package com.example.life;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.life.MovieAdd.MovieBoard;


public class BoardFragment extends Fragment {
    private View view;

    private String TAG = "HumanFragment";


    private ImageButton movieboard;
    private ImageButton bookboard;
    private ImageButton tvboard;
    private ImageButton insideadd;
    private ImageButton outsideadd;
    private ImageButton ballboard;
    private ImageButton bicycleboard;
    private ImageButton mountainboard;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Log.i(TAG, "onCreatView");
        view = inflater.inflate(R.layout.fragment_board, container, false);

        movieboard = (ImageButton) view.findViewById(R.id.movieboard);  //fragment에서 findViewByid는 view.을 이용해서 사용

        movieboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MovieBoardActivity.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        bookboard = (ImageButton) view.findViewById(R.id.bookboard);  //fragment에서 findViewByid는 view.을 이용해서 사용

        bookboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),BookBoard.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        tvboard = (ImageButton) view.findViewById(R.id.tvboard);  //fragment에서 findViewByid는 view.을 이용해서 사용

        tvboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),TvBoard.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        insideadd= (ImageButton) view.findViewById(R.id.insideadd);  //fragment에서 findViewByid는 view.을 이용해서 사용

        insideadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InsideBoard.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        ballboard= (ImageButton) view.findViewById(R.id.ballboard);  //fragment에서 findViewByid는 view.을 이용해서 사용

        ballboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),BallBoard.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        bicycleboard= (ImageButton) view.findViewById(R.id.bicycleboard);  //fragment에서 findViewByid는 view.을 이용해서 사용

        bicycleboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),BicycleBoard.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        mountainboard= (ImageButton) view.findViewById(R.id.mountainboard);  //fragment에서 findViewByid는 view.을 이용해서 사용

        mountainboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Mountainboard.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        outsideadd= (ImageButton) view.findViewById(R.id.outsideadd);  //fragment에서 findViewByid는 view.을 이용해서 사용

        outsideadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),OutsideBoard.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        return view;
    }
}