
import java.util.*;


public class Rift extends MapElement {

    public Rift() {
        System.out.println("Letrejon egy szakadek objektum.");
    }


    public boolean stepOn(Colonel colonel) {
        System.out.println("Az ezredes ralephet a szakadekra es meghal.");
        colonel.kill();
        return true;
    }


    public boolean putDown(Box b) {
        System.out.println("Az ezredes dobhat dobozt a szakadekba.");
        return true;
    }

}