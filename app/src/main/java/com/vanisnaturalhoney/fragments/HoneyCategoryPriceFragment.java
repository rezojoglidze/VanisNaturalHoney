package com.vanisnaturalhoney.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vanisnaturalhoney.R;

public class HoneyCategoryPriceFragment extends Fragment {

    public static View mView;
    private Callback mCallBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_price, container, false);

        mView.findViewById(R.id.setMayHoney).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallBack != null) {
                    mCallBack.onHoneyChanged("მაისის თაფლი");
                    setHoneyCategory("მაისი",20);
                    setImageMayHoneys();
                }
            }
        });
        mView.findViewById(R.id.setChesnutHoney).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallBack != null) {
                    mCallBack.onHoneyChanged("წაბლის თაფლი");
                    setHoneyCategory("წაბლი",25);
                    setImageChesnutHoneys();
                }
            }
        });
        mView.findViewById(R.id.setMayHoneyComb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallBack != null) {
                    mCallBack.onHoneyChanged("მაისის ფიჭა");
                    setHoneyCombCategory("მაისი",30);
                    setImageMayComb();
                }
            }
        });
        mView.findViewById(R.id.setChesnutHoneyComb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallBack != null) {
                    mCallBack.onHoneyChanged("წაბლის ფიჭა");
                    setHoneyCombCategory("წაბლი",35);
                    setImageChesnutComb();
                }
            }
        });
        return mView;
    }





    public void setImageChesnutHoneys(){
        ((ImageView) mView.findViewById(R.id.honeyImageCategory)).setImageResource(R.drawable.chesnuthoneyjar);
    }
    public void setImageMayHoneys(){
        ((ImageView) mView.findViewById(R.id.honeyImageCategory)).setImageResource(R.drawable.mayhoney);
    }
    public void setImageChesnutComb(){
        ((ImageView) mView.findViewById(R.id.honeyImageCategory)).setImageResource(R.drawable.chesnuthoneycomb);
    }
    public void setImageMayComb(){
        ((ImageView) mView.findViewById(R.id.honeyImageCategory)).setImageResource(R.drawable.mayhoneycomb);
    }



    public void setHoneyCombCategory(String category, int price){
        ((TextView) mView.findViewById(R.id.honeyCategory)).setText(category+"ს ფიჭიანი თაფლი "+ " ლიტრიანი ქილით - "
                +price+" ლარი");
    }
    public void setHoneyCategory(String category, int price){
        ((TextView) mView.findViewById(R.id.honeyCategory)).setText(category+"ს თაფლი "+ " ლიტრიანი ქილით - "
                +price+" ლარი");
    }



    public void setCallback(Callback mCallback) {
        this.mCallBack = mCallback;
    }

    public interface Callback {
        void onHoneyChanged(String category);
    }

}
