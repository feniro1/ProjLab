
import java.util.*;


public class Ground extends MapElement {

    private Box box = null; // alapértelmezetten nincs a talajon doboz
    private ZPM zpm = null; // alapértelmezetten nincs a talajon ZPM modul


    public  Ground() {
        System.out.println("A talaj objektum létrehozása sikeresen megtörtént.");
    } // konstruktor a talaj objektumhoz

    public Ground(Box box, ZPM zpm) { // paraméteres konstruktor, mely beállít egy zpm modult és egy boxot
        this.box = box;
        this.zpm = zpm;
        System.out.println("A talaj objektum létrehozása sikeresen megtörtént.");
    }

    public boolean hasZPM() { // visszaadja, hogy a talajon van-e zpm
        if (zpm != null) {
            System.out.println("A talajon van ZPM.");
            return true;
        }
        System.out.println("A talajon nincs ZPM.");
        return false;
    }

    public boolean hasBox() { // visszaadja, hogy a talajon van-e doboz
        if (box != null) {
            System.out.println("A talajon van doboz.");
            return true;
        }
        System.out.println("A talajon nincs doboz.");
        return false;
    }

    public void removeZPM() { // null-ra állítja a zpm paramétert
        zpm = null;
        System.out.println("A talaj objektumon nincs többé ZPM.");
    }

    public void removeBox() { // null-ra állítja a zpm paramétert
        box = null;
        System.out.println("A talaj objektumon nincs többé doboz.");
    }

    public void createBox() { // null-ra állítja a doboz paramétert
        this.box = box;
        System.out.println("A talajra rákerült egy doboz");

    }

    public boolean stepOn(Colonel colonel) { //visszaadja, hogy az ezredes ráléphet-e a doboz 
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
        return null;
    }

    public boolean putDown(Box b) {
        if (hasBox()) {
            System.out.println("A talajon már van doboz, így nem teheted le.");
            return false;
        } else {
            box = b;
            System.out.println("Leteheted a dobozt.");
            return true;
        }
    }

}