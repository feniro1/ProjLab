
import java.util.*;


public class Rift extends MapElement {

    //Rift konstruktora
    public Rift() {
        System.out.println("Létrejön egy szakadék objektum.");
    }


    //Az ezredes belelephet a szakadekba, csak meg fog halni
    public boolean stepOn(Colonel colonel) {
        System.out.println("Az ezredes ráléphet a szakadékra és meghal.");
        colonel.kill();
        return true;
    }


    //Az ezredes leteheti a dobozt
    public boolean putDown(Box b) {
        System.out.println("Az ezredes dobhat dobozt a szakadékba.");
        return true;
    }

}