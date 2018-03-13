package laco.projet1;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;


/**
 * Created by achraf on 19/02/2017.
 */

public class TheApplication extends Application {
    Model m;
    public int largeur = 10; // nombre de colonnes
    public int hauteur = 6;  // nombre de lignes
    public Pentomino pento;
    public ArrayList<Pentomino> listpento;
    @Override
    public void onCreate() {
        super.onCreate();
        m = new Model(largeur, hauteur);
        listpento = new ArrayList<Pentomino>();
    }
    Model getModel() {
        System.out.println("test get model");
        return m;}

    public void setSelectedToken(Pentomino t) {
        this.pento = t;
    }
    public void newGame() {

        listpento.add(Pentomino.P1d);
        listpento.add(Pentomino.Uc);
        listpento.add(Pentomino.Y1d);
        listpento.add(Pentomino.Z1b);
        listpento.add(Pentomino.N2a);
        listpento.add(Pentomino.Vc);
        listpento.add(Pentomino.Wa);
        listpento.add(Pentomino.Tc);
        listpento.add(Pentomino.L1a);
        listpento.add(Pentomino.X);
        listpento.add(Pentomino.F1c);
        listpento.add(Pentomino.Ia);

    }

    public ArrayList<Pentomino> getGame() {

        return listpento;
    }

    public Pentomino getSelectedPentomino(int i) {

        System.out.println("test get Selected Pentomino");
        return listpento.get(i);
    }

    public void reset() {
        m.reset();
        //this.m = new Model(largeur, hauteur);

    }

}

