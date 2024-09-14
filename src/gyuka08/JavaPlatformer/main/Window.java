package gyuka08.JavaPlatformer.main;

import javax.swing.*;

public class Window extends JFrame {
    private JFrame window;

    public Window(int windowWidth, int windowHeight, Panel gamePanel) {
        window = new JFrame();

        window.setSize(windowWidth, windowHeight);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setTitle("Javaro");
        window.add(gamePanel);
        window.setVisible(true);
    }
}
