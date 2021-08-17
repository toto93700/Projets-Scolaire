

/**
 * <p>Modélise un joueur pour le jeu Zork. Un Joueur est caractérisé par un nom,
 * un poids maximal ainsi que par les ObjetZork qu'il "transporte"
 * avec lui et dont le poids total ne doit pas excéder le poids maximal.</p>
 *
 * <p>La somme des poids de tous les ObjetZork transportés doit toujours être inférieure ou
 * égale à un poids maximal fixé définitivement à la création du Joueur. Ce poids maximal
 * doit toujours être supérieur ou égal à zéro.</p>
 *
 * <p>Pour le transport des ObjetZork, le Joueur se comporte comme un conteneur d'ObjetZork
 * possédant les propriétés suivantes:
 * <ul>
 *  <li>Un nombre non borné d'ObjetZork peut être ajouté dans la mesure où la contrainte
 *      sur le poids maximal est respectée.</li>
 *  <li>Le Joueur peut transporter plusieurs exemplaires d'un même ObjetZork</li>
 *  <li>La valeur null n'est pas autorisée parmi les ObjetZork transportés</li>
 *  <li>Les objets transportés ne sont pas ordonnés</li>
 *  <li>La méthode equals de ObjetZork est utilisée pour toutes les opérations
 *  nécessitant de tester la présence d'un ObjetZork</li>
 * </ul>
 * </p>
 *
 * @invariant !contient(null);
 * @invariant getPoidsMax() > 0;
 * @invariant getPoids() >= 0 && getPoids() <= getPoidsMax();
 * @invariant getNbObjets() >= 0;
 * @invariant getNom() != null;
 *
 * @author Sujeevan ASEERVATHAM
 * @author Marc Champesme (amélioration du contrat)
 * @version 31 mars 2013
 * @since 31 janvier 2007
 */
public class Joueur extends ArrayListConteneur {
    private String nom;
      private int poidsMax;


    /**
     * Initalise un joueur ne transportant aucun objet et dont le nom est
     * la chaîne de caractères spécifiée.
     * Le poids maximal est initialisé à 10.
     *
     * @requires nom != null;
     * @ensures getNom().equals(nom);
     * @ensures getPoidsMax() == 10;
     * @ensures getPoids() == 0;
     * @ensures getNbObjets() == 0;
     *
     * @param nom Le nom du joueur
     *
     * @throws NullPointerException si le nom spécifié est null
     */
    public Joueur(String nom) {

        if (nom == null) {
            throw new NullPointerException("Le nom du Joueur doit être non null");
        }
        Al=new ArrayListConteneur();
        this.nom = nom;
        poidsMax = 10;
      //  lesObjets = new ObjetZork[10];
    }


    /**
     * Initalise un joueur ne transportant aucun objet, dont le nom est la chaîne
     * de caractères spécifiée et le poids maximal est l'entier spécifié.
     *
     * @requires nom != null;
     * @requires poidsMax > 0;
     * @ensures getNom().equals(nom);
     * @ensures getPoidsMax() == poidsMax;
     * @ensures getPoids() == 0;
     * @ensures getNbObjets() == 0;
	 *
     * @param nom Le nom du joueur.
     * @param poidsMax Le poids maximal transportable par ce joueur.
     *
     * @throws NullPointerException si le nom spécifié est null
     * @throws IllegalArgumentException si le poids maximal spécifié est négatif ou nul
     */
      public Joueur (String nom, int poidsMax) {

        this(nom);
        if (poidsMax <= 0 || nom==null) {
            throw new IllegalArgumentException("Le  nom du joueur doit etre specifié et  le poids maximal transportable par un Joueur doit être strictement positif");
        }
        this.poidsMax = poidsMax;
    }


    /**
     * Renvoie le nom du joueur.
     *
     *
     * @return Le nom du joueur.
     *
     * @pure
     */
    public String getNom() {
        return nom;
    }

    /**
    *@requires oz!=null ;
    *throws NullPointerException si oz==null;
    */

    public boolean ajoutEstPossible(ObjetZork oz){
      if(oz==null){
        throw new NullPointerException("ajoutEstPossible a ete appeler avec un parametre null ");
      }

      // getpoids et oz.getpoids appele une methode du même nom mais pas de la même class !!! ps: cela peut prêter a confusion!
      if(getPoids()+oz.getPoids() <= poidsMax){
        return true;
      }
      else{
        return false;
      }
    }



    /**
     * Renvoie la somme des poids de l'ensemble des ObjetZork transportés
     * par ce Joueur.
     *
     *
     * @return Le poids total des ObjetZork de ce Joueur
     *
     * @pure
     */
    public int getPoids() {
      int c;
        for(int i=0; i<getNbObjets();i++){
          c+=getObjets(i).getPoids();
        }
        return c;
    }

    /**
     * Retourne le poids maximal des objets que le joueur peut porter.
     *
     * @return le poids maximal transportable par ce Joueur
     *
     * @pure
     */
    public int getPoidsMax() {
        return poidsMax;
    }
}
