import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel{


    public int widhtOfScene = 500;
    public int heightOfScene = 500;

    JFrame jFrame = new JFrame("PacMON");
    Pacman pacman = new Pacman(1,1,"img//pacman.jpg", true);
    KeyEvents keyEvents = new KeyEvents(pacman, this);
    Ghost ghost1 = new Ghost (20,30 , "img//ghost10.jpg",true, this);



    public Scene()
    {
        jFrame.addKeyListener(keyEvents);
        jFrame.setFocusable(true);
        jFrame.add(this);
        Thread thread = new Thread(ghost1);
        thread.start(); // It basically calls the run method


        jFrame.setSize(widhtOfScene,heightOfScene);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }


    public void paint(Graphics graphics)
    {
        ImageIcon imageIcon = new ImageIcon("img//abstract-background.png");
        graphics.drawImage(imageIcon.getImage(),0,0,null);
        pacman.drawPacman(graphics);
        ghost1.drawPacman(graphics);

    }
}
