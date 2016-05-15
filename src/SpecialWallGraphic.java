import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mate on 11/05/16.
 */
public class SpecialWallGraphic implements Drawable {
    private SpecialWall specialWall;
    BufferedImage img;

    public SpecialWallGraphic(SpecialWall sw){
        specialWall = sw;
        img = Images.instance.specialwall;

    }


    public BufferedImage getImage(){
        return img;
    }

    //Ide jonnek a playerek meg a portalok vagy dobozok amiket az alap kepre ra kell rajzolni
    public ArrayList<BufferedImage> getExtraImages(){
        return null;
    }


}
