
import java.util.*;


public class SpecialWall extends Wall {


    private WormHole wormhole;
    private HashMap<Color, Portal> portals;
    protected boolean isSpecWall = true;

    //Konstruktor wormhole paraméterrel
    public SpecialWall(WormHole wormHole) {
        this.wormhole = wormHole;
        portals = new HashMap<Color, Portal>();
        System.out.println("Letrejon egy specialis fal objektum.");
    }

    //wormhole attribútumhoz tartozó getter
    public WormHole getWormHole() {
        System.out.println("Visszaadjuk a specialis falon levo feregjaratot.");
        return wormhole;
    }

    //Speciális fal hit függvénye. A beérkező töltény színével megegyező portált állítja be a féregjáraton.
    public boolean hit(Bullet bullet) {
        System.out.println("A golyo egy SpecialWall objektumnak utkozott");
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
        System.out.println("Meghivodott a SpecWall stepOn fuggvenye");
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

    public Portal getPortal(Color col) {
        return portals.get(col);
    }

    public void setPortal(Color col, Portal port) {
        portals.remove(col);
        portals.put(col, port);
    }


}