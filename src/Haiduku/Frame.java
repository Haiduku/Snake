package Haiduku;

import Haiduku.graphics.Screen;
import entitati.Anatomie;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dan on 2/12/2015.
 */
public class Frame extends JFrame{

    public Frame() {
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setTitle("Sarpele");
       setResizable(false);

                setLayout(new GridLayout(1, 1, 0, 0));

        Screen s = new Screen();
        add(s);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);



   }



    public static void main(String[] args) {
        new Frame();
    }
}
