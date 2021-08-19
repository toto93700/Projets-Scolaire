
public class ObjetZork {
	private String description;
	private int poids;
	private String nom;
	private boolean estTransportable;

	/**
	 *  Initialise un objet transportable identifi� par la cha�ne de caract�res
	 *  sp�cifi�e et dont le poids est l'entier sp�cifi�. La cha�ne de caract�res
	 *  sp�cifi�e doit �tre diff�rente de <code>null</code> et le poids doit �tre sup�rieur ou
	 *  �gal � 0.
	 *
	 * @requires description != null;
	 * @requires poids >= 0;
	 * @ensures descriptionCourte().equals(description);
	 * @ensures getPoids() == poids;
	 *
	 * @param  description  La cha�ne de caract�res qui identifie cet objet
	 * @param  poids        Le poids de l'objet
	 */
	public ObjetZork(String description, String nom,int poids) {
		this.description=description;
		this.poids = poids;
		this.nom=nom;
		estTransportable=true;
	}
	public ObjetZork(String description, String nom,int poids,boolean transportable) {
		this.description=description;
		this.poids = poids;
		this.nom=nom;
		estTransportable=transportable;
	}

	/**
	 *  Renvoie la description de cet objet (i.e. la description sp�cifi�e lors de
	 *  la cr�ation de cette instance).
	 *
	 * @return    Description de cet objet
	 *
	 * @pure
	 */
	public String descriptionCourte() {
		return description;
	}


	/**
	 *  Renvoie une description de cet objet contenant l'ensemble de ses
	 *  caract�ristiques. Cette description est destin�e a fournir une description
	 *  compl�te de cet objet format�e pour un affichage pr�sent� a l'utilisateur.
	 *
	 * @return    Renvoie une description de cet objet contenant l'ensemble de ses
	 *      caract�ristiques
	 *
	 * @pure
	 */
	public String descriptionLongue() {
		if(estTransportable==true) {
		String descriptionLongue = description+" un(e)"+nom+"de poids = "+poids; 
		return descriptionLongue ;
		}
		else {
			String descriptionLongue = description+" un(e)"+nom+"de poids = "+poids+" Cette objet n'est pas transportable "; 
			return descriptionLongue ;
		}
	}


	/**
	 *  Renvoie le poids de cet objet. 
	 *
	 * @return    Le poids de cet objet.
	 *
	 * @pure
	 */
	public int getPoids() {
		return poids;
	}


	public boolean getEstTransportable() {
		return estTransportable;
	}
	/**
	 *  Renvoie true si et seulement si l'objet sp�cifi� est un ObjetZork,et verifie si
	 *  les caracteristique des objets compar� son equivalante
	 *
	 * @param  o  L'objet a comparer avec cet objet.
	 * @return    true si et seulement si l'objet sp�cifi� est un ObjetZork
	 *      poss�dant les memes propri�t�s ; false sinon
	 *
	 * @pure
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ObjetZork)) {
			return false;
		}

		ObjetZork oz = (ObjetZork) o;
		return(this.getPoids()==oz.getPoids() && this.descriptionCourte()==oz.descriptionCourte()
				&& this.getNom()==oz.getNom() && this.getEstTransportable()==oz.getEstTransportable());
		
	}

	/**
	 *  Renvoie un code de hashage pour cette instance.
	 *
	 * @return    un code de hashage pour cette instance.
	 *
	 * @pure
	 */
	@Override
	public int hashCode() {
		
		return description.hashCode() + 31 * (poids + 1);
	}
	public String getNom() {
		return nom;
	}

	/**
	 *  Renvoie une repr�sentation rudimentaire de cette instance
	 * sous forme d'une cha�ne de caract�res.
	 *
	 * @return    une repr�sentation rudimentaire de cette instance
	 * sous forme d'une cha�ne de caract�res.
	 *
	 * @pure
	 */
	@Override
	public String toString() {
		return description + ":poids=" + poids ;
	}
}