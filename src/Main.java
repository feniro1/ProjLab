public class Main {

    public static void main(String[] args) {
        //Colonel es Wormhole inicializalasa
        Colonel oneill = new Colonel();
        WormHole wh = new WormHole();

        //GameEngine-nek atadjuk az ezredesunket es a fereglyukat
        GameEngine ge = new GameEngine(oneill, wh);
        //csavo
        //Jatek kezdete
        //valami2
        //krisz ari
        ge.startGame();
    }
}
