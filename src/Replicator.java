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

    public void kill() { isAlive = false; }

    public void setBaseElement(MapElement me) { baseElement = me; }

    //A replicator mozgatasa a parameterben kapott irany szerint
    public void move(Direction dir) { // ejsze randomnal nem kell direction, benne is megadhatjuk
        //setLookDirection(dir); // a kapott haladasi irany alapjan valtoztatja meg az ezredes iranyat

        switch(isRandom){
            case true:
                Random rand = new Random();
                int n = rand.nextInt(4);
                Direction d;

                switch(n){
                    case 0: d = Direction.Up;
                        break;
                    case 1: d = Direction.Right;
                        break;
                    case 2: d = Direction.Down;
                        break;
                    case 3: d = Direction.Left;
                        break;
                }

                MapElement nextElement = baseElement.getNextElement(d);

                if(nextElement.stepOn(this)) { //ha a kovetkezo elemre ra lehet lepni
                    if (nextElement.getClass() == SpecialWall.class) {
                        SpecialWall sw = (SpecialWall) nextElement;
                        nextElement = sw.walkthroughWormHole(this);
                        if (nextElement.stepOn(this)) {
                            stepOff(nextElement); // akkor lepjen le a jelenlegi elemrol
                        }
                    } else {
                        stepOff(nextElement); // akkor lepjen le a jelenlegi elemrol
                    }
                }

                    break;
        }

//        MapElement nextElement = baseElement.getNextElement(dir); //lekeri az iranynak megfelelo kovetkezo elemet
//
//        if(nextElement.stepOn(this)) { //ha a kovetkezo elemre ra lehet lepni
//            if (nextElement.getClass() == SpecialWall.class){
//                SpecialWall sw = (SpecialWall)nextElement;
//                nextElement = sw.walkthroughWormHole(this);
//                if (nextElement.stepOn(this)) {
//                    stepOff(nextElement); // akkor lepjen le a jelenlegi elemrol
//                }
//            }
//            else {
//                stepOff(nextElement); // akkor lepjen le a jelenlegi elemrol
//            }
//
//        }
    }

    public void stepOff(MapElement me) {
        me.setReplicator(this);
        baseElement.setReplicator(null);
        baseElement = me;
        if(me.isSpecWall) {

        }
        else if(me.isScale){

        }
        else {
            me.setPlayer(this);
            baseElement.setReplicator(null);
            baseElement = me;
        }
    }

}
