package a200390.pctruong.com.docbaodantri.CheckConnectInternet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by PhamTruong on 26/05/2017.
 */

public class ConnectInternet {
    public static boolean connectionInternet(Context context){
        boolean haveConnectionWifi=false;
        boolean haveConncetionMobile=false;
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info=cm.getAllNetworkInfo();
        for(NetworkInfo ni:info){
            if(ni.getTypeName().equalsIgnoreCase("WIFI")){
                if(ni.isConnected()){
                    haveConnectionWifi=true;
                }
            }
            if(ni.getTypeName().equalsIgnoreCase("MOBILE")){
                if(ni.isConnected()){
                    haveConncetionMobile=true;
                }
            }
        }
        return haveConnectionWifi||haveConncetionMobile;
    }
}
