import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mate on 11/05/16.
 */
public class WallGraphic implements Drawable {
    private String img;
    private Wall wall;

    public WallGraphic(Wall w){
        wall = w;
        img = "../images/wall.jpg";
    }

    @Override
    public void draw(ImagePanel imgpanel, int x, int y) {
        /*BufferedImage image = null;
        try {
            image = ImageIO.read(new File(img));
            imgpanel.paintOnMe(x, y, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/


        try {
            BufferedImage bi = ImageIO.read(new File(img));
            Graphics g = bi.getGraphics();
            g.drawImage(bi, x, y, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
