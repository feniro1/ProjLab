
import java.util.*;


public class Ground extends MapElement {

    private Box box = null; // alapértelmezetten nincs a talajon doboz
    private ZPM zpm = null; // alapértelmezetten nincs a talajon ZPM modul


    public  Ground() {
        System.out.println("A talaj objektum letrehozasa sikeresen megtortent.");
    } // konstruktor a talaj objektumhoz

    public Ground(Box box, ZPM zpm) { // paraméteres konstruktor, mely beállít egy zpm modult és egy boxot
        this.box = box;
        this.zpm = zpm;
        System.out.println("A talaj objektum letrehozasa sikeresen megtortent.");
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
        System.out.println("A talaj objektumon nincs tobbe ZPM.");
    }

    public void removeBox() { // null-ra állítja a doboz paramétert
        box = null;
        System.out.println("A talaj objektumon nincs tobbe doboz.");
    }

    public void createBox() { // átállítja a doboz paramétert
        this.box = box;
        System.out.println("A talajra rakerult egy doboz");

    }

    public boolean stepOn(Player Player) { //visszaadja, hogy az ezredes ráléphet-e a talaj objektumra
        if (!hasBox()) {
            System.out.println("A talajon nincs doboz, igy az ezredes ralephet.");
            return true;
        }

        System.out.println("A talajon van doboz.");
        return false;

    }

    public Box pickUp() { // visszaad egy doboz objektumot, ha van neki
        if (hasBox()) {
            Box tmp = box;
            removeBox();
            System.out.println("Az ezredes a dobozt sikeresen felvette.");
            return tmp;
        }
        System.out.println("Nincs mit felvegyel, mivel nincs elotted doboz");
        return null;
    }

    public boolean putDown(Box b) { // visszaadja, hogy tehet le dobozt az ezredes és ha igen leteszi azt, és visszaad egy booleant, hogy sikerült-e
        if (hasBox()) {
            System.out.println("A talajon mar van doboz, igy nem teheted le.");
            return false;
        } else {
            box = b;
            System.out.println("Leteheted a dobozt.");
            return true;
        }
    }

}