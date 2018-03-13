package laco.projet1;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Screen2 extends Activity{
    MediaPlayer musictoogle;

    public int musicEncours=0;
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12;
    Animation shake;
    public float x=0;
    public float y=0;
    public int durationtoast = 5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondscreen);

        shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);// quand pentomino est selectionné, il vibre

        // ici on definie le boutton music
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                  if (isChecked) {
                                                      // The toggle is enabled
                                                      musictoogle = MediaPlayer.create(Screen2.this, R.raw.cartoonncs);
                                                      musictoogle.setVolume(50,50);
                                                      musictoogle.start();
                                                      musicEncours=1;
                                                  } else {
                                                      // The toggle is disabled
                                                      musictoogle.pause();
                                                      musicEncours=0;
                                                  }
                                              }
                                          }
        );

        img1 = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);

        img5 = (ImageView) findViewById(R.id.imageView5);
        img6 = (ImageView) findViewById(R.id.imageView6);
        img7 = (ImageView) findViewById(R.id.imageView7);
        img8 = (ImageView) findViewById(R.id.imageView8);

        img9 =  (ImageView) findViewById(R.id.imageView9);
        img10 = (ImageView) findViewById(R.id.imageView10);
        img11 = (ImageView) findViewById(R.id.imageView11);
        img12 = (ImageView) findViewById(R.id.imageView12);


        ///////// SEPARATEUR CLICK ET LONG CLICK
        img1.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(0);
                img1.startAnimation(shake);

                ClipData data = ClipData.newPlainText("Pento num "," 1 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });

        img2.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(1);
                img2.startAnimation(shake);

                ClipData data = ClipData.newPlainText("Pento num "," 2 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });

        img3.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(2);
                img3.startAnimation(shake);

                ClipData data = ClipData.newPlainText("Pento num "," 3 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });

        img4.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(3);
                img4.startAnimation(shake);

                ClipData data = ClipData.newPlainText("Pento num "," 4 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });

        img5.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(4);
                img5.startAnimation(shake);

                ClipData data = ClipData.newPlainText("Pento num "," 5 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });


        img6.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(5);
                img6.startAnimation(shake);

                ClipData data = ClipData.newPlainText("Pento num "," 6 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });

        img7.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(6);
                img7.startAnimation(shake);

                ClipData data = ClipData.newPlainText("Pento num "," 7 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });
        img8.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(7);
                img8.startAnimation(shake);


                ClipData data = ClipData.newPlainText("Pento num "," 8 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });

        img9.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(8);
                img9.startAnimation(shake);


                ClipData data = ClipData.newPlainText("Pento num "," 9 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });

        img10.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(9);
                img10.startAnimation(shake);

                ClipData data = ClipData.newPlainText("Pento num "," 10 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });

        img11.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(10);
                img11.startAnimation(shake);

                ClipData data = ClipData.newPlainText("Pento num "," 11 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });

        img12.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                ((GameBoard) findViewById(R.id.boardSurface)).setselectione(11);
                img12.startAnimation(shake);

                ClipData data = ClipData.newPlainText("Pento num "," 12 ");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,myShadowBuilder,v,1000);

                return true;

            }

        });

    }

    public void onClicexit(View v){
        if(musicEncours==1){
            musictoogle.stop();//On arrete la music si on sort, sinon elle contninu d'etre jouer
        }
        Intent intent = new Intent(Screen2.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);

    }

    public void onClickReset (View v){

        if (!((GameBoard) findViewById(R.id.boardSurface)).finioupas()) {//Si on fini pas le jeu, le reset lance la music de defaite
            try {
                synchronized (this) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.fail);
                    mediaPlayer.start();
                    wait(4000);
                }
            } catch (InterruptedException ex) {
            }
        }
        ((GameBoard) findViewById(R.id.boardSurface)).getapp().reset();
        ((GameBoard) findViewById(R.id.boardSurface)).reDraw();

    }

}
