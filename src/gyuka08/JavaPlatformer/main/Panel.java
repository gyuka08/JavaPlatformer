package gyuka08.JavaPlatformer.main;

import gyuka08.JavaPlatformer.inputs.KeyboardInputs;
import gyuka08.JavaPlatformer.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Panel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 0, yDelta = 0;
    private float xDirection = 1F, yDirection = 1F;
    private int frames;
    private long lastCheck = 0;
    private Color color = new Color(100, 100, 100);
    private Random random;

    public Panel() {
        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void setRectanglePosition(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        updateRectangle();
        graphics.setColor(color);
        graphics.fillRect((int)xDelta, (int)yDelta, 200, 240);



    }

    private void updateRectangle() {
        xDelta+= xDirection;
        if(xDelta > Game.getWindowWidth() || xDelta < 0) {
            xDirection *= -1;
            color = getRandomColor();
        }
        yDelta+= yDirection;
        if(yDelta > Game.getWindowHeight() || yDelta < 0) {
            yDirection *= -1;
            color = getRandomColor();
        }
    }

    private Color getRandomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r, g, b);
    }
}
