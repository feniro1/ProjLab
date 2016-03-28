
import java.util.*;

/**
 * 
 */
public class Door extends MapElement {

    private boolean isOpen;
    // szerintem private kellene legyen ... es max egy getter .. setter nem kell, ugyis belul allitgat mindent a csavo
    public Door() {
        isOpen = false;
        System.out.print("Ajtó létrehozása sikeres");
    }

    public boolean getIfItsOpened() {
        System.out.print("Az ajtó állapotával sikerült visszatérni");
        return isOpen;
    }

    public void open() {
        isOpen = true;
        System.out.print("Az ajtó kinyílt.");
    }

    public void close() {
        isOpen = false;
        System.out.println("Az ajtó bezárult.");
    }

    /**
     * @param colonel 
     * @return
     */

    @Override
    public boolean stepOn(Colonel colonel) { // colonel miert kell parameterbe?
        if (isOpen) {
            System.out.println("Az ajtó nyitva van."); //lehetne olyat is, hogy a lepes megtortent, de az meg nem biztos, mivel nem tole fugg ha jol tudom
            return true;
            }
        System.out.println("Az ajtó zárva van.");
        return false;
    }

}