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

    // konstruktor, mely hozzarendel egy ajto objektumot a az osztalyhoz
    public DoorGraphic(Door d){
        door = d;
        img = Images.instance.doorclosed;
    }

    // visszaadja az ajto allapotatol fuggoen milyen kepet rajzoljon ki
    public BufferedImage getImage(){
        if (door.itsOpened()) {
            img = Images.instance.doorOpened;
        } else if (!door.itsOpened()) {
            img = Images.instance.doorclosed;
        }
        return img;
    }


    // arraylist, mely tarolja az ajto felett rajzolt extra kepeket
    public ArrayList<BufferedImage> getExtraImages(){
        //megnezzuk van e rajta valaki
        ArrayList<BufferedImage> extraimages = new ArrayList<BufferedImage>();
        Player player =  door.getPlayer();
        // ha van rajta replikator hozzaadjuk az extrakepekhez
        if (door.hasReplicator()){
            try {
                BufferedImage zpm = ImageIO.read(new File("images/replicator.png"));
                extraimages.add(zpm);
            } catch (IOException e) {
            }
        }
        // ha van rajta player megvizsgaljuk melyik player es attol fuggoen merre nez kirajzoljuk
        if (player != null) {
            switch (player.getName()) {
                case "oneill":
                    BufferedImage oneill;
                    try {
                        // ha van nala doboz akkor dobozos playert rajzolunk ki
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
                // ugyanez jaffanal
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
                        extraimages.add(jaffa); // kezeljuk az exceptiont ha nincs kep
                    } catch (IOException e) {
                    }
                    break;
            }
        }
        // visszaadjuk az extrakepeket
        return extraimages;
    }
}
