package laco.projet1;

/**
 * Created by achraf on 19/02/2017.
 */

import java.util.ArrayList;

public class Model implements IModel {

    private Integer  width = 0; // largeur
    private Integer  height = 0; // hauteur
    public Coordinate[][] tab;
    //public ArrayList<ArrayList<Coordinate>> rectangle ;
    public ArrayList<Pair<Pentomino,ArrayList<Coordinate>>> sauvegarde ;
    //public ArrayList<Pair<Pentomino,ArrayList<Coordinate>>> rectangle ;

    public Model(Integer width, Integer height ){
        if(width>0 && height>0){
            this.width = width;
            this.height = height;

            sauvegarde = new ArrayList<Pair<Pentomino,ArrayList<Coordinate>>>();

            tab=new Coordinate[width][height];
        }
    }



    public int width(){
        return this.width;
    }

    public int height(){
        return this.height;
    }

    public boolean valid(Coordinate pos){
        if(pos.getLig()<0 || pos.getCol()<0 || pos.getLig()>=height || pos.getCol()>=width){
            return false;
        }
        return true;
    }

    public boolean free(Coordinate pos){
        if (valid(pos) == false ){
            return false;
        }
        if(sauvegarde.size()!=0){
            for(Pair<Pentomino, ArrayList<Coordinate>> p: sauvegarde){
                ArrayList<Coordinate> idShape = p.snd();
                for(Coordinate c: idShape){
                    if((c.getCol() == pos.getCol()) && (c.getLig() == pos.getLig())){
                        return false;
                    }
                }
            }

        }

        return true;
    }

    public boolean achieved(){
        if(sauvegarde.size()!=0){
            int cpt=0;
            for(Pair<Pentomino, ArrayList<Coordinate>> p: sauvegarde){
                cpt+=5;
            }
            if(cpt==(height*width)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public boolean isPlaced(Pentomino id){
        ArrayList<Coordinate> searchList = id.shapeOf();
        if(sauvegarde.size()!=0){
            for(Pair<Pentomino, ArrayList<Coordinate>> p: sauvegarde){
                if (p.fst().equals(id)) {// && p.snd().equals(searchList)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPut(Pentomino id, Coordinate pos){
        if (this.isPlaced(id))
            return false;

        if(free(pos)){
            ArrayList<Coordinate> idList = id.shapeOf();
            Integer c0X = idList.get(0).getLig();
            Integer c0Y = idList.get(0).getCol();
            Integer posX = pos.getLig();
            Integer posY = pos.getCol();
            for(Coordinate c : idList){
                Coordinate newCoord= new Coordinate((c.getLig()-c0X +posX),(c.getCol()-c0Y+posY));
                if(!(free(newCoord))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void put(Pentomino id, Coordinate pos){
        if(canPut(id,pos)){
            System.out.println("test debut put");
            ArrayList<Coordinate> idList=id.shapeOf();
            ArrayList<Coordinate> tempList = new ArrayList<Coordinate>();
            Integer c0X = idList.get(0).getLig();
            Integer c0Y = idList.get(0).getCol();
            Integer posX = pos.getLig();
            Integer posY = pos.getCol();
            System.out.println("test debut for");
            for(Coordinate c : idList){
                Coordinate newCoord= new Coordinate((c.getLig()-c0X +posX),(c.getCol()-c0Y+posY));
                if(!(tempList.contains(newCoord))  ){

                    tempList.add(newCoord);
                }
                //tab[newCoord.getLig()][newCoord.getCol()]=newCoord;
            }
            System.out.println("test avant saugevarde");

            sauvegarde.add(new Pair<Pentomino, ArrayList<Coordinate>>(id,tempList));


        }
    }

    public void remove(Pentomino id){
        if(sauvegarde.size()!=0){

            for(int i=0; i<sauvegarde.size();i++){
                Pentomino p = sauvegarde.get(i).fst();


                if(id.equals(p)){
                    sauvegarde.remove(sauvegarde.get(i));

                }

            }
        }
    }


    public ArrayList<Pair<Pentomino,ArrayList<Coordinate>>> placedPentominos(){
		/*for(Pair<Pentomino, ArrayList<Coordinate>> p: sauvegarde){
			System.out.print(p.fst()+" ");
		}*/
        return sauvegarde;
    }
    public void reset(){
        sauvegarde.clear();
    }


    public Pentomino get(Coordinate pos) throws NotFound{
        for(Pair<Pentomino, ArrayList<Coordinate>> p: sauvegarde){
            for(Coordinate c: p.snd()){
                if(pos.equals(c)){
                    return p.fst();
                }
            }
        }
        throw new NotFound();
    }




    public String toString(){
        String s="";
        for(int i=0; i<width;i++){
            for(int j=0;j<height;j++){
                if(tab[i][j]!=null){
                    s+=" * ";
                }else{
                    s+=" - ";
                }
            }
            s+="\n";
        }
        return s;
    }


}


