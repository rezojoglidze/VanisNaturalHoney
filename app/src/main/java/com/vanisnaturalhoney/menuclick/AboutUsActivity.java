package com.vanisnaturalhoney.menuclick;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.vanisnaturalhoney.R;

public class AboutUsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_activity);
        //action bar hide
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
