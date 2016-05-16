import com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_zh_CN;

import javax.imageio.ImageIO;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Mate on 11/05/16.
 */
public class View extends JFrame {
    private MapElement firstElement;
    private int row;
    private int column;
    private Screen screen;
    private ArrayList<Drawable> map;
    private Controller controller;

    public View(Controller cont) {
        super();
        //keylistener beallitasahoz szukseges
        controller = cont;
        //Ablak, lista, panel inicializalasa
        map = new ArrayList<Drawable>();
        this.setTitle("Portal Game Liskovtheorem");
        this.addKeyListener(controller);

        //Ablak parametereinek beallitasa
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 950, 820);
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        //Kepernyo es panel hozzaadasa
        screen = new Screen();
        screen.setBounds(0, 0, 800, 820);

        JPanel resultPanel = new JPanel();
        resultPanel.setBounds(800, 0, 150, 820);
        resultPanel.setBackground(Color.YELLOW);
        resultPanel.setLayout(new GridLayout(6, 1, 0, 0));

        JLabel oLbl = new JLabel("Oneill");
        oLbl.setSize(50, 50);

        resultPanel.add(oLbl);

        this.add(screen);
        this.add(resultPanel);
    }

    public void drawMap(){
        //panelnek atadjuk az adatokat
        screen.setData(column, map);
        //utana repaint: ez automatikusan a jpanel paint fuggvenyet hivja ujra
        screen.repaint();
    }

    //ez hibatlanul mukodik, ne bazd el
    public void setList(MapElement fe, int r, int c){
        firstElement = fe;
        MapElement tmp = fe;
        row = r;
        column = c;

        map.clear();
        for (int i = 0; i < row; i ++){
            map.add(fe.getDrawableClass());
            for (int j = 0; j < column - 1; j++) {
                fe = fe.getNextElement(Direction.Right);
                map.add(fe.getDrawableClass());
            }
            fe = tmp.getNextElement(Direction.Down);
            tmp = fe;
        }
    }

    //Ideiglenes
    public void close() {
        this.remove(screen);
    }
}
