import java.awt.*;

/**
 * Created by Mate on 11/05/16.
 */
public class SpecialWallGraphic implements Drawable {
    private String img;
    private SpecialWall specialWall;

    public SpecialWallGraphic(SpecialWall sw){
        specialWall = sw;
        img = "../images/specialwall.jpg";
    }

    @Override
    public void draw(Graphics graphics, int x, int y) {

    }
}
