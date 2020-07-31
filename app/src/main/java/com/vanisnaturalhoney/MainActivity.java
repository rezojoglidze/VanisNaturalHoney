
package com.vanisnaturalhoney;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vanisnaturalhoney.photoclick.PhotoActivity;
import com.vanisnaturalhoney.popClass.PopClassHelpActivity;
import com.vanisnaturalhoney.popClass.PopClassSocialMediaActivity;
import com.vanisnaturalhoney.priceclick.PriceActivity;

public class MainActivity extends AppCompatActivity {
    EditText mMayHoneyNumberOrders;
    EditText mMayHoneyCombNumberOrders;
    EditText mChesnutHoneyNumberOrders;
    EditText mChesnutHoneyCombNumberOrders;
    TextView mShowTextMainActivity;

    public int mayHoneyFullPrice;
    public int mayHoneyCombFullPrice;
    public int chesnutHoneyFullPrice;
    public int chesnutHoneyCombFullPrice;

    public String mayHoneyOrderText;
    public String chesnutHoneyOrderText;
    public String mayHoneyCombOrderText;
    public String chesnutHoneyCombOrderText;
    public String orderSmsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMayHoneyNumberOrders = findViewById(R.id.mayHoneyNumberOrders);
        mChesnutHoneyNumberOrders = findViewById(R.id.chesnutHoneyNumberOrders);
        mMayHoneyCombNumberOrders = findViewById(R.id.mayHoneyCombNumberOrders);
        mChesnutHoneyCombNumberOrders = findViewById(R.id.chesnutHoneyCombNumberOrders);
        mShowTextMainActivity = findViewById(R.id.showTextMainActivity);
        //action bar hide
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }


    public void smsAppClick(View view) {
        getPriceFromFields();
        orderSmsText = ("გამარჯობა, მე მსურს " + mayHoneyOrderText + chesnutHoneyOrderText + mayHoneyCombOrderText + chesnutHoneyCombOrderText);

        if (orderSmsText.trim().equals("გამარჯობა, მე მსურს")) {
            Toast.makeText(this, "შეავსეთ რომელიმე ველი", Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        Uri uri = Uri.parse("smsto:558305304");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", orderSmsText);
        startActivity(intent);
    }

    public void getPriceFromFields() {
        if (!(mMayHoneyNumberOrders.getText().toString().isEmpty())) {
            mayHoneyFullPrice = Integer.parseInt(mMayHoneyNumberOrders.getText().toString()) * 20;
            mayHoneyOrderText = String.format("%S %S", mMayHoneyNumberOrders.getText().toString(), "ლიტრი მაისის თაფლი. ");
        } else {
            mayHoneyFullPrice = 0;
            mayHoneyOrderText = String.format("%S", " ");
        }


        if (!(mChesnutHoneyNumberOrders.getText().toString().isEmpty())) {
            chesnutHoneyFullPrice = Integer.parseInt(mChesnutHoneyNumberOrders.getText().toString()) * 25;
            chesnutHoneyOrderText = String.format("%S %S", mChesnutHoneyNumberOrders.getText().toString(), " ლიტრი წაბლის თაფლი. ");
        } else {
            chesnutHoneyFullPrice = 0;
            chesnutHoneyOrderText = String.format("%S", " ");
        }

        if (!(mMayHoneyCombNumberOrders.getText().toString().isEmpty())) {
            mayHoneyCombFullPrice = Integer.parseInt(mMayHoneyCombNumberOrders.getText().toString()) * 30;
            mayHoneyCombOrderText = String.format("%S %S", mMayHoneyCombNumberOrders.getText().toString(), " ცალი, ლიტრიანი ქილით მაისის ფიჭა. ");
        } else {
            mayHoneyCombFullPrice = 0;
            mayHoneyCombOrderText = String.format("%S", " ");
        }

        if (!(mChesnutHoneyCombNumberOrders.getText().toString().isEmpty())) {
            chesnutHoneyCombFullPrice = Integer.parseInt(mChesnutHoneyCombNumberOrders.getText().toString()) * 35;
            chesnutHoneyCombOrderText = String.format("%S %S", mChesnutHoneyCombNumberOrders.getText().toString(), " ცალი, ლიტრიანი ქილით წაბლის ფიჭა. ");
        } else {
            chesnutHoneyCombFullPrice = 0;
            chesnutHoneyCombOrderText = String.format("%S", " ");
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void allOrderPriceGenerationButtonClick(View view) {
        getPriceFromFields();

        int allOrderPrice;
        allOrderPrice = mayHoneyFullPrice + mayHoneyCombFullPrice + chesnutHoneyFullPrice + chesnutHoneyCombFullPrice;

        if (allOrderPrice > 0) {
            mShowTextMainActivity.setText(allOrderPrice + " ლარი არის თქვენს მიერ არჩეული პროდუქცი(ებ)-ის ღირებულება \uD83C\uDF6F ");
        } else {
            mShowTextMainActivity.setText("ჯერ არ მიგითითებიათ რომელი თაფლი რამდენი ლიტრი გსურთ ");
        }
    }


    public void whatsAppClick(View view) {
        getPriceFromFields();
        orderSmsText = ("გამარჯობა, მე მსურს " + mayHoneyOrderText + chesnutHoneyOrderText + mayHoneyCombOrderText + chesnutHoneyCombOrderText);

        PackageManager pm = getPackageManager();
        try {
            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String text = "გამარჯობა, მე მსურს " + mayHoneyOrderText + chesnutHoneyOrderText + mayHoneyCombOrderText + chesnutHoneyCombOrderText;

            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(waIntent, "Share with"));

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }
    }


    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.helpIconOnClick:
                Intent intent = new Intent(this, PopClassHelpActivity.class);
                startActivity(intent);
                break;

            case R.id.socialIconClick:
                Intent intent1 = new Intent(this, PopClassSocialMediaActivity.class);
                startActivity(intent1);
                break;

            case R.id.menuButtonClick:
                Intent intent3 = new Intent(this, MenuActivity.class);
                startActivity(intent3);
                break;
            case R.id.photoButtonClick:
                Intent intent4 = new Intent(this, PhotoActivity.class);
                startActivity(intent4);
                break;
            case R.id.priceButtonClick:
                Intent intent5 = new Intent(this, PriceActivity.class);
                startActivity(intent5);
                break;
        }
    }
}