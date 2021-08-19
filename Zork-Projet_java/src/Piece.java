import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *  Une piece dans un jeu d'aventure. <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p> <p>
 *
 *  Une "Piece" represente un des lieux dans lesquels se déroule l'action du
 *  jeu. Elle est reliée a au plus quatre autres "Piece" par des sorties. Les
 *  sorties sont étiquettées "nord", "est", "sud", "ouest". Pour chaque
 *  direction, la "Piece" possède une référence sur la piece voisine ou null
 *  s'il n'y a pas de sortie dans cette direction.</p>
 *
 * @author     Michael Kolling
 * @author     Marc Champesme (pour la traduction francaise)
 * @version    1.2
 * @since      August 2000
 */

public class Piece {
 	private String description;
	// mémorise les sorties de cette piece.
	private Map<Direction, Piece> sorties;
	private ArrayList<ObjetZork> objetsPresent;
	private ArrayList<Chien> chienPresent;



	/**
	 *  Initialise une piece décrite par la chaine de caractères spécifiée.
	 *  Initialement, cette piece ne possède aucune sortie. La description fournie
	 *  est une courte phrase comme "la bibliothèque" ou "la salle de TP".
	 *
	 * @param  description  Description de la piece.
	 * @param objetsPiece sont une arrayLIST D'objet Zork a ajouter dans la piece
	 * @param chien ajoute un chien ou non dans la piece
	 */
	
	
	public Piece(String description,ArrayList<ObjetZork> objetsPiece,Chien chien) {
		this.description = description;
		sorties = new HashMap<Direction, Piece>();
		objetsPresent= new ArrayList<ObjetZork>();
		objetsPresent.addAll(objetsPiece);
		chienPresent=new ArrayList<Chien>(5);
		if(chien!=null) {
		chienPresent.add(chien);
		}
	}


	/**
	 *  Définie les sorties de cette piece. A chaque direction correspond ou bien
	 *  une piece ou bien la valeur null signifiant qu'il n'y a pas de sortie dans
	 *  cette direction.
	 *
	 * @param  nord   La sortie nord
	 * @param  est    La sortie est
	 * @param  sud    La sortie sud
	 * @param  ouest  La sortie ouest
	 */
	public void setSorties(Piece nord, Piece est, Piece sud, Piece ouest) {
		if (nord != null) {
			sorties.put(Direction.NORD, nord);
		}
		if (est != null) {
			sorties.put(Direction.EST, est);
		}
		if (sud != null) {
			sorties.put(Direction.SUD, sud);
		}
		if (ouest != null) {
			sorties.put(Direction.OUEST, ouest);
		}
	}

	 	/**
	 	 * cette methode renvoi une description de notre piece
		 */
	public String getDescription() {
		return description;
	}
	
	/*cette methode ajoute un objet zork dans la piece
	 * @requires oz!=null;
	 */
	public void ajouterPiece(ObjetZork oz) {
		objetsPresent.add(oz);
	}
	
	
	   /*cette methode renvoi une chaine de caractere indiquant les objetszork  present dans la piece
		 *@return contenue; 
		 */
	public String contenuPiece() {
		String contenue="";
		if(objetsPresent.isEmpty()==true) {
			contenue="La piece est vide.";
			return contenue;
		}
		for(int i=0;i<objetsPresent.size();i++) {
			contenue=contenue+""+ objetsPresent.get(i).getNom()+",";
		}
		return"Les objet(s) presents dans la piece sont :"+ contenue;
	}
	
	/*cette methode renvoi une chaine de caractere indiquant les chiens present dans la piece
	 *@return contenue; 
	 */
	public String ChienPresent() {
		String contenue="";
		if(chienPresent.isEmpty()==true) {
			contenue="il n'y a aucun chien dans cette piece";
			return contenue;
		}
		for(int i=0;i<chienPresent.size();i++) {
			contenue=contenue+""+chienPresent.get(i).getNom()+",";
		}
		return "les chien(s) presents dans la piece sont :"+contenue;
	}
	
	/**
	 * cette methode renvoi une descriptioncourte indiquant la description du nom de l'objet  present dans la piece
	 *@return descriptioncourte()
	 */
	
	public String DescrptionNom(String nom) {
		if(objetsPresent.isEmpty()==true) {
			return("l'objet d'on vous demandez la description n'est pas dans cette piece , Ou n'existe pas dans le jeux zork");
		}
		else {
		for(int i=0;i<objetsPresent.size();i++) {
			if(objetsPresent.get(i).getNom().equals(nom)) {
				return (objetsPresent.get(i).descriptionCourte());
			}
		}
		}
		return("l'objet d'on vous demandez la description n'est pas dans cette piece , Ou n'existe pas dans le jeux zork");
	}

	
	/**cette methode supprime un objet de la piece 
	 * @param o un objet zork a supprimer
	 *@return true si l'objet a ete correctement supprimer false sinnon
	 */
	
	public boolean removeFromPiece(ObjetZork o) {
		
		return(objetsPresent.remove(o));
		
	}
	
	
	/**
	 * cette methode renvoi une arrayList d'objetZork de la piece
	 *@return objetsPresent;
	 */
	public ArrayList<ObjetZork> getListeObjet() {
		return(objetsPresent);
	}
	
	/**
	 * cette methode renvoi une arrayList de chien present dans la piece
	 *@return ochienPresent;
	 */
	public ArrayList<Chien> GetLeschienPresent(){
		return chienPresent;
		
		
	}
	/**
	 *cette methode supprimer un chien (passer en parametre ) present dans le piece
	 */
	public void removeUnChienPiece(Chien chien) {
		chienPresent.remove(chien);
		
		
	}
	


	/**
	 *  Renvoie la description de cette piece (i.e. la description spécifiée lors
	 *  de la création de cette instance).
	 *
	 * @return    Description de cette piece
	 */
	public String descriptionCourte() {
		return description;
	}


	/**
	 *  Renvoie une description de cette piece mentionant ses sorties et
	 *  directement formatée pour affichage, de la forme: <pre>
	 *  Vous etes dans la bibliothèque.
	 *  Sorties: nord ouest</pre> Cette description utilise la chaine de caractères
	 *  renvoyée par la méthode descriptionSorties pour décrire les sorties de
	 *  cette piece.
	 *
	 * @return    Description affichable de cette piece
	 */
	public String descriptionLongue() {
		return "Vous etes dans " + description + ".\n" + descriptionSorties();
	}


	/**
	 *  Renvoie une description des sorties de cette piece, de la forme: <pre>
	 *  Sorties: nord ouest</pre> Cette description est utilisée dans la
	 *  description longue d'une piece.
	 *
	 * @return    Une description des sorties de cette pièce.
	 */
	public String descriptionSorties() {
		String resulString = "Sorties:";
		for (Direction sortie :  sorties.keySet()) {
			resulString += " " + sortie;
		}
		return resulString;
	}


	/**
	 *  Renvoie la piece atteinte lorsque l'on se déplace a partir de cette piece
	 *  dans la direction spécifiée. Si cette piece ne possède aucune sortie dans cette direction,
	 *  renvoie null.
	 *
	 * @param  direction  La direction dans laquelle on souhaite se déplacer
	 * @return            Piece atteinte lorsque l'on se déplace dans la direction
	 *      spécifiée ou null.
	 */
	public Piece pieceSuivante(Direction d) {
		return sorties.get(d);
	}
}

