package com.example.foodorder;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChiTietDatHang extends AppCompatActivity {
    ArrayList<String> toppings = new ArrayList<String>();
    Button btnQuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_dat_hang);

        Intent intent = getIntent();
        //get value
        String textSize = intent.getStringExtra("text_size");
        String textDuong = intent.getStringExtra("text_duong");
        String textDa = intent.getStringExtra("text_da");
        toppings = intent.getStringArrayListExtra("topping_list");

        String textTopping = "";
        //convert ArrayList String sang String
        for (String s : toppings)
        {
            textTopping += s + ", ";
        }

        //set vào textview
        TextView tv_size = (TextView) findViewById(R.id.mucSizeText);
        tv_size.setText(textSize);
        TextView tv_duong = (TextView) findViewById(R.id.mucDuongText);
        tv_duong.setText(textDuong);
        TextView tv_da = (TextView) findViewById(R.id.mucDaText);
        tv_da.setText(textDa);
        TextView tv_toppings = (TextView) findViewById(R.id.themToppingText);
        tv_toppings.setText(textTopping);

        //Hàm chạy khi nhấn nút "Quay lại"
        QuayLai();

    }

    public void QuayLai(){
        btnQuayLai = (Button) findViewById(R.id.buttonQuayLai);
        btnQuayLai.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });


    }






}