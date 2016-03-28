
import java.util.*;

/**
 * 
 */
public class WormHole {

    public WormHole() {

    }

    private Portal yportal;
    private Portal bportal;

/*
    public void setYPortal(Bullet bull) {
        // TODO implement here
    }

    public void setBPortal(Bullet bull) {
        // TODO implement here
    }
*/
    public void setYPortal(Direction dir, SpecialWall swall){
        yportal.getSpecWall().setYPortal(null);
        yportal.setDirection(dir);
        yportal.setSpecWall(swall);
    }

    public void setBPortal(Direction dir, SpecialWall swall){
        bportal.getSpecWall().setBPortal(null);
        bportal.setDirection(dir);
        bportal.setSpecWall(swall);
    }

    public Portal getYPortal() {
        return yportal;
    }

    public Portal getBPortal() {
        return bportal;
    }

}