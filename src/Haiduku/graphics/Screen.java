package Haiduku.graphics;

import entitati.Anatomie;
import entitati.Mar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Dan on 2/12/2015.
 */
public class Screen extends JPanel implements Runnable{


    public static final int WIDTH = 800, HEIGHT = 800;

    private Thread thread;
    private boolean running = false;

    private Anatomie b;
    private ArrayList<Anatomie> sarpe;
    private Mar mar;
    private ArrayList<Mar> mere;
    private Random r;
    private int scor;


    //capul sarpelui!!!
    private int xCoor = 10, yCoor = 10;
    private int size = 5;


    private boolean right = true, left = false, up = false, down = false;
    private int ticks = 0;

    private Key key;



    public Screen(){
        setFocusable(true);
        key = new Key();
        addKeyListener( key );
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        r = new Random();
        sarpe = new ArrayList<Anatomie>();
        mere = new ArrayList<Mar>();
        scor = 0;
        start();
    }

    public void tick(){
        if(sarpe.size()== 0){
            b = new Anatomie(xCoor, yCoor, 10);
            sarpe.add(b);
        }

        if(mere.size() == 0){
            int xCoor = r.nextInt(79);
            int yCoor = r.nextInt(79);
            mar = new Mar(xCoor, yCoor, 10);
            mere.add(mar);
        }

        for(int i = 0; i < mere.size(); i++ ){
            if(xCoor == mere.get(i).getxCoor() && yCoor == mere.get(i).getyCoor()){
                size++;
                mere.remove(i);
                i--;
                scor = scor + 20;
            }
        }



        ticks++;

        if(ticks > 1000000){
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;

            ticks = 0;

            b = new Anatomie(xCoor, yCoor, 10);
            sarpe.add(b);

            if(sarpe.size() > size){
                sarpe.remove(0);
            }
            System.out.println("" +scor);

        }

    }
    public void paint(Graphics g){
//Linie???
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.YELLOW);
        for(int i = 0; i<WIDTH /10; i++){
            g.drawLine(i * 10, 0, i *10, HEIGHT);
        }
        for(int i =0; i< HEIGHT /10; i++){
            g.drawLine(0, i * 10, WIDTH, i * 10);
        }

        for(int i = 0; i < sarpe.size(); i++ ){
            sarpe.get(i).draw(g);
        }
        for(int i = 0; i < mere.size(); i++ ){
           mere.get(i).draw(g);


        }


    }

    public void start(){
        running = true;
        thread = new Thread(this, "Game Loop");
        thread.start();

    }
    public void stop(){

    }

    public void run(){
        while(running){
            tick();
           repaint();
        }

    }



    private class Key implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }


        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if(key == KeyEvent.VK_RIGHT && !left){
                up = false;
                down = false;
                right=true;

            }
            if(key == KeyEvent.VK_LEFT && !right){
                up = false;
                down = false;
                left = true;

            }
            if(key == KeyEvent.VK_DOWN && !up){
                down = true;
                right = false;
                left = false;

            }
            if(key == KeyEvent.VK_UP && !down){
                up = true;
                right = false;
                left = false;

            }


        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
