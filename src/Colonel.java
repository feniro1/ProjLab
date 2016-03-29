
import java.util.*;

/**
 * 
 */
public class Colonel {

    public Colonel() {
    }

    private Direction lookDirection;

    private Box box;

    private int ZPMNumber;

    private MapElement baseElement;

    private boolean isAlive;


    public Direction getLookDirection(){
        return lookDirection;
    }

    public void setLookDirection(Direction dir){
        lookDirection = dir;
    }



    public Colonel(MapElement _baseElement){
        lookDirection = Direction.valueOf("Up");
        baseElement = _baseElement;
        ZPMNumber = 0;
        box = null;
        isAlive = true;
    }


    /**
     * @param dir - elmozdulas iranya
     */
    public void move(Direction dir) {
        changeLookDirection(dir); // a kapott haladasi irany alapjan valtoztatja meg az ezredes iranyat
        MapElement nextElement = baseElement.getNextElement(dir); //lekeri az iranynak megfelelo kovetkezo elemet

        if(nextElement.stepOn(this))//ha a kovetkezo elemre ra lehet lepni
            stepOff(nextElement); // akkor lepjen le a jelenlegi elemrol
            System.out.println("Az ezredes sikeresen ralepett a kivant mezore");
    }

    /**
     * @param color
     */
    public void shoot(Color color) {
        System.out.println("Meghivodott az ezredes shoot fuggvenye");
        Bullet b = new Bullet();
        System.out.println("Letrejott egy golyo");
        b.move();

    }

    /**
     * 
     */
    public void kill() {
        isAlive = false;
        System.out.println("Meghivodott az ezredes kill fuggvenye");
    }

    /**
     * 
     */
    public void pickUp() {
        System.out.println("Meghivodott az ezredes pickUp fuggvenye");
        MapElement nextElement = baseElement.getNextElement(lookDirection);//lekeri az iranynak megfelelo kovetkezo elemet
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
        System.out.println("Meghivodott az ezredes putDown fuggvenye");
        MapElement nextElement = baseElement.getNextElement(lookDirection);//lekeri az iranynak megfelelo kovetkezo elemet
        if(box != null) {
            System.out.println("Az ezredesnel van doboz");
            if (nextElement.putDown(box)) { //ha a kovetkezo elemre leteheto a doboz,
                removeBox();                //akkor leteszi.
                System.out.println("A doboz le lett teve");
            }
        } else {
            System.out.println("Az ezredesnel nincs doboz");
        }
    }

    /**
     * 
     */
    public void incZPMNumber() {
        ZPMNumber++;
        System.out.println("Nott a ZPM szam");
    }

    /**
     * @param dir
     */
    public void changeLookDirection(Direction dir) {
        lookDirection = dir;
        System.out.println("Meghivodott az ezredes changeLookDircetion fuggvenye");
    }

    /**
     * Ez a fuggveny csak a teszteleshez kell, hogy egyertelmu legyen
     */
    public void createBox(Box b) {
        box = b;
        System.out.println("Az ezredesnel van doboz");
    }

    /**
     *
     */
    public void removeBox() {
        box = null;
        System.out.println("A doboz le lett teve");
    }

    /**
     * @param me
     */
    public void stepOff(MapElement me) {
        me.setColonel(this);
        baseElement.setColonel(null);
        baseElement = me;
        System.out.println("Meghivodott az ezredes stepOff fuggvenye");
    }

}