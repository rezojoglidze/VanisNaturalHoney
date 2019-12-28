package com.vanisnaturalhoney.popClass;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.vanisnaturalhoney.R;


public class PopClassSocialMediaActivity extends AppCompatActivity {
    private ListView mPopClassSocailMediaListView;
    private PopClassSocialMediaItemAdapter popClassSocialMediaItemAdapter;
    public static final int REQUEST_CALL = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_social_media);
        mPopClassSocailMediaListView = findViewById(R.id.popUpSocialListView);
        popClassSocialMediaItemAdapter = new PopClassSocialMediaItemAdapter(this, 0, popClassSocialMediaItem.values());
        mPopClassSocailMediaListView.setAdapter(popClassSocialMediaItemAdapter);
        //action bar hide
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.widthPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .8));



        mPopClassSocailMediaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popClassSocialMediaItem popClassSocialMediaItem = popClassSocialMediaItemAdapter.getItem(position);
                switch (popClassSocialMediaItem) {

                    case GO_TO_FACEBOOK_PAGE:
                        fbIconClick();
                        break;
                    case MESSAGE_TO_FACEBOOK_PAGE:
                        messengerIconClick();
                        break;

                    case CALL_TO_HONEY_ORDER:
                        makeCallClick();
                        break;
                }

            }
        });
    }





    class PopClassSocialMediaItemAdapter extends ArrayAdapter<popClassSocialMediaItem> {
        private Context mContext;

        public PopClassSocialMediaItemAdapter(@NonNull Context context, int resource, @NonNull popClassSocialMediaItem[] objects) {
            super(context, resource, objects);
            this.mContext = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.view_pop_up_social_media_item, parent, false);
            popClassSocialMediaItem popClassSocialMediaItem = getItem(position);
            ((TextView) view.findViewById(R.id.menuText)).setText(popClassSocialMediaItem.getName());
            ((ImageView) view.findViewById(R.id.menuIcon)).setBackgroundResource(popClassSocialMediaItem.getIcon());
            return view;
        }
    }

    enum popClassSocialMediaItem {
        GO_TO_FACEBOOK_PAGE(R.drawable.facebook_icon,"Facebook გვერდზე გადასვლა"),
        MESSAGE_TO_FACEBOOK_PAGE(R.drawable.messenger_icon, "Facebook გვერდზე მიწერა"),
        CALL_TO_HONEY_ORDER(R.drawable.call_icon, "თაფლის შეკვეთაზე დარეკვა");
        private int icon;
        private String name;

        popClassSocialMediaItem(int icon, String name) {
            this.icon = icon;
            this.name = name;
        }

        public int getIcon() {
            return icon;
        }

        public String getName() {
            return name;
        }
    }


//view view აკლია
    public void fbIconClick() {
        goToFacebookPage("460768061354807");
    }
    public void messengerIconClick(){
        goToMessenger("460768061354807");
    }


    public void makeCallClick (){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:558305304"));
        if (ContextCompat.checkSelfPermission(PopClassSocialMediaActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PopClassSocialMediaActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            return;
        }
        startActivity(intent);
    }
    //makeCall permission
    @Override
    public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeCallClick();
            }
        }
    }

    private void goToFacebookPage(String id) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page" + id));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id));
            startActivity(intent);
        }
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