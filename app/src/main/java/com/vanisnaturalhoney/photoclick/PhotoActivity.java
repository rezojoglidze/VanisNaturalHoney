package com.vanisnaturalhoney.photoclick;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.vanisnaturalhoney.R;

public class PhotoActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView showImageDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        showImageDisplay = findViewById(R.id.showImageDisplay);

        ImageView mayHoney = findViewById(R.id.mayhoney);
        ImageView chesnutHoneyJar = findViewById(R.id.chesnuthoneyjar);
        ImageView mayHoneyComb = findViewById(R.id.mayhoneycomb);
        ImageView chesnutHoneyComb = findViewById(R.id.chesnuthoneycomb);
        ImageView nature = findViewById(R.id.nature);
        ImageView naturearoundbees = findViewById(R.id.naturearoundbees);
        ImageView manychesnuthoneycomb = findViewById(R.id.manychesnuthoneycomb);
        ImageView beeswaxphoto = findViewById(R.id.beeswaxphoto);

        nature.setOnClickListener(this);
        naturearoundbees.setOnClickListener(this);
        manychesnuthoneycomb.setOnClickListener(this);
        beeswaxphoto.setOnClickListener(this);
        mayHoney.setOnClickListener(this);
        chesnutHoneyJar.setOnClickListener(this);
        mayHoneyComb.setOnClickListener(this);
        chesnutHoneyComb.setOnClickListener(this);

    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.mayhoney:
                showImageDisplay.setImageResource(R.drawable.mayhoney);
                break;
            case R.id.chesnuthoneyjar:
                showImageDisplay.setImageResource(R.drawable.chesnuthoneyjar);
                break;
            case R.id.mayhoneycomb:
                showImageDisplay.setImageResource(R.drawable.mayhoneycomb);
                break;
            case R.id.chesnuthoneycomb:
                showImageDisplay.setImageResource(R.drawable.chesnuthoneycomb);
                break;
            case R.id.nature:
                showImageDisplay.setImageResource(R.drawable.nature);
                break;
            case R.id.naturearoundbees:
                showImageDisplay.setImageResource(R.drawable.naturearoundbees);
                break;
            case R.id.manychesnuthoneycomb:
                showImageDisplay.setImageResource(R.drawable.manychesnuthoneycomb);
                break;
            case R.id.beeswaxphoto:
                showImageDisplay.setImageResource(R.drawable.beeswaxphoto);
                break;
        }
    }
}