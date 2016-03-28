
import java.util.*;


public class SpecialWall extends Wall {


    private WormHole wormhole;
    private Portal yport;
    private Portal bport;

    public SpecialWall() {

    }


    public WormHole getWormHole() {
        return wormhole;
    }

    public boolean hit(Bullet bullet) {
        Color color = bullet.color;
        Direction dir = bullet.lookDirection.reverse();

        if (color == Color.Yellow) {
            wormhole.setYPortal(dir, this);
            yport = wormhole.getYPortal();
        }
        else {
            wormhole.setBPortal(dir, this);
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

    public Portal getYPortal(){
        return yport;
    }

    public Portal getBPortal(){
        return bport;
    }

    public void setYPortal(Portal port){
        yport = port;
    }

    public void setBPortal(Portal port){
        bport = port;
    }


}