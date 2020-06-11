package PacMan;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImagingOpException;

public class PacMan {

    private  int lives;
    private int yAxis;
    private int xAxis;
    private String imagePath;
    private boolean isAlive;


    public int getLives ( ) {
        return lives;
    }

    public void setLives (int lives) {
        this.lives = lives;
    }

    public int getyAxis ( ) {
        return yAxis;
    }

    public void setyAxis (int yAxis) {
        this.yAxis = yAxis;
    }

    public int getxAxis ( ) {
        return xAxis;
    }

    public void setxAxis (int xAxis) {
        this.xAxis = xAxis;
    }

    public String getImagePath ( ) {
        return imagePath;
    }

    public void setImagePath (String imagePath) {
        if(imagePath == null)
            JOptionPane.showMessageDialog(null, "Invalid string!");
        else if(imagePath.length() == 0)
            JOptionPane.showMessageDialog(null, "String Empty");
        else
            this.imagePath = imagePath;

    }

    public boolean isAlive ( ) {
        return isAlive;
    }

    public void setAlive (boolean alive) {
        isAlive = alive;
    }

    public PacMan (int lives , int yAxis , int xAxis , String imagePath , boolean isAlive) {
//        super();
        this.lives = lives;
        this.yAxis = yAxis;
        this.xAxis = xAxis;
        this.imagePath = imagePath;
        this.isAlive = isAlive;
    }

    public void drawPacMAN(Graphics g){
        ImageIcon pacManJpg = new ImageIcon (imagePath);
        g.drawImage (pacManJpg.getImage (), xAxis, yAxis, null);
    }

}
