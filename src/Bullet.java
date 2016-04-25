
import java.util.*;

public class Bullet {

    public Direction lookDirection;
    public Color color;
    public MapElement baseElement;

    //Konstruktor. A töltény irányát színét és a kilövés pillanatában hozzá tartozó
    // saját pozícióját kell átadni.
    public Bullet(Direction dir, MapElement mapElement, Color col) {
        lookDirection = dir;
        baseElement = mapElement;
        color = col;
    }

    //Addig megy a töltény, amíg tud, tehát amíg true-t kap a következő elemtől.
    // A következő elemet a bullet iránya alapján tudjuk lekérni a getNextElement segítségével.
    // A bullet próbálja eltalálni a következő elemet és addig megy amíg valamit nem talál el.
    public void move() {
        boolean free = true;
        MapElement nextMe = baseElement.getNextElement(lookDirection);
        free = !nextMe.hit(this);
        while (free) {
            nextMe.setBullet(this);
            baseElement.setBullet(null);
            baseElement = nextMe;
            nextMe = baseElement.getNextElement(lookDirection);
            free = !nextMe.hit(this);
        }
    }

}