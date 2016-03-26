
import java.util.*;


public class SpecialWall extends Wall {


    public SpecialWall() {

    }

    public WormHole wormhole;
    public Portal yport;
    public Portal bport;


    public WormHole getWormHole() {
        return wormhole;
    }

    public boolean hit(Bullet bullet) {
        Color color = bullet.color;
        Direction dir = bullet.lookDirection.reverse();

        if (color == Color.Yellow) {
            wormhole.setYportal(dir, this);
            yport = wormhole.getYPortal();
        }
        else {
            wormhole.setBportal(dir, this);
            bport = wormhole.getBPortal();
        }

        return false;
    }

    public boolean stepOn(Colonel colonel) {
        Direction dir = colonel.lookDirection.reverse();
        if (yport.getDirection() == dir | bport.getDirection() == dir)
            return true;
        else
            return false;
    }

}