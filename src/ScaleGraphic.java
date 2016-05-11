/**
 * Created by Mate on 11/05/16.
 */
public class ScaleGraphic implements Drawable {
    private String img;
    private Scale scale;

    public ScaleGraphic(Scale s){
        scale = s;
        img = "../images/scale.jpg";
    }

    @Override
    public void draw(int x, int y) {

    }
}
