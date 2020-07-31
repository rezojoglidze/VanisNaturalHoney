package com.vanisnaturalhoney.BaseActivityForMenu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(BaseActivity.class.getName(), "OnCReate");
    }

    protected void startActivity(Class kClass) {
        Intent intent = new Intent(this, kClass);
        startActivity(intent);
    }
}
