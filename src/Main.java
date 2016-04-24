public class Main {

    public static void main(String[] args) {
        //Player es Wormhole inicializalasa
        Player oneill = new Player();
        WormHole wh = new WormHole();
        Replicator rep = new Replicator();

        //GameEngine-nek atadjuk az ezredesunket es a fereglyukat
        GameEngine ge = new GameEngine(oneill, wh, rep);

        //Jatek kezdete
        ge.startGame();

    }
}
