import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mate on 11/05/16.
 */
public class RiftGraphic implements Drawable {
    private Rift rift;
    BufferedImage img;

    public RiftGraphic(Rift r){
        rift = r;
        img = Images.instance.rift;

    }
    public BufferedImage getImage(){
        return img;
    }

    public ArrayList<BufferedImage> getExtraImages(){
        return null;
    }
}
