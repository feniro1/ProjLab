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

    //visszaad egy hozza tartozo graphics objektumot
    public SpecialWallGraphic(SpecialWall sw){
        specialWall = sw;
        img = Images.instance.specialwall;

    }


    public BufferedImage getImage(){
        return img;
    }

    //Ide jonnek a playerek meg a portalok vagy dobozok amiket az alap kepre ra kell rajzolni
    public ArrayList<BufferedImage> getExtraImages(){
        //megnezzuk van e rajta valaki
        ArrayList<BufferedImage> extraimages = new ArrayList<BufferedImage>();

        WormHole wh = specialWall.getWormhole();
        try {
            if (wh.getThisPortal(Direction.Down, specialWall) != null) {
                Portal p = wh.getThisPortal(Direction.Down, specialWall);
                switch (p.getColor()) {
                    case Blue: extraimages.add(Images.instance.rotateDown(ImageIO.read(new File("images/blueportal.png"))));
                        break;
                    case Yellow: extraimages.add(Images.instance.rotateDown(ImageIO.read(new File("images/yellowportal.png"))));
                        break;
                    case Red: extraimages.add(Images.instance.rotateDown(ImageIO.read(new File("images/redportal.png"))));
                        break;
                    case Green: extraimages.add(Images.instance.rotateDown(ImageIO.read(new File("images/greenportal.png"))));
                        break;
                }
            }
            if (wh.getThisPortal(Direction.Right, specialWall) != null) {
                Portal p = wh.getThisPortal(Direction.Right, specialWall);
                switch (p.getColor()) {
                    case Blue: extraimages.add(Images.instance.rotateToRight(ImageIO.read(new File("images/blueportal.png"))));
                        break;
                    case Yellow: extraimages.add(Images.instance.rotateToRight(ImageIO.read(new File("images/yellowportal.png"))));
                        break;
                    case Red: extraimages.add(Images.instance.rotateToRight(ImageIO.read(new File("images/redportal.png"))));
                        break;
                    case Green: extraimages.add(Images.instance.rotateToRight(ImageIO.read(new File("images/greenportal.png"))));
                        break;
                }
            }
            if (wh.getThisPortal(Direction.Left, specialWall) != null) {
                Portal p = wh.getThisPortal(Direction.Left, specialWall);
                switch (p.getColor()) {
                    case Blue: extraimages.add(Images.instance.rotateToLeft(ImageIO.read(new File("images/blueportal.png"))));
                        break;
                    case Yellow: extraimages.add(Images.instance.rotateToLeft(ImageIO.read(new File("images/yellowportal.png"))));
                        break;
                    case Red: extraimages.add(Images.instance.rotateToLeft(ImageIO.read(new File("images/redportal.png"))));
                        break;
                    case Green: extraimages.add(Images.instance.rotateToLeft(ImageIO.read(new File("images/greenportal.png"))));
                        break;
                }
            }
            if (wh.getThisPortal(Direction.Up, specialWall) != null) {
                Portal p = wh.getThisPortal(Direction.Up, specialWall);
                switch (p.getColor()) {
                    case Blue: extraimages.add(ImageIO.read(new File("images/blueportal.png")));
                        break;
                    case Yellow: extraimages.add(ImageIO.read(new File("images/yellowportal.png")));
                        break;
                    case Red: extraimages.add(ImageIO.read(new File("images/redportal.png")));
                        break;
                    case Green: extraimages.add(ImageIO.read(new File("images/greenportal.png")));
                        break;
                }
            }

        } catch (IOException e) {

        }
        return extraimages;
    }


}
