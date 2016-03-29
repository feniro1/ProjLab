
import java.util.*;


public class SpecialWall extends Wall {


    private WormHole wormhole;
    private Portal yport;
    private Portal bport;

    //Konstruktor wormhole paraméterrel
    public SpecialWall(WormHole wormHole) {
        this.wormhole = wormHole;
        yport = null;
        bport = null;
        System.out.println("Létrejön egy speciális fal objektum.");
    }

    //wormhole attribútumhoz tartozó getter
    public WormHole getWormHole() {
        System.out.println("Visszaadjuk a speciális falon lévő féregjáratot.");
        return wormhole;
    }

    //Speciális fal hit függvénye. A beérkező töltény színével megegyező portált állítja be a féregjáraton.
    public boolean hit(Bullet bullet) {
        System.out.println("A golyó egy SpecialWall objektumnak ütközött");
        Color color = bullet.color;
        Direction dir = bullet.lookDirection.reverse();

        //a féregjárat portáljának beállításához át kell adni a portál irányát, ami a beérkező tölténnyel ellentétes irányú
        //illetve saját magát, mert a portálhoz be kell állítani a hozzá tartoz speciális falat
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
/*        if (yport.getDirection() == dir | bport.getDirection() == dir) {
            System.out.println("Van portál");
            return true;
        }
        else {
            System.out.println("Nincs portál");
            return false;
        }
        */
        return true;
    }

    public Portal getYPortal() {
        System.out.println("Visszaadjuk a sárga csillagkaput.");
        return yport;
    }

    public Portal getBPortal() {
        System.out.println("Visszaadjuk a kék csillagkaput.");
        return bport;
    }

    public void setYPortal(Portal port) {
        System.out.println("Beállítjuk a sárga csillagkaput.");
        yport = port;
    }

    public void setBPortal(Portal port) {
        System.out.println("Beállítjuk a kék csillagkaput.");
        bport = port;
    }


}