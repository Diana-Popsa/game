package tileGame;

public class Launcher { // only responsible for starting
    public static void main(String[] args) {
        Game game = new Game("Fake Mario", 640, 486);
        game.start();
    }
}
