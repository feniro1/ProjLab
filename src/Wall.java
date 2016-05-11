
import java.util.*;

public class Wall extends MapElement {

    public String symbol(){
        return "X";
    }

    @Override
    public Drawable getDrawableClass() {
        return new WallGraphic(this);
    }

    //ha falnak utkozik a golyo akkor igaz
    public boolean hit(Bullet bullet) {
        return true;
    }

}