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
                System.out.println("Felfe gomb lenyomva");
                game.move("oneill", Direction.Up);
                view.drawMap();
                break;
            case KeyEvent.VK_K:
                System.out.println("Lefele gomb lenyomva");
                game.move("oneill", Direction.Down);
                view.drawMap();
                break;
            case KeyEvent.VK_L:
                System.out.println("Jobbra gomb lenyomva");
                game.move("oneill", Direction.Right);
                view.drawMap();
                break;
            case KeyEvent.VK_J:
                System.out.println("Balra gomb lenyomva");
                game.move("oneill", Direction.Left);
                view.drawMap();
                break;
            case KeyEvent.VK_N:
                System.out.println("Kek portal kilove");
                game.shoot("oneill", Color.Blue);
                view.drawMap();
                break;
            case KeyEvent.VK_M:
                System.out.println("Sarga portal kilove");
                game.shoot("oneill", Color.Yellow);
                view.drawMap();
                break;
            case KeyEvent.VK_U:
                System.out.println("Oneill balra fordult");
                game.turn("oneill");
                view.drawMap();
                break;
            case KeyEvent.VK_O:
                System.out.println("Oneill felvett egy dobozt");
                game.putDown("oneill");
                view.drawMap();
                break;
            case KeyEvent.VK_P:
                System.out.println("Oneill letett egy dobozt");
                game.pickUp("oneill");
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
            case KeyEvent.VK_X:
                System.out.println("Zold portal kilove");
                game.shoot("jaffa", Color.Green);
                view.drawMap();
                break;
            case KeyEvent.VK_C:
                System.out.println("Piros portal kilove");
                game.shoot("jaffa", Color.Red);
                view.drawMap();
                break;
            case KeyEvent.VK_Q:
                System.out.println("Jaffa balra fordult");
                game.turn("jaffa");
                view.drawMap();
                break;
            case KeyEvent.VK_E:
                System.out.println("Jaffa felvett egy dobozt");
                game.putDown("jaffa");
                view.drawMap();
                break;
            case KeyEvent.VK_R:
                System.out.println("Jaffa letett egy dobozt");
                game.pickUp("jaffa");
                view.drawMap();
                break;

            //kocsonya
            //csapatas
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
