import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;


/**
 * Created by Mate on 11/05/16.
 */
// Kapcsolatot letesit a model es a view kozott, es kezeli a felhasznaloi interakciokat
public class Controller implements KeyListener {
    private GameEngine game;
    private View view;

    // konstruktor, melyben inicializaljuk a jatekmenetet es egy uj nezetet
    public Controller() {
        game = new GameEngine(this);
        view = new View(this);
    }

    //Elinditja a jatekot, inicializalja es beallitja a megfelelo komponenseket
    public void start() {
        try {
            game = new GameEngine(this);
            game.loadMap();
            view.setList(game.getFirstElement(), game.getRow(), game.getColumn());
            view.setScoreOneillLabel(0);
            view.setScoreJaffaLabel(0);
            view.drawMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // figyeli, ha a palyaban valtozas tortenik es ujratolti azt
    public void check(){
        game.check();

        if (game.getReloadMap() == true){
            view.setList(game.getFirstElement(), game.getRow(), game.getColumn());
            game.resetReloadMap();
        }

    }

    // felelos a billentyuzet lenyomasokert, kezeli azokat, es a megfelelo gombok leutesere megfelelo karakterekre hiv meg fuggvenyeket, ez lehet mozgas, loves, forgas, dobozfelveves
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

          switch (key) {
                case KeyEvent.VK_I:
                    game.move("oneill", Direction.Up);
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_K:
                    game.move("oneill", Direction.Down);
                    view.drawMap();
                    this.check();
                    break;
                case KeyEvent.VK_L:
                    game.move("oneill", Direction.Right);
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_J:
                    game.move("oneill", Direction.Left);
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_N:
                    game.shoot("oneill", Color.Blue);
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_M:
                    game.shoot("oneill", Color.Yellow);
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_U:
                    game.turn("oneill");
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_O:
                    game.pickUp("oneill");
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_W:
                    game.move("jaffa", Direction.Up);
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_S:
                    game.move("jaffa", Direction.Down);
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_D:
                    game.move("jaffa", Direction.Right);
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_A:
                    game.move("jaffa", Direction.Left);
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_X:
                    game.shoot("jaffa", Color.Green);
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_C:
                    game.shoot("jaffa", Color.Red);
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_Q:
                    game.turn("jaffa");
                    this.check();
                    view.drawMap();
                    break;
                case KeyEvent.VK_E:
                    game.pickUp("jaffa");
                    this.check();
                    view.drawMap();
                    break;
        }
        // figyeli, ha valtozik a jatekosok ZPM szama, es megvaltoztatja a panel aljan levo ZPM szamot
        view.setScoreOneillLabel(game.getPlayer("oneill").getZPMNumber());
        view.setScoreJaffaLabel(game.getPlayer("jaffa").getZPMNumber());
        // figyeli, hogy veget ert-e a jatek
        endGame();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    //Jatek veget vizsgalo fuggveny, eredmeny megjelenitese
    public boolean endGame() {
        //Ha mindket jatekos meghalt, jatek vege
        if (!game.getPlayer("oneill").isAlive() && !game.getPlayer("jaffa").isAlive()) {
            int result = JOptionPane.showConfirmDialog(null, "Sajnaljuk, elvesztettetek a jatekot! Szeretnetek ujat jatszani?", "Mindket jatekos meghalt", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) start();
            if (result == JOptionPane.NO_OPTION) System.exit(0);
            return true;
        }
        //Ha a kezdeti ZPM szambol kivonjuk a jatekosoknal levo ZPM-ek osszeget es 0-t kapunk, akkor jatek vege
        //Amelyik jatekos tobbet gyujtott, az nyert
        if ((game.getZPMNumber() - game.getPlayer("oneill").getZPMNumber() - game.getPlayer("jaffa").getZPMNumber()) == 0){
            if(game.getPlayer("oneill").getZPMNumber() > game.getPlayer("jaffa").getZPMNumber()) {
                int result = JOptionPane.showConfirmDialog(null, "Gratulalunk, Oneill megnyerte a jatekot! Szeretnel ujat jatszani?", "Felvettek az osszes ZPM-et", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    game.getPlayer("oneill").setZPMNumber(0);
                    game.getPlayer("jaffa").setZPMNumber(0);
                    start();
                }
                if (result == JOptionPane.NO_OPTION) System.exit(0);
            }else
            if(game.getPlayer("oneill").getZPMNumber() < game.getPlayer("jaffa").getZPMNumber()) {
                int result = JOptionPane.showConfirmDialog(null, "Gratulalunk, Jaffa megnyerte a jatekot! Szeretnel ujat jatszani?", "Felvettek az osszes ZPM-et", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    game.getPlayer("oneill").setZPMNumber(0);
                    game.getPlayer("jaffa").setZPMNumber(0);
                    start();
                }
                if (result == JOptionPane.NO_OPTION) System.exit(0);
            }else
            if(game.getPlayer("oneill").getZPMNumber() == game.getPlayer("jaffa").getZPMNumber()) {
                int result = JOptionPane.showConfirmDialog(null, "Gratulalunk, a jatek soran dontetlen szuletett, igy a jatekosok sikeresen hazajuthatnak! Szeretnel ujat jatszani?", "Felvettek az osszes ZPM-et", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    game.getPlayer("oneill").setZPMNumber(0);
                    game.getPlayer("jaffa").setZPMNumber(0);
                    start();
                }
                if (result == JOptionPane.NO_OPTION) System.exit(0);
            }
            return true;
        }
        else return false;
    }
}
