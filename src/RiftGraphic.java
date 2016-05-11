import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mate on 11/05/16.
 */
public class RiftGraphic implements Drawable {
    private String img;
    private Rift rift;

    public RiftGraphic(Rift r){
        rift = r;
        img = "images/rift.jpg";
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
