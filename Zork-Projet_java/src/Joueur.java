import java.util.ArrayList;

/**
 *  Un joueur du jeux  d'aventure. <p>
 *
 * toute les action concerneron de pres ou de loin au joueur creer 
 */




public class Joueur {
	
	private String nom;
	private int poidsMax;
	private Piece pieceActuelle;
	private ArrayList<ObjetZork> sac;
	private ArrayList<Chien> clebs; /////////////////
	
	

	/**
	 *  Initialise un joueur 
	 *
	 * @param  nom  nom du joueur 
	 * @param capaciteSac capacité donner au sac de notre joeur 
	 * @param pieceActuelle piece ou atterie le joeur en début de jeux 
	 * 
	 * @requires nom != null;
	 * @requires capaciteSac >= 0;
	 * @ensures getPoidMax() == capaciteSac;
	 * 
	 */
	
	
	public Joueur(String nom,int capaciteSac,Piece pieceActuelle) {
		
		this.nom=nom;
		poidsMax=capaciteSac;
		this.pieceActuelle=pieceActuelle;
		sac=new ArrayList<ObjetZork>(poidsMax);
		clebs=new ArrayList<Chien>(5);
	}

	/**
	 *  Renvoie si le contenue du sac du jouueur est plein
	 *
	 * @return true si sacEstplein else sinnon
	 */
	boolean sacEstPlein() {
		
		if(sac.size()>=poidsMax) {
			return true;
		}
		return false;
	}
	
	
	
	/**
	 *  cette methode permet d'ajouter un objetZork dans le sac du joueur .
	 * @param Un objetZork a ajouter;
	 * @requires oz!= null;
	 * @return 1 si l'ajoute a ete possible en fonction de la capacitéMax donner au joueur a notre creation 0 sinon
	 */
	public int ajouteSac(ObjetZork oz) {
		if(sacEstPlein()==false && oz.getEstTransportable()==true) {
			sac.add(oz);
			return 1;
		}
		return 0;
	}
	
	/**
	 *  cette methode permet de supprimer un objet du sac du joueur et d'avoir un retour en fonction de la reussite ou non de l'operation 
	 * @param Un objetZork a supprimer
	 * @requires oz!= null;
	 * @return l'objetZork supprimer   null sinnon
	 */
	public ObjetZork suppimerObjet(ObjetZork oz) {
		if(sac.indexOf(oz)>=0) {
			return(sac.remove(sac.indexOf(oz)));
		}
		return null;	
	}
	
	/**
	 *  cette methode renvois une chaine de caractère decrivant le contenue du sac d'objetZork du joueur
	 * @return une description du contenue du sac ;
	 */
	
	public String contenuSac() {
		String contenue=" ";
		if(sac.isEmpty()==true) {
			return("mon sac est vide");
		}
		for(int i=0;i<sac.size();i++) {
			contenue=contenue+" "+sac.get(i).getNom();
		}
		return "Contien"+ contenue;
	}
	/**
	 *  cette methode permet de modifier la piece courante du joeuur
	 */
	public void setPieceCouranteJoueur(Piece pieceCourante) {
		pieceActuelle=pieceCourante;
	}
	/**
	 *cette methode renvois le poidsMax qui est la capaciteMax du sac
	 *@return poidsMax
	 */
	public int getPoidsMax() {
		return poidsMax;
	}
	
	/**
	 * cette methode renvois une description de  la piece ou se trouve le joueur
	 * @return une description de la piece ;
	 */
	public String getpieceCouranteJoueur(Piece pieceCourante) {
		return pieceCourante.descriptionCourte();
	}
	
	/**
	 *  cette methode renvois une arrraList du contenue DU sac
	 * @return sac ;
	 */
	public ArrayList<ObjetZork> getContenueSac(){
		return sac;
	}

	/**
	 *  cette methode renvois une arrraList des chien avec le joueur 
	 * @return clebs ;
	 */
	public ArrayList<Chien> getLesChienAvecJoueur(){
		return clebs;
	}
	

	/**
	 *  cette methode ajoute Un objet zork  a l'indice i dans arrayList de chien clebs.
	 * @return 1 si l'objet a ete ajouter 0 sinnon  ;
	 */
	public int AjouteDansChien(ObjetZork o,int i) {
		
		if(clebs.get(i).addObjetChien(o)==0) {
			return 0;
		}
		return 1;
		
	}

	/**
	 *  cette methode ajoute un chien dans arrayList de chien du joueur
	 * @param chien un chien 
	 */
	public void AdopteChien(Chien chien) {
		if(clebs.size()>=5) {
			System.out.println("Vous ne pouvez adopter plus de chien");
			return;
		}
		clebs.add(chien);
	}
	

	/**
	 *  cette methode renvois une chaine de caractere des chien avec le joeuur
	 * @return contenue ;
	 */
	public String MesChien() {
		String contenue=" ";
		if(clebs.isEmpty()==true) {
			return("Je n'ai aucun chien avec moi");
		}
		for(int i=0;i<clebs.size();i++) {
			contenue=contenue+" "+clebs.get(i).getNom();
		}
		return "Mes chien(s) sont :"+ contenue;
	}
	

	/**
	 *  cette methode affiche dans la console les chien qui suivent le joueur 
	 */
	public void ChienQuiSuit(Piece piece) {
		if(clebs.isEmpty()==true) {
			return;
		}
		String fallow="";
		for(int i=0;i<clebs.size();i++) {
			fallow+=clebs.get(i).getNom()+ ",";
		}
		fallow+="vous suivent dans "+piece.getDescription();
	
    System.out.println(fallow);
	
	}

	/**
	 *  cette methode supprimer tout les chien de clebs 
	 * @return 1   si des chien on exister et on ete supprimer 0 si il n'y a aucun chien dans clebs;
	 */
	public int libererChien() {
		if(clebs.isEmpty()==true) {
			return 0;
		}
		for(int i =0 ;i<clebs.size();i++) {
			if(clebs.get(i)!=null) {
				clebs.remove(i);
			}
			
		}
		System.out.println("vos chien se sont enfuit comme prévue");
		return 1;
	}

	/**
	 *  cette methode renvois le nombre d'élément de la list clebs
	 * @return clebs.size() ;
	 */
	public int getSizeClebs() {
		return clebs.size();
	}
	
}
