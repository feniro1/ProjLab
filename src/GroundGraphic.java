import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mate on 11/05/16.
 */
public class GroundGraphic implements Drawable {
    private String img;
    private Ground ground;

    public GroundGraphic(Ground g) {
        ground = g;
        img = "images/ground.jpg";
    }

    public void draw(Graphics2D graphics, int x, int y) {
        try {
            BufferedImage bi = ImageIO.read(new File(img));
            BufferedImage toPaint = convertToARGB(bi);
            graphics.drawImage(toPaint, x, y, null);

            if(ground.getPlayer() != null){
                if(ground.getPlayer().getName().equals("oneill")){
                    BufferedImage oneilim = ImageIO.read(new File("images/colonel.png"));
                    BufferedImage toPaint2 = convertToARGB(oneilim);
                    graphics.drawImage(toPaint2, x, y, null);
                }
                if(ground.getPlayer().getName().equals("jaffa")){
                    BufferedImage oneilim = ImageIO.read(new File("images/jaffa.png"));
                    BufferedImage toPaint3 = convertToARGB(oneilim);
                    graphics.drawImage(toPaint3, x, y, null);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage convertToARGB(BufferedImage image)
    {
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }
}
