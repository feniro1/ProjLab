
import java.util.*;

/**
 * 
 */
public abstract class MapElement {


    public MapElement() {

    }

    public MapElement[] neighbours;


    public Colonel col;


    public Bullet bul;



    public void draw() {
        // TODO implement here
    }

    /**
     * @param colonel 
     * @return
     */
    public boolean stepOn(Colonel colonel) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Box pickUp() {
        // TODO implement here
        return null;
    }

    /**
     * @param b 
     * @return
     */
    public boolean putDown(Box b) {
        // TODO implement here
        return false;
    }

    /**
     * @param bullet 
     * @return
     */
    public boolean hit(Bullet bullet) {
        System.out.println("Meg lett hívva a hit függvény");
        // TODO implement here
        return false;
    }

    /**
     * @param dir 
     * @return
     */
    public MapElement getNextElement(Direction dir) {
        return neighbours[dir.getValue()];
    }

}