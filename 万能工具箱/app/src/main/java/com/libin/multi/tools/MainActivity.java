package com.libin.multi.tools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.libin.multi.tools.wifi.WifiMacActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn_wifi_mac;
    private Button btn_knife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findview();

        setOnClick();
    }

    private void findview() {
        btn_wifi_mac = (Button) findViewById(R.id.btn_wifi_mac);
        btn_knife = (Button) findViewById(R.id.btn_knife);
    }

    private void setOnClick() {
        btn_wifi_mac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WifiMacActivity.class));
            }
        });

        btn_knife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
