
import java.util.*;


public class Door extends MapElement {

    private boolean isOpen; // az ajtó állapotát tárolja

    public Door() { // konstruktor, melyben zártra állítjuk az ajtót
        isOpen = false;
        System.out.print("Ajtó létrehozása sikeres.");
    }

    public boolean getIfItsOpened() { //getter, mely visszaadja az ajtó állapotát
        System.out.print("Az ajtó állapotával sikerült visszatérni");
        return isOpen;
    }

    public void open() { //kinyitja az ajtót (az isOpen paramétert igazra állatja)
        isOpen = true;
        System.out.print("Az ajtó kinyílt.");
    }

    public void close() { //bezárja az ajtót (az isOpen paramétert hamisra állatja)
        isOpen = false;
        System.out.println("Az ajtó bezárult.");
    }


    @Override
    public boolean stepOn(Colonel colonel) { // visszaadja, hogy odaléphet-e az ezredes az ajtó állapotától függően
        if (isOpen) {
            System.out.println("Az ajtó nyitva van.");
            return true;
            }
        System.out.println("Az ajtó zárva van.");
        return false;
    }

}