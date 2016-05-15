import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Mate on 11/05/16.
 */
public interface Drawable {
    void draw(Graphics2D graphics, int x, int y);

    BufferedImage getImage();

    ArrayList<BufferedImage> getExtraImages();
}
