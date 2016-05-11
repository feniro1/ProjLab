
import java.util.*;


public class Scale extends MapElement {

    private List<Box> boxes;
    private Door door;
    private int limit;
    protected boolean isScale = true;

    //Konstruktor. Alapertelmezettben nincs rajta doboz.
    public Scale(int limit) {
        this.limit = limit;
        boxes = new ArrayList<>();
    }

    // visszaadja a merleghez tartozo ajtot
    public Door getDoor() {
        return door;
    }

    //Ha van doboza, akkor igazzal tér vissza, ha nincs hamissal
    public boolean hasBox() {
        if (boxes.size() > 0) {
            return true;
        }
        return false;
    }

    //Beallithato, a merleghez tartozo ajtot.
    public void setDoor(Door d) {
        door = d;
    }

    //Eltavolit egy dobozt a merlegrol
    public void removeBox() {
        if (hasBox()) {
            boxes.remove(boxes.size() - 1);
        }
    }

    //Ezzel allitható be a merlegnek doboz
    public void addBox(Box box) {
        boxes.add(box);
    }

    //A Player alapértelmezett esetben ráléphet a mérlegre, de ha van rajta doboz, akkor nem
    public boolean stepOn(Player player) {
        if (hasBox()) {
            return false;
        }
        if (player.getWeight() >= limit) {
            door.open();
        }
        return true;
    }

    //ugyanaz mint az előző, csak replikátorra
    public boolean stepOn(Replicator repl) {
        if (hasBox()) {
            return false;
        }
        return true;
    }

    //Ha nincs doboz és játékos a mérlegen, vagy ha replikátor van, akkor eltalálta a golyó, tehát tru-val
    //téreünk vissza replikátor esetén megöljük azt, ellenkező esetben false
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

    //Felveheto a merlegen levo legfelso doboz, ha van rajta.
    public Box pickUp() {
        if (hasBox()) {

            Box temp = boxes.remove(boxes.size() - 1);
            int totalWeight = 0;
            for (int i = 0; i < boxes.size(); i++) {
                totalWeight += boxes.get(i).getWeight();
            }
            if (totalWeight < limit) {
                door.close();
            }
            return temp;
        }
        return null;
    }

    //Letehető a mérlegre doboz, ha nincsen rajta.
    public boolean putDown(Box box) {
        if (player == null) {
            boxes.add(box);
            int totalWeight = 0;
            for (int i = 0; i < boxes.size(); i++) {
                totalWeight += boxes.get(i).getWeight();
            }
            if (totalWeight >= limit) {
                door.open();
            }
            return true;
        }
        return false;
    }

    //Kirajzoláshoz szükséges. Ha vn rajta doboz $, ha nincs S-t rajzolunk ki
    public String symbol(){
        if(hasBox()){
            return "$";
        } else {
            return "S";
        }
    }

    @Override
    public Drawable getDrawableClass() {
        return new ScaleGraphic(this);
    }

}