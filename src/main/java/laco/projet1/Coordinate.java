package laco.projet1;

/**
 * Created by achraf on 19/02/2017.
 */

public class Coordinate extends Pair<Integer,Integer> {

    Coordinate(int lig, int col) {
        super(lig,col);
    }

    public int getLig() { return this.fst(); }
    public int getCol() { return this.snd(); }

}

