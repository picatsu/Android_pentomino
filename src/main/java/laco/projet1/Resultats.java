package laco.projet1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Resultats extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.resultats);

    }
    public void onclicbackgame(View v) {

        Intent intent6 = new Intent(Resultats.this, Screen2.class);
        startActivity(intent6);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);

    }
}
