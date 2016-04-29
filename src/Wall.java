
import java.util.*;

public class Wall extends MapElement {

    public String symbol(){
        return "X";
    }

    //ha falnak utkozik a golyo akkor igaz
    public boolean hit(Bullet bullet) {
        return true;
    }

}