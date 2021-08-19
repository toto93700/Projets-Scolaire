import java.util.ArrayList;

/**
 * cette classe permet la creation d'un type chien et  ses differente methode associé 
 * 
 */
public class Chien {
	
	private String nom ;
	private  int poidsMaximal;
	ArrayList<ObjetZork> objetChien;


	/* initialise un Chien 
	 *
	 * @param  nom  nom du chien 
	 * @param poidsMax capacité donner au "sac" de notre chien 
	 * @requires nom != null;
	 * @requires poidsMax >= 0;
	 * @ensures getPoidMax() == capaciteSac 
	 */
	
	public  Chien(String nom,int poidsMax){
		this.nom=nom;
		poidsMaximal=poidsMax; // on supose qu'a la création chaque chien a un poidsMax D'objet transportable de 5 comme l'indique l'énnoncé
		objetChien=new ArrayList<ObjetZork>();
	}
 
	 /**cette methode renvoi une chaine de description  = au nom du chien
	 *@return nom
	 */
public String getNom() {
	return nom;
}
     /**cette methode renvoi une arrayListd'objet Zork  des objets du chien 
	 *@return objetChien
	 */
public ArrayList<ObjetZork> getObjetChien(){
	return objetChien;
}
	 /**cette methode ajoute un objet zork dans l'inventaire de notre chien 
	 *@requires oz!=null
	 *@return 1 si l'ajoute c'est correctement effectuer  0 sinnon
	 */
public int addObjetChien(ObjetZork oz) {
	
	if(objetChien.size()>=poidsMaximal) {
		return 0;
	}
	objetChien.add(oz);
	return (1);
}
	/**cette methodes supprime  un objet zork dans l'inventaire de notre chien 
	 *@requires oz!=null
	 *@return true si l'operation a pu etre effectué false sinnon
	 */
public boolean removeObjetChien(ObjetZork oz) {
	return(objetChien.remove(oz));
}

 	   ////////// redefinition des methodes equals hashcode et to String de la class Chien 

		public boolean equals(Object o) {
			if (!(o instanceof Chien)) {
				return false;
			}
			
		
			Chien chienx = (Chien) o;
			return(this.getNom().equals(chienx.getNom()) && this.poidsMaximal==chienx.poidsMaximal);
		}
		
		
		
		public int hashCode() {
			
			return nom.hashCode() + 5 * (poidsMaximal + 1);
		}
		
		
		
		public String toString() {
			
			return nom+"poids Max transportable du chien = "+poidsMaximal;
			
		}
	}
