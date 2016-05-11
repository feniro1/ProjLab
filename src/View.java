import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Mate on 11/05/16.
 */
public class View {
    private MapElement firstElement;
    private int row;
    private int column;
    private JPanel panel;
    private ArrayList<Drawable> map;

    public View() {
        //Ablak, lista, panel inicializalasa
        map = new ArrayList<Drawable>();
        JFrame window = new JFrame("Portal Game Liskovtheorem");
        panel = new JPanel();

        //Panel hozzaadasa
        window.add(panel);

        //Ablak parametereinek beallitasa
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(100, 100, 800, 822);
        window.setVisible(true);
    }

    //Terkep kirajzolasa, ez geci lassu, de mukodik.. TODO
    public void drawMap(){
        //Panel graphics lekerese
        Graphics2D gr = (Graphics2D) panel.getGraphics();

        //A lista elemeinek bejarasa
        int i = 0;
        while(i < map.size()){
            //Dupla for ciklussal a terkep kirajzolasa a megadott koordinatakra
            for (int a = 0; a < row; a++)
                for (int b = 0; b < column; b++) {
                    map.get(i).draw(gr, b * 40, a * 40);
                    i++;
                }
        }
    }

    //ez hibatlanul mukodik, ne bazd el
    public void setList(MapElement fe, int r, int c){
        firstElement = fe;
        MapElement tmp = fe;
        row = r;
        column = c;

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
