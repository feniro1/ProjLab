
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Mate on 11/05/16.
 */
public class WallGraphic implements Drawable {
    private Wall wall;
    BufferedImage img;

    //konstruktor, kep es a falelem beallitasa
    public WallGraphic(Wall w){
        wall = w;

        img = Images.instance.wall;

    }

    public BufferedImage getImage(){
        return img;
    }

    //nem lehet rajta extra image
    public ArrayList<BufferedImage> getExtraImages(){
        return null;
    }
}
