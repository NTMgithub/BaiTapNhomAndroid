package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Gui_sms extends AppCompatActivity {

    private static final String LOG_TAG = "AndroidExample";

    ArrayList<String> toppings = new ArrayList<String>();
    private EditText editTextPhoneNumber;
    private EditText editTextMessage;

    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui_sms);

        this.editTextPhoneNumber = (EditText) this.findViewById(R.id.editText_phoneNumber);
        this.editTextMessage = (EditText) this.findViewById(R.id.editText_message);

        this.buttonSend = (Button) this.findViewById(R.id.button_send);

        editTextPhoneNumber.setEnabled(false);

        Intent intent = getIntent();
        //get value
        String textSize = intent.getStringExtra("text_size");
        String textDuong = intent.getStringExtra("text_duong");
        String textDa = intent.getStringExtra("text_da");
        String toppings = intent.getStringExtra("topping_list");

        this.editTextMessage.setText("Size: " + textSize + "\n" +
                                    "Mức đường: " + textDuong + "\n" +
                                    "Mức đá: " + textDa + "\n" +
                                    "Topping: " + toppings + "\n" + "\n" + "Tôi muốn một ly thật lớn!");

        this.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS_by_Intent_ACTION_SEND();
            }
        });
    }

    private void sendSMS_by_Intent_ACTION_SEND()  {

        String phoneNumber = this.editTextPhoneNumber.getText().toString();
        String message =  this.editTextMessage.getText().toString();

        // Add the phone number in the data
        Uri uri = Uri.parse("smsto:" + phoneNumber);

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
        // Add the message at the sms_body extra field
        smsIntent.putExtra("sms_body", message);
        try {
            startActivity(smsIntent);
        } catch (Exception ex) {
            Log.e(LOG_TAG, "Your sms has failed... " + ex.getMessage(), ex);
            Toast.makeText(Gui_sms.this, "Your sms has failed... " + ex.getMessage(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}
