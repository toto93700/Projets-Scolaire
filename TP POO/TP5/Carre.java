import java.awt.Point;

/**
 *  Un carré est un Rectangle dont la hauteur et la largeur sont identiques et
 *  sont égales au côté du carré. Cette classe héritant de la classe Rectangle,
 *  les carrés modélisés par cette classe ont leurs côtés parallèles aux axes de
 *  coordonnée et ont un côté strictement positif.
 *
 * @invariant    getLargeur() == getHauteur();
 * @invariant    getCote() == getLargeur();
 * @invariant    getCote() == getHauteur();

 * @author       Valentina Dragos
 * @author       Marc Champesme
 * @version      12 mars 2008
 * @since        19 Mars 2007
 */

public class Carre extends Rectangle {

	/**
	 *  Initialise un carré dont le coin supérieur gauche est le Point spécifié et
	 *  dont le côté est l'entier spécifié. Le Point spécifié doit être non null et
	 *  la valeur spécifiée pour le côté doit être strictement positive.
	 *
	 * @requires	coinSupGauche != null;
	 * @requires	cote > 0;
	 * @ensures		getCoinSupGauche().equals(coinSupGauche);
	 * @ensures		getCote() == cote;
	 *
	 * @param  coinSupGauche              Le coin supérieur gauche du nouveau Carre
	 * @param  cote                       Le côté du carré
	 * @throws  NullPointerException      si le Point spécifié est null
	 * @throws  IllegalArgumentException  si le côté spécifié est négatif ou nul
	 */
	public Carre(Point coinSupGauche, int cote) {
		super(coinSupGauche, cote, cote);
	}


	/**
	 *  Renvoie le côté de ce Carre.
	 *
 	 * @ensures      \result > 0;
	 * @ensures      \result == getLargeur();
	 * @ensures      \result == getHauteur();

	 * @return    La valeur du côté de ce Carre
	 */
	public int getCote() {
		return getLargeur();
	}


	/**
	 *  Remplace le côté de ce carré par la valeur absolue de la valeur spécifiée.
	 *  Si la valeur spécifiée est égale à zéro, aucune modification n'est apportée
	 *  à ce Carre.
	 *
	 * @ensures (newCote == 0) ==> (getCote() == \old(getCote()));
	 * @ensures (newCote < 0) ==> (getCote() == -newCote);
	 * @ensures (newCote > 0) ==> (getCote() == newCote);
	 *
	 * @param  newCote  nouvelle valeur du côté
	 */
	public void setCote(int newCote) {
		setLargeur(Math.abs(newCote));
	}


	/**
	 *  Remplace la largeur et la longueur de ce carre par la valeur spécifiée. Si la valeur
	 *  spécifiée est inférieure ou égale à zéro, ne fait rien et laisse longueur et largeur
	 *  inchangées.
	 *
	 * @ensures	(nouvelleValeur > 0) ==> ((getLargeur() == nouvelleValeur)
	 *		&& (getHauteur() == nouvelleValeur)
	 *		&& (getCote() == nouvelleValeur));
	 * @ensures	(nouvelleValeur <= 0) ==> (getLargeur() == \old(getLargeur()));
	 *		&& (getHauteur() == \old(getHauteur()))
	 *		&& (getCote() == \old(getCote())));
	 *
	 * @param  nouvelleValeur  nouvelle valeur de la largeur, de la longeur et du côté
	 */
    @Override
	public void setLargeur(int nouvelleValeur) {
		super.setLargeur(nouvelleValeur);
		super.setHauteur(nouvelleValeur);
	}


	/**
	 *  Remplace la largeur et la longueur de ce carre par la valeur spécifiée. Si la valeur
	 *  spécifiée est inférieure ou égale à zéro, ne fait rien et laisse longueur et largeur
	 *  inchangées.
	 *
	 * @ensures	(nouvelleValeur > 0) ==> ((getLargeur() == nouvelleValeur)
	 *		&& (getHauteur() == nouvelleValeur)
	 *		&& (getCote() == nouvelleValeur));
	 * @ensures	(nouvelleValeur <= 0) ==> (getLargeur() == \old(getLargeur()));
	 *		&& (getHauteur() == \old(getHauteur()))
	 *		&& (getCote() == \old(getCote())));
	 *
	 * @param  nouvelleValeur  nouvelle valeur de la largeur, de la longeur et du côté
	 */
    @Override
	public void setHauteur(int nouvelleValeur) {
		setLargeur(nouvelleValeur);
	}


	/**
	 *  Teste l'égalité de ce Carre avec l'objet spécifié. Renvoie true si
	 *  l'objet spécifié est un Rectangle de même coin supérieur gauche (au sens de
	 *  equals), de même largeur et de même hauteur.
	 *
	 * @ensures !(obj instanceof Rectangle) ==> !\result;
	 * @ensures (obj instanceof Rectangle) ==>
	 *	\result <==> getCoinSupGauche().equals(((Rectangle) obj).getCoinSupGauche())
	 *			&& (getCote() == ((Rectangle) obj).getLargeur())
	 *			&& (getCote() == ((Rectangle) obj).getHauteur());
	 * @ensures \result ==> (this.hashCode() == obj.hashCode());
	 *
	 * @param  obj  L'objet à comparer avec ce Rectangle
	 * @return      true si l'objet spécifié est un Rectangle de mêmes
	 *      caractéristiques que cette instance ; false sinon.
	 */
    @Override
	public boolean equals(Object obj) {
		// Cette redéfinition n'est absolument pas
		// indispensable, elle ne conduit d'ailleurs
		// à aucun gain en efficacité
		if (!(obj instanceof Rectangle)) {
			return false;
		}

		Rectangle rect = (Rectangle) obj;
		return getCoinSupGauche().equals(rect.getCoinSupGauche())
			 && getCote() == rect.getHauteur()
			 && rect.getHauteur() == rect.getLargeur();
	}


	// Il n'y a aucune nécessité ni aucun intérêt à redéfinir les méthodes
	// clone et hashCode

	/**
	 * Renvoie une représentation rudimentaire de cette instance 
	 * sous forme de chaîne de caractères.
	 *
	 * @ensures \result != null;
	 *
	 * @return Une représentation rudimentaire de cette instance 
	 * sous forme de chaîne de caractères.
	 */
    @Override
	public String toString() {
		String str = "Carre:" + getCoinSupGauche().toString();
		return str + "/" + getCote();
	}


	/**
	 *  Calcule le périmètre de ce carre.
	 *
	 * @return    Le périmètre de ce carre.
	 */
    @Override
	public int getPerimetre() {
		return 4 * getCote();
	}

}
