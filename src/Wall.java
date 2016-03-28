
import java.util.*;

/**
 * 
 */
public class Wall extends MapElement {

    /**
     * Default constructor
     */
    public Wall() {

    }

    @Override
    public boolean stepOn(Colonel colonel) {
        System.out.println("Meghívódott a visszakapott Wall objektum stepOn függvénye." +
                "Nem lehet a falra rálépni. Nem vagy te paukembör.");
        return super.stepOn(colonel);
    }
}