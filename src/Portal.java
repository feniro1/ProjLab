
import java.util.*;


public class Portal {

    public Color color;
    public Direction dir;
    public SpecialWall specwall;

    public Portal() {

    }


    public void setDirection(Direction dir) {
        this.dir = dir;
    }

    public Direction getDirection() {
        return dir;
    }

    public SpecialWall getSpecWall() {
        return specwall;
    }


    public void setSpecWall(SpecialWall swall) {
        this.specwall = swall;
    }

}