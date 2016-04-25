
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
    //na ezt az elemet kapjuk meg ezzel a fuggvennyel MapElementtel ter tehat vissza
    public MapElement walkthroughWormHole(Player player){
        Direction dir = player.getLookDirection().reverse();

        MapElement wheretoGo = wormhole.getOtherPortal(dir, this).getDestinationElement();
        return wheretoGo;
    }

    //ugyanaz mint a felso, csak replicatorra
    public MapElement walkthroughWormHole(Replicator replicator){
        Direction dir = replicator.getLookDirection().reverse();

        MapElement wheretoGo = wormhole.getOtherPortal(dir, this).getDestinationElement();
        return wheretoGo;
    }

    //Kirajzoláshoz lekérjük, hogy vagy-e a falnak portálja, ehhez végig kell nézni a 4 portált, hogy
    //az ehhez a falhoz tartozik-e
    public boolean hasPortal() {
        if (this == wormhole.getPortal(Color.Yellow).getSpecWall()) return true;
        if (this == wormhole.getPortal(Color.Blue).getSpecWall()) return true;
        if (this == wormhole.getPortal(Color.Green).getSpecWall()) return true;
        if (this == wormhole.getPortal(Color.Red).getSpecWall()) return true;
        return false;
    }

    //Kirajzolást segítő függvény. Ha portál van a falon #-et rajzolunk, ha sima speciális fal %-t.
    public String symbol(){
        if(hasPortal())
            return "#";
        else
            return "%";
    }


}