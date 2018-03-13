package laco.projet1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import static laco.projet1.R.layout.instructions;


/**
 * Created by achraf on 19/02/2017.
 */

public class Instructions extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(instructions);
    }
    public void onClickback(View v){
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);

    }


}
