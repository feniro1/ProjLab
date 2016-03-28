
import java.io.Console;

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
        // TODO implement here

        Console c = System.console();

        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }


        String i = c.readLine();

        switch (i){
            //movement on ground
            case "0":
                oneill.move(Direction.Up);
                break;
            //movement from scale
            case "1":
                oneill.move(Direction.Up);
                break;

            case "2":
                oneill.move(Direction.Up);
                break;

            case "3":
                oneill.move(Direction.Up);
                break;

            case "4":
                oneill.move(Direction.Up);
                break;

            case "5":
                oneill.move(Direction.Up);
                break;

            case "6":
                oneill.pickUp();
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