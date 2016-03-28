
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 */
public class GameEngine {

    /**
     * Default constructor
     */
    public GameEngine() {
    }

    /**
     * 
     */
    public Colonel oneill;

    /**
     * 
     */
    public WormHole wormhole;

    /**
     * 
     */
    public MapElement firstElement;



    public GameEngine(Colonel _oneill, WormHole _wh){
        oneill = _oneill;
        wormhole = _wh;
    }


    /**
     * 
     */
    public void startGame() {

        System.out.println("Udvozlunk a LiskovTheorem Oneill's Adventure nevu jatekaban!");
        System.out.println("Kerlek valassz egy tesztesetet!");
        System.out.println();
        System.out.println("0: Oneill ralep egy talajelemre");
        System.out.println("1: Oneill lelep egy merlegrol");
        System.out.println("2: Oneill nekimegy egy nyitott ajtonak");
        System.out.println("3: Oneill szakadekba lep");
        System.out.println("4: Oneill ralep egy merlegre");
        System.out.println("5: Oneill falnak megy");
        System.out.println("6: Oneill felvesz egy dobozt a talajrol");
        System.out.println("7: Oneill felvesz egy dobozt a merlegrol");
        System.out.println("8: Oneill letesz egy dobozt a talajra");
        System.out.println("9: Oneill letesz egy dobozt a merlegre");
        System.out.println("10: Oneill beletesz egy dobozt a szakadekba");
        System.out.println("11: Oneill specialis falra lo");
        System.out.println("12: Oneill belemegy a fereglyukba");
        System.out.println();
        System.out.println("Valasztott teszteset: ");

        Scanner s = new Scanner(System.in);
        String i = s.nextLine();

        switch (i) {
            //movement on ground
            case "0":
                oneill.move(Direction.Up);
                break;
            //movement from scale
            case "1":
                oneill.move(Direction.Up);
                break;
            //movement to door
            case "2":
                oneill.move(Direction.Up);
                break;
            //movement to rift
            case "3":
                oneill.move(Direction.Up);
                break;
            //movement to scale
            case "4":
                oneill.move(Direction.Up);
                break;
            //movement to wall
            case "5":
                oneill.move(Direction.Up);
                break;
            //pick up box from ground
            case "6":
                oneill.pickUp();
                break;
            //pick up box from scale
            case "7":
                oneill.pickUp();
                break;
            //put down box to ground
            case "8":
                oneill.putDown();
                break;
            //put down box to scale
            case "9":
                oneill.putDown();
                break;
            //put down box to rift
            case "10":
                oneill.putDown();
                break;
            //shoot bullet
            case "11":
                oneill.shoot(Color.Yellow);
                break;
            //walk into wormhole
            case "12":
                oneill.move(Direction.Up);
                break;

        }

    }

    /**
     * @param f
     */
   // public void loadMap(File f) {
        // TODO implement here
   // }

    /**
     * 
     */
    public void setNeighbours() {
        // TODO implement here
    }

}