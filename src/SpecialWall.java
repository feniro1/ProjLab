
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
        System.out.println("A golyó egy SpecialWall objektumnak ütközött");
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
        System.out.println("Meghívódott a SpecWall stepOn függvénye");
        Direction dir = colonel.getLookDirection().reverse();
        if (yport.getDirection() == dir | bport.getDirection() == dir) {
            System.out.println("Van portál");
            return true;
        }
        else {
            System.out.println("Nincs portál");
            return false;
        }
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