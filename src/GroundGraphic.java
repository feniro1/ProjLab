import java.awt.*;

/**
 * Created by Mate on 11/05/16.
 */
public class GroundGraphic implements Drawable{
    private String img;
    private Ground ground;

    public GroundGraphic(Ground g) {
        ground = g;
        img = "../images/ground.jpg";
    }



    @Override
    public void draw(Graphics graphics, int x, int y) {

    }
}
