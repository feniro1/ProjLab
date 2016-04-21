
import java.util.*;

public class Wall extends MapElement {

    public Wall() {
        System.out.println("Létrejön egy fal objektum");
    }

    //Ideiglenes, csak a kiírás miatt van felüldefiniálva
    @Override
    public boolean stepOn(Player colonel) {
        System.out.println("Meghívódott a visszakapott Wall objektum stepOn függvénye." +
                "Nem lehet a falra rálépni. Nem vagy te paukembör.");
        return super.stepOn(colonel);
    }
}