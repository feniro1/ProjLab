
import java.util.*;


public class Ground extends MapElement {

    private Box box = null;
    private ZPM zpm = null;


    public Ground(Box box, ZPM zpm) {
        this.box = box;
        this.zpm = zpm;
        System.out.print("A talaj objektum létrehozása sikeresen megtörtént.");
    }


    public void removeZPM() {
        zpm = null;
        System.out.print("A talaj objektumon nincs többé ZPM.");
    }

    public void removeBox() {
        box = null;
        System.out.print("A talaj objektumon nincs többé ZPM.");
    }

    public void createBox() {
        if(box == null) {
            box = new Box();
            System.out.print("Sikerült új doboz elemet letenni a talajra.");
        } else {
            System.out.print("A talajon már van doboz, így nem sikerült új doboz elemet letenni rá.");
        }
        // zpm-el egyszerre lehet letenni doboz objektumot felvenni? tehat hogy egy csavon ket csavo legyen? ha nem akkor lekezelem azt is (valoszinuleg nem de ezt inkabb most nem)
    }


    public boolean stepOn(Colonel colonel) {
        if (box == null) {
            System.out.print("A talaj objektumon nincs doboz"); //, így az ezredes ráléphet.");
            return true;
        }

        System.out.print("A talaj objektumon van doboz.");
        return false;
        // remelem csak ennyi esetet kell vizsgalni
    }

    public Box pickUp() {
        if (box!=null) {
            Box tmp = box;
            // kell irni egy fuggvenyt, hogy van-e doboz vagy nincs, mert ez igy ciganysag .. don't repeat yourself (box!=null) -ra hasBox
            // ez nem olyan szep, majd kerdezzetek meg miert gondolom igy ... kicsit nem objektum orientalt, viszont kell uj fuggvenyt irni, hogy az legyen ..
            removeBox();
            System.out.print("A doboz objektumot");
            return tmp;
        }
        System.out.print("Nincs mit felvegyél, mivel nincs előtted doboz");
        // valamit kell csavozni itt, mivel csak a neighbournak kell legyen doboza direction szerint stb de neki nem... es csak ha a neighbourje is ground .. yooooooo
        return null;
    }

    public boolean putDown(Box b) {
        // itt is neighbour ... keletibe vagyok, megirom ha SCH
        return false;
    }

}