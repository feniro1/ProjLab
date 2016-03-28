
import java.util.*;


public class Scale extends MapElement {
    

    public Box box;
    public Door door;


    public Scale() {

    }


    public void removeBox() {
       box = null;
    }


    public void createBox() {
        box = new Box();
    }


    public boolean stepOn(Colonel colonel) {
        if(box == null)
            return true;
        else
            return false;
    }

    public Box pickUp() {
        Box boxtemp = new Box();
        box = null;
        return boxtemp;
    }


    public boolean putDown(Box b) {
       if (box == null){
           box = b;
           return true;
       }
       else
           return false;
    }

}