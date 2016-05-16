public class Main {

    public static void main(String[] args) {
        //Inicializaljuk a Controllert, ami kezeli az egesz jatekmenetet
        Controller cont = new Controller();

        //Jatek kezdete
        cont.start();

        System.out.println("You won this shit");
        return;
    }
}
