
import java.util.*;

public class Wall extends MapElement {

    //visszaad egy hozza tartozo graphics objektumot
    @Override
    public Drawable getDrawableClass() {
        return new WallGraphic(this);
    }

    //ha falnak utkozik a golyo akkor igaz
    public boolean hit(Bullet bullet) {
        return true;
    }

}