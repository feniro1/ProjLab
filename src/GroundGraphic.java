import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mate on 11/05/16.
 */
public class GroundGraphic implements Drawable{
    private String img;
    private Ground ground;

    public GroundGraphic(Ground g) {
        ground = g;
        img = "images/ground.jpg";
    }

    public void draw(Graphics2D graphics, int x, int y) {
        try {
            BufferedImage bi = ImageIO.read(new File(img));
            graphics.drawImage(bi, x, y, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
