
import java.util.*;

/**
 * 
 */
public class Colonel {

    /**
     * Default constructor
     */
    public Colonel() {
    }

    /**
     * 
     */
    public Direction lookDirection;

    /**
     * 
     */
    public Box box;

    /**
     * 
     */
    public int ZPMNumber;

    /**
     * 
     */
    public MapElement baseElement;

    /**
     * 
     */
    public boolean isAlive;


    public Colonel(MapElement _baseElement){
        lookDirection = Direction.valueOf("Up");
        baseElement = _baseElement;
        ZPMNumber = 0;
        box = null;
        isAlive = true;
    }


    /**
     * @param dir
     */
    public void move(Direction dir) {
        // TODO implement here
        changeLookDirection(dir);
        MapElement nextElement = baseElement.getNextElement(dir);

        if(nextElement.stepOn(this))
            stepOff(nextElement);
            System.out.println("Az ezredes sikeresen ralepett a kivant mezore");
    }

    /**
     * @param color
     */
    public void shoot(Color color) {
        // TODO implement here
    }

    /**
     * 
     */
    public void kill() {
        // TODO implement here
    }

    /**
     * 
     */
    public void pickUp() {
        // TODO implement here
        System.out.println("Meghivodott az ezredes pickUp fuggvenye");
        MapElement nextElement = baseElement.getNextElement(lookDirection);
        box = nextElement.pickUp();
    }

    /**
     * 
     */
    public void turn() {
        // TODO implement here
    }

    /**
     * 
     */
    public void putDown() {
        // TODO implement here
    }

    /**
     * 
     */
    public void incZPMNumber() {
        // TODO implement here
    }

    /**
     * @param dir
     */
    public void changePos(Direction dir) {
        // TODO implement here
    }

    /**
     * @param dir
     */
    public void changeLookDirection(Direction dir) {
        // TODO implement here
        System.out.println("Meghivodott az ezredes changeLookDircetion fuggvenye");
    }

    /**
     * 
     */
    public void createBox() {
        // TODO implement here
    }

    /**
     * @param me
     */
    public void stepOff(MapElement me) {
        // TODO implement here
        System.out.println("Meghivodott az ezredes stepOff fuggvenye");
    }

}