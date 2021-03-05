package tileGame;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas; // alows us to draw graphics to it, images


    private String title;
    private int width, height; // in terms of pixels

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// to make sure it is not running in the background
        frame.setResizable(false); // window can't be resized by dragging
        frame.setLocationRelativeTo(null);//it will appear in the center of the screen
        frame.setVisible(true);//silly, but the window is visible

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));//to make sure it stays at the width&height that we give

        frame.add(canvas);
        frame.pack();//resize the window a bit to see the canvas fully

    }

    public Canvas getCanvas() {
        return canvas;
    }
}
