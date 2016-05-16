import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;


/**
 * Created by Mate on 11/05/16.
 */
public class Controller implements KeyListener{
    private GameEngine game;
    private View view;

    public Controller() {
        game = new GameEngine(this);
        view = new View(this);
    }

    public void start() {
        try {
            game.loadMap();
            view.setList(game.getFirstElement(), game.getRow(), game.getColumn());
            view.drawMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch(key){
            case KeyEvent.VK_I:
                game.move("oneill", Direction.Up);
                game.move("rep", Direction.Up);
                view.drawMap();
                break;
            case KeyEvent.VK_K:
                game.move("oneill", Direction.Down);
                game.move("rep", Direction.Up);
                view.drawMap();
                break;
            case KeyEvent.VK_L:
                game.move("oneill", Direction.Right);
                game.move("rep", Direction.Up);
                view.drawMap();
                break;
            case KeyEvent.VK_J:
                game.move("oneill", Direction.Left);
                game.move("rep", Direction.Up);
                view.drawMap();
                break;
            case KeyEvent.VK_N:
                game.shoot("oneill", Color.Blue);
                view.drawMap();
                break;
            case KeyEvent.VK_M:
                game.shoot("oneill", Color.Yellow);
                view.drawMap();
                break;
            case KeyEvent.VK_U:
                game.turn("oneill");
                view.drawMap();
                break;
            case KeyEvent.VK_O:
                game.pickUp("oneill");
                view.drawMap();
                break;
            case KeyEvent.VK_W:
                game.move("jaffa", Direction.Up);
                game.move("rep", Direction.Up);
                view.drawMap();
                break;
            case KeyEvent.VK_S:
                game.move("jaffa", Direction.Down);
                game.move("rep", Direction.Up);
                view.drawMap();
                break;
            case KeyEvent.VK_D:
                game.move("jaffa", Direction.Right);
                game.move("rep", Direction.Up);
                view.drawMap();
                break;
            case KeyEvent.VK_A:
                game.move("jaffa", Direction.Left);
                game.move("rep", Direction.Up);
                view.drawMap();
                break;
            case KeyEvent.VK_X:
                game.shoot("jaffa", Color.Green);
                view.drawMap();
                break;
            case KeyEvent.VK_C:
                game.shoot("jaffa", Color.Red);
                view.drawMap();
                break;
            case KeyEvent.VK_Q:
                game.turn("jaffa");
                view.drawMap();
                break;
            case KeyEvent.VK_E:
                game.pickUp("jaffa");
                view.drawMap();
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
