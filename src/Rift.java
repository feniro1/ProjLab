
import java.util.*;


public class Rift extends MapElement {


    public Rift() {
        System.out.println("Létrejön egy szakadék objektum.");
    }


    public boolean stepOn(Colonel colonel) {
        System.out.println("Az ezredes ráléphet a szakadékra és meghal.");
        colonel.kill();
        return true;
    }


    public boolean putDown(Box b) {
        System.out.println("Az ezredes dobhat dobozt a szakadékba.");
        return true;
    }

}