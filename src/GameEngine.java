
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

    public GameEngine(Player _oneill, WormHole _wh, Replicator rep){
        oneill = _oneill;
        wormhole = _wh;
        replicator = rep;
    }


    public void startGame() {

        //menu kirajzolasa, amig a felhasznalo ker uj tesztesetet
        boolean test = true;
        while(test) {
            System.out.println("Udvozlunk a LiskovTheorem Oneill's Adventure nevu jatekaban!");
            System.out.println("Kerlek valassz egy tesztesetet!");
            System.out.println();
            System.out.println("all: Osszes teszteset futtatasa");
            System.out.println();
            System.out.println("0: Jatekos mozgatasa");
            System.out.println("1: Jatekos ajton valo atelepese");
            System.out.println("2: Jatekos feregjaraton valo athjutasa");
            System.out.println("3: Jatekos szakadekba esese");
            System.out.println("4: Lovedek kilovese");
            System.out.println("5: Doboz felvetele merleg palyaelemrol");
            System.out.println("6: Doboz letevese merleg palyaelemre");
            System.out.println("7: ZPM felvetele");
            System.out.println("8: Replicator szakadekba esese");
            System.out.println();
            System.out.println("Valasztott teszteset: ");

            Scanner s = new Scanner(System.in);
            String i = s.nextLine();

            try {
                //fajl megnyitasa
                File file = new File("test.txt");

                //ha letezik kitoroljuk
                if(file.exists())
                    file.delete();
                file.createNewFile();

                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                switch (i) {
                    case "all":
                        for (int t = 0; t < 9; t++){
                            test(pw, t);
                        }
                        break;
                    //foldon jaras
                    case "0":
                        test(pw, 0);
                        break;
                    //ajton atlepes
                    case "1":
                        test(pw, 1);
                        break;
                    //feregjaraton atmenes
                    case "2":
                        test(pw, 2);
                        break;
                    //szakadekba eses
                    case "3":
                        test(pw, 3);
                        break;
                    //lovedek
                    case "4":
                        test(pw, 4);
                        break;
                    //doboz felvetele merlegrol
                    case "5":
                        test(pw, 5);
                        break;
                    //doboz letevese merlegre
                    case "6":
                        test(pw, 6);
                        break;
                    //ZPM felvetele
                    case "7":
                        test(pw, 7);
                        break;
                    //Replicator szakadekba esese
                    case "8":
                        test(pw, 8);
                        break;
                    default:
                        System.out.println("Nem letezo teszteset!");
                        break;
                }
                pw.close();
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

    //teszteseteket megvalosito fuggveny, melyben minden teszteset soran beolvassuk a hozzatartozo palyat, elvegezzuk az
    //elvart kimeneten megjelenitendo valtoztatasokat, majd egy test.txt nevu fajlba kiirjuk az eredmenyt
    public void test(PrintWriter pw, int testnumber) throws IOException {
        switch (testnumber) {
            //foldon jaras
            case 0:
                loadMap(0);
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("move Oneill right");
                pw.println();
                oneill.move(Direction.Right);
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("move Oneill up");
                pw.println();
                oneill.move(Direction.Up);
                mapPrintOut(pw);
                statusPrintOut(pw);
                pw.println("Teszt vege!");
                pw.println();

                break;
            //ajton atlepes
            case 1:
                loadMap(1);
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("move Oneill up");
                pw.println();
                oneill.move(Direction.Up);
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("move Oneill up");
                pw.println();
                oneill.move(Direction.Up);
                mapPrintOut(pw);
                statusPrintOut(pw);
                pw.println("Teszt vege!");
                pw.println();

                break;
            //feregjaraton atmenes
            case 2:
                loadMap(2);
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("move Oneill right");
                pw.println();
                oneill.move(Direction.Right);
                mapPrintOut(pw);
                statusPrintOut(pw);
                pw.println("Teszt vege!");
                pw.println();

                break;
            //szakadekba eses
            case 3:
                loadMap(3);
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("move Oneill up");
                pw.println();
                oneill.move(Direction.Up);
                mapPrintOut(pw);
                statusPrintOut(pw);
                pw.println("Teszt vege!");
                pw.println();

                break;
            //lovedek
            case 4:
                loadMap(4);
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("shoot Oneill yellow");
                pw.println();
                oneill.shoot(Color.Yellow);
                mapPrintOut(pw);
                statusPrintOut(pw);
                pw.println("Teszt vege!");
                pw.println();

                break;
            //doboz felvetele merlegrol
            case 5:
                loadMap(5);
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("turn Oneill");
                pw.println();
                oneill.turn();
                oneill.turn();
                oneill.turn();
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("pickUp Oneill");
                pw.println();
                oneill.pickUp();
                mapPrintOut(pw);
                statusPrintOut(pw);
                pw.println("Teszt vege!");
                pw.println();

                break;
            //doboz letevese merlegre
            case 6:
                loadMap(6);
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("turn Oneill");
                pw.println();
                oneill.turn();
                oneill.turn();
                oneill.turn();
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("putDown Oneill");
                pw.println();
                oneill.putDown();
                mapPrintOut(pw);
                statusPrintOut(pw);
                pw.println("Teszt vege!");
                pw.println();

                break;
            //ZPM felvetele
            case 7:
                loadMap(7);
                mapPrintOut(pw);
                statusPrintOut(pw);

                pw.println("move Oneill up");
                pw.println();
                oneill.move(Direction.Up);
                mapPrintOut(pw);
                statusPrintOut(pw);
                pw.println("Teszt vege!");
                pw.println();

                break;
            //Replicator szakadekba esese
            case 8:
                loadMap(8);
                mapPrintOut(pw);
                pw.println("A Replicator egy " + replicator.getBaseElement().getClass().getSimpleName() + " objektumon all");
                pw.println();

                pw.println("randomize off");
                pw.println();
                replicator.randomizeOff();
                replicator.move(Direction.Up);
                mapPrintOut(pw);
                pw.println("A Replicator egy Mennyorszag objektumon all");
                pw.println("Teszt vege!");
                pw.println();

                break;
            default:
                break;
        }
    }

    //kimeneti palya kiirasara szolgalo fuggveny
    private void mapPrintOut(PrintWriter file) throws IOException {
        MapElement actual = firstElement;
        //az osszes sor kiirasa, kiveve az utolso
        for (int i = 0; i < row - 1; i++) {
            file.print(actual.symbol());
            for (int j = 0; j < column - 1; j++) {
                actual = actual.getNextElement(Direction.Right);
                file.print(actual.symbol());
            }
            for (int k = 0; k < column - 1; k++) {
                actual = actual.getNextElement(Direction.Left);
            }
            actual = actual.getNextElement(Direction.Down);
            file.println();
        }

        // a palya utolso soranak kiirasa
        file.print(actual.symbol());
        for (int j = 0; j < column - 1; j++) {
            actual = actual.getNextElement(Direction.Right);
            file.print(actual.symbol());
        }
        file.println();
        file.println();

    }

    //a jatek jelenlegi allasat fajlba kiiro fuggveny
    public void statusPrintOut(PrintWriter file) {
        file.println(oneill.getName() + " " + oneill.getLookDirection().toHungarian() + " nez");
        file.println(oneill.getName() + "nal " + oneill.getZPMNumber() + " db ZPM van");
        if(oneill.hasBox())
            file.println(oneill.getName() + "nal van doboz");
        else
            file.println(oneill.getName() + "nal nincs doboz");
        String className = oneill.getBaseElement().getClass().getSimpleName();
        if (className == "Rift")
            file.println(oneill.getName() + " egy Mennyorszag objektumon all");
        else
            file.println(oneill.getName() + " egy " + className + " objektumon all");
        file.println();
    }

    //Fajlbol betolti, es letrehozza a mapelementeket
    public void loadMap(int testNumber) throws IOException {
        //A tesztesettol fuggoen betolti a megfelelo txt file-t
        FileReader fr = new FileReader(Integer.toString(testNumber) + ".txt");
        BufferedReader br = new BufferedReader(fr);
        // Az elso ket sora a textnek a sor-, es oszlopszam
        row = Integer.parseInt(br.readLine());
        column = Integer.parseInt(br.readLine());
        int thisLine = 0;
        //Letrehozza az ideiglenes segedmatrixot
        MapElement table[][] = new MapElement[row][column];
        //Az ajtokat es merlegeket kulon listaban taroljuk a paroztatas miatt
        ArrayList<Door> doors = new ArrayList<Door>(20);
        ArrayList<Scale> scales = new ArrayList<Scale>(20);
        ArrayList<Door> odoors = new ArrayList<Door>(20);
        ArrayList<Scale> oscales = new ArrayList<Scale>(20);
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
                    //Letrehoz egy kelenleges falat
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
                    Scale s3 = new Scale(1);
                    s3.isScale = true;
                    table[i][j] = s3;
                    scales.add(thisLine % 100 - 1, s3);
                    db++;
                }
                //Letrehoz egy zart ajtot es eltarolja a listaban
                if (thisLine / 100 == 3) {
                    Door d2 = new Door();
                    table[i][j] = d2;
                    doors.add(thisLine % 100 - 1, d2);
                }
                //Letrehoz egy merleget dobozzal es eltarolja a listaban
                if (thisLine / 100 == 10) {
                    Scale s4 = new Scale(1);
                    s4.addBox(new Box(1));
                    s4.isScale = true;
                    table[i][j] = s4;
                    oscales.add(thisLine % 100 - 1, s4);
                    odb++;
                }
                //Letrehoz egy nyitott ajtot es eltarolja a listaban
                if (thisLine / 100 == 11) {
                    Door d3 = new Door();
                    d3.open();
                    table[i][j] = d3;
                    odoors.add(thisLine % 100 - 1, d3);
                }
            }
        }
        //A merlegeknek bealltja az ajtokat
        for(int k = 0; k < db; k++){
            scales.get(k).setDoor(doors.get(k));
        }
        //A dobozos merlegeknek bealltja a nyitott ajtokat
        for(int k = 0; k < odb; k++){
            oscales.get(k).setDoor(odoors.get(k));
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

}