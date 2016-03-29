
import java.util.*;

public class Wall extends MapElement {

    public Wall() {
        System.out.println("Létrejön egy fal objektum");
    }

    @Override
    public boolean stepOn(Colonel colonel) {
        System.out.println("Meghívódott a visszakapott Wall objektum stepOn függvénye." +
                "Nem lehet a falra rálépni. Nem vagy te paukembör.");
        return super.stepOn(colonel);
    }
}