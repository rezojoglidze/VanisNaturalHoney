package com.vanisnaturalhoney;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.vanisnaturalhoney.BaseActivityForMenu.BaseActivity;
import com.vanisnaturalhoney.menuclick.AboutAppActivity;
import com.vanisnaturalhoney.menuclick.AboutUsActivity;


public class MenuActivity extends BaseActivity {
    private ListView mMenuListView;
    private MenuItemAdapter menuItemAdapter;
    public static final int REQUEST_CALL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mMenuListView = findViewById(R.id.menuListView);
        menuItemAdapter = new MenuItemAdapter(this, 0, MenuItem.values());
        mMenuListView.setAdapter(menuItemAdapter);

        mMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuItem menuItem = menuItemAdapter.getItem(position);
                switch (menuItem) {

                    case CALL_FOR_HONEY_ORDER:
                       makeCallClick();
                        break;
                    case ABOUT_US:
                        startActivity(AboutUsActivity.class);
                        break;
                    case SHARE_APP:
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        String shareBody="https://www.facebook.com/VanisNaturalHoney/";
                        intent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                        intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                        startActivity(Intent.createChooser(intent,"Share Using"));
                        break;
                    case ABOUT_APP:
                        startActivity(AboutAppActivity.class);
                        break;
                }
            }
        });
    }




    class MenuItemAdapter extends ArrayAdapter<MenuItem> {
        private Context mContext;

        public MenuItemAdapter(@NonNull Context context, int resource, @NonNull MenuItem[] objects) {
            super(context, resource, objects);
            this.mContext = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.view_menu_item, parent, false);
            MenuItem menuItem = getItem(position);
            ((TextView) view.findViewById(R.id.menuText)).setText(menuItem.getName());
            ((ImageView) view.findViewById(R.id.menuIcon)).setBackgroundResource(menuItem.getIcon());
            return view;
        }
    }

    enum MenuItem {
        CALL_FOR_HONEY_ORDER(R.drawable.call_icon,"თაფლის შეკვეთაზე დარეკვა"),
        ABOUT_US(R.drawable.about_us_icon, "ჩვენს შესახებ"),
        SHARE_APP(R.drawable.share_icon, "facebook გვერდის ლინკის გაზიარება"),
        ABOUT_APP(R.drawable.about_app_icon, "აპლიკაციის შესახებ");
        private int icon;
        private String name;

        MenuItem(int icon, String name) {
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



    public void makeCallClick (){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:558305304"));
        if (ContextCompat.checkSelfPermission(MenuActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MenuActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            return;
        }
        startActivity(intent);
    }
    //makeCall permission
    @Override
    public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions,
                                             @NonNull int[] grantResults){
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeCallClick();
            }
        }
    }
     //String string=String.format("dafasd %S %S" firsname, lastname);
}