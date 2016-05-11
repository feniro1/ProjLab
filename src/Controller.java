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
            case KeyEvent.VK_UP:
                System.out.println("Felfe gomb lenyomva");
                game.move("oneill", Direction.Up);
                view.drawMap();
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Lefele gomb lenyomva");
                game.move("oneill", Direction.Down);
                view.drawMap();
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Jobbra gomb lenyomva");
                game.move("oneill", Direction.Right);
                view.drawMap();
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Balra gomb lenyomva");
                game.move("oneill", Direction.Left);
                view.drawMap();
                break;
            case KeyEvent.VK_W:
                System.out.println("W gomb lenyomva");
                game.move("jaffa", Direction.Up);
                view.drawMap();
                break;
            case KeyEvent.VK_S:
                System.out.println("S gomb lenyomva");
                game.move("jaffa", Direction.Down);
                view.drawMap();
                break;
            case KeyEvent.VK_D:
                System.out.println("D gomb lenyomva");
                game.move("jaffa", Direction.Right);
                view.drawMap();
                break;
            case KeyEvent.VK_A:
                System.out.println("A gomb lenyomva");
                game.move("jaffa", Direction.Left);
                view.drawMap();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
