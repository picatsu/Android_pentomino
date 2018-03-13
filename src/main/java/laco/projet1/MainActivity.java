package laco.projet1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.IntentCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.support.v4.content.IntentCompat;


import java.lang.reflect.InvocationTargetException;

import laco.projet1.R;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);


    }

    public void onChickpea(View v) {

        Intent intent = new Intent(MainActivity.this, Screen2.class);

        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void onClickinfo(View v) {

        Intent intent2 = new Intent(MainActivity.this, Instructions.class);
        startActivity(intent2);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void onClicdiff(View v) {

            Intent intent3 = new Intent(MainActivity.this, Difficulty.class);
            startActivity(intent3);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void onClickExit(View v) {

        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }


}


































