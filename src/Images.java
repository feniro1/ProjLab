import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Fanni on 15/05/16.
 */
public class Images {

    public static Images instance = new Images();
    public BufferedImage ground;
    public BufferedImage doorclosed;
    public BufferedImage rift;
    public BufferedImage scale;
    public BufferedImage specialwall;
    public BufferedImage wall;

    protected Images() {
        // Exists only to defeat instantiation.
        try {
            ground = ImageIO.read(new File("images/ground.jpg"));
            doorclosed = ImageIO.read(new File("images/doorclosed.jpg"));
            rift = ImageIO.read(new File("images/rift.jpg"));
            scale = ImageIO.read(new File("images/scale.jpg"));
            specialwall= ImageIO.read(new File("images/specialwall.jpg"));
            wall = ImageIO.read(new File("images/wall.jpg"));
        } catch (IOException e) {
        }
    }

}



