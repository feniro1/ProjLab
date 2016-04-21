
import java.util.*;


public class SpecialWall extends Wall {

    private WormHole wormhole;

    //Konstruktor wormhole paraméterrel
    public SpecialWall(WormHole wormHole) {
        this.wormhole = wormHole;
        System.out.println("Létrejön egy speciális fal objektum.");
    }

    //Speciális fal hit függvénye. A beérkező töltény színével megegyező portált állítja be a féregjáraton.
    //Most akkor elvileg a hit akkor ter vissza trueval, amikor eltalt valamit
    public boolean hit(Bullet bullet) {
        System.out.println("A golyó egy SpecialWall objektumnak ütközött");
        Color color = bullet.color;
        Direction dir = bullet.lookDirection.reverse();

        //a féregjárat portáljának beállításához át kell adni a portál irányát, ami a beérkező tölténnyel ellentétes irányú
        //illetve saját magát, mert a portálhoz be kell állítani a hozzá tartoz speciális falat, tovabba a fal szinet
        wormhole.setPortal(dir, this, color);

        return true;
    }

    //akkor ter vissza trueval, ha letezik feregjarat abban az iranyban ahonnan a jatekos jon, egyebkent false
    public boolean stepOn(Player player) {
        System.out.println("Meghívódott a SpecWall stepOn függvénye");
        Direction dir = player.getLookDirection().reverse();

        Portal myportal = wormhole.getThisPortal(dir, this);
        Portal otherportal = wormhole.getOtherPortal(dir, this);

        if (myportal != null && otherportal != null) {
            System.out.println("Letezik feregjarat johet a jatekos");
            return true;
        }
        else {
            System.out.println("Ezen a falon nem jutsz at");
            return false;
        }
    }
    //ez azert van mert ha van feregjarat akkor a jatekosnak nem a steponban lekerdezett elem kovetkezo elemere kell lepnie
    //hanem oda ahol a feregjarat masik portalja van
    //na ezt ay elemet kapjuk meg ezzel a fuggvennyel MapElementtel ter tehat vissza
    public MapElement walkthroughWormHole(Player player){
        System.out.println("Meghívódott a SpecWall  walkthroughWormHole függvénye");
        Direction dir = player.getLookDirection().reverse();

        MapElement wheretoGo = wormhole.getOtherPortal(dir, this).getDestinationElement();
        return wheretoGo;
    }


}