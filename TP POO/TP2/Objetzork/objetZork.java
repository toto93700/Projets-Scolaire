public class ObjectZork{

private int poids;
private String decription;
private String nom;
private boolean estTransportable;






public ObjectZork(int i,String n,String d){

  poids=i;
  description="l'objet est de poids:"+poids+" se nomme:"+n+"\n";
  nom=n;

  if(poids>= 50){
    estTransportable=false;
  }
  else {
    estTransportable=true;
  }
}

public int getPoids(){
  return poids;
}
public String getnom(){
  return nom;
}
public boolean transportable(){
  return estTransportable;
}
public String getDescription(){
    return description;
}




































}
