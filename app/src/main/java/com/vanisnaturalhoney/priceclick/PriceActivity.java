package com.vanisnaturalhoney.priceclick;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.vanisnaturalhoney.R;
import com.vanisnaturalhoney.fragments.HoneyCategoryPriceFragment;

public class PriceActivity extends AppCompatActivity {

    private HoneyCategoryPriceFragment mHoneyCategoryPriceFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.price_activity);
        mHoneyCategoryPriceFragment = (HoneyCategoryPriceFragment) getSupportFragmentManager().findFragmentById(R.id.pricesFramgent);
        mHoneyCategoryPriceFragment.setCallback(new HoneyCategoryPriceFragment.Callback() {
            @Override
            public void onHoneyChanged (String category ) {
                Toast.makeText(PriceActivity.this, String.format(category," თაფლი"), Toast.LENGTH_SHORT).show();
            }
        });
        //action bar hide
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void messengerIconClick(View view){
        goToMessenger("460768061354807");
    }


    private void goToMessenger(String id){
        try{
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.messenger.com/t/"+id));
            startActivity(intent);
        } catch (ActivityNotFoundException e){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.messenger.com/t/"+id));
            startActivity(intent);
        }
    }
}

