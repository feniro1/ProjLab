import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mate on 11/05/16.
 */
public class DoorGraphic implements Drawable {
    private Door door;
    private BufferedImage img;

    public DoorGraphic(Door d){
        door = d;

        img = Images.instance.doorclosed;
    }

    @Override
    public void draw(Graphics2D graphics, int x, int y) {

    }

    public BufferedImage getImage(){
        //Itt forgatas vagy kepcsere
        return img;
    }

    public ArrayList<BufferedImage> getExtraImages(){
        return null;
    }
}
