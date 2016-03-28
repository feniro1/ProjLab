
import java.util.*;

/**
 * 
 */
public class Door extends MapElement {

    private boolean isOpen;

    public Door() {
        isOpen = false;
        System.out.print("Ajtó létrehozása sikeres.");
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


    @Override
    public boolean stepOn(Colonel colonel) {
        if (isOpen) {
            System.out.println("Az ajtó nyitva van.");  
            return true;
            }
        System.out.println("Az ajtó zárva van.");
        return false;
    }

}