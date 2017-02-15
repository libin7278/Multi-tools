package com.libin.multi.tools.wifi;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.libin.multi.tools.R;
import com.libin.multi.tools.wifi.adapter.MyWifiRVAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class WifiMacActivity extends Activity {
    private RecyclerView rv_mac_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_mac);

        rv_mac_id = (RecyclerView) findViewById(R.id.rv_mac_id);

        getListRouterMACString(getApplicationContext());

        rv_mac_id.setHasFixedSize(true);
        rv_mac_id.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        if(getListRouterMAC(getApplicationContext()) !=  null){
            rv_mac_id.setAdapter(new MyWifiRVAdapter(getApplicationContext(),getListRouterMAC(getApplicationContext())));
        }else {
            Toast.makeText(getApplicationContext(),"请开启wifi",Toast.LENGTH_LONG).show();
        }
    }

    private String getRouterMAC(Context mContext){
        WifiInfo wifiInfo = null;

        try {
            WifiManager wifiManager = (WifiManager) mContext.getSystemService(WIFI_SERVICE);
            wifiInfo = wifiManager.getConnectionInfo();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            for (int i = 0 ; i < scanResults.size();i++){
                Toast.makeText(mContext,scanResults.get(i).BSSID + "扫描"+i ,Toast.LENGTH_LONG).show();
            }
            Logger.i(scanResults+"SAOMIAO");
            return wifiInfo.getBSSID();
        }catch (Exception e){
            return "";
        }

    }

    private List getListRouterMAC(Context mContext){
        List<String> bssidResults = new ArrayList<>();

        try {
            WifiManager wifiManager = (WifiManager) mContext.getSystemService(WIFI_SERVICE);
            List<ScanResult>  scanResults = wifiManager.getScanResults();
            for(int i = 0 ; i < scanResults.size();i++){
                bssidResults.add(i,scanResults.get(i).BSSID);
            }

            return bssidResults;
        }catch (Exception e){
            Logger.e("报错了。。。");
            return null;
        }
    }

    private String getListRouterMACString(Context mContext){
        String bssidResults = "";

        try {
            WifiManager wifiManager = (WifiManager) mContext.getSystemService(WIFI_SERVICE);
            List<ScanResult>  scanResults = wifiManager.getScanResults();
            for(int i = 0 ; i < scanResults.size();i++){
                if(i == 0){
                    bssidResults = bssidResults+scanResults.get(i).BSSID;
                }else {
                    bssidResults = bssidResults+","+scanResults.get(i).BSSID;
                }

            }

            Logger.i(bssidResults+"  扫描");

            return bssidResults;
        }catch (Exception e){
            Logger.e("报错了。。。");
            return null;
        }
    }
}
