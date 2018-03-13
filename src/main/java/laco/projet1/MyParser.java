package laco.projet1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class MyParser {
	private int height;
	private int width;
	private ArrayList<Pentomino> pentominos ;

	
	public static Document readXMLFile(InputStream fname) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(fname);
		} catch (Exception ex) {
			System.out.println("erreur d'ouverture");
			return null;
		}
	}
	
	public MyParser(int height, int width, ArrayList<Pentomino> pentominos) {
		this.height = height;
		this.width = width;
		this.pentominos = pentominos;
	}
	
	public int getHeight()
	{

		return height ;
	}

	public int getWidth() {
		return width;
	}
	
	public ArrayList<Pentomino> getPentominos() {
		return pentominos;
	}
	
	public static ArrayList<MyParser>lesParties (Document theDoc1){
		ArrayList<MyParser> listXML =new ArrayList<MyParser>();
		
		//Document theDoc1 = readXMLFile("https://www.irif.fr/~eleph/Enseignement/2016-17/2I013-Android/puzzles.xml");
		
        
		// 1 : r�cup�ration de la racine 
		Element racine = theDoc1.getDocumentElement();
		
        // 2: r�cup�ration de la liste des noeud 
		NodeList listNoeuds = racine.getChildNodes();
		int nbRacineNoeuds = listNoeuds.getLength();
		Element puzzle = null ; 
		// 3:r�cup�ration et affichage des noeurs 
        for (int i = 0; i<nbRacineNoeuds; i++) {
        	if(listNoeuds.item(i).getNodeType()==Node.ELEMENT_NODE){
                puzzle = (Element) listNoeuds.item(i);
                // 4:affichage et r�cup�ration  des atributs height & width
            	int h = Integer.parseInt(puzzle.getAttribute("height")) ;
            	int w = Integer.parseInt(puzzle.getAttribute("width")) ;
            	//System.out.println(listNoeuds.item(i).getNodeName()); // sa affiche le noeud ( son nom  )
            	
            	 // 6 : r�cup�ration des pento ( de id ) 
            	NodeList filsPento ; 
        		Element pento ;
        		ArrayList<Pentomino> listDePento=new ArrayList<Pentomino>();
                filsPento = puzzle.getElementsByTagName("pento");
                int nbFilsPento = filsPento.getLength();
                for(int j=0  ; j< nbFilsPento ; j++){
                	pento = (Element) filsPento.item(j);
                	listDePento.add(Pentomino.valueOf(pento.getAttribute("id")));
                	//System.out.println(" id :" + pento.getAttribute("id"));
                }
    			listXML.add(new MyParser(h, w, listDePento));
        	}
           
        }		
		return listXML;
	}
}

