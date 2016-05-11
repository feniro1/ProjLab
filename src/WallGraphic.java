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
        img = "wall.jpg";
    }

    @Override
    public void draw(Graphics graphics, int x, int y) {
        try {
            BufferedImage bi = ImageIO.read(new File(img));
            graphics.drawImage(bi, x, y, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
