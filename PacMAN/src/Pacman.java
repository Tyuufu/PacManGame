import javax.swing.*;
import java.awt.*;

public class Pacman {

    private int xAxis;
    private int yAxis;
    private String imagePath;
    private boolean isAlive;

    public Pacman(int xAxis, int yAxis, String imagePath, boolean isAlive)
    {
        setxAxis (xAxis);
        setyAxis (yAxis);
        setImagePath(imagePath);
        setIsAlive(isAlive);
    }

    public void setxAxis (int xAxis)
    {
        this.xAxis = xAxis;

    }

    public void setyAxis (int yAxis)
    {
        this.yAxis = yAxis;

    }

    public void setImagePath(String imagePath)
    {
        if(imagePath == null)
        {
            JOptionPane.showMessageDialog(null, "Image is null");
            System.exit(1);
        }
        else
            this.imagePath = imagePath;
    }

    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }

    public int getyAxis() {
        return yAxis;
    }

    public int getxAxis() {
        return xAxis;
    }

    public String getImagePath() {
        return imagePath;
    }

    public boolean isAlive() {
        return isAlive;
    }


    // This function will allow me to draw the pacman image!
    public void drawPacman(Graphics graphics)
    {
        ImageIcon img = new ImageIcon(imagePath);
        graphics.drawImage(img.getImage(),xAxis,yAxis,null);
    }
}
