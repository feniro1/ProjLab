
import java.util.*;


public class Ground extends MapElement {

    private Box box = null; // alapertelmezetten nincs a talajon doboz
    private ZPM zpm = null; // alapertelmezetten nincs a talajon ZPM modul

    // konstruktor a talaj objektumhoz
    public  Ground() {
        isGround = true;
    }

    // parameteres konstruktor, mely beallít egy boxot
    public Ground(Box box) {
        isGround = true;
        this.box = box;
    }

    // parameteres konstruktor, mely beallít egy zpm modult
    public Ground(ZPM zpm) {
        isGround = true;
        this.zpm = zpm;
    }

    // visszaadja, hogy a talajon van-e zpm
    public boolean hasZPM() {
        if (zpm != null) {
            return true;
        }
        return false;
    }

    //beallit neki egy uj zpm-et a groundnak
    public void setZPM() {
        this.zpm = new ZPM();
    }

    //megmutatja van e rajta jatekos
    public boolean hasPlayer() {
        if (player != null) {
            return true;
        }
        return false;
    }

    //megmutatja van e rajta replikator
    public boolean hasReplicator() {
        if (rep != null) {
            return true;
        }
        return false;
    }

    // visszaadja, hogy a talajon van-e doboz
    public boolean hasBox() {
        if (box != null) {
            return true;
        }
        return false;
    }

    // null-ra allitja a zpm parametert
    public void removeZPM() {
        zpm = null;
    }

    // null-ra allitja a doboz parametert
    public void removeBox() {
        box = null;
    }

    // ha a foldon all valami es golyo megy el a fold objektum felett, ez lekezeli, hogy utkozik-e valamivel
    public boolean hit(Bullet bullet) {
        if((!hasBox()) && (player == null)) {
            if(rep != null){
                rep.killedByBullet();
                rep = null;
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    // visszaadja, hogy az ezredes ralephet-e a talaj objektumra
    public boolean stepOn(Player player) {
        if (!hasBox()) {
            if(!hasPlayer()) {
                if (hasZPM()) {
                    player.incZPMNumber();
                    removeZPM();
                }
                return true;
            }
        }
        return false;
    }

    public boolean stepOn(Replicator _rep) {
        if (!hasBox()&&!hasZPM()) {
            return true;
        }
        return false;
    }

    // visszaad egy doboz objektumot, ha van neki
    public Box pickUp() {
        if (hasBox()) {
            Box tmp = box;
            removeBox();
            return tmp;
        }
        return null;
    }

    // visszaadja, hogy tehet le dobozt az ezredes es ha igen leteszi azt, es visszaad egy booleant, hogy sikerult-e
    public boolean putDown(Box b) {
        if (hasBox()) {
            return false;
        } else {
            box = b;
            return true;
        }
    }

    public Replicator getReplicator(){
        return rep;
    }

    public Drawable getDrawableClass() {
        return new GroundGraphic(this);
    }

}