
import javax.swing.*;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;


public class GameEngine {

    private Player oneill;
    private Player jaffa;
    private Replicator replicator;
    private WormHole wormhole;
    private MapElement firstElement;
    private int row;
    private int column;
    private Controller controller;
    private boolean reloadMap;
    private int ZPMNumber;
    private boolean addedZPM;

    public GameEngine(Controller cont){
        oneill = new Player("oneill");
        jaffa = new Player("jaffa");
        replicator = new Replicator();
        wormhole = new WormHole();
        controller = cont;
        reloadMap = false;
        ZPMNumber = 0;
        addedZPM = true;
    }


    public void resetReloadMap(){
        reloadMap = false;
    }

    public boolean getReloadMap(){
        return reloadMap;
    }

    public void check(){
        if(replicator.isKilledByRift() == true){
            reloadMap = true;
            replicator.resetKilledByRift();

        }
    }

    public void move(String name, Direction dir) {

        if ((name.equals("oneill")) && oneill.isAlive()){
            oneill.move(dir);
            if(replicator!=null) {
                if (replicator.isAlive()) {
                    replicator.move(dir);
                }
            }
        }
        else if (name.equals("jaffa") && jaffa.isAlive()){
            jaffa.move(dir);
            if(replicator!=null) {
                if (replicator.isAlive()) {
                    replicator.move(dir);
                }
            }
        }
        zpmGenerator();
    }

    public void shoot(String name, Color col) {
        if (name.equals("oneill") && oneill.isAlive()){
            oneill.shoot(col);
        }
        else if (name.equals("jaffa") && jaffa.isAlive()){
            jaffa.shoot(col);
        }

    }

    public void pickUp(String name) {
        if (name.equals("oneill") && oneill.isAlive()) {
            if (oneill.hasBox()) {
                oneill.putDown();
            } else {
                oneill.pickUp();
            }
        } else if (name.equals("jaffa") && jaffa.isAlive()) {
            if (jaffa.hasBox()) {
                jaffa.putDown();
            } else {
                jaffa.pickUp();
            }
        }
    }

    public void turn(String name){
        if (name.equals("oneill") && oneill.isAlive()){
            oneill.turn();
        }
        else if (name.equals("jaffa") && jaffa.isAlive()){
            jaffa.turn();
        }
    }

    public int getZPMNumber(){
        return ZPMNumber;
    }

    public void zpmGenerator() {
        int collectedZPM = oneill.getZPMNumber() + jaffa.getZPMNumber();
        if((collectedZPM > 0) && (collectedZPM % 2 == 0) && !addedZPM) {
            addedZPM = true;
            int countPlacesWhereToPut = 0;
            MapElement firstRowElement = firstElement;
            MapElement actualElement = firstElement;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (actualElement.isGround) {
                        Ground g = (Ground) actualElement;
                        if ((!g.hasZPM()) && (!g.hasReplicator()) && (!g.hasBox()) && (!g.hasPlayer())) {
                            countPlacesWhereToPut++;
                        }
                    }
                    actualElement = actualElement.getNextElement(Direction.Right);
                }
                firstRowElement = firstRowElement.getNextElement(Direction.Down);
                actualElement = firstRowElement;
            }
            firstRowElement = firstElement;
            actualElement = firstElement;
            int random = (int) (Math.random() * countPlacesWhereToPut + 1);
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (actualElement.isGround  ) {
                        Ground g = (Ground) actualElement;
                        if ((!g.hasZPM()) && (!g.hasReplicator()) && (!g.hasBox()) && (!g.hasPlayer())) {
                            random--;
                            if (random == 0) {
                                g.setZPM();
                                ZPMNumber++;
                                return;
                            }

                        }
                    }
                    actualElement = actualElement.getNextElement(Direction.Right);
                }
                firstRowElement = firstRowElement.getNextElement(Direction.Down);
                actualElement = firstRowElement;
            }
        } else {
            if ((collectedZPM % 2 == 1) && addedZPM) addedZPM = false;
        }

    }

    public MapElement getFirstElement() {
        return firstElement;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean hasToReloadMap() {
        return reloadMap;
    }

    //Fajlbol betolti, es letrehozza a mapelementeket
    public void loadMap() throws IOException {
        //A tesztesettol fuggoen betolti a megfelelo txt file-t
        FileReader fr = new FileReader("map.txt");
        BufferedReader br = new BufferedReader(fr);
        // Az elso ket sora a textnek a sor-, es oszlopszam
        row = Integer.parseInt(br.readLine());
        column = Integer.parseInt(br.readLine());
        int thisLine = 0;
        //Letrehozza az ideiglenes segedmatrixot
        MapElement table[][] = new MapElement[row][column];
        //Az ajtokat es merlegeket kulon listaban taroljuk a paroztatas miatt
        Door[] doors = new Door[10];
        Scale[] scales = new Scale[10];
        Door[] odoors = new Door[10];
        Scale[] oscales = new Scale[10];
        int db = 0;
        int odb = 0;
        //Vegigfutunk a fajlon es letrehozzuk a megfelelo mapelementeket es eltaroljuk a matrixban
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                thisLine = Integer.parseInt(br.readLine());
                switch (thisLine) {
                    //Letrehoz egy talaj elemet
                    case 1:
                        table[i][j] = new Ground();
                        break;
                    //Letrehoz egy talaj elemet egy ZPM-mel
                    case 2:
                        ZPM z = new ZPM();
                        ZPMNumber++;
                        table[i][j] = new Ground(z);
                        break;
                    //Letrehoz egy talaj elemet egy dobozzal
                    case 3:
                        Box b = new Box(1);
                        table[i][j] = new Ground(b);
                        break;
                    //Letrehoz egy talaj elemet rajta O'Neill-lel
                    case 4:
                        table[i][j] = new Ground();
                        oneill.setBaseElement(table[i][j]);
                        table[i][j].setPlayer(oneill);
                        break;
                    //Letrehoz egy talaj elemet rajta Jaffa-val
                    case 5:
                        table[i][j] = new Ground();
                        jaffa.setBaseElement(table[i][j]);
                        table[i][j].setPlayer(jaffa);
                        break;
                    //Letrehoz egy talaj elemet rajta Replicator-ral
                    case 6:
                        table[i][j] = new Ground();
                        replicator.setBaseElement(table[i][j]);
                        table[i][j].setReplicator(replicator);
                        break;
                    //Letrehoz egy szakadek elemet
                    case 7:
                        table[i][j] = new Rift();
                        break;
                    //Letrehoz egy fal elemet
                    case 8:
                        table[i][j] = new Wall();
                        break;
                    //Letrehoz egy kulonleges falat
                    case 9:
                        SpecialWall sw1 = new SpecialWall(wormhole);
                        sw1.isSpecWall = true;
                        table[i][j] = sw1;
                        break;
                    //Letrehoz egy merleget rajta O'Neillel
                    case 501:
                        Scale s1 = new Scale(1);
                        s1.isScale = true;
                        table[i][j] = s1;
                        oneill.setBaseElement(table[i][j]);
                        table[i][j].setPlayer(oneill);
                        break;
                    //Letrehoz egy merleget egy dobozzal
                    case 502:
                        Scale s2 = new Scale(1);
                        s2.isScale = true;
                        s2.addBox(new Box(1));
                        table[i][j] = s2;
                        break;
                    //Letrehoz egy kulonleges falat rajta jobbra nezo kek portallal
                    case 503:
                        SpecialWall sw2 = new SpecialWall(wormhole);
                        sw2.isSpecWall = true;
                        wormhole.setPortal(Direction.Right, sw2, Color.Blue);
                        table[i][j] = sw2;
                        break;
                    //Letrehoz egy kulonleges falat rajta balra nezo sarga portallal
                    case 504:
                        SpecialWall sw3 = new SpecialWall(wormhole);
                        sw3.isSpecWall = true;
                        wormhole.setPortal(Direction.Left, sw3, Color.Yellow);
                        table[i][j] = sw3;
                        break;
                    //Letrehoz egy kulonleges falat rajta jobbra nezo zold portallal
                    case 505:
                        SpecialWall sw4 = new SpecialWall(wormhole);
                        sw4.isSpecWall = true;
                        wormhole.setPortal(Direction.Right, sw4, Color.Green);
                        table[i][j] = sw4;
                        break;
                    //Letrehoz egy kulonleges falat rajta balra nezo piros portallal
                    case 506:
                        SpecialWall sw5 = new SpecialWall(wormhole);
                        sw5.isSpecWall = true;
                        wormhole.setPortal(Direction.Left, sw5, Color.Red);
                        table[i][j] = sw5;
                        break;
                    //Letrehoz egy talaj elemet rajta O'Neill-el, akinel egy doboz van
                    case 507:
                        Ground g = new Ground();
                        oneill.setBox(new Box(1));
                        g.setPlayer(oneill);
                        table[i][j] = g;
                        oneill.setBaseElement(table[i][j]);
                        break;
                    //Letrehoz egy nyitott ajtot
                    case 508:
                        Door d1 = new Door();
                        d1.open();
                        table[i][j] = d1;
                        break;
                    default:
                        break;
                }
                //Letrehoz egy merleget es eltarolja a listaban
                if (thisLine / 100 == 2) {
                    Scale s3 = new Scale((thisLine - 200) / 10);
                    table[i][j] = s3;
                    scales[thisLine % 10 - 1] = s3;
                    table[i][j].isScale = true;
                    db++;
                }
                //Letrehoz egy zart ajtot es eltarolja a listaban
                if (thisLine / 100 == 3) {
                    Door d2 = new Door();
                    table[i][j] = d2;
                    doors[thisLine % 10 - 1] = d2;
                }
                //Letrehoz egy merleget dobozzal es eltarolja a listaban
                if (thisLine / 100 == 10) {
                    Scale s4 = new Scale(1);
                    s4.addBox(new Box(1));
                    s4.isScale = true;
                    table[i][j] = s4;
                    oscales[thisLine % 10 - 1] = s4;
                    odb++;
                }
                //Letrehoz egy nyitott ajtot es eltarolja a listaban
                if (thisLine / 100 == 11) {
                    Door d3 = new Door();
                    d3.open();
                    table[i][j] = d3;
                    odoors[thisLine % 10 - 1] = d3;
                }
            }
        }
        //A merlegeknek bealltja az ajtokat
        for(int k = 0; k < db; k++){
            scales[k].setDoor(doors[k]);
        }
        //A dobozos merlegeknek bealltja a nyitott ajtokat
        for(int k = 0; k < odb; k++){
            oscales[k].setDoor(odoors[k]);
        }

        br.close();
        //Beallitja a szomszedokat
        firstElement = table[0][0];
        setNeighbours(table, row, column);
    }

    //Beallitja a szomszedokat
    public void setNeighbours(MapElement[][] table, int row, int column) {
        //Beallitja az elso sor elso tablaelemenek a szomszedait
        table[0][0].setNeighbour(Direction.Right, table[0][1]);
        table[0][0].setNeighbour(Direction.Down, table[1][0]);
        //Beallitja az elso sor kozbenso tablaelemeinek a szomszedait
        for(int i = 1; i < column - 1; i++){
            table[0][i].setNeighbour(Direction.Right, table[0][i + 1]);
            table[0][i].setNeighbour(Direction.Down, table[1][i]);
            table[0][i].setNeighbour(Direction.Left, table[0][i - 1]);
        }
        //Beallitja az elso sor utolso tablaelemenek a szomszedait
        table[0][column - 1].setNeighbour(Direction.Down, table[1][column - 1]);
        table[0][column - 1].setNeighbour(Direction.Left, table[0][column - 2]);
        //Beallitja a kozbenso sorok tablaelemeinek a szomszedait
        for(int j = 1; j < row - 1; j ++){
            //Beallitja a kozbenso sorok elso tablaelemenek a szomszedait
            table[j][0].setNeighbour(Direction.Up, table[j - 1][0]);
            table[j][0].setNeighbour(Direction.Right, table[j][1]);
            table[j][0].setNeighbour(Direction.Down, table[j + 1][0]);
            //Beallitja a kozbenso sorok kozbenso tablaelemeinek a szomszedait
            for(int i = 1; i < column - 1; i++){
                table[j][i].setNeighbour(Direction.Up, table[j - 1][i]);
                table[j][i].setNeighbour(Direction.Right, table[j][i + 1]);
                table[j][i].setNeighbour(Direction.Down, table[j + 1][i]);
                table[j][i].setNeighbour(Direction.Left, table[j][i - 1]);
            }
            //Beallitja a kozbenso sorok utolso tablaelemenek a szomszedait
            table[j][column - 1].setNeighbour(Direction.Up, table[j - 1][column - 1]);
            table[j][column - 1].setNeighbour(Direction.Down, table[j + 1][column - 1]);
            table[j][column - 1].setNeighbour(Direction.Left, table[j][column - 2]);
        }
        //Beallitja az utolso sor elso tablaelemenek a szomszedait
        table[row - 1][0].setNeighbour(Direction.Up, table[row - 2][0]);
        table[row - 1][0].setNeighbour(Direction.Right, table[row - 1][1]);
        //Beallitja az utolso sor kozbenso tablaelemeinek a szomszedait
        for(int i = 1; i < column - 1; i++){
            table[row - 1][i].setNeighbour(Direction.Up, table[row - 2][i]);
            table[row - 1][i].setNeighbour(Direction.Right, table[row - 1][i + 1]);
            table[row - 1][i].setNeighbour(Direction.Left, table[row - 1][i - 1]);
        }
        //Beallitja az utolso sor utolso tablaelemenek a szomszedait
        table[row - 1][column - 1].setNeighbour(Direction.Up, table[row - 2][column - 1]);
        table[row - 1][column - 1].setNeighbour(Direction.Left, table[row - 1][column - 2]);
    }

    public Player getPlayer(String name) {
        if (name.equals("oneill"))
            return oneill;
        if (name.equals("jaffa"))
            return jaffa;
        return null;
    }
}