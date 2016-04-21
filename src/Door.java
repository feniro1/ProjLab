
import java.util.*;


public class Door extends MapElement {

    private boolean isOpen; // az ajtó állapotát tárolja

    public Door() { // konstruktor, melyben zártra állítjuk az ajtót
        isOpen = false;
        System.out.print("Ajto letrehozasa sikeres.");
    }

    public void open() { //kinyitja az ajtót (az isOpen paramétert igazra állatja)
        isOpen = true;
        System.out.print("Az ajto kinyilt.");
    }

    public void close() { //bezárja az ajtót (az isOpen paramétert hamisra állatja)
        isOpen = false;
        System.out.println("Az ajtó bezárult.");
    }


    @Override
    public boolean stepOn(Player player) { // visszaadja, hogy odaléphet-e az ezredes az ajtó állapotától függően
        if (isOpen) {
            System.out.println("Az ajto nyitva van.");
            return true;
            }
        System.out.println("Az ajto zarva van.");
        return false;
    }

}