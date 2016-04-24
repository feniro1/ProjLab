
import java.util.*;


public class Door extends MapElement {

    // az ajto allapotat tarolja
    private boolean isOpen;

    // konstruktor, melyben zartra allitjuk az ajtot
    public Door() {
        isOpen = false;
    }

    // kinyitja az ajtot (az isOpen parametert igazra allitja)
    public void open() {
        isOpen = true;
    }

    // bezarja az ajtot (az isOpen parametert hamisra allitja)
    public void close() {
        isOpen = false;
    }

    public String symbol(){
        if(isOpen){
            return ".";
        } else {
            return "!";
        }
    }

    // visszaadja, hogy odalephet-e az ezredes az ajto allapotatol fuggoen
    @Override
    public boolean stepOn(Player player) {
        if (isOpen) {
            return true;
            }
        return false;
    }

}