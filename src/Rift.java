
import java.util.*;


public class Rift extends MapElement {

    public Rift() {

    }


    public boolean stepOn(Player player) {
        player.kill();
        return true;
    }

    // visszaadja, hogy lehet rá tenni, dobozt és ezt a dobozt megsemmisítjük
    public boolean putDown(Box b) {
        // akkor ezt a b-t amit megkapunk gondolom nullra kell allitani
        return true;
    }

}