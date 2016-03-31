
import java.util.*;


public abstract class MapElement {


    protected MapElement[] neighbours = new MapElement[4]; // az adott mapElement szomszedait tarolja
    protected Colonel col; // ezredesre mutato pointert tarol, ha az van rajta
    protected Bullet bul; // lovedekre mutato pointert tarol, ha az van rajta
    protected boolean isSpecWall = false;
    protected boolean isScale = false;


    public MapElement() { // letrehoz egy mapElement objektumot
        //System.out.println("Sikeresen létrehoztál egy MapElement objektumot.");
    }


    public void draw() { // kirajzolja a palyat, kesobb lesz implementalva

    }

    public void setColonel(Colonel colonel) { // beallit egy ezredest az adott mapElementre, ha az rajta van
        col = colonel;
    }


    public boolean stepOn(Colonel colonel) { // visszaadja, hogy ralephetsz-e a mapElementre, alapbol false
        System.out.println("Nem léphetsz rá a MapElementre.");
        return false;
    }


    public Box pickUp() { // visszaadja, hogy van-e doboz a mapElementen. alapbol nincs
        System.out.println("Nincs mit felvenni.");
        return null;
    }


    public boolean putDown(Box b) { // visszaadja, hogy felveheted-e a dobozt az adott mapElementrol
        System.out.println("Nem tudod letenni a dobozt a MapElementre.");
        return false;
    }


    public boolean hit(Bullet bullet) { // visszaadja ed true-t ha a golyo belecsapodik valamibe, alapbol false
        System.out.println("A golyo nem csapodott meg be semmibe.");
        return false;
    }


    public MapElement getNextElement(Direction dir) { // visszaadja a sajat szomszedjat (mapelement objektumot) attol fuggoen merre van fordulva az ezredes
        System.out.println("Le lett kérve a következő palyaelem.");
        return neighbours[dir.getValue()];
    }

    public void setNeighbour(Direction dir, MapElement me){ // beallitja a fal szomszedait
        switch (dir){
            case Up:
                neighbours[0] = me;
                break;
            case Right:
                neighbours[1] = me;
                break;
            case Down:
                neighbours[2] = me;
                break;
            case Left:
                neighbours[3] = me;
                break;
        }
    }


}