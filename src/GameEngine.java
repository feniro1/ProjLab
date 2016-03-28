
import java.io.*;
import java.util.*;

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
    public void loadMap(File f) {
         // TODO implement here

    }

    /**
     * 
     */
    public void setNeighbours() {
        // TODO implement here
    }

}