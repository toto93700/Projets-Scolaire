/**

* permet de lancer le jeux
*/
public class Jeu {

  public static void main(String[] args) {
    Carte c = new Carte(Rang.VALET,Famille.PIQUE);
    c.retourner(c);
    Jeu j = new Jeu();
    j.afficher(c);
  }


public void afficher(Carte c) {

  System.out.println(c.getRang()+"de"+c.getFamille());

}

}
