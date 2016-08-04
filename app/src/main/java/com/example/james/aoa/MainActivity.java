package com.example.james.aoa;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "G9wxe7qxPH4PQwzqPz3uNkzrN";
    private static final String TWITTER_SECRET = "ZnhTtFxMO1ltiKndvXdXI9jGFnCC8Gt53ZDdFOsxdFc8KEtJZS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.getWindow().getDecorView().setSystemUiVisibility(getSystemUIFlags());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig), new Crashlytics());

        setContentView(R.layout.activity_main);

        /*Button wifi = (Button) findViewById(R.id.button);
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager Checkwifi = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                TextView text = (TextView) findViewById(R.id.textView2);
                if (Checkwifi == null) {
                    text.setText("No wifi");
                } else {
                    NetworkInfo networkCheck = Checkwifi.getActiveNetworkInfo();
                    boolean isConnected = networkCheck != null && networkCheck.isConnectedOrConnecting();
                    if (isConnected) {
                        text.setText("Wifi is Connected");
                    } else {
                        text.setText("No Wifi");
                    }
                }

            }
        });*/

        MediaPlayer background = MediaPlayer.create(this, R.raw.aoa_luvme );
        background.start();

        ImageButton AOATwitter = (ImageButton) findViewById(R.id.AOATwitter);
        AOATwitter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent (MainActivity.this, Newsfeed.class);
                startActivity(i);
            }
        });

    }


private static int getSystemUIFlags(){
    return View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN;

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
