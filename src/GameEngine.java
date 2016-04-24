
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;


public class GameEngine {

    public Player oneill;
    public Player jaffa;
    public Replicator replicator;
    public WormHole wormhole;
    public MapElement firstElement;

    public GameEngine() {
        System.out.println("Letrejon egy jatekkezelo peldanya.");
    }

    public GameEngine(Player _oneill, WormHole _wh){
        oneill = _oneill;
        wormhole = _wh;
    }


    public void startGame() {

        boolean test = true;
        while(test) {
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

            try {
                switch (i) {
                    //movement on ground
                    case "0":
                        loadMap(0);
                        oneill.move(Direction.Up);
                        break;
                    //movement from scale
                    case "1":
                        loadMap(1);
                        oneill.move(Direction.Up);
                        break;
                    //movement to door
                    case "2":
                        loadMap(2);
                        oneill.move(Direction.Up);
                        break;
                    //movement to rift
                    case "3":
                        loadMap(3);
                        oneill.move(Direction.Up);
                        break;
                    //movement to scale
                    case "4":
                        loadMap(4);
                        oneill.move(Direction.Up);
                        break;
                    //movement to wall
                    case "5":
                        loadMap(5);
                        oneill.move(Direction.Up);
                        break;
                    //pick up box from ground
                    case "6":
                        loadMap(6);
                        oneill.pickUp();
                        break;
                    //pick up box from scale
                    case "7":
                        loadMap(7);
                        oneill.pickUp();
                        break;
                    //put down box to ground
                    case "8":
                        loadMap(8);
                        oneill.putDown();
                        break;
                    //put down box to scale
                    case "9":
                        loadMap(9);
                        oneill.putDown();
                        break;
                    //put down box to rift
                    case "10":
                        loadMap(10);
                        oneill.putDown();
                        break;
                    //shoot bullet
                    case "11":
                        loadMap(11);
                        oneill.shoot(Color.Yellow);
                        break;
                    //walk into wormhole
                    case "12":
                        loadMap(12);
                        oneill.move(Direction.Up);
                        break;
                    default:
                        System.out.println("Nem letezo teszteset!");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println();
            System.out.println("Szeretnel meg egy tesztesetet futtatni?");
            System.out.println("igen/nem");
            String answer = s.nextLine();
            System.out.println();

            if (answer.equals("igen"))
                test = true;
            else test = false;
        }

    }

    //F·jlbÛl betˆlti, Ès lÈtrehozza a mapelementeket
    public void loadMap(int testNumber) throws IOException {
        //A tesztesettıl f¸ggıen betˆlti a megfelelı txt file-t
        FileReader fr = new FileReader(Integer.toString(testNumber) + ".txt");
        BufferedReader br = new BufferedReader(fr);
        // Az elsı kÈt sora a textnek a sor-, Ès oszlopsz·m
        int row = Integer.parseInt(br.readLine());
        int column = Integer.parseInt(br.readLine());
        int thisLine = 0;
        //LÈtrehozza az ideiglenes segÈdm·trixot
        MapElement table[][] = new MapElement[row][column];
        //Az ajtÛkat Ès mÈrlegeket k¸lˆn list·ban t·roljuk a p·roztat·s miatt
        ArrayList<Door> doors = new ArrayList<Door>(20);
        ArrayList<Scale> scales = new ArrayList<Scale>(20);
        ArrayList<Door> odoors = new ArrayList<Door>(20);
        ArrayList<Scale> oscales = new ArrayList<Scale>(20);
        int db = 0;
        int odb = 0;
        //VÈgigfutunk a f·jlon Ès lÈtrehozzuk a megfelelı mapelementeket Ès elt·roljuk a m·trixban
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                thisLine = Integer.parseInt(br.readLine());
                switch (thisLine) {
                    //LÈtrehoz egy talaj elemet
                    case 1:
                        table[i][j] = new Ground();
                        break;
                    //LÈtrehoz egz talaj elemet egy ZPM-mel
                    case 2:
                        ZPM z = new ZPM();
                        table[i][j] = new Ground(z);
                        break;
                    //LÈtrehoz egy talaj elemet egy dobozzal
                    case 3:
                        Box b = new Box(1);
                        table[i][j] = new Ground(b);
                        break;
                    //LÈtrehoz egy talaj elemet rajta O'Neill-lel
                    case 4:
                        table[i][j] = new Ground();
                        oneill.setBaseElement(table[i][j]);
                        table[i][j].setPlayer(oneill);
                        break;
                    //LÈtrehoz egy talaj elemet rajta Jaffa-val
                    case 5:
                        table[i][j] = new Ground();
                        jaffa.setBaseElement(table[i][j]);
                        table[i][j].setPlayer(jaffa);
                        break;
                    //LÈtrehoz egy talaj elemet rajta Replicator-ral
                    case 6:
                        table[i][j] = new Ground();
                        replicator.setBaseElement(table[i][j]);
                        table[i][j].setReplicator(replicator);
                        break;
                    //LÈtrehoz egy szakadÈk elemet
                    case 7:
                        table[i][j] = new Rift();
                        break;
                    //LÈtrehoz egy fal elemet
                    case 8:
                        table[i][j] = new Wall();
                        break;
                    //LÈtrehoz egy k¸lˆnleges falat
                    case 9:
                        table[i][j] = new SpecialWall(wormhole);
                        break;
                    //LÈtrehoz egy mÈrleget rajta O'Neillel
                    case 501:
                        table[i][j] = new Scale();
                        oneill.setBaseElement(table[i][j]);
                        table[i][j].setPlayer(oneill);
                        break;
                    //LÈtrehoz egy mÈrleget egy dobozzal
                    case 502:
                        Scale s1 = new Scale();
                        s1.createBox(new Box(1)); //random 1 suly yolo
                        table[i][j] = s1;
                        break;
                    //LÈtrehoz egy k¸lˆnleges falat rajta lefelÈ nÈzı kÈk port·llal
                    case 503:
                        SpecialWall sw1 = new SpecialWall(wormhole);
                        wormhole.setPortal(Direction.Down, sw1, Color.Blue);
                        table[i][j] = sw1;
                        break;
                    //LÈtrehoz egy k¸lˆnlege falat rajta lefelÈ nÈzı s·rga port·llal
                    case 504:
                        SpecialWall sw2 = new SpecialWall(wormhole);
                        wormhole.setPortal(Direction.Down, sw2, Color.Yellow);
                        table[i][j] = sw2;
                        break;
                    //LÈtrehoz egy k¸lˆnleges falat rajta lefelÈ nÈzı kÈk port·llal
                    case 505:
                        SpecialWall sw3 = new SpecialWall(wormhole);
                        wormhole.setPortal(Direction.Down, sw3, Color.Green);
                        table[i][j] = sw3;
                        break;
                    //LÈtrehoz egy k¸lˆnlege falat rajta lefelÈ nÈzı s·rga port·llal
                    case 506:
                        SpecialWall sw4 = new SpecialWall(wormhole);
                        wormhole.setPortal(Direction.Down, sw4, Color.Red);
                        table[i][j] = sw4;
                        break;
                    //LÈtrehoz egy talaj elemet rajta O'Neill-el, akinÈl egy doboz van
                    case 507:
                        Ground g = new Ground();
                        oneill.createBox(new Box(1));
                        g.setPlayer(oneill);
                        table[i][j] = g;
                        oneill.setBaseElement(table[i][j]);
                        break;
                    //LÈtrehoz egy nyitott ajtÛt
                    case 508:
                        Door d1 = new Door();
                        d1.open();
                        table[i][j] = d1;
                        break;
                    default:
                        break;
                }
                //LÈtrehoz egy mÈrleget
                if (thisLine / 100 == 2) {
                    Scale s2 = new Scale();
                    table[i][j] = s2;
                    scales.add(thisLine % 100 - 1, s2);
                    db++;
                }
                //LÈtrehoy egy z·rt ajtÛt
                if (thisLine / 100 == 3) {
                    Door d2 = new Door();
                    table[i][j] = d2;
                    doors.add(thisLine % 100 - 1, d2);
                }
                //LÈtrehoz egy mÈrleget
                if (thisLine / 100 == 10) {
                    Scale s3 = new Scale();
                    table[i][j] = s3;
                    scales.add(thisLine % 100 - 1, s3);
                    odb++;
                }
                //LÈtrehoy egy nyitott ajtÛt
                if (thisLine / 100 == 11) {
                    Door d3 = new Door();
                    table[i][j] = d3;
                    doors.add(thisLine % 100 - 1, d3);
                }
            }
        }
        //A mÈrlegeknek be·lltja az ajtÛt
        for(int k = 0; k < db; k++){
            scales.get(k).setDoor(doors.get(k));
        }
        //A mÈrlegeknek be·lltja az ajtÛt
        for(int k = 0; k < odb; k++){
            oscales.get(k).setDoor(odoors.get(k));
        }

        br.close();
        //Be·lltja a szomszÈdokat
        setNeighbours(table, row, column);
    }

    //Be·lltja a szomszÈdokat
    public void setNeighbours(MapElement[][] table, int row, int column) {
        table[0][0].setNeighbour(Direction.Right, table[0][1]);
        table[0][0].setNeighbour(Direction.Down, table[1][0]);
        for(int i = 1; i < column - 1; i++){
            table[0][i].setNeighbour(Direction.Right, table[0][i + 1]);
            table[0][i].setNeighbour(Direction.Down, table[1][i]);
            table[0][i].setNeighbour(Direction.Left, table[0][i - 1]);
        }
        table[0][column - 1].setNeighbour(Direction.Down, table[1][column - 1]);
        table[0][column - 1].setNeighbour(Direction.Left, table[0][column - 2]);

        for(int j = 1; j < row - 1; j ++){
            table[j][0].setNeighbour(Direction.Up, table[j - 1][0]);
            table[j][0].setNeighbour(Direction.Right, table[j][1]);
            table[j][0].setNeighbour(Direction.Down, table[j + 1][0]);
            for(int i = 1; i < column - 1; i++){
                table[j][i].setNeighbour(Direction.Up, table[j - 1][i]);
                table[j][i].setNeighbour(Direction.Right, table[j][i + 1]);
                table[j][i].setNeighbour(Direction.Down, table[j + 1][i]);
                table[j][i].setNeighbour(Direction.Left, table[j][i - 1]);
            }
            table[j][column - 1].setNeighbour(Direction.Up, table[j - 1][column - 1]);
            table[j][column - 1].setNeighbour(Direction.Down, table[j + 1][column - 1]);
            table[j][column - 1].setNeighbour(Direction.Left, table[j][column - 2]);
        }

        table[row - 1][0].setNeighbour(Direction.Up, table[row - 2][0]);
        table[row - 1][0].setNeighbour(Direction.Right, table[row - 1][1]);
        for(int i = 1; i < column - 1; i++){
            table[row - 1][i].setNeighbour(Direction.Up, table[row - 2][i]);
            table[row - 1][i].setNeighbour(Direction.Right, table[row - 1][i + 1]);
            table[row - 1][i].setNeighbour(Direction.Left, table[row - 1][i - 1]);
        }
        table[row - 1][column - 1].setNeighbour(Direction.Up, table[row - 2][column - 1]);
        table[row - 1][column - 1].setNeighbour(Direction.Left, table[row - 1][column - 2]);
    }

}