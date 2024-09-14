package gyuka08.JavaPlatformer.main;

public class Game {
    private final int windowWidth = 1920;
    private final int windowHeight = 1080;
    private Window gameWindow;
    private Panel gamePanel;

    public Game() {
        gamePanel = new Panel();
        gameWindow = new Window(windowWidth, windowHeight, gamePanel);
        gamePanel.requestFocus();

    }
}
