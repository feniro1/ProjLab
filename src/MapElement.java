
import java.util.*;

/**
 * 
 */
public abstract class MapElement {


    public MapElement[] neighbours;
    public Colonel col;
    public Bullet bul;


    public MapElement() {
        System.out.println("Sikeresen létrehoztál egy MapElement objektumot.");
    }


    public void draw() {

    }


    public boolean stepOn(Colonel colonel) {
        System.out.println("Nem léphetsz rá a MapElementre.");
        return false;
    }


    public Box pickUp() {
        System.out.println("Nincs mit felvenni.");
        return null;
    }


    public boolean putDown(Box b) {
        System.out.println("Nem tudod letenni a dobozt a MapElementre.");
        return false;
    }


    public boolean hit(Bullet bullet) {
        System.out.println("Meg lett hívva a hit függvény.");
        return false;
    }


    public MapElement getNextElement(Direction dir) {
        System.out.println("Le lett kérve a következő elem.");
        return neighbours[dir.getValue()];
    }

}