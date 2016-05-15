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
    //private String img;
    private Rift rift;
    BufferedImage img;

    public RiftGraphic(Rift r){
        rift = r;
        //img = "images/rift.jpg";
        try {
            img = ImageIO.read(new File("images/rift.jpg"));
        } catch (IOException e) {
        }
    }

    @Override
    public void draw(Graphics2D graphics, int x, int y) {

    }

    public BufferedImage getImage(){
        return img;
    }

    public ArrayList<BufferedImage> getExtraImages(){
        return null;
    }
}
