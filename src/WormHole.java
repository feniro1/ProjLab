
import java.util.*;


public class WormHole {

    private Portal yportal;
    private Portal bportal;

    //Konstruktor. Létrehozz két portált, aminek kezdetben csak a színét beállítja, de ezek még
    // nincsenek speciális falhoz rendelve.
    public WormHole() {
        yportal = new Portal();
        bportal = new Portal();
        yportal.setColor(Color.Yellow);
        bportal.setColor(Color.Blue);
        System.out.println("Létrejön egy féregjárat.");
    }
/*
    public void setYPortal(Bullet bull) {
        // TODO implement here
    }

    public void setBPortal(Bullet bull) {
        // TODO implement here
    }
*/
    //Sárga portálhoz tartozó setter. A fal irányát és a hozzá tartozó speciális falat kell beállítani
    public void setYPortal(Direction dir, SpecialWall swall){
        yportal.getSpecWall().setYPortal(null);
        yportal.setDirection(dir);
        yportal.setSpecWall(swall);
        System.out.println("Létrejött egy sárga portál.");
    }

    //Kék portálhoz tartozó setter. A fal irányát és a hozzá tartozó speciális falat kell beállítani
    public void setBPortal(Direction dir, SpecialWall swall){
        //bportal.getSpecWall().setBPortal(null);
        bportal.setDirection(dir);
        bportal.setSpecWall(swall);
        System.out.println("Létrejött egy kék portál.");
    }

    //Portálokhoz tartozó getter
    public Portal getYPortal() {
        System.out.println("Visszaadja a sárga portált");
        return yportal;
    }

    public Portal getBPortal() {
        System.out.println("Visszaadja a kék portált");
        return bportal;
    }

}