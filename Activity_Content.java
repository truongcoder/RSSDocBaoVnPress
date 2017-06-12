package a200390.pctruong.com.docbaodantri.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import a200390.pctruong.com.docbaodantri.CheckConnectInternet.ConnectInternet;
import a200390.pctruong.com.docbaodantri.R;

public class Activity_Content extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;
    ProgressDialog progressDialog;
    String link="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__content);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        webView= (WebView) findViewById(R.id.web_view);
        progressBar= (ProgressBar) findViewById(R.id.pro_bar);
        Intent intent = getIntent();
        link = intent.getStringExtra("link");
        webView.loadUrl(link);
        webView.setWebViewClient(webViewClient);

        
    }

    public WebViewClient webViewClient=new WebViewClient(){

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressDialog.dismiss();
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Toast.makeText(Activity_Content.this, " Lỗi ", Toast.LENGTH_SHORT).show();
        }
    };
}
