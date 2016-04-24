
import java.util.*;


public abstract class MapElement {


    protected MapElement[] neighbours = new MapElement[4]; // az adott mapElement szomszedait tarolja
    protected Player col; // ezredesre mutato pointert tarol, ha az van rajta
    protected Replicator rep; // replikatorra mutato pointer
    protected Bullet bul; // lovedekre mutato pointert tarol, ha az van rajta
    protected boolean isSpecWall = false;
    protected boolean isScale = false;


    public MapElement() { // letrehoz egy mapElement objektumot
        //System.out.println("Sikeresen létrehoztál egy MapElement objektumot.");
    }


    public void draw() { // kirajzolja a palyat, kesobb lesz implementalva

    }

    public void setPlayer(Player player) { // beallit egy ezredest az adott mapElementre, ha az rajta van
        col = player;
    }

    public void setReplicator(Replicator _rep) { // beallit egy ezredest az adott mapElementre, ha az rajta van
        rep = _rep;
    }

    public String symbol(){
        return "";
    }

    // visszaadja, hogy ralephetsz-e a mapElementre, alapbol false
    public boolean stepOn(Player player) {
        //System.out.println("Nem léphetsz rá a MapElementre.");
        return false;
    }

    // visszaadja, hogy ralephetsz-e a mapElementre, alapbol false
    public boolean stepOn(Replicator _rep) {
        //System.out.println("Nem léphetsz rá a MapElementre.");
        return false;
    }


    // visszaadja, hogy van-e doboz a mapElementen. alapbol nincs
    public Box pickUp() {
        //System.out.println("Nincs mit felvenni.");
        return null;
    }


    // visszaadja, hogy felveheted-e a dobozt az adott mapElementrol
    public boolean putDown(Box b) {
        //System.out.println("Nem tudod letenni a dobozt a MapElementre.");
        return false;
    }


    // visszaadja ed true-t ha a golyo belecsapodik valamibe, alapbol false
    public boolean hit(Bullet bullet) {
        //System.out.println("A golyo nem csapodott meg be semmibe.");
        return false;
    }


    // visszaadja a sajat szomszedjat (mapelement objektumot) attol fuggoen merre van fordulva az ezredes
    public MapElement getNextElement(Direction dir) {
        //System.out.println("Le lett kérve a következő palyaelem.");
        return neighbours[dir.getValue()];
    }

    // beallitja a fal szomszedait
    public void setNeighbour(Direction dir, MapElement me){
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