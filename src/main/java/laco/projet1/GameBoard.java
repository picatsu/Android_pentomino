package laco.projet1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by achraf on 19/02/2017.
 */

public class GameBoard extends SurfaceView implements SurfaceHolder.Callback, View.OnDragListener {

    TheApplication app;
    public Temps scoore = new Temps(); // Calcule du score via une classe a part
    public int selection=0;  // pentomino selectionné qui sera modifié par screen2
    public int width, height;
    public int ligne= 6 ;//largeur dans app
    public int colonne = 10; // hauteur dans app
    public float x=0; //x et y brut, sans %
    public float y=0;
    public int xx=0; // x et y rèel entre 0 et 5 ou 0 et 9
    public int yy =0;
    public int bouleanaide=0; // variable pour donné une aide, pas sur d'implementer en jeu
    public Paint p = new Paint();

    public int durationtoast = 5; // temps d'apparition du toast

    public GameBoard(Context c) {
        super(c);
        getHolder().addCallback(this);
        this.setOnDragListener(this);
        app = (TheApplication)(c.getApplicationContext()); // On recupère THEApplication
        app.newGame();
        scoore.start();// Lancement du calcule  en Seconde
    }

    public GameBoard(Context c, AttributeSet as) {
        super(c, as);
        getHolder().addCallback(this);

        this.setOnDragListener(this);
        app = (TheApplication)(c.getApplicationContext());
        app.newGame();
        scoore.start();// Lancement du calcule  en Seconde

    }
    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh){
        width = w;
        height = h;
    }



    @Override
    public void draw(Canvas c) {
        Paint p = new Paint();

        c.drawColor(Color.WHITE);//Couleur de la grille
        float largeur = getWidth();
        float hauteur = getHeight();

        p.setColor(Color.GREEN);
        for (int i = 0; i < ligne; i++){
            c.drawLine(0,hauteur/ligne*(i+1),largeur,hauteur/ligne*(i+1),p);
        }
        for (int i=0; i < colonne; i++){
            c.drawLine(largeur/colonne*(i+1),0,largeur/colonne*(i+1),largeur,p);

        }
        Random rnd = new Random();// On genère un nombre random

        for(Pair<Pentomino, ArrayList<Coordinate>> aa: app.getModel().sauvegarde){
            for(int i=0; i< aa.snd().size(); i++){

                p.setStyle(Paint.Style.FILL);
                p.setARGB(255,rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                // Pour chaque pentomino, on donne une couleur au hasard et on le dessine

                 for(int j=0; j<5; j++){
                    c.drawRect(aa.snd().get(j).getCol() * (largeur/colonne),aa.snd().get(j).getLig() *
                            (hauteur/ligne),(aa.snd().get(j).getCol() + 1) * (largeur/colonne),
                            (aa.snd().get(j).getLig()+ 1) * (hauteur/ligne),p );
                 }
            }}
    }

    public void reDraw() {
        Canvas c = getHolder().lockCanvas();
        if (c != null) {
            this.draw(c);
            getHolder().unlockCanvasAndPost(c);
        }
        this.postInvalidate();


    }
    @Override
    public boolean onDrag(View v, DragEvent event){
        try {
            int x = (int) event.getX();
            int y = (int) event.getY();
            int action = event.getAction();
            switch (action) {
                case DragEvent.ACTION_DROP:
                    yy=(int)x/(getWidth()/colonne);
                    xx=(int)y/(getHeight()/ligne);

                    if(app.getModel().canPut(app.getSelectedPentomino(selection),new Coordinate( xx, yy))){
                        //Si on peut le deposer, on joue,le ding puis on depose le pentomino
                        MediaPlayer mediaPlayer = MediaPlayer.create(this.getContext(), R.raw.ding);
                        mediaPlayer.start();
                        app.getModel().put(app.getSelectedPentomino(selection), new Coordinate(xx, yy));
                    }
                    else{
                        // Si on peut pas deposer, on vibre l'ecran
                        Vibrator vib = (Vibrator) this.getContext().getSystemService(Context.VIBRATOR_SERVICE);
                        // Vibrate for 100 milliseconds
                        vib.vibrate(100);}
                    reDraw();
                    if(app.getModel().sauvegarde.size() >=1) {
                        //Dés qu'un pentomino est deposé, on affiche la case où il a été deposé
                        Toast.makeText(this.getContext(), "Le pentomino  " + app.getSelectedPentomino(selection).name() + "  " +
                                "vient d'etre deposé en (" + xx +"," + yy + ")", durationtoast).show();
                    }

            /*
              ################################################################
              #                                                              #
              #              L'animation fin de jeu                          #
              #                                                              #
              ################################################################
              */
                    if(app.getModel().achieved()){

                        fingame(); // La fonction fin game sera detaillé plus tard
                        this.reset();

                    }



                    return true;
                case DragEvent.ACTION_DRAG_ENDED:

                    return true;
                default:
                    return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean onTouchEvent( MotionEvent motionEvent) {
        this.x = motionEvent.getX();
        this.y = motionEvent.getY();
        int action = motionEvent.getAction();

        switch (action){
            case MotionEvent.ACTION_DOWN: {
                yy=(int)x/(getWidth()/colonne);
                xx=(int)y/(getHeight()/ligne);
                System.out.println("test onTouch xx="+xx+" yy="+yy+" et   x = "+x+" y= "+y);
                app.getModel().put(app.getSelectedPentomino(selection), new Coordinate( xx, yy));
                reDraw();
                return true;

            }
            case MotionEvent.TOOL_TYPE_FINGER:
                app.getModel().remove(app.getSelectedPentomino(selection));//si on touche, on supprime le dernier pentomino deposé
                reDraw();

            default :
                return false;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        reDraw();
    }



    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void reset(){
        app.reset();
    }
    public void setselectione(int i){

        this.selection=i;//on modifie le pentomino selectionné
    }
    public boolean finioupas(){// Fonction utiliser lors du boutton reset du Screen 2 pour jouer song defaite ou pas
        if(app.getModel().achieved() == true ){
            return true;
        }
        return false;
    }
    public TheApplication getapp(){
        return this.app;
    }

    public Temps getTemps(){
        return this.scoore;
    }//on retourne le score


    public void fingame(){ // LA fonction qui gère la victoire

        this.scoore.stop(); // On stop le decompte

        MediaPlayer mediaPlayer = MediaPlayer.create(this.getContext(), R.raw.victory);
        mediaPlayer.start(); // On joue la music de la vitoire puis on lance le dialog box

       this.openDialog();


    }
    public void openDialog() {
        // Creation du SharedPreferences HIGH_SCORE
        SharedPreferences settings = getContext().getSharedPreferences("HIGH_SCORE", Context.MODE_PRIVATE);
        long highScore = settings.getLong("HIGH_SCORE", 2000000);// La premiere sera evidement le premier score
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext()); // creation du dialog box
        LayoutInflater inflater = LayoutInflater.from(getContext()); // on le met sur la fenetre du screen 2
        View dialogLayout = inflater.inflate(R.layout.dialog, null); // on lui associe un xml
        builder.setView(dialogLayout);
        // CReation du Dialog Box
        // Titre du Dialog Box
        builder.setTitle("Fin de Partie ! ");// Titre du dialog box
        // Initialisation des deu bouttons
        Button buttonok = (Button)dialogLayout.findViewById(R.id.dialog_ok);
        Button buttonexit = (Button)dialogLayout.findViewById(R.id.dialog_cancel);

        buttonok.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Si new game est activé, alors on lance une nouvelle game direction sur la meme activity
                GameBoard.this.reset();
                Intent intent7 = new Intent(getContext(), Screen2.class);
                getContext().startActivity(intent7);
            }
        });
        buttonexit.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Si le Exit est activé, on revient au main activity
                app.reset();
                reDraw();
                Intent intent7 = new Intent(getContext(), MainActivity.class);
                getContext().startActivity(intent7);

            }
        });
        // Ici on choisi quel message affiché
        if(highScore < this.getTemps().getDureeSec()){// On compare le score actuel avec le high score enregistré
            builder.setMessage(" Score : "+this.getTemps().getDureeSec());
        }
        else{
            // on rentre ici si c'est un nouveau score en seconde
            builder.setMessage("Congratulation New Record ! \n Score : "+this.getTemps().getDureeSec()+"\n");
            settings.edit().putLong("HIGH_SCORE", this.getTemps().getDureeSec()).apply();
            // on modifie la valeur
        }
        // Create the alert dialog and display it
        AlertDialog theAlertDialog = builder.create();
        theAlertDialog.show();
    }

}









