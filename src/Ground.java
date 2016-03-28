
import java.util.*;

/**
 * 
 */
public class Ground extends MapElement {

    /**
     * Default constructor
     */
    public Ground() {
    }

    public Box box;
    public ZPM zpm;


    public void removeZPM() {
        zpm = null;
    }

    public void removeBox() {
        box = null;
    }

    public void createBox() {
        box = new Box();
        System.out.print("");
    }

    /**
     * @param colonel 
     * @return
     */

    public boolean stepOn(Colonel colonel) {
        if (box!)
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

}