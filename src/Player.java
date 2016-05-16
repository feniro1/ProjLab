
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
    private String name;

    //Az ezredes inicializalasa, attributumainak alapertelmezett ertekekre allitasa
    public Player(String n) {
        lookDirection = Direction.Up;
        ZPMNumber = 0;
        box = null;
        isAlive = true;
        name = n;
        weight = 2;
    }

    public Player(MapElement _baseElement, String n){
        lookDirection = Direction.Up;
        baseElement = _baseElement;
        ZPMNumber = 0;
        box = null;
        isAlive = true;
        name = n;
        weight = 2;
    }

    //MARK: getters
    //Visszater a jatekos sulyaval
    public int getWeight(){ return weight; }

    public boolean ItsAlive() {
        return isAlive;
    }

    //visszater a jatekos nevevel
    public String getName() {
        return name;
    }

    //visszater a jatekos ZPM szamaval
    public int getZPMNumber () {
        return ZPMNumber;
    }

    //visszater azzal a palyaelemmel, amin a jatekos epp tartozkodik
    public MapElement getBaseElement() {
        return baseElement;
    }

    //Visszater azzal az irannyal, ahova az ezredes nez
    public Direction getLookDirection(){
        return lookDirection;
    }

    public boolean hasBox(){
        if(box == null)
            return false;
        else return true;
    }

    //MARK: setters
    //Beallitja az ezredes nezopontjat
    public void setLookDirection(Direction dir){
        lookDirection = dir;
    }

    //beallitja hogy melyik mapElementen all a player
    public void setBaseElement(MapElement me) {
        baseElement = me;
    }

    //Csak a tesztesetek latvanyos feltuntetese celjabol
    public void setBox(Box b) {
        box = b;
    }

    //MARK: methods
    //Doboz referenciajanak torlese
    public void removeBox() {
        box = null;
    }

    //Az ezredes mozgatasa a parameterben kapott irany szerint
    public void move(Direction dir) {
        setLookDirection(dir); // a kapott haladasi irany alapjan valtoztatja meg az ezredes iranyat
        MapElement nextElement = baseElement.getNextElement(dir); //lekeri az iranynak megfelelo kovetkezo elemet

        if(nextElement.stepOn(this)) { //ha a kovetkezo elemre ra lehet lepni
            if (nextElement.getClass() == SpecialWall.class){ // ha a kovetkezo elem specialis fal
                SpecialWall sw = (SpecialWall)nextElement; //atkasztolas, hogy hasznalhassuk a SpacialWall osztaly tagvaltozoit
                nextElement = sw.walkthroughWormHole(this);// visszakerjuk az elemet, amire feregjaraton valo athaladaskor lepunk
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
        switch(lookDirection){
            case Up: setLookDirection(Direction.Left);
                break;
            case Right:setLookDirection(Direction.Up);
                break;
            case Down:setLookDirection(Direction.Right);
                break;
            case Left:setLookDirection(Direction.Down);
                break;
        }
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

    //Visszater azzal a szimbolummal, ami a jatekoshoz tartozik. palya fajlbairasanal hasznaljuk
    public String symbol(){
        return "O";
    }


    public boolean isAlive() {
        return isAlive;
    }
}