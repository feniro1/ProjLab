/**
 * Created by Mate on 11/05/16.
 */
public class DoorGraphic implements Drawable {
    private String img;
    private Door door;

    public DoorGraphic(Door d){
        door = d;
        img = "../images/doorclosed.jpg";
    }

    @Override
    public void draw(int x, int y) {

    }
}
