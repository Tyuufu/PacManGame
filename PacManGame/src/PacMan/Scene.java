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
    Ghost ghost1 = new Ghost (100, 100, "ghost10.jpg", true);

    private int Yincrement = 0;
    private int Xincrement = 0;

    public Level()
    {
        this.setFocusable (true);
        this.addKeyListener (this);
//        Thread thread = new Thread (ghost1);
//        thread.start ();

        jFrame.add(this);
        jFrame.setSize(500, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    public void paint(Graphics g)
    {
        g.drawImage(background.getImage(), 0, 0, null);
        pacMan.drawPacMAN (g);
        ghost1.drawGhostJpg (g);
    }



    @Override
    public void keyTyped (KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed (KeyEvent keyEvent) {

        switch(keyEvent.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                Xincrement = -4;
                pacMan.setImagePath ("img//pacmanleft.jpg");
              //  desiredDirection='L';
                break;
            case KeyEvent.VK_RIGHT:
                Xincrement = 4;
                pacMan.setImagePath ("img//pacmanright.jpg");
                //  desiredDirection='R';
                break;
            case KeyEvent.VK_UP:
                Yincrement = -4;
                pacMan.setImagePath ("img//pacmanup.jpg");
               // desiredDirection='U';
                break;
            case KeyEvent.VK_DOWN:
                Yincrement = 4;
                pacMan.setImagePath ("img//pacmandown.jpg");
                //desiredDirection='D';
                break;
        }
        pacMan.setxAxis (pacMan.getxAxis () + Xincrement);
        pacMan.setyAxis (pacMan.getyAxis () + Yincrement);
        Xincrement = 0;
        Yincrement = 0;
        repaint();
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

