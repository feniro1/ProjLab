import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Mate on 11/05/16.
 */
public interface Drawable {

    //alap kep lekerese
    BufferedImage getImage();

    //extra kepek lekerese listaban, mint portal, jaffa, oneill, box meg ezek...
    ArrayList<BufferedImage> getExtraImages();
}
