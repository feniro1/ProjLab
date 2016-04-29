import java.util.*;

/**
 * Created by dmt on 24/04/16.
 */
public class Replicator {
    private Direction lookDirection;
    private MapElement baseElement;
    private boolean isAlive; //killhez
    private boolean isRandom; // nemtom h ide kell-e, yolo

    public Replicator(){
        lookDirection = Direction.Up;
        isAlive = true;
        isRandom = true;
    }

    public Replicator(MapElement _baseElement){
        lookDirection = Direction.Up;
        baseElement = _baseElement;
        isAlive = true;
        isRandom = true;
    }

    // ha a replicator rift palyaelemre lep, akkor a rift-bol ground palyaelem lesz
    public void killedByRift() {
        isAlive = false;
        Rift r = (Rift)baseElement.getNextElement(lookDirection);
        r.replaceWithGround();
    }

    //akkor hivodik, ha egy golyo eltalalta a replicatort
    public void killedByBullet() {
        isAlive = false;
    }

    public void setBaseElement(MapElement me) { baseElement = me; }

    //visszaadja az iranyt, amerre a replikator nez
    public Direction getLookDirection(){
        return lookDirection;
    }

    public void setLookDirection(Direction dir) { lookDirection = dir; }

    public String symbol(){
        return "@";
    }


    //seged fuggveny, kod duplikalas elkerulese vegett. move-ban hasznaljuk arra, hogy a lepes mechanizmusa megvalosuljon
    public void moveHelper(Direction dir) {
        MapElement nextElement = baseElement.getNextElement(dir);
        if (nextElement.stepOn(this)) { //ha a kovetkezo elemre ra lehet lepni
            if (nextElement.isSpecWall) {
                SpecialWall sw = (SpecialWall) nextElement;
                nextElement = sw.walkthroughWormHole(this);
                if (nextElement.stepOn(this)) {
                    stepOff(nextElement); // akkor lepjen le a jelenlegi elemrol
                }
            } else {
                stepOff(nextElement); // akkor lepjen le a jelenlegi elemrol
            }
        }
    }

    //A replicator mozgatasa a parameterben kapott irany szerint
    public void move(Direction dir) { // ejsze randomnal nem kell direction, benne is megadhatjuk
        setLookDirection(dir); // a kapott haladasi irany alapjan valtoztatja meg az ezredes iranyat

        //generalunk egy random szamot 0-3 kozott, es szam szerinti iranyba mozditjuk a replikatort
        if (isRandom) {
            Random rand = new Random();
            int n = rand.nextInt(4);
            Direction d = Direction.Up; // ebbol lehet bajok lesznek
            switch (n) {
                case 0:
                    d = Direction.Up;
                    break;
                case 1:
                    d = Direction.Right;
                    break;
                case 2:
                    d = Direction.Down;
                    break;
                case 3:
                    d = Direction.Left;
                    break;
            }
            moveHelper(d);

        } else {
            moveHelper(dir);
        }
    }

    //A kovetekezo elemnek odaadja a sajat referenciajat, ezzel ralepteti es a mostanirol leveszi. Ezzel hajtodik vegre a lepes
    public void stepOff(MapElement me) {
        if(me.isSpecWall) {
            SpecialWall sw = (SpecialWall)me;
            MapElement targetME = sw.walkthroughWormHole(this);
            if(targetME.stepOn(this)){
                stepOff(targetME);
            }
        } else {
            me.setReplicator(this);
            baseElement.setReplicator(null);
            baseElement = me;
        }
    }

    public void randomizeOff(){
        isRandom = false;
    }

    //visszaadja a palyaelemet, amin epp tartozkodik
    public MapElement getBaseElement() {
        return baseElement;
    }

}
