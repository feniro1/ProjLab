
import java.util.*;

public class Bullet {

    public Direction lookDirection;
    public Color color;
    public MapElement baseElement;

    public Bullet(Direction dir, MapElement mapElement, Color col) {
        lookDirection = dir;
        baseElement = mapElement;
        color = col;
        System.out.println("Létrejön egy lövedék objektum.");
    }


    public void move() {
        System.out.println("A lövedék mozgott egyet.");
        boolean free = true;
        while (free) {
            free = baseElement.getNextElement(lookDirection).hit(this);
        }
    }

}