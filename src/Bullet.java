
import java.util.*;

public class Bullet {

    public Bullet() {
        System.out.println("Létrejön egy lövedék objektum.");
    }

    public Direction lookDirection;
    public Color color;
    public MapElement baseElement;


    public void move() {
        System.out.println("Meghívódott a golyó move függvénye");
        boolean free = true;
        while (free) {
            free = baseElement.getNextElement(lookDirection).hit(this);
        }
    }

}