package laco.projet1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.io.InputStream;
import java.util.ArrayList;

public class Difficulty extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_difficulty);

    }

    public void onclicexit(View v) { // retour au Main_activity
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);

    }


    public void onClickcorrection(View v) {// LA fonction qui affiche les resultats progressivement

        Intent intent7 = new Intent(Difficulty.this, Resultats.class);
        startActivity(intent7);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}