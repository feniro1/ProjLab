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
        img = "images/wall.jpg";
    }

    @Override
    public void draw(Graphics2D graphics, int x, int y) {
        try {
//            BufferedImage bi = ImageIO.read(new File(img));
//            BufferedImage toPaint = convertToARGB(bi);
//            graphics.drawImage(toPaint, x, y, null);

            //prepare a original Image source
            Image image = ImageIO.read(new File(img));

            //Get current GraphicsConfiguration
            GraphicsConfiguration graphicsConfiguration = graphics.getDeviceConfiguration();

            //Create a Compatible BufferedImage
            BufferedImage bufferedImage = graphicsConfiguration.createCompatibleImage(image.getWidth(null), image.getHeight(null));
            //Copy from original Image to new Compatible BufferedImage
            Graphics tempGraphics = bufferedImage.getGraphics();
            tempGraphics.drawImage(image, x, y, null);
            tempGraphics.dispose();


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
