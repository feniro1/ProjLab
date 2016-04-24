
import java.util.*;

/**
 * Az ezredes osztaly
 */
public class Player {

    private Direction lookDirection;
    private Box box;
    private int ZPMNumber;
    private MapElement baseElement;
    private boolean isAlive;
    private boolean hasToPlaceDownZPM;
    private int weight;

    //Az ezredes inicializalasa, attributumainak alapertelmezett ertekekre allitasa
    public Player() {
        lookDirection = Direction.Up;
        ZPMNumber = 0;
        box = null;
        isAlive = true;
    }

    public Player(MapElement _baseElement){
        lookDirection = Direction.Up;
        baseElement = _baseElement;
        ZPMNumber = 0;
        box = null;
        isAlive = true;
    }

    //Visszater azzal az irannyal, ahova az ezredes nez
    public Direction getLookDirection(){
        return lookDirection;
    }

    public int getWeight(){
        return weight;
    }

    //Beallitja az ezredes nezopontjat
    public void setLookDirection(Direction dir){
        lookDirection = dir;
    }

    //Az ezredes mozgatasa a parameterben kapott irany szerint
    public void move(Direction dir) {
        setLookDirection(dir); // a kapott haladasi irany alapjan valtoztatja meg az ezredes iranyat
        MapElement nextElement = baseElement.getNextElement(dir); //lekeri az iranynak megfelelo kovetkezo elemet

        if(nextElement.stepOn(this)) { //ha a kovetkezo elemre ra lehet lepni
            if (nextElement.getClass() == SpecialWall.class){
                SpecialWall sw = (SpecialWall)nextElement;
                nextElement = sw.walkthroughWormHole(this);
                if (nextElement.stepOn(this)) {
                    stepOff(nextElement); // akkor lepjen le a jelenlegi elemrol
                }
            }
            else {
                stepOff(nextElement); // akkor lepjen le a jelenlegi elemrol
            }

        }
    }

    //Loves az adott szinu golyoval
    public void shoot(Color color) {

        Bullet b = new Bullet(lookDirection, baseElement, color);

        b.move();

    }

    //Az ezredes ongyilkossaga
    public void kill() {
        isAlive = false;
    }

    //Doboz felvetele
    public void pickUp() {
        MapElement nextElement = baseElement.getNextElement(lookDirection);//lekeri az iranynak megfelelo kovetkezo elemet
        if (box == null) {
            box = nextElement.pickUp();
        }
    }


    public void turn() {
        // TODO implement here
    }


    //Doboz letevese
    public void putDown() {
        if(box != null) { //Ha van nala doboz
            MapElement nextElement = baseElement.getNextElement(lookDirection);//lekeri az iranynak megfelelo kovetkezo elemet
            if (nextElement.putDown(box)) { //ha a kovetkezo elemre leteheto a doboz,
                removeBox();                //akkor leteszi.
            }
        }
    }


    //ZPM szam novelese
    public void incZPMNumber() {
        ZPMNumber++;
    }


    //Csak a tesztesetek latvanyos feltuntetese celjabol
    public void createBox(Box b) {
        box = b;
    }

    //Doboz referenciajanak torlese
    public void removeBox() {
        box = null;
    }


    //A kovetekezo elemnek odaadja a sajat referenciajat, ezzel ralepteti es a mostanirol leveszi. Ezzel hajtodik vegre a lepes
    public void stepOff(MapElement me) {
        if(baseElement.isScale){
            Scale sc = (Scale)baseElement;
            sc.getDoor().close();
        }

        if(me.isSpecWall) {
            SpecialWall sw = (SpecialWall)me;
            MapElement targetME = sw.walkthroughWormHole(this);
            if(targetME.stepOn(this)){
                stepOff(targetME);
            }
        } else {
            me.setPlayer(this);
            baseElement.setPlayer(null);
            baseElement = me;
        }

    }

    public void setBaseElement(MapElement me) {
        baseElement = me;
    }

}