package gyuka08.JavaPlatformer.main;

import gyuka08.JavaPlatformer.inputs.KeyboardInputs;
import gyuka08.JavaPlatformer.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel {
    private MouseInputs mouseInputs = new MouseInputs(this);
    private int xDelta = 0, yDelta = 0;

    public Panel() {
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
        repaint();
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
        repaint();
    }

    public void setRectanglePosition(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.fillRect(xDelta, yDelta, 200, 240);
    }
}
