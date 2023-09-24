package com.example.life;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MovieActivity extends AppCompatActivity {

    HomeFragment fragment; //홈프래그먼트를 선언한다.

    HomeFragment fragment2; //홈프래그먼트를 선언한다.
    HomeFragment fragment3; //홈프래그먼트를 선언한다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        fragment = new HomeFragment(); //초기화해준다.

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        ////프래그먼트를 여러개 사용할 수 있으므로, 비긴트랜잭션을 사용한다.
        //간단히 프래그먼트에서 사용되는 트랜잭션이란 어떤 대상에 대해 추가, 제거, 변경등의 작업들이
        //발생하는 것을 묶어서 이야기 하는 것이다.
        // 끝에 커밋을 해줘야지 작동한다.

        fragment2 = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container2, fragment2).commit();
        ////프래그먼트를 여러개 사용할 수 있으므로, 비긴트랜잭션을 사용한다.
        //간단히 프래그먼트에서 사용되는 트랜잭션이란 어떤 대상에 대해 추가, 제거, 변경등의 작업들이
        //발생하는 것을 묶어서 이야기 하는 것이다.
        // 끝에 커밋을 해줘야지 작동한다.

        fragment3 = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container3, fragment3).commit();
        ////프래그먼트를 여러개 사용할 수 있으므로, 비긴트랜잭션을 사용한다.
        //간단히 프래그먼트에서 사용되는 트랜잭션이란 어떤 대상에 대해 추가, 제거, 변경등의 작업들이
        //발생하는 것을 묶어서 이야기 하는 것이다.
        // 끝에 커밋을 해줘야지 작동한다.
    }
}