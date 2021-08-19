
import java.util.ArrayList;

/**
 *  Classe principale du jeu "Zork". <p>
 *
 *  Zork est un jeu d'aventure très rudimentaire avec une interface en mode
 *  texte: les joueurs peuvent juste se déplacer parmi les différentes pieces.
 *  Ce jeu nécessite vraiment d'etre enrichi pour devenir intéressant!</p> <p>
 *
 *  Pour jouer a ce jeu, créer une instance de cette classe et appeler sa
 *  méthode "jouer". </p> <p>
 *
 *  Cette classe crée et initialise des instances de toutes les autres classes:
 *  elle crée toutes les pieces, crée l'analyseur syntaxique et démarre le jeu.
 *  Elle se charge aussi d'exécuter les commandes que lui renvoie l'analyseur
 *  syntaxique.</p>
 *
 * @author     Michael Kolling
 * @author     Marc Champesme (pour la traduction francaise)
 * @version    1.2
 * @since      March 2000
 */

public class Jeu {
	private AnalyseurSyntaxique analyseurSyntaxique;
	private Piece pieceCourante;
	private Joueur Tom;


	/**
	 *  Crée le jeu et initialise la carte du jeu (i.e. les pièces).
	 */
	public Jeu() {
		creerPieces();
		this.Tom=new Joueur("Tom",10,pieceCourante);
		analyseurSyntaxique = new AnalyseurSyntaxique();
		
	}
	
	
	
	
	
	

	/**
	 *  Crée toutes les pieces et relie leurs sorties les unes aux autres. et les initiliase arbitrairement d'objet et ou de chien present
	 */
	
	public void creerPieces() {
		Piece dehors;
		Piece salleTD;
		Piece taverne;
		Piece batimentC;
		Piece burreau;
		Piece centrale;

	   //creation d'objet Zork
		ObjetZork ciseaux =new ObjetZork("un ciseaux pour couper la laisse d'un chien","ciseaux",1);
		ObjetZork laisse  =new ObjetZork("une laisse pour attraper un chien","laisse",1);
		ObjetZork gamelle =new ObjetZork("Une gamelle avec  plein de croquette","gamelle",100,false);
		ArrayList<ObjetZork> a0=new ArrayList<ObjetZork>();
		ArrayList<ObjetZork> a1=new ArrayList<ObjetZork>();
		a1.add(ciseaux);a1.add(laisse);
		ArrayList<ObjetZork> a2=new ArrayList<ObjetZork>();
		a2.addAll(a1);a2.add(gamelle);
		
		
		
		// creation de chien 
		
		Chien milou=new Chien("Milou",5);
		Chien medore=new Chien("Medore",5);
		
		// création des pieces
		
		
		dehors = new Piece("devant le batiment C",a1,milou);
		salleTD = new Piece("une salle de TD dans le batiment G",a0,null);
		taverne = new Piece("la taverne",a1,medore);
		batimentC = new Piece("le batiment C",a0,null);
		burreau = new Piece("le secrétariat",a0,null);
		centrale= new Piece("Scolarite centrale",a2,null);

		// initialise les sorties des pieces
		dehors.setSorties(centrale, salleTD, batimentC, taverne);
		salleTD.setSorties(null, null, null, dehors);
		taverne.setSorties(null, dehors, null, null);
		batimentC.setSorties(dehors, burreau, null, null);
		burreau.setSorties(null, null, null, batimentC);
		centrale.setSorties(null, null, dehors,null);
	
		

		// le jeu commence dehors
		pieceCourante = dehors;
		
	}
	
	

	

	/**
	 *  Pour lancer le jeu. Boucle jusqu'a la fin du jeu.
	 */
	public void jouer() {
		afficherMsgBienvennue();
		
		// Entrée dans la boucle principale du jeu. Cette boucle lit
		// et exécute les commandes entrées par l'utilisateur, jusqu'a
		// ce que la commande choisie soit la commande "quitter"
		boolean termine = false;
		while (!termine) {
			Commande commande = analyseurSyntaxique.getCommande();	
			termine = traiterCommande(commande);
		}
		System.out.println("Merci d'avoir jouer.  Au revoir.");
	}


	/**
	 *  Affiche le message d'accueil pour le joueur.
	 */
	public void afficherMsgBienvennue() {
		System.out.println();
		System.out.println("Bienvennue dans le monde de Zork !");
		System.out.println("Zork est un nouveau jeu d'aventure, terriblement enuyeux.");
		System.out.println("Tapez 'aide' si vous avez besoin d'aide.");
		System.out.println();
		System.out.println(pieceCourante.descriptionLongue());
	}


	/**
	 *  Exécute la commande spécifiée. Si cette commande termine le jeu, la valeur
	 *  true est renvoyée, sinon false est renvoyée
	 *
	 * @param  commande  La commande a exécuter
	 * @return           true si cette commande termine le jeu ; false sinon.
	 */
	public boolean traiterCommande(Commande commande) {
		if (commande.estInconnue()) {
			System.out.println("Je ne comprends pas ce que vous voulez...");
			return false;
		}

		String motCommande = commande.getMotCommande();
		if(motCommande.equals("lister")) {
			listerObjetPiece();
		}
		if(motCommande.equals("description")){
			if(commande.aSecondMot()==false) {
				System.out.println("Description de quoi ?");
			}
			else {
			printlnDecription(commande.getSecondMot());
			}
				
	    }
		if(motCommande.equals("monSac")) {
			afficherSac();
			
		}
		
		
		if(motCommande.equals("prendre")) {
			if(commande.aSecondMot()==false) {
				System.out.println("Prendre quoi ?");
			}
			else {
				addEtRemove(commande.getSecondMot());
			}
		}
		if(motCommande.equals("listerChien")) {
			listerChienPiece();
		}
		
		
		
		if(motCommande.equals("deposer")) {
			if(commande.aSecondMot()==false) {
				System.out.println("Deposer quoi ?");
			}
			else {
				deposer(commande.getSecondMot());
			}
		}
		
		if(motCommande.equals("donner")) {
			if(commande.aSecondMot()==false || commande.aTroisiemeMot()==false) {
				System.out.println("Donner Quoi � qui ? ?");
				
			}
			else {
				if(donnerObjetChien(commande.getSecondMot(),commande.getTroisiemeMot())==0){
					System.out.println("vous avez depasser la capaciter maximal que votre chien peut porter : Game Over");
					return true; ///////////////////////// FINI LE JEUX SI CAPACITE DEPASSER DANS UN DES CHIEN 
				}
			}
			
		}
		if(motCommande.equals("adopterChien")){
			if(commande.aSecondMot()==false ) {
				System.out.println("Adopte quelle chien ?");
			}
			else {
				adopteUnChien(commande.getSecondMot());
			}
			
		}
		if(motCommande.equals("libererChien")) {
			if(Tom.libererChien()==1){
			System.out.println("vous avez perdu vos chien GameOver");
			return true;
			}
		}
		
		if(motCommande.equals("mesChien")){
			System.out.println(Tom.MesChien());
		}
		
		if(motCommande.equals("fini")) {
			if(Tom.getSizeClebs()>=2) {
				ArrayList<Chien> A=Tom.getLesChienAvecJoueur();
					ObjetZork laisse  =new ObjetZork("une laisse pour attraper un chien","laisse",1);
				for(int i =0;i<A.size();i++) {
					ArrayList<ObjetZork> B=A.get(i).getObjetChien();
					if(B.contains(laisse)==false) {
						System.out.println("Vous n'avez pas reunie les condition de victoire qui sont : Obtenir les deux chien disperser dans les differente piece  les equiper d'une laisse "
								+ "et les amener dans la Scolarite centrale");
						return false;
					}
				}
				if(pieceCourante.getDescription().equals("Scolarite centrale")) {
					System.out.println("felicitation vous avez gagner");
					return true;
				}
			}
			System.out.println("Vous n'avez pas reunie les condition de victoire qui sont : Obtenir les deux chien disperser dans les differente piece  les equiper d'une laisse "
					+ "et les amener dans la Scolarite centrale");
			return false;
		}if (motCommande.equals("regle")) {
			System.out.println(" Pour gagner vous devez Obtenir les deux chien disperser dans les differente piece  les equiper d'une laisse et les amener dans la Scolarite centrale");
			}
		
		if (motCommande.equals("aide")) {
			afficherAide();
		} else if (motCommande.equals("aller")) {
			deplacerVersAutrePiece(commande);
		} else if (motCommande.equals("quitter")) {
			if (commande.aSecondMot()) {
				System.out.println("Quitter quoi ?");
			} else {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	 	/**
	 	 *cette methode permet l'adoption d'un chien en passant en parametre le nom d'un chien present dans la piecce courante 
		 *@requires nom!=null
		 */
	public void adopteUnChien(String nom){
		ArrayList<Chien> A=pieceCourante.GetLeschienPresent();
	
		for(int i=0;i<A.size();i++) {
			if(A.get(i).getNom().equals(nom)) {
				Tom.AdopteChien(A.get(i));
				pieceCourante.removeUnChienPiece(A.get(i));
				System.out.println("vous avez adopter "+nom);
				return;
			}
		}
		System.out.println("Erreur dans l'adoption");
	}
	
	 	/**
	 	 *cette methode permet d'ajouter un objetZork present dans le sac du joueur a un chien present dans la liste des chien du joueur 
		 *@requires mot2 !=null  mot3 != null
		 *@return 0 si on depasser le nombre d'objetTransportable par le chien 1 sinnon
		 */
	
	public int donnerObjetChien(String mot2,String mot3) {
		
		ObjetZork oz=null;
		ArrayList<ObjetZork> A=Tom.getContenueSac();
		if(A.isEmpty()==true) {
			System.out.println("Il n'y a rien a donner mon sac est vide");
			return 1;
		}
		
		for(int i =0;i<A.size();i++) {
			if(A.get(i).getNom().equals(mot2)) {
				oz=A.get(i);
			}
		}
		if(oz==null) {
			System.out.println("L'objet stipul� n'est pas dans mon sac ou n'existe pas dans le jeux");
			return 1;
		}
		ArrayList<Chien> C =Tom.getLesChienAvecJoueur();
		if(C.isEmpty()==true) {
			System.out.println("Vous n'avez aucun chien avec vous");
			return 1;
		}
		for(int j=0;j<C.size();j++) {
			if(C.get(j).getNom().equals(mot3)) {
				Tom.suppimerObjet(oz);
				if(Tom.AjouteDansChien(oz,j)==0) {
					System.out.println("vous avez depasser la capacite du sac de votre chien game over ");
					return 0;
				}
			}
		}
		System.out.println("l'objet a correctement ete donner");
		return 1;
	}
	
	
		/**
		 * cette methode  liste les chien present avec le joueur 
		 */
	public void listerChienPiece() {	
		System.out.println(pieceCourante.ChienPresent());
	}
	
	

	
	/** 
	 * cette methode ajoute un objet zork dans l'inventaire de notre joueur et le supprime de la piece
	 *@requires nom !=null
	 */


public void addEtRemove(String nom) {
	
	
	ArrayList<ObjetZork> A=pieceCourante.getListeObjet();

	for(int i=0;i<A.size();i++) {
		if(A.get(i).getNom().equals(nom)) {
			
			if(Tom.ajouteSac(A.get(i))==1) {
				pieceCourante.removeFromPiece(A.get(i));
				System.out.println("L'objet a correctement �t� ajouter a votre sac");
				return;
			}
			
		}
	}
	
	System.out.println("L'objet  stipuler n'a pas pu �tre ajouter a votre sac");
	
}




/**cette methode ajoute un objet zork dans dans la piece
 * @requires nom!=null
 */

public void  deposer(String nom){

ArrayList<ObjetZork> A=Tom.getContenueSac();
if(A.isEmpty()==true) {
	System.out.println("Impossible d'�ffectuer cette operation votre sac ne contient rien");
	return;
}

for(int i=0;i<A.size();i++) {
	if(A.get(i).getNom().equals(nom)) {
		pieceCourante.ajouterPiece(A.get(i));
		Tom.suppimerObjet(A.get(i));
		System.out.println("L'objet a correctement �t� deposer dans la piece actuelle");
		return;
	}
}

System.out.println("Erreur , Impossible d'�ffectuer cette operation");
return;
}




/**
 * *
 * @return la piece courante dans laquel le joueur se trouvera
 */
public Piece getPieceCourante() {
return this.pieceCourante;
}




	// implementations des commandes utilisateur:

	/**
	 *  Affichage de l'aide. Affiche notament la liste des commandes utilisables.
	 */
	public void afficherAide() {
		System.out.println("Vous etes perdu. Vous etes seul. Vous errez");
		System.out.println("sur le campus de l'Université Paris 13.");
		System.out.println();
		System.out.println("Les commandes reconnues sont:");
		analyseurSyntaxique.afficherToutesLesCommandes();
	}
	public void listerObjetPiece() {
		String contenue=pieceCourante.contenuPiece();
		System.out.println(contenue);
	}

	
	public void printlnDecription(String objet) {
		System.out.println(pieceCourante.DescrptionNom(objet));
	}
	
	public void afficherSac(){
		System.out.println(Tom.contenuSac());
	}
	
	
	
	
	
	
	

	/**
	 *  Tente d'aller dans la direction spécifiée par la commande. Si la piece
	 *  courante possède une sortie dans cette direction, la piece correspondant a
	 *  cette sortie devient la piece courante, dans les autres cas affiche un
	 *  message d'erreur.
	 *
	 * @param  commande  Commande dont le second mot spécifie la direction a suivre
	 */
	public void deplacerVersAutrePiece(Commande commande) {
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
			System.out.println("Aller où ?");
			return;
		}

		String direction = commande.getSecondMot();
		Direction d = null;
		try {
		    d = Direction.valueOf(direction);
		  } catch (IllegalArgumentException e) {
		      System.out.println("Pour indiquer une direction entrez une des chaînes de caractères suivantes:");
		      for (Direction dok : Direction.values()) {
		          System.out.println("-> \"" + dok + "\"");
		      }
		      return;
		  }

		// Tentative d'aller dans la direction indiquée.
		Piece pieceSuivante = pieceCourante.pieceSuivante(d);

		if (pieceSuivante == null) {
			System.out.println("Il n'y a pas de porte dans cette direction!");
		} else {
			pieceCourante = pieceSuivante;
			//Ajout de l'actualisation de l'emplacement du joueur TOM
			Tom.setPieceCouranteJoueur(pieceCourante);
			System.out.println(pieceCourante.descriptionLongue());
			Tom.ChienQuiSuit(pieceCourante);
		}
	}

	
	
	
	

}

