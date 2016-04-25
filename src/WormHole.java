
import java.util.*;


public class WormHole {

    private Portal yportal;
    private Portal bportal;

    private Portal rportal;
    private Portal gportal;


    //Konstruktor. Letrehoz negy portalt, aminek kezdetben csak a szinet beallitja, de ezek meg
    // nincsenek specialis falhoz rendelve.
    public WormHole() {
        yportal = new Portal();
        bportal = new Portal();
        rportal = new Portal();
        gportal = new Portal();
        yportal.setColor(Color.Yellow);
        bportal.setColor(Color.Blue);
        rportal.setColor(Color.Red);
        gportal.setColor(Color.Green);
    }

    //beallitja a megfelelo portalt, ha pont olyan helyen akarunk letrehozni portalt, ahol mar van, akkor nem hozza letre
    //egyebkent pedig a kapott parameterek alapjan beallitja a megfelelo szinu portalt a megadott specwallra a megadott iranyaba
    public void setPortal(Direction dir, SpecialWall swall, Color c){
        if (getThisPortal(dir, swall) == null){
            switch (c){
                case Yellow:
                    yportal.setSpecWall(swall);
                    yportal.setDirection(dir);
                    break;
                case Blue:
                    bportal.setSpecWall(swall);
                    bportal.setDirection(dir);
                    break;
                case Red:
                    rportal.setSpecWall(swall);
                    rportal.setDirection(dir);
                    break;
                case Green:
                    gportal.setSpecWall(swall);
                    gportal.setDirection(dir);
                    break;
                default:
                    System.out.println("Hiba");
                    break;
            }
        }
    }

    public Portal getPortal(Color col) {
        switch(col) {
            case Yellow:
                return yportal;
            case Blue:
                return bportal;
            case Red:
                return rportal;
            case Green:
                return gportal;
        }
        return null;
    }

    //megadja, hogy adott specwallhoz adott iranyba letezik-e portal es ha igen azzal ter vissza, ha nincs, akkor null
    public Portal getThisPortal(Direction dir, SpecialWall swall){
        if (yportal.getSpecWall() == swall && yportal.getDirection() == dir)
            return yportal;
        else if (bportal.getSpecWall() == swall && bportal.getDirection() == dir)
            return bportal;
        else if (rportal.getSpecWall() == swall && rportal.getDirection() == dir)
            return rportal;
        else if (gportal.getSpecWall() == swall && gportal.getDirection() == dir)
            return gportal;
        else
            return null;
    }
    //megadja, hogy adott specwallhoz adott iranyba letezik-e feregjarat es ha igen visszater a masik portallal, ha nem akkor null
    public Portal getOtherPortal(Direction dir, SpecialWall swall){
        if (yportal.getSpecWall() == swall && yportal.getDirection() == dir && bportal.getSpecWall() != null)
            return bportal;
        else if (bportal.getSpecWall() == swall && bportal.getDirection() == dir && yportal.getSpecWall() != null)
            return yportal;
        else if (rportal.getSpecWall() == swall && rportal.getDirection() == dir && gportal.getSpecWall() != null)
            return gportal;
        else if (gportal.getSpecWall() == swall && gportal.getDirection() == dir && rportal.getSpecWall() != null)
            return rportal;
        else{
            return null;
        }
    }
}