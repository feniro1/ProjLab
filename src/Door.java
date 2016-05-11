
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

    // visszaadja, hogy odalephet-e az ezredes az ajto allapotatol fuggoen
    public boolean stepOn(Player player) {
        if (isOpen) {
            return true;
        }
        return false;
    }

    // ha az ajto nyitva van es a golyo utkozik akkor true, ha az ajto zart akkor false
    public boolean hit(Player player) {
        if (isOpen) {
            return false;
        }
        return true;
    }

    public String symbol(){
        if(isOpen){
            if(player != null)
                return "O";
            else
                return ".";
        } else {
            return "!";
        }
    }

    @Override
    public Drawable getDrawableClass() {
        return new DoorGraphic(this);
    }

}