package com.vanisnaturalhoney;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class HelloPageActivity extends AppCompatActivity {
    private  static int SPLASH_TIME_OUT=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_page_activity);
//action bar hide
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, Status bar and navigation bar hide  //View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
// Create Welcome Screen (Splash Screen) in Android Studio
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(HelloPageActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);


    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        // Create Welcome Screen (Splash Screen) in Android Studio
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(HelloPageActivity.this,MainActivity.class);
//                startActivity(intent);
//                //  finish();
//            }
//        },SPLASH_TIME_OUT);
//    }
}


