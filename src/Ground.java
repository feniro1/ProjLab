
import java.util.*;


public class Ground extends MapElement {

    private Box box = null; // alapertelmezetten nincs a talajon doboz
    private ZPM zpm = null; // alapertelmezetten nincs a talajon ZPM modul

    // konstruktor a talaj objektumhoz
    public  Ground() {
    }

    // parameteres konstruktor, mely beallít egy boxot
    public Ground(Box box) {
        this.box = box;
    }

    // parameteres konstruktor, mely beallít egy zpm modult
    public Ground(ZPM zpm) {
        this.zpm = zpm;
    }

    // visszaadja, hogy a talajon van-e zpm
    public boolean hasZPM() {
        if (zpm != null) {
            return true;
        }
        return false;
    }

    // visszaadja, hogy a talajon van-e doboz
    public boolean hasBox() {
        if (box != null) {
            return true;
        }
        return false;
    }

    // null-ra allitja a zpm parametert
    public void removeZPM() {
        zpm = null;
    }

    // null-ra allitja a doboz parametert
    public void removeBox() {
        box = null;
    }

    // atallitja a doboz parametert
    public void createBox() {
        //this.box = box;
        // TODO
    }

    // visszaadja, hogy az ezredes ralephet-e a talaj objektumra
    public boolean stepOn(Player Player) {
        if (!hasBox()) {
            return true;
            // TODO: itt kezeljuk le a zpm felvetelt? v mivan?
        }
        return false;

    }

    // visszaad egy doboz objektumot, ha van neki
    public Box pickUp() {
        if (hasBox()) {
            Box tmp = box;
            removeBox();
            return tmp;
        }
        return null;
    }

    // visszaadja, hogy tehet le dobozt az ezredes es ha igen leteszi azt, es visszaad egy booleant, hogy sikerult-e
    public boolean putDown(Box b) {
        if (hasBox()) {
            return false;
        } else {
            box = b;
            return true;
        }
    }

}