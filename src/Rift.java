
import java.util.*;


public class Rift extends MapElement {

    public Rift() {

    }

    public String symbol(){
        return "R";
    }

    // player ralepesenel meghal a player
    public boolean stepOn(Player player) {
        player.kill();
        return true;
    }

    // a replicator ralepesenel ground objektumra csereljuk ki a riftet
    public void replaceWithGround() {
        Ground g = new Ground();

        //beállítjuk az új ground szomszédjait a rift szomszédjai alapján
        g.setNeighbour(Direction.Down, this.getNextElement(Direction.Down));
        g.setNeighbour(Direction.Left, this.getNextElement(Direction.Left));
        g.setNeighbour(Direction.Up, this.getNextElement(Direction.Up));
        g.setNeighbour(Direction.Right, this.getNextElement(Direction.Right));

        //a rift szomszédainak szomszédait beállítjuk az új ground elemre
        this.getNextElement(Direction.Down).setNeighbour(Direction.Up,g);
        this.getNextElement(Direction.Right).setNeighbour(Direction.Left,g);
        this.getNextElement(Direction.Left).setNeighbour(Direction.Right,g);
        this.getNextElement(Direction.Up).setNeighbour(Direction.Down,g);

        this.setNeighbour(Direction.Down,null);
        this.setNeighbour(Direction.Up,null);
        this.setNeighbour(Direction.Left,null);
        this.setNeighbour(Direction.Right,null);

    }

    // ha ralep egy replicator megoljuk a replicatort
    public boolean stepOn(Replicator _rep) {
        _rep.killedByRift();
        return true;
    }


    // visszaadja, hogy lehet ra tenni, dobozt es a doboz megsemmisul
    public boolean putDown(Box b) {
        return true;
    }

}