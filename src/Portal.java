
import java.util.*;


public class Portal {

    private Color color;
    private Direction dir;
    private SpecialWall specwall;

    public Portal() {
        System.out.println("Létrejön egy csillagkapu.");
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