package a200390.pctruong.com.docbaodantri.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import a200390.pctruong.com.docbaodantri.CheckConnectInternet.ConnectInternet;
import a200390.pctruong.com.docbaodantri.R;

public class Activity_Splash extends AppCompatActivity {
   Button btnConnect;
   ConnectInternet connect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__splash);
        btnConnect= (Button) findViewById(R.id.btnConnect);
        connect=new ConnectInternet();
        Check();
    }
    public void Check(){
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(connect.connectionInternet(Activity_Splash.this)){
                    Intent intent=new Intent(Activity_Splash.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    btnConnect.setVisibility(View.VISIBLE);
                }
            }
        },1000);

    }
    @Override
    protected void onResume() {
        super.onResume();
        Check();
    }
}
