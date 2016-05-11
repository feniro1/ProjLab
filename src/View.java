import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;

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
        JFrame window = new JFrame("Portal Game Liskovtheorem");
        panel = new JPanel();

        window.add(panel);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(100, 100, 800, 800);
        window.setVisible(true);
    }

    public void drawMap(){
        for(int i = 0; i < map.size(); i++) {
            for (int a = 0; a < row; a++)
                for(int b = 0; b < column; b++){
                    map.get(i).draw(a * 40, b * 40);
                }
        }
    }

    public void setList(MapElement fe, int r, int c){
        firstElement = fe;
        row = r;
        column = c;


    }
}
