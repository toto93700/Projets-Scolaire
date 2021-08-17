public class Carte{

  private Rang monRang;
  private Famille maFamille;
  private boolean estVisible;
  private Couleur maCouleur;

  /**
  * Carte initliatlise une carte avec un Rang et une Famille
  */
  public Carte(Rang r,Famille f) {

    monRang=r;
    maFamille=f;

  }



  public Famille getFamille() {
    return maFamille;
  }
  public Rang getRang(){
    return monRang;
  }
  public boolean estVisible(){
    return estVisible;
  }
  public Couleur maCouleur(){
  return maCouleur;
  }
  public void retourner(Carte c){
    c.estVisible=!c.estVisible;
  }
}
