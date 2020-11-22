package com.example.personal_safety_battery_management;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Close_Friends extends AppCompatActivity {

    Button send;
    EditText phone_Number, message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close__friends);
        send = (Button) findViewById(R.id.Send_msg_Btn);
        phone_Number = (EditText) findViewById(R.id.EditText_PhoneNumber);
        message = (EditText) findViewById(R.id.MainActivity_Message);
        send.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        String phone_Num = phone_Number.getText().toString();
                                        String send_msg = message.getText().toString();
                                        try {
                                            SmsManager sms = SmsManager.getDefault(); // using android SmsManager
                                            sms.sendTextMessage(phone_Num, null, send_msg, null, null); // adding number and text
                                        } catch (Exception e) {
                                            Toast.makeText(getApplicationContext(), "Sms not Send", Toast.LENGTH_SHORT).show();
                                            e.printStackTrace();
                                        }
                                    }
                                });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.close_friends);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),
                                About.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(),
                                Settings.class));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.description:
                        startActivity(new Intent(getApplicationContext(),
                                Description.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.close_friends:
                        return true;
                }
                return false;
            }
        });
    }

}
