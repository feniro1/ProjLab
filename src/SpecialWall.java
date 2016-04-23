
import java.util.*;


public class SpecialWall extends Wall {

    private WormHole wormhole;

    //Konstruktor wormhole paraméterrel
    public SpecialWall(WormHole wormHole) {
        this.wormhole = wormHole;
    }

    //Speciális fal hit függvénye. A beérkező töltény színével megegyező portált állítja be a féregjáraton.
    //Most akkor elvileg a hit akkor ter vissza trueval, amikor eltalt valamit
    public boolean hit(Bullet bullet) {
        Color color = bullet.color;
        Direction dir = bullet.lookDirection.reverse();

        //a féregjárat portáljának beállításához át kell adni a portál irányát, ami a beérkező tölténnyel ellentétes irányú
        //illetve saját magát, mert a portálhoz be kell állítani a hozzá tartoz speciális falat, tovabba a fal szinet
        wormhole.setPortal(dir, this, color);

        return true;
    }

    //akkor ter vissza trueval, ha letezik feregjarat abban az iranyban ahonnan a jatekos jon, egyebkent false
    public boolean stepOn(Player player) {
        Direction dir = player.getLookDirection().reverse();

        Portal myportal = wormhole.getThisPortal(dir, this);
        Portal otherportal = wormhole.getOtherPortal(dir, this);

        if (myportal != null && otherportal != null) {
            return true;
        }
        else {
            return false;
        }
    }
    //ez azert van mert ha van feregjarat akkor a jatekosnak nem a steponban lekerdezett elem kovetkezo elemere kell lepnie
    //hanem oda ahol a feregjarat masik portalja van
    //na ezt ay elemet kapjuk meg ezzel a fuggvennyel MapElementtel ter tehat vissza
    public MapElement walkthroughWormHole(Player player){
        Direction dir = player.getLookDirection().reverse();

        MapElement wheretoGo = wormhole.getOtherPortal(dir, this).getDestinationElement();
        return wheretoGo;
    }


}