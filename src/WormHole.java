
import java.util.*;

/**
 * 
 */
public class WormHole {

    public WormHole() {
        yportal = new Portal();
        bportal = new Portal();
    }

    public Portal yportal;
    public Portal bportal;

/*
    public void setYPortal(Bullet bull) {
        // TODO implement here
    }

    public void setBPortal(Bullet bull) {
        // TODO implement here
    }
*/
    public void setYportal(Direction dir, SpecialWall swall){
        yportal.getSpecWall().yport = null;
        yportal.setDirection(dir);
        yportal.setSpecWall(swall);
    }

    public void setBportal(Direction dir, SpecialWall swall){
        bportal.getSpecWall().bport = null;
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