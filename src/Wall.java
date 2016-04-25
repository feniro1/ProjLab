
import java.util.*;

public class Wall extends MapElement {

    //Ideiglenes, csak a kiírás miatt van felüldefiniálva
    @Override
    public boolean stepOn(Player colonel) {
        return super.stepOn(colonel);
    }

    public String symbol(){
        return "X";
    }

    //ha falnak utkozik a golyo akkor igaz
    public boolean hit(Bullet bullet) {
        return true;
    }

}