import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mate on 11/05/16.
 */
public class ScaleGraphic implements Drawable {
    private Scale scale;
    private BufferedImage img;

    public ScaleGraphic(Scale s){
        scale = s;
        img = Images.instance.scale;

    }


    public BufferedImage getImage(){
        return img;
    }


    public ArrayList<BufferedImage> getExtraImages(){
        //megnezzuk van e rajta valaki
        ArrayList<BufferedImage> extraimages = new ArrayList<BufferedImage>();
        Player player =  scale.getPlayer();
        if (player != null) {
            //ha van akkor csinalunk egy extraimages listat es abba belerakjuk az elemeket
            //oneill jaffa, vagy doboz lehet rajta
            switch (player.getName()) {
                case "oneill":
                    BufferedImage oneill;
                    try {
                        oneill = ImageIO.read(new File("images/colonel.png"));
                        switch (player.getLookDirection()) {
                            case Up:
                                break;
                            case Right:
                                oneill = Images.instance.rotateToRight(oneill);
                                break;
                            case Left:
                                oneill = Images.instance.rotateToLeft(oneill);
                                break;
                            case Down:
                                oneill = Images.instance.rotateDown(oneill);
                        }
                        extraimages.add(oneill);
                    } catch (IOException e) {
                    }
                    break;
                case "jaffa":
                    BufferedImage jaffa;
                    try {
                        jaffa = ImageIO.read(new File("images/jaffa.png"));
                        switch (player.getLookDirection()) {
                            case Up:
                                break;
                            case Right:
                                jaffa = Images.instance.rotateToRight(jaffa);
                                break;
                            case Left:
                                jaffa = Images.instance.rotateToLeft(jaffa);
                                break;
                            case Down:
                                jaffa = Images.instance.rotateDown(jaffa);
                        }
                        extraimages.add(jaffa);
                    } catch (IOException e) {
                    }
                    break;
            }
        }
        if (scale.hasBox() == true){
            try {
                BufferedImage box = ImageIO.read(new File("images/box.png"));
                extraimages.add(box);
            } catch (IOException e) {
            }
        }
        return extraimages;
    }
}
