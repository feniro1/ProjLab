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
        ArrayList<BufferedImage> extraimages = new ArrayList<BufferedImage>();
        Player player =  ground.getPlayer();
        if (ground.hasReplicator()){
            try {
                BufferedImage zpm = ImageIO.read(new File("images/replicator.png"));
                extraimages.add(zpm);
            } catch (IOException e) {
            }
        }
        if (player != null) {
            //ha van akkor csinalunk egy extraimages listat es abba belerakjuk ay elemeket
            //ez igy meg nem szem mert mindenfelere le kell majd kezelni TODO
            //csak probakent raktam ra oneill meg jaffa van eddig kezelve :(
            switch (player.getName()) {
                case "oneill":
                    BufferedImage oneill;
                    try {
                        if(!player.hasBox()) {
                            oneill = ImageIO.read(new File("images/colonel.png"));
                        } else {
                            oneill = ImageIO.read(new File("images/colonelwithbox.png"));
                        }
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
                        if(!player.hasBox()) {
                            jaffa = ImageIO.read(new File("images/jaffa.png"));
                        } else {
                            jaffa = ImageIO.read(new File("images/jaffawithbox.png"));
                        }
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
            if (ground.hasBox() == true){
                try {
                    BufferedImage box = ImageIO.read(new File("images/box.png"));
                    extraimages.add(box);
                } catch (IOException e) {
                }
            }
            if (ground.hasZPM() == true){
                try {
                    BufferedImage zpm = ImageIO.read(new File("images/zpm.png"));
                    extraimages.add(zpm);
                } catch (IOException e) {
                }
            }

            return extraimages;
    }
}
