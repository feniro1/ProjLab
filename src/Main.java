public class Main {

    public static void main(String[] args) {
        //Player es Wormhole inicializalasa
        Player oneill = new Player();
        WormHole wh = new WormHole();

        //GameEngine-nek atadjuk az ezredesunket es a fereglyukat
        GameEngine ge = new GameEngine(oneill, wh);

        //Jatek kezdete
        ge.startGame();

    }
}
