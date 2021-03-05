package tileGame;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable { // main part of the game // Runnable make it run on a thread
    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs; //tells a computer how it should draw things to the screen
    // a memory in the computer that holds the same data as the actual screen
    private Graphics g;




    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;

    }

    private void init() {
        display = new Display(title, width, height);

    }

    private void tick() { // for update

    }

    private void render() { //will render everything for the game = draw things to the screen
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear the screen
        g.clearRect(0, 0, width, height);
        //Here we begin drawing


        //End drawing
        bs.show();
        g.dispose();

    }

    public void run() {
        init();
        while (running) { // while running = true, it wil run over and over again
            tick();
            render();
        }
        stop();

    }

    public synchronized void start() { //to start the thread
        if (running) {
            return;// if the game is already running, we will stop the process
        }
        running = true;
        thread = new Thread(this);
        thread.start(); //will call the run method

    }

    public synchronized void stop() { // synchronized is used only when working with threads
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


