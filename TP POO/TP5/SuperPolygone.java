import java.awt.Point;


public class SuperPolygone {

private List<Point> lp;
private Point coinSupGauche;

public SuperPolygone(List<Point> lps){

  this.lp = lps.clone();
  this.coinSupGauche=lp.get(0);

}




  public Point getPoints(int x){
    return lp.get(x);
  }


  public int getNbrPoints(){
        return lp.size();
  }

  public Point getCoinSupGauche(){
    return coinSupGauche;
  }

  public int getLongueurCote(int x){
    return lp.get(x-1).distanceTO(lp.get(x));
  }
}
