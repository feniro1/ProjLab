
import java.util.*;

public class Bullet {

    public Bullet() {

    }

    public Direction lookDirection;
    public Color color;
    public MapElement baseElement;


    public void move() {
        boolean free = true;
        while (free) {
            free = baseElement.neighbours[lookDirection.getValue()].hit(this);
        }
    }

}