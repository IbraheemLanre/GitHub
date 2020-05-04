package PongGame;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Tennis extends Applet implements Runnable, KeyListener {
    public static void main(String[] args) {

    }
    final int WIDTH = 700;
    final int HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    AIPaddle p2;
    Ball b1;
    boolean gameStarted;
    Graphics gfx;
    Image img;

    public void init() {
        this.resize(WIDTH, HEIGHT);
        gameStarted = false;
        this.addKeyListener(this);
        p1 = new HumanPaddle(1);
        p2 = new AIPaddle(2, b1);
        img = createImage(WIDTH, HEIGHT);
        gfx = img.getGraphics();
        b1 = new Ball();
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        gfx.setColor(Color.black);
        gfx.fillRect(0,0, WIDTH, HEIGHT);
        if (b1.getX() < -10 || b1.getX() > 710) {
            gfx.setColor(Color.red);
            gfx.drawString("Game Over", 350, 250);
        }else {
            p1.draw(gfx);
            b1.draw(gfx);
            p2.draw(gfx);
        }

        if(!gameStarted) {
            gfx.setColor(Color.white);
            gfx.drawString("Tenni", 340, 100);
            gfx.drawString("Press Enter to being..", 310, 130);
        }
        g.drawImage(img, 0, 0, this);

    }

    public void update(Graphics g) {
        paint(g);
    }

    public void run() {
        for (;;) {
            if (gameStarted) {
                p1.move();
                p2.move();
                b1.move();
                b1.checkPaddleCollision(p1, p2);
            }

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStarted = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(false);

        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownAccel(false);
        }

    }



}
