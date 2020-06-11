package PacMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Level extends JPanel implements KeyListener, MouseListener {
    private JFrame jFrame = new JFrame("PackMAN");
    private ImageIcon background = new ImageIcon("img//abstract-background.png");
    PacMan pacMan = new PacMan (3, 0, 0 , "img//pacman.jpg", true );


    public Level()
    {
        this.setFocusable (true);
        this.addKeyListener (this);

        jFrame.add(this);
        jFrame.setSize(500, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    public void paint(Graphics g)
    {
        g.drawImage(background.getImage(), 0, 0, null);
        pacMan.drawPacMAN (g);
    }

    @Override
    public void keyTyped (KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed (KeyEvent keyEvent) {
        if (keyEvent.getKeyCode () == KeyEvent.VK_RIGHT){

            pacMan.setxAxis (pacMan.getxAxis ()+ 5);
            pacMan.setImagePath ("img//pacmanright.jpg");
            this.repaint ();
        }else if (keyEvent.getKeyCode () == KeyEvent.VK_UP){

            pacMan.setyAxis (pacMan.getyAxis ()- 5);
            pacMan.setImagePath ("img//pacmanup.jpg");
            this.repaint ();
        }else if (keyEvent.getKeyCode () == KeyEvent.VK_LEFT){

            pacMan.setxAxis (pacMan.getxAxis () - 5);
            pacMan.setImagePath ("img//pacmanleft.jpg");
            this.repaint ();
        }else if (keyEvent.getKeyCode () == KeyEvent.VK_DOWN){

            pacMan.setyAxis (pacMan.getyAxis () + 5);
            pacMan.setImagePath ("img//pacmandown.jpg");
            this.repaint ();
        }

    }

    @Override
    public void keyReleased (KeyEvent keyEvent) {

    }

    @Override
    public void mouseClicked (MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed (MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased (MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered (MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited (MouseEvent mouseEvent) {

    }
}

