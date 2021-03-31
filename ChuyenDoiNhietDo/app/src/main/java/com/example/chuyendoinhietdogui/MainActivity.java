package com.example.chuyendoinhietdogui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button chuyendoi_btn, hoandoi_btn;
    TextView DoC_txV,DoF_txV;
    EditText Nhap_edt,Kq_edt,lichsu_edt;
    int flag=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DoC_txV = findViewById(R.id.DoC);
        DoF_txV = findViewById(R.id.DoF);
        Nhap_edt = findViewById(R.id.Nhapnhietdo);
        Kq_edt  = findViewById(R.id.ketqua);
        chuyendoi_btn = findViewById(R.id.tinh);
        hoandoi_btn = findViewById(R.id.chuyen);
        Nhap_edt.setText("");
        lichsu_edt = findViewById(R.id.history);

        hoandoi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = flag*(-1);
//              Hoán đổi Tên nhiệt độ
                String x,y,z;
                x = DoC_txV.getText().toString();
                y = DoF_txV.getText().toString();
                z=x;
                x=y;
                y=z;
                DoC_txV.setText(""+x);
                DoF_txV.setText(""+y);

//              Hoán đổi Giá Trị nhiệt độ trong ô
                String a,b,c;
                a = Nhap_edt.getText().toString();
                b = Kq_edt.getText().toString();
                c=a;
                a=b;
                b=c;
                Nhap_edt.setText(""+a);
                Kq_edt.setText(""+b);
                Nhap_edt.setSelection(Nhap_edt.getText().length());
            }
        });
        chuyendoi_btn.setOnClickListener(new View.OnClickListener() {
            String s="";
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(Nhap_edt.getText().toString().equals(""))
                {
                    AlertDialog.Builder RangBuoc = new AlertDialog.Builder(MainActivity.this);
                    RangBuoc.setTitle("Thông báo!");
                    RangBuoc.setMessage("Bạn chưa nhập số");
                    RangBuoc.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog al = RangBuoc.create();
                    al.show();
                }

                else {
                    float a = Float.parseFloat(Nhap_edt.getText().toString());
                    float kq = 0;
                    if(flag==1){
                        kq = (float) ((float) 1.8*a+32);
                        s = s + ("Độ C:" + a + "=> Độ F:" + kq + "\n");
                        lichsu_edt.setText(s);}
                    if(flag==-1) {
                        kq = (float) ((float) (a - 32) / 1.8);
                        s = s + ("Độ F:" + a + "=> Độ C:" + kq +"\n");
                        lichsu_edt.setText(s);
                    }
                    Kq_edt.setText(""+kq);
                    Nhap_edt.setSelection(Nhap_edt.getText().length());   //Cho con trỏ cuối dòng
                }
            }
        });
    }
}