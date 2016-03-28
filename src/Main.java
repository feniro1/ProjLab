public class Main {

    public static void main(String[] args) {
        Colonel oneill = new Colonel();
        WormHole wh = new WormHole();

        GameEngine ge = new GameEngine(oneill, wh);

        //ge.loadMap(f);
        ge.startGame();
    }
}
