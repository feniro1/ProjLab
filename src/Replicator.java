import java.util.*;

/**
 * Created by dmt on 24/04/16.
 */
public class Replicator {
    private Direction lookDirection;
    private MapElement baseElement;
    private boolean isAlive; //killhez

    public Replicator(){
        lookDirection = Direction.Up;
        isAlive = true;
    }

    public Replicator(MapElement _baseElement){
        lookDirection = Direction.Up;
        baseElement = _baseElement;
        isAlive = true;
    }

    public void kill() { isAlive = false; }

    //A replicator mozgatasa a parameterben kapott irany szerint
    public void move(Direction dir) {
        //setLookDirection(dir); // a kapott haladasi irany alapjan valtoztatja meg az ezredes iranyat
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
