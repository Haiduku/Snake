package entitati;

import java.awt.*;

/**
 * Created by Dan on 2/12/2015.
 */
public class Anatomie {

    private int xCoor, yCoor, width, height;


    public Anatomie(int xCoor, int yCoor, int tileSize){
            this.xCoor = xCoor;
            this.yCoor = yCoor;
            width = tileSize;
            height = tileSize;
        //?? ce este this??
    }
    public void tick() {

    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(xCoor * width , yCoor * height , width , height);
        g.setColor(Color.GREEN);
        g.fillRect(xCoor * width + 2, yCoor * height +2, width, height );
    }

}
