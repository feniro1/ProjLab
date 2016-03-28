
import java.util.*;


public class Ground extends MapElement {

    private Box box = null;
    private ZPM zpm = null;


    public  Ground() {

    }

    public Ground(Box box, ZPM zpm) {
        this.box = box;
        this.zpm = zpm;
        System.out.println("A talaj objektum létrehozása sikeresen megtörtént.");
    }

    public boolean hasZPM() {
        if (zpm != null) {
            System.out.println("A talajon van ZPM.");
            return true;
        }
        System.out.println("A talajon nincs ZPM.");
        return false;
    }

    public boolean hasBox() {
        if (box != null) {
            System.out.println("A talajon van doboz.");
            return true;
        }
        System.out.println("A talajon nincs doboz.");
        return false;
    }

    public void removeZPM() {
        zpm = null;
        System.out.println("A talaj objektumon nincs többé ZPM.");
    }

    public void removeBox() {
        box = null;
        System.out.println("A talaj objektumon nincs többé doboz.");
    }

    public void createBox() {
        if(!hasBox()) {
            box = new Box(); // TODO: Refactor
            System.out.println("Sikerült új doboz elemet letenni a talajra.");
        } else {
            System.out.println("A talajon már van doboz, így nem sikerült új doboz elemet letenni rá.");
        }

    }


    public boolean stepOn(Colonel colonel) {
        if (!hasBox()) {
            System.out.println("A talajon nincs doboz, így az ezredes ráléphet.");
            return true;
        }

        System.out.println("A talajon van doboz.");
        return false;

    }

    public Box pickUp() {
        if (hasBox()) {
            Box tmp = box;
            removeBox();
            System.out.println("Az ezredes a dobozt sikeresen felvette.");
            return tmp;
        }
        System.out.println("Nincs mit felvegyél, mivel nincs előtted doboz");
        // valamit kell csavozni itt, mivel csak a neighbournak kell legyen doboza direction szerint stb de neki nem... es csak ha a neighbourje is ground .. yooooooo
        return null;
    }

    public boolean putDown(Box b) {
        // itt is neighbour ... keletibe vagyok, megirom ha SCH
        if (hasBox()) {
            System.out.println("A talajon már van doboz, így nem teheted le.");
            return false;
        }

        box = b;
        System.out.println("Leteheted a dobozt.");
        return true;

    }

}