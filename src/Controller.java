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
    //high-end debug session ftw
//        if (key == KeyEvent.VK_D)
//            System.out.println("d lett nyomva");

        switch(key){
            case KeyEvent.VK_UP:
                game.move("oneill", Direction.Up);
                break;
            case KeyEvent.VK_DOWN:
                game.move("oneill", Direction.Down);
                break;
            case KeyEvent.VK_RIGHT:
                game.move("oneill", Direction.Right);
                break;
            case KeyEvent.VK_LEFT:
                game.move("oneill", Direction.Left);
                break;
            case KeyEvent.VK_W:
                game.move("jaffa", Direction.Up);
                break;
            case KeyEvent.VK_S:
                game.move("jaffa", Direction.Down);
                break;
            case KeyEvent.VK_D:
                game.move("jaffa", Direction.Right);
                break;
            case KeyEvent.VK_A:
                game.move("jaffa", Direction.Left);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
}
