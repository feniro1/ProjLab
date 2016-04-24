
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
    public void createBox(Box box) {
        boxes.add(boxes.size() - 1, box);
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

    public boolean stepOn(Replicator repl) {
        if (hasBox()) {
            return false;
        }
        return true;
    }

    //Felveheto a merlegen levo legfelso doboz, ha van rajta.
    public Box pickUp() {
        if (hasBox()) {

            Box temp = boxes.remove(boxes.size() - 1);
            int totalWeight = 0;
            for (int i = 0; i < boxes.size() - 1; i++) {
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
        if (col == null) {
            boxes.add(boxes.size() - 1, box);
            int totalWeight = 0;
            for (int i = 0; i < boxes.size() - 1; i++) {
                totalWeight += boxes.get(i).getWeight();
            }
            if (totalWeight >= limit) {
                door.open();
            }
            return true;
        }
        return false;
    }

}