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
    Button btnQuayLai, btnXacNhan;
    String textSize, textDuong, textDa, textTopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_dat_hang);

        Intent intent = getIntent();
        //get value
        textSize = intent.getStringExtra("text_size");
        textDuong = intent.getStringExtra("text_duong");
        textDa = intent.getStringExtra("text_da");
        toppings = intent.getStringArrayListExtra("topping_list");

        textTopping = "";
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

        //Hàm chạy khi nhấn nút "Xác nhận" -> Trang sms
        XacNhan();

    }

    private void XacNhan() {
        btnXacNhan = (Button) findViewById(R.id.buttonXacNhan);
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietDatHang.this, Gui_sms.class);
                //gán dữ liệu
                intent.putExtra("text_size", textSize);
                intent.putExtra("text_duong", textDuong);
                intent.putExtra("text_da", textDa);
                intent.putExtra("topping_list", textTopping);

                startActivity(intent);
            }
        });
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