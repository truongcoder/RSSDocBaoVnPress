package a200390.pctruong.com.docbaodantri.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import a200390.pctruong.com.docbaodantri.R;
import a200390.pctruong.com.docbaodantri.ReadRSS.RSSItem;

public class Activity_Share extends AppCompatActivity {
    LoginButton loginButton;
    CallbackManager callbackManager;
    private ProfilePictureView profilePictureView;
    private ProfileTracker profileTracker;
    private AccessTokenTracker accessTokenTracker;
    RSSItem rssItem;
    TextView userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity__share);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        rssItem = (RSSItem) bundle.getSerializable("data");
        String link = rssItem.getLink();
        String title = rssItem.getTitle();
        Toast.makeText(this, ""+link, Toast.LENGTH_SHORT).show();
//        profilePictureView = (ProfilePictureView) findViewById(R.id.image);
//        loginButton = (LoginButton) findViewById(R.id.login_button);
    }
}
