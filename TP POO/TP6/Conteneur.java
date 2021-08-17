






public interface Conteneur{


public boolean ajoutEstPossible(Object oz); //ObjetZork


/**
*@requires ajoutEstPossible(oz);
*@ensures contient(oz);
*/
public void ajouter(Object oz);     /// ObjetZork
public boolean retirer(Object obj);
public int getNbObjets();
public int getNbObjetsReccurent();
public Conteneur getObjets();
public boolean contient(Object obj);




}


/*

public interface Conteneur<E> extends Iterable<E>{


public boolean ajoutEstPossible(E oz);


/**
*@requires ajoutEstPossible(oz);
*@ensures contient(oz);

public void ajouter(E oz);
public boolean retirer(Object obj);
public int getNbObjets();
public int getNbObjetsReccurent();
public Conteneur<E> getObjets();
public boolean contient(Object obj);




}
*/
