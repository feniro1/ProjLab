import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mate on 11/05/16.
 */
public class GroundGraphic implements Drawable {
   // private String img;
    private Ground ground;
    private BufferedImage img;

    public GroundGraphic(Ground g) {
        ground = g;

        img = Images.instance.ground;

    }

    public BufferedImage getImage(){
        return img;
    }

    //Ide jonnek a playerek meg a portalok vagy dobozok amiket az alap kepre ra kell rajzolni
    public ArrayList<BufferedImage> getExtraImages(){
        //megnezzuk van e rajta valaki
        Player player =  ground.getPlayer();
        if (player != null){
            //ha van akkor csinalunk egy extraimages listat es abba belerakjuk ay elemeket
            //ez igy meg nem szem mert mindenfelere le kell majd kezelni TODO
            //csak probakent raktam ra oneill meg jaffa van eddig kezelve :(
            ArrayList<BufferedImage> extraimages = new ArrayList<BufferedImage>();
            switch (player.getName()){
                case "oneill":
                    BufferedImage oneill;
                    try {
                        oneill = ImageIO.read(new File("images/oneill.png"));
                        extraimages.add(oneill);
                    } catch (IOException e) {
                    }
                    break;
                case "jaffa":
                    BufferedImage jaffa;
                    try {
                        jaffa = ImageIO.read(new File("images/jaffa.png"));
                        extraimages.add(jaffa);
                    } catch (IOException e) {
                    }
                    break;
            }
            return extraimages;
        }
        return null;
    }
}
