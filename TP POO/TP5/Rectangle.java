import java.awt.Point;

/**
 *  Un Rectangle est un parallélogramme dont les côtés consécutifs sont
 *  perpendiculaires entre eux. Toute instance de rectangle a une largeur et une
 *  hauteur strictement positive. Les côtés sont parallèles aux axes de
 *  coordonnées
 *
 * @invariant getCoinSupGauche() != null;
 * @invariant (getLargeur() > 0) && (getHauteur() > 0);
 *
 * @author     Valentina Dragos
 * @author     Marc Champesme
 * @version    12 mars 2008
 * @since      19 Mars 2007
 */
public class Rectangle implements Cloneable {
	private Point coinSupGauche;
	private int largeur;
	private int hauteur;


	/**
	 *  Initialise un nouveau rectangle dont le coin supérieur gauche est le point
	 *  spécifié et dont la largeur et la hauteur sont les valeurs spécifiées. Le
	 *  point spécifié doit être non null et les paramètres largeur et hauteur
	 *  doivent être strictement positifs.
	 *
	 * @requires 	coinSupGauche != null;
	 * @requires	largeur > 0 && hauteur > 0;
	 * @ensures		getCoinSupGauche().equals(coinSupGauche);
	 * @ensures		getLargeur() == largeur;
	 * @ensures		getHauteur() == hauteur;
	 *
	 * @param  coinSupGauche              le coin supérieur gauche du nouveau
	 *      rectangle
	 * @param  largeur                    largeur du nouveau rectangle
	 * @param  hauteur                    hauteur du nouveau rectangle
	 * @throws  NullPointerException      si le Point spécifié est null
	 * @throws  IllegalArgumentException  si la largeur ou la hauteur spécifiées
	 *      sont négatives ou nulles
	 */
	public Rectangle(Point coinSupGauche, int largeur, int hauteur) {
		if (largeur <= 0 || hauteur <= 0) {
			throw new IllegalArgumentException("Rectangle de dimensions nulles ou négatives interdit");
		}
		// La classe Point étant une classe modifiable, il faut
		// cloner le point spécifié pour éviter tout
		// risque de modification incontrôlée.
		this.coinSupGauche = (Point) coinSupGauche.clone();
		// Lance une NullPointerException
		// si coinSupGauche est null
		this.largeur = largeur;
		this.hauteur = hauteur;
	}


	/**
	 *  Renvoie le coin supérieur gauche de ce Rectangle, c'est-à-dire le sommet de
	 *  plus petite abcisse et de plus grande ordonnée.
	 *
	 * @ensures      \result != null;
	 *
	 * @return    Le coin supérieur gauche de ce Rectangle
	 */
	public Point getCoinSupGauche() {
		return (Point) coinSupGauche.clone();
	}


	/**
	 *  Renvoie la largeur de ce Rectangle, c'est-à-dire la longueur de ses côtés
	 *  horizontaux.
	 *
	 * @ensures      \result > 0;
	 *
	 * @return    La largeur de ce Rectangle
	 */
	public int getLargeur() {
		return largeur;
	}


	/**
	 *  Renvoie la hauteur de ce rectangle, c'est-à-dire la longueur des côtés
	 *  verticaux.
	 *
	 * @ensures      \result > 0;
	 *
	 * @return    La longueur de ce rectangle
	 */
	public int getHauteur() {
		return hauteur;
	}


	/**
	 *  <p>
	 *
	 *  Remplace la largeur de ce rectangle par la largeur spécifiée. Si la valeur
	 *  spécifiée est inférieure ou égale à zéro, ne fait rien et laisse la largeur
	 *  inchangée.</p> <p>
	 *
	 *  Pour certaines sous-classe de Rectangle modélisant des Rectangle ayant des
	 *  propriétés spécifiques (par exemple des carrés). Une modification de la
	 *  largeur peut entrainer une modification de la hauteur afin de préserver ces
	 *  propriétés spécifiques.</p>
	 *
	 * @ensures 	(newLargeur > 0) ==> (getLargeur() == newLargeur);
	 * @ensures 	(newLargeur <= 0) ==> (getLargeur() == \old(getLargeur()));
	 *
	 * @param  newLargeur  nouvelle valeur de la largeur
	 */
	public void setLargeur(int newLargeur) {
		if (newLargeur > 0) {
			largeur = newLargeur;
		}
	}


	/**
	 *  <p>
	 *
	 *  Remplace la hauteur de ce rectangle par la hauteur spécifiée. Si la valeur
	 *  spécifiée est inférieure ou égale à zéro, ne fait rien et laisse la hauteur
	 *  inchangée.</p> <p>
	 *
	 *  Pour certaines sous-classe de Rectangle modélisant des Rectangle ayant des
	 *  propriétés spécifiques (par exemple des carrés). Une modification de la
	 *  hauteur peut entrainer une modification de la largeur afin de préserver ces
	 *  propriétés spécifiques</p>
	 *
	 * @ensures 	(newHauteur > 0) ==> (getHauteur() == newHauteur);
	 * @ensures 	(newHauteur <= 0) ==> (getHauteur() == \old(getHauteur()));
	 *
	 * @param  newHauteur  nouvelle valeur de la hauteur
	 */
	public void setHauteur(int newHauteur) {
		if (newHauteur > 0) {
			hauteur = newHauteur;
		}
	}


	/**
	 *  Teste l'égalité de ce Rectangle avec l'objet spécifié. Renvoie true si
	 *  l'objet spécifié est un Rectangle de même coin supérieur gauche (au sens de
	 *  equals), de même largeur et de même hauteur.
	 *
	 * @ensures !(obj instanceof Rectangle) ==> !\result;
	 * @ensures (obj instanceof Rectangle) ==>
	 *	\result <==> getCoinSupGauche().equals(((Rectangle) obj).getCoinSupGauche())
	 *			&& (getLargeur() == ((Rectangle) obj).getLargeur())
	 *			&& (getHauteur() == ((Rectangle) obj).getHauteur());
	 * @ensures \result ==> (this.hashCode() == obj.hashCode());
	 *
	 * @param  obj  L'objet à comparer avec ce Rectangle
	 * @return      true si l'objet spécifié est un Rectangle de mêmes
	 *      caractéristiques ; false sinon.
	 */
    @Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Rectangle)) {
			return false;
		}

		Rectangle rect = (Rectangle) obj;
		return coinSupGauche.equals(rect.coinSupGauche)
			 && (largeur == rect.largeur)
			 && (hauteur == rect.hauteur);
	}


	/**
	 *  Renvoie un clone de cette instance.
	 *
	 * @ensures \result != null:
	 * @ensures \result != this;
	 * @ensures \result.equals(this);
	 *
	 * @return    Un clone de cette instance.
	 */
    @Override
	public Rectangle clone() {
		Rectangle leClone = null;
		try {
			leClone = (Rectangle) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
		leClone.coinSupGauche = (Point) coinSupGauche.clone();
		return leClone;
	}


	/**
	 *  Renvoie un code de hashage pour cette instance.
	 *
	 * @return Le code de hashage de cette instance.
	 */
    @Override
	public int hashCode() {
		int code = coinSupGauche.hashCode();
		code = code * 31 + largeur;
		code = code * 31 + hauteur;
		return code;
	}


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
		String str = "Rectangle:" + coinSupGauche.toString();
		str += "/" + largeur + "x" + hauteur;
		return str;
	}


	/**
	 *  Calcule le périmètre du Rectangle
	 *
	 * @ensures \result == (2 * (getLargeur() + getLongueur()));
	 *
	 * @return    Le périmètre de ce Rectangle.
	 */

	public int getPerimetre() {
		return 2 * (largeur + hauteur);
	}
}


