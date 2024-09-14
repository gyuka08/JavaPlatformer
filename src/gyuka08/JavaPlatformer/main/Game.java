package gyuka08.JavaPlatformer.main;

public class Game implements Runnable{
    private static int windowWidth = 1920;
    private static int windowHeight = 1080;
    private Window gameWindow;
    private Panel gamePanel;
    private Thread loopThread;
    private final int FPS_SET = 120;

    public Game() {
        gamePanel = new Panel();
        gameWindow = new Window(windowWidth, windowHeight, gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        loopThread = new Thread(this);
        loopThread.start();
    }

    public static int getWindowWidth() {
        return windowWidth;
    }

    public static int getWindowHeight() {
        return windowHeight;
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while(true) {

            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame) {
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }
}
