
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

    public String symbol(){
        if(hasBox()) {
            return "B";
        } else if(hasZPM()){
            return "Z";
        } else if(col != null){
            return "O";
        } else if(rep != null){
            return "@";
        } else {
            return " ";
        }
    }

    // null-ra allitja a zpm parametert
    public void removeZPM() {
        zpm = null;
    }

    // null-ra allitja a doboz parametert
    public void removeBox() {
        box = null;
    }


    // visszaadja, hogy az ezredes ralephet-e a talaj objektumra
    public boolean stepOn(Player player) {
        if (!hasBox()) {
            if (hasZPM()) {
                player.incZPMNumber();
                removeZPM();
            }
            return true;
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