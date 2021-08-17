/**
 *
 */
package examjanvier2018;

import java.util.AbstractCollection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Implémentation directe de l'interface Collection qui représente une
 * collection non ordonnée pouvant contenir des éléments duppliqués. Cette
 * implémentation utilise une LinkedList pour mémoriser les élements de la
 * Collection et garantie qu'aucun de ses éléments ne peut être null.
 *
 * @invariant !contains(null);
 *
 * @param <E>
 *            le type des éléments de cette Collection
 *
 * @author Marc Champesme
 * @since 18 mai 2013
 * @version 30 decembre 2017
 */
public class LinkedListCollection<E> extends AbstractCollection<E> implements Cloneable {
	private LinkedList<E> contenu;

	/**
	 * Constructs an empty LinkedListCollection.
	 *
	 * @ensures this.isEmpty();
	 *
	 */
	public LinkedListCollection() {
		contenu = new LinkedList<E>();
	}

	/**
	 * Constructs a LinkedListCollection containing the elements of the specified
	 * collection.
	 *
	 * @requires c != null;
	 * @requires !c.contains(null);
	 * @ensures this.hasSameContentAs(c);
	 *
	 * @param c
	 *            the collection whose elements are to be placed into this
	 *            LinkedListCollection
	 *
	 * @throws NullPointerException
	 *             if the specified collection is null or contains the null element.
	 */
	public LinkedListCollection(Collection<? extends E> c) {
		if (c.contains(null)) {
			throw new NullPointerException("The specified collection must not contain null");
		}
		contenu = new LinkedList<E>(c);
	}

	/**
	 * Ajoute l'élément non null spécifié à cette LinkedListCollection.
	 *
	 * @requires e != null;
	 * @ensures this.frequency(e) == \old(this.frequency(e) + 1);
	 *
	 * @param e
	 *            l'élément à ajouter à cette LinkedListCollection
	 *
	 * @return true si l'appel à cette méthode a modifié cette LinkedListCollection
	 *
	 * @throws NullPointerException
	 *             si l'élément spécifié est null
	 */
	@Override
	public boolean add(E e) {
		if (e == null) {
			throw new NullPointerException("The element to add must not be null");
		}
		return this.contenu.add(e);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.AbstractCollection#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return contenu.iterator();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return contenu.size();
	}

	/**
	 * Renvoie le nombre d'éléments présents dans cette LinkedListCollection qui
	 * sont equals à l'objet spécifié. Plus formellement, rencoie le nombre
	 * d'éléments e tels que e.equals(o).
	 *
	 * @ensures contains(o) <==> (\result > 0);
	 * @ensures (o == null) ==> (\result == 0);
	 *
	 * @param o
	 *            l'objet dont la fréquence dans cette LinkedListCollection doit
	 *            être déterminée
	 * @pure
	 */
	public int frequencyOf(Object o) {
		return Collections.frequency(this, o);
	}

	/**
	 * Renvoie true si cette LinkedListCollection contient les mêmes éléments que la
	 * collection spécifiée.
	 *
	 * @requires c != null;
	 * @ensures \result <==> ((this.size() == c.size()) && (\forall E e;
	 *          this.contains(e); this.frequencyOf(e) == Collections.frequency(c,
	 *          e)));
	 *
	 * @param c
	 *            la collection qui doit être comparée à cette LinkedListCollection
	 * @throws NullPointerException
	 *             si la collection spécifiée est null.
	 *
	 * @pure
	 */
	public boolean hasSameContentAs(Collection<?> c) {
		if (this.size() != c.size()) {
			return false;
		}
		LinkedList<E> copyOfThis = new LinkedList<E>(this);
		LinkedList<Object> copyOfOther = new LinkedList<Object>(c);
		while (!copyOfThis.isEmpty()) {
			if (!copyOfOther.remove(copyOfThis.removeFirst())) {
				return false;
			}
		}
		return copyOfOther.isEmpty();
	}

	/**
	 * Compare l'objet spécifié avec cette LinkedListCollection. Renvoie true si et
	 * seulement si l'objet spécifié est aussi une LinkedListCollection, que ces
	 * deux LinkedListCollection contiennent le même nombre d'éléments et qu'elle
	 * contienne le même nombre de fois chaque élément.
	 *
	 *
	 * @ensures !(obj instanceof LinkedListCollection<?>) ==> !\result;
	 * @ensures (obj instanceof LinkedListCollection<?>) ==> \result ==
	 *          this.hasSameContentAs((LinkedListCollection<?>) obj);
	 *
	 * @param obj
	 *            l'objet à comparer avec cette LinkedListCollection
	 *
	 * @return true si l'objet spécifié est equal à cette LinkedListCollection
	 *
	 * @pure
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LinkedListCollection<?>)) {
			return false;
		}
		LinkedListCollection<?> bag = (LinkedListCollection<?>) obj;
		return this.hasSameContentAs(bag);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int code = 0;
		for (E elt : this) {
			code += elt.hashCode();
		}
		return code;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.AbstractCollection#toString()
	 */
	@Override
	public String toString() {
		return this.contenu.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#clone()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public LinkedListCollection<E> clone() {
		LinkedListCollection<E> theClone = null;
		try {
			theClone = (LinkedListCollection<E>) super.clone(); // Unchecked cast inevitable
		} catch (CloneNotSupportedException e) {
			throw new InternalError("Erreur interne sur clone");
		}
		theClone.contenu =  new LinkedList<E>(this);
		return theClone;
	}
}
