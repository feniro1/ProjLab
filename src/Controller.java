import java.io.IOException;

/**
 * Created by Mate on 11/05/16.
 */
public class Controller {
    private GameEngine game;
    private View view;

    public Controller() {
        game = new GameEngine(this);
        view = new View();
    }

    public void start() {
        try {
            game.loadMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        view.setList(game.getFirstElement(), game.getRow(), game.getColumn());
    }
}
