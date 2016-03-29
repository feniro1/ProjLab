
import java.util.*;


public class Portal {

    private Color color;
    private Direction dir;
    private SpecialWall specwall;

    public Portal() {
        specwall = null;
        System.out.println("Létrejön egy csillagkapu.");
    }


    public void setDirection(Direction dir) {
        this.dir = dir;
    }

    public Direction getDirection() {
        return this.dir;
    }

    public SpecialWall getSpecWall() {
        return this.specwall;
    }
    
    public void setSpecWall(SpecialWall swall) {
        this.specwall = swall;
    }

    public void setColor(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;
    }
}