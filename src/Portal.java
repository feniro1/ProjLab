
import java.util.*;


public class Portal {

    private Color color;
    private Direction dir;
    private SpecialWall specwall;

    //Konstruktor. Portál létrejön. Alapértelmezett esetben nem tartozik speciális falhoz.
    public Portal() {
        specwall = null;
    }

    //Portál irányának beállítása
    public void setDirection(Direction dir) {
        this.dir = dir;
    }

    //Portál irányának lekérdezése
    public Direction getDirection() {
        return this.dir;
    }

    //Portálhoz tartozó speciális fal lekérdezése
    public SpecialWall getSpecWall() {
        return this.specwall;
    }

    //Portálhoz tartozó speciális fal beállítása
    public void setSpecWall(SpecialWall swall) {
        this.specwall = swall;
    }

    //Portál színének beállítása
    public void setColor(Color c) {
        color = c;
    }
    
    //Portál színének lekérdezése
    public Color getColor() {
        return color;
    }

    //Portálhoz tartozó speciális fal lekérdezést. A férekjáraton való áthaladáskor szükséges.
    public MapElement getDestinationElement(){
        return specwall.getNextElement(dir);
    }
}