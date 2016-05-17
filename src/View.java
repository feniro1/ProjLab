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
    private JLabel scoreOneillLabel;
    private JLabel scoreJaffaLabel;

    public View(Controller cont) {
        super();

        controller = cont;
        //Ablak, lista, panel inicializalasa
        map = new ArrayList<Drawable>();
        this.setTitle("Portal Game Liskovtheorem");
        this.addKeyListener(controller);

        //Ablak parametereinek beallitasa
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 844, 877);
        setLayout(new BorderLayout());

        //a jatek jelenlegi allasanak kiirasa
        scoreOneillLabel = new JLabel("   0");
        scoreJaffaLabel = new JLabel("   0");
        JLabel nameOneillLabel = new JLabel("      Oneill:");
        JLabel nameJaffaLabel = new JLabel("        Jaffa:");
        JLabel splitterLabel = new JLabel("                ");

        //szovegek szinenek beallitasa
        scoreOneillLabel.setForeground(new Color(230, 200, 0));
        scoreJaffaLabel.setForeground(new Color(0, 200, 0));
        nameOneillLabel.setForeground(new Color(230, 200, 0));
        nameJaffaLabel.setForeground(new Color(0, 200, 0));
        splitterLabel.setForeground(Color.WHITE);

        //szovegek betutipusanak beallitasa
        Font font = new Font("Roboto", Font.BOLD, 30);
        scoreOneillLabel.setFont(font);
        scoreJaffaLabel.setFont(font);
        nameOneillLabel.setFont(font);
        nameJaffaLabel.setFont(font);
        splitterLabel.setFont(font);

        //panelek letrehozasa
        JPanel northPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel southPanel = new JPanel();

        //panelek hatterszinenek beallitasa
        northPanel.setBackground(new Color(70, 10, 20));
        westPanel.setBackground(new Color(70, 10, 20));
        eastPanel.setBackground(new Color(70, 10, 20));
        southPanel.setBackground(new Color(70, 10, 20));

        //keret letrehozasa
        northPanel.add(new JLabel("   "));
        westPanel.add(new JLabel("   "));
        eastPanel.add(new JLabel("   "));

        //eredmenytablazathoz gridlayout beallitasa
        southPanel.setLayout(new GridLayout(1, 5));

        //eredmenytablazat gridlayoutjaba a panelek hozzaadasa
        southPanel.add(nameOneillLabel);
        southPanel.add(scoreOneillLabel);
        southPanel.add(splitterLabel);
        southPanel.add(nameJaffaLabel);
        southPanel.add(scoreJaffaLabel);

        //jatekter letrehozasa
        screen = new Screen();
        screen.setBounds(0, 0, 800, 800);

        //fo ablak reszeinek hozzaadasa
        add(northPanel, BorderLayout.NORTH);
        add(westPanel, BorderLayout.WEST);
        add(eastPanel, BorderLayout.EAST);
        add(screen, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        //fo ablak megjelenitese
        this.setVisible(true);
    }

    //a ZPM szam kiiratasahoz setter a label-re
    public void setScoreOneillLabel(int s){
        scoreOneillLabel.setText("   " + Integer.toString(s));
    }

    //a ZPM szam kiiratasahoz setter a label-re
    public void setScoreJaffaLabel(int s){
        scoreJaffaLabel.setText("   " + Integer.toString(s));
    }

    public void drawMap(){
        //panelnek atadjuk az adatokat
        screen.setData(column, map);
        //utana repaint: ez automatikusan a jpanel paint fuggvenyet hivja ujra
        screen.repaint();
    }

    //megvizsgalja milyen elemekbol all a palya, es az alapjan a megfelelo osztalyok graphics oszytalyok objektumaival tolti fel a listat
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
}
