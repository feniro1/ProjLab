
import java.util.*;

/**
 * 
 */
public class WormHole {

    private Portal yportal;
    private Portal bportal;

    public WormHole() {

    }
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
        System.out.println("Létrejött egy sárga portál.");
    }

    public void setBPortal(Direction dir, SpecialWall swall){
        bportal.getSpecWall().setBPortal(null);
        bportal.setDirection(dir);
        bportal.setSpecWall(swall);
        System.out.println("Létrejött egy kék portál.");
    }

    public Portal getYPortal() {
        return yportal;
    }

    public Portal getBPortal() {
        return bportal;
    }

}