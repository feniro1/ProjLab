
import java.util.*;

/**
 * 
 */
public abstract class MapElement {


    public MapElement() {

    }

    public MapElement[] neighbours;


    private Colonel col;


    private Bullet bul;



    public void draw() {
        // TODO implement here
    }


    public boolean stepOn(Colonel colonel) {
        // TODO implement here
        return false;
    }


    public Box pickUp() {
        // TODO implement here
        return null;
    }


    public boolean putDown(Box b) {
        // TODO implement here
        return false;
    }

    public boolean hit(Bullet bullet) {
        System.out.println("Meg lett hívva a hit függvény");
        // TODO implement here
        return false;
    }


    public MapElement getNextElement(Direction dir) {
        System.out.println("Le lett kérve a következő elem");
        return neighbours[dir.getValue()];
    }

    public void setColonel(Colonel colonel){
        col = colonel;
    }

    public  void setBullet (Bullet bullet){
        bul = bullet;
    }

}