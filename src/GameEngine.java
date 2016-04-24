
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class GameEngine {

    public Player oneill;
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

    //Fájlból betölti, és létrehozza a mapelementeket
    public void loadMap(int testNumber) throws IOException {
        //A tesztesettől függően betölti a megfelelő txt file-t
        FileReader fr = new FileReader(Integer.toString(testNumber) + ".txt");
        BufferedReader br = new BufferedReader(fr);
        // Az első két sora a textnek a sor-, és oszlopszám
        int row = Integer.parseInt(br.readLine());
        int column = Integer.parseInt(br.readLine());
        int thisLine = 0;
        //Létrehozza az ideiglenes segédmátrixot
        MapElement table[][] = new MapElement[row][column];
        //Az ajtókat és mérlegeket külön listában tároljuk a pároztatás miatt
        ArrayList<Door> doors = new ArrayList<Door>(20);
        ArrayList<Scale> scales = new ArrayList<Scale>(20);
        int db = 0;
        //Végigfutunk a fájlon és létrehozzuk a megfelelő mapelementeket és eltároljuk a mátrixban
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                thisLine = Integer.parseInt(br.readLine());
                switch (thisLine) {
                    //Létrehoz egy talaj elemet
                    case 1:
                        table[i][j] = new Ground();
                        break;
                    //Létrehoz egz talaj elemet egy ZPM-mel
                    case 2:
                        ZPM z = new ZPM();
                        table[i][j] = new Ground(z);
                        break;
                    //Létrehoz egy talaj elemet egy dobozzal
                    case 3:
                        Box b = new Box(1);
                        table[i][j] = new Ground(b);
                        break;
                    //Létrehoz egy talaj elemet rajta O'Neill-lel
                    case 4:
                        table[i][j] = new Ground();
                        oneill.setBaseElement(table[i][j]);
                        table[i][j].setPlayer(oneill);
                        break;
                    //Létrehoz egy szakadék elemet
                    case 5:
                        table[i][j] = new Rift();
                        break;
                    //Létrehoz egy fal elemet
                    case 6:
                        table[i][j] = new Wall();
                        break;
                    //Létrehoz egy különleges falat
                    case 7:
                        table[i][j] = new SpecialWall(wormhole);
                        break;
                    //Létrehoz egz kinyitott állású ajtót
                    case 501:
                        Door d1 = new Door();
                        d1.open();
                        table[i][j] = d1;
                        break;
                    //Létrehoz egy zárt állású ajtót
                    case 502:
                        Door d2 = new Door();
                        d2.close();
                        table[i][j] = d2;
                        break;
                    //Létrehoz egy mérleget rajta O'Neillel
                    case 503:
                        table[i][j] = new Scale();
                        oneill.setBaseElement(table[i][j]);
                        table[i][j].setPlayer(oneill);
                        break;
                    //Létrehoz egy mérleget egy dobozzal
                    case 504:
                        Scale s1 = new Scale();
                        s1.createBox(new Box(1)); //random 1 suly yolo
                        table[i][j] = s1;
                        break;
                    //Létrehoz egy különleges falat rajta lefelé néző kék portállal
                    case 505:
                        SpecialWall sw1 = new SpecialWall(wormhole);
                        wormhole.setPortal(Direction.Down, sw1, Color.Blue);
                        table[i][j] = sw1;
                        break;
                    //Létrehoz egy különlege falat rajta lefelé néző sárga portállal
                    case 506:
                        SpecialWall sw2 = new SpecialWall(wormhole);
                        wormhole.setPortal(Direction.Down, sw2, Color.Yellow);
                        table[i][j] = sw2;
                        break;
                    //Létrehoz egy talaj elemet rajta O'Neill-el, akinél egy doboz van
                    case 507:
                        Ground g = new Ground();
                        oneill.createBox(new Box(1));
                        g.setPlayer(oneill);
                        table[i][j] = g;
                        oneill.setBaseElement(table[i][j]);
                        break;
                    default:
                        break;
                }
                //Létrehoz egy mérleget
                if (thisLine / 100 == 2) {
                    Scale s2 = new Scale();
                    table[i][j] = s2;
                    scales.add(thisLine % 100 - 1, s2);
                    db++;
                }
                //Létrehoy egy ajtót
                if (thisLine / 100 == 3) {
                    Door d3 = new Door();
                    table[i][j] = d3;
                    int index = thisLine % 100 - 1;
                    doors.add(index, d3);
                }
            }
        }
        //A mérlegeknek beálltja az ajtót
        for(int k = 0; k < db; k++){
            scales.get(k).setDoor(doors.get(k));
        }

        br.close();
        //Beálltja a szomszédokat
        setNeighbours(table, row, column);
    }

    //Beálltja a szomszédokat
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