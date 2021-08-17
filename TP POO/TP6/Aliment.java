public class Aliment {

private int valeurNut;
private String type;


public Aliment(int valeurNut,String type){

  this.valeurNut=valeurNut;
  this.type=type;


}




public String getType(){
  return type;
}
public int getValeurNut(){

return valeurNut;
}

public boolean equals(object o){

if(!(o instanceof Aliment){
  return false;
}
  Aliment al=(Aliment) o;
  if(valeurNut!=o.getValeurNut()){
    return false;
  }
  return(type.equals(o.getType()));
}
}














}
