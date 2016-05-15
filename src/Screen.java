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
    //o rajzol ki, azert csintam kulon osztalyt mert jpanel-paint fuggvenyet kellett atirni
    private ArrayList<Drawable> maplist = new ArrayList<Drawable>();
    private int column;

    public Screen(){
    }
    //kell neki a drawable lista meg az oszlopok szama
    public void setData(int column, ArrayList<Drawable> maplist) {
        this.column = column;
        this.maplist = maplist;
    }

    public void paint(Graphics g){
        int i = 0;
        while(i < maplist.size()){
            int x = i%column;
            int y = i/column;

            //lekeri az adott elem kepet, majd
            g.drawImage(maplist.get(i).getImage(), x * 40, y * 40, null);
            //megkerdezi vannak e rajta meg extra elemek (ez egy listat ad vissza)
            ArrayList<BufferedImage> extraimages = maplist.get(i).getExtraImages();
            //ha vannak extra elemek akkor azokon vegigmegy es ugyanoda egymasra rajzolja a png-ket
            if (extraimages != null){
                for(int j = 0; j < extraimages.size(); j++){
                    g.drawImage(extraimages.get(j), x * 40, y * 40, null);
                }

            }

            i++;
        }

    }
}
