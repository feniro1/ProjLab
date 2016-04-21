
import java.util.*;


public class Scale extends MapElement {

    private Box box;
    private Door door;
    protected boolean isScale = true;

    //Konstruktor. Alapértelmezettben nincs rajta doboz.
    public Scale() {
        this.box = null;
        System.out.println("Sikerult letrehozni egy merleg objektumot.");
    }

    //Ha van doboza, akkor igazzal tér vissza, ha nincs hamissal
    public boolean hasBox() {
        if (box != null) {
            System.out.println("A merlegen van doboz.");
            return true;
        }
        System.out.println("A merlegen nincs doboz.");
        return false;
    }

    //Beállítható, a mérleghez tartozó ajtót.
    public void setDoor(Door d) {
        System.out.println("A merlegnek az ajtoeleres be lett allitva.");
        door = d;
    }

    //Eltávolítja a dobozt a mérlegről
    public void removeBox() {
        box = null;
        System.out.println("A merlegen nincs tobbe doboz.");
    }

    //Ezzel állítható be a mérlegnek doboz
    public void createBox(Box box) {
        this.box = box;
        System.out.println("A merlegre rakerult egy doboz");
    }

    //A Player alapértelmezett esetben ráléphet a mérlegre, de ha van rajta doboz, akkor nem
    public boolean stepOn(Player Player) {
        if (hasBox()) {
            System.out.println("Az ezredes nem lephet ra a merlegre, mert azon van doboz.");
            return false;
        }
        System.out.println("Az ezredes ralephet a merlegre.");
        return true;
    }

    //Felvehető a mérlegen lévő doboz, ha van rajta.
    public Box pickUp() {
        if (hasBox()) {
            System.out.println("Sikerült felvenni a dobozt a mérlegről.");
            return box;
        }
        System.out.println("A mérlegen nem volt doboz, így nem volt mit felvenni a mérlegről.");
        return null;
    }

    //Letehető a mérlegre doboz, ha nincsen rajta.
    public boolean putDown(Box box) {
        if(!hasBox()) {
            this.box = box;
            System.out.println("Sikerült új doboz elemet letenni a mérlegre.");
            return true;
        } else {
            System.out.println("A mérlegen már van doboz, így nem sikerült új doboz elemet letenni rá.");
            return false;
        }
    }

}