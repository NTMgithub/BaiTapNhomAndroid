package com.example.foodorder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonDatNgay;

    RadioGroup radioChonSize, radioChonDuong, radioChonDa;
    RadioButton radioButtonSize, radioButtonDuong, radioButtonDa;

    CheckBox cb_tranChanDen, cb_tranChanTrang, cb_kemCheese, cb_puddingPhoMai, cb_thachRauCau,
    cb_thachTraiCay, cb_banhFlan, cb_tranChauOkinawa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatNgay();
    }
    public void clicked_url(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void DatNgay(){
        buttonDatNgay = (Button) findViewById(R.id.buttonDatNgay);
        radioChonSize = (RadioGroup) findViewById(R.id.radioChonSize);
        radioChonDuong = (RadioGroup) findViewById(R.id.radioChonDuong);
        radioChonDa = (RadioGroup) findViewById(R.id.radioChonDa);

        cb_tranChanDen = (CheckBox) findViewById(R.id.tranChauDen);
        cb_tranChanTrang = (CheckBox) findViewById(R.id.tranChauTrang);
        cb_kemCheese = (CheckBox) findViewById(R.id.kemCheese);
        cb_puddingPhoMai = (CheckBox) findViewById(R.id.puddingPhoMai);
        cb_thachRauCau = (CheckBox) findViewById(R.id.thachRauCau);
        cb_thachTraiCay = (CheckBox) findViewById(R.id.thachTraiCay);
        cb_banhFlan = (CheckBox) findViewById(R.id.banhFlan);
        cb_tranChauOkinawa = (CheckBox) findViewById(R.id.tranChauOkinawa);
        findViewById(R.id.buttonXemDiaChi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked_url("https://bitly.com.vn/4hogv1");

            }
        });

        buttonDatNgay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext() , ChiTietDatHang.class);

                //Radio size
                int selectedSizeID = radioChonSize.getCheckedRadioButtonId();
                radioButtonSize =(RadioButton) findViewById(selectedSizeID);
                String textSize = radioButtonSize.getText().toString();

                //Radio mức đá
                int selectedDuongID = radioChonDuong.getCheckedRadioButtonId();
                radioButtonDuong =(RadioButton) findViewById(selectedDuongID);
                String textDuong = radioButtonDuong.getText().toString();

                //Radio mức đường
                int selectedDaID = radioChonDa.getCheckedRadioButtonId();
                radioButtonDa =(RadioButton) findViewById(selectedDaID);
                String textDa = radioButtonDa.getText().toString();

                //Lấy dữ liệu topping
                ArrayList<String> toppings = new ArrayList<String>();

                if (cb_tranChanDen.isChecked()){
                    toppings.add(cb_tranChanDen.getText().toString());
                }
                if (cb_tranChanTrang.isChecked()){
                    toppings.add(cb_tranChanTrang.getText().toString());
                }
                if (cb_kemCheese.isChecked()){
                   toppings.add(cb_kemCheese.getText().toString());
                }
                if (cb_puddingPhoMai.isChecked()){
                    toppings.add(cb_puddingPhoMai.getText().toString());
                }
                if (cb_thachRauCau.isChecked()){
                    toppings.add(cb_thachRauCau.getText().toString());
                }
                if (cb_thachTraiCay.isChecked()){
                    toppings.add(cb_thachTraiCay.getText().toString());
                }
                if (cb_banhFlan.isChecked()){
                    toppings.add(cb_banhFlan.getText().toString());
                }
                if (cb_tranChauOkinawa.isChecked()){
                    toppings.add(cb_tranChauOkinawa.getText().toString());
                }

                //gán dữ liệu
                intent.putExtra("text_size", textSize);
                intent.putExtra("text_duong", textDuong);
                intent.putExtra("text_da", textDa);
                intent.putExtra("topping_list", toppings);

                startActivity(intent);
            }
        });


    }








}