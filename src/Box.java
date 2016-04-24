
import java.util.*;


public class Box {

    // attributum, mely a doboz sulyat tarolja
    private int weight;

    // letrehozunk egy bizonyos sulyu doboz objektumot
    public Box(int weight) {
        this.weight = weight;
    }

    // a doboz sulyat ezzel a getterrel kerjuk le
    public int getWeight() {
        return weight;
    }
}