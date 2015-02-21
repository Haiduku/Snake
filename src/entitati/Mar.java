package entitati;

import java.awt.*;

/**
 * Created by Dan on 2/13/2015.
 */
public class Mar {



    private int xCoor, yCoor, width, height;



    public Mar(int xCoor, int yCoor, int tileSize){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;

    }
    public void tick() {
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(xCoor * width , yCoor * height , width , height);
    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }


}
