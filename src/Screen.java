import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Fanni on 15/05/16.
 */
public class Screen extends JPanel {

    private ArrayList<Drawable> maplist = new ArrayList<Drawable>();
    private int column;

    public Screen(){
    }

    public void setData(int column, ArrayList<Drawable> maplist) {
        this.column = column;
        this.maplist = maplist;
    }

    public void paint(Graphics g){
        int i = 0;
        while(i < maplist.size()){
            int x = i%column;
            int y = i/column;

            g.drawImage(maplist.get(i).getImage(), x * 40, y * 40, null);
            ArrayList<BufferedImage> abc = maplist.get(i).getExtraImages();
            if (abc != null){
                for(int j = 0; j < abc.size(); j++){
                    g.drawImage(abc.get(j), x * 40, y * 40, null);
                }

            }

            i++;
        }

    }
}
