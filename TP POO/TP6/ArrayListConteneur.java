



public   class ArrayListConteneur implements Conteneur {



private ArrayList<ObjetZork> Cobj;






public ArrayListConteneur(){

  Cobj=new ArrayList<ObjetZork>();

}




/**
*@param c une variable de type conteneur
*@requires !=null;
*throws NullPointerException si c==null
*/
public ArrayListConteneur(Conteneur c){
  Cobj=new ArrayList<ObjetZork>();
  for(int i=0 ;c.getNbObjets();i++){
    Cobj.ajouter(c.getObjet(i));
  }
}







public ObjetZork getObjet(int i){
  return Cobj.get(i);
}

public boolean ajoutEstPossible(ObjetZork oz){
  if(oz!=null){
    return true;
  }
  else{
    return false;
  }
}
/**
*@requires on!=null
*@throws NullPointerException si oz==null
*/
public boolean  ajouter(ObjetZork oz){
  if(ajoutEstPossible(oz)==false){
    return false;

  }
  Cobj.add(oz);
  return true;
}


public boolean retirer(Object obj){
  return(Cobj.remove(obj));
}
public int getNbObjets(){
  return Cobj.size();
}
public int getNbObjetsReccurent(Object obj){
  int c;
  for(ObjetZork oz : Cobj){
    if(oz.equals(obj)==true){
      c++;
    }
  }
  return c;
}




public Conteneur getObjets(){
  return new ArrayListConteneur(this);
}

public boolean contient(Object obj){

  return Cobj.contains(obj);
}








}
