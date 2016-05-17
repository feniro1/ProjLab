
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

    // visszaadja, hogy az ajto milyen allapotban van
    public boolean itsOpened() {
        if (isOpen) {
            return true;
        }
        return false;
    }

    // visszaadja, hogy all-e valaki az ajtoban
    public boolean hasPlayer() {
        if (player != null) {
            return true;
        }
        return false;
    }

    // visszaadja, hogy van all-e replikator az ajtoban
    public boolean hasReplicator() {
        if (rep != null) {
            return true;
        }
        return false;
    }


    // visszaadja, hogy odalephet-e az ezredes az ajto allapotatol fuggoen
    public boolean stepOn(Player player) {
        if (isOpen) {
            if(!hasPlayer()) {
                return true;
            }
        }
        return false;
    }

    // ha az ajto nyitva van es a golyo utkozik akkor true, ha az ajto zart akkor false
    public boolean hit(Bullet bullet) {
        if (isOpen) {
            if(!hasPlayer()) {
                return false;
            }
        }
        return true;
    }

    // segedfuggveny a grafikus felulet nelkuli tesztek megjelenitesehez
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

    //visszaad egy hozza tartozo graphics objektumot
    @Override
    public Drawable getDrawableClass() {
        return new DoorGraphic(this);
    }

}