/**
 * Created by Mate on 11/05/16.
 */
public class WallGraphic implements Drawable {
    private String img;
    private Wall wall;

    public WallGraphic(Wall w){
        wall = w;
        img = "../images/wall.jpg";
    }

    @Override
    public void draw(int x, int y) {

    }
}
