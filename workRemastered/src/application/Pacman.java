package application;/* Drew Schuster */
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JApplet;
import java.awt.*;
import java.lang.*;

/* This class contains the entire game... most of the game logic is in the Board class but this
   creates the gui and captures mouse and keyboard input, as well as controls the game states */
public class Pacman implements MouseListener, KeyListener
{

     public static int level;
    /* Create a new board */
    Board board =new Board();

    /* This timer is used to do request new frames be drawn*/
    javax.swing.Timer frameTimer;


    /* This constructor creates the entire game essentially */
    public Pacman()
    {
        Pacman.level = 1;
        board.requestFocus();

        /* Create and set up window frame*/
        JFrame jFrame =new JFrame();
        jFrame.setSize(430,480);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = jFrame.getSize().width;
        int h = jFrame.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        jFrame.setLocation(x, y);

        /* Add the board to the frame */
        jFrame.add(board ,BorderLayout.CENTER);

        /*Set listeners for mouse actions and button clicks*/
        board.addMouseListener(this);
        board.addKeyListener(this);

        /* Make frame visible, disable resizing */
        jFrame.setVisible(true);
        jFrame.setResizable(false);

        /* Set the New flag to 1 because this is a new game */
        board.New=1;

        /* Manually call the first frameStep to initialize the game. */
        stepFrame(false);

        /* Create a timer that calls stepFrame every 30 milliseconds */
        frameTimer = new javax.swing.Timer(30,new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                stepFrame(false);
            }
        });

        /* Start the timer */
        frameTimer.start();

        board.requestFocus();
    }

    /* This  function repaints only the parts of the screen that may have changed.
       Namely the area around every player ghost and the menu bars
    */
    public void repaint()
    {
        board.repaint ();
    }

    /* Steps the screen forward one frame */
    public void stepFrame(boolean New)
    {

        if (board.dying>0)
        {
            board.repaint();
            return;
        }


        if (!New)
        {

            board.player.move();

            /* Also move the ghosts, and update the pellet states */
            if (Player.changedInitPosition) {
                board.ghost1.move ( );
                board.ghost2.move ( );
                board.ghost3.move ( );
                board.ghost4.move ( );
            }

        }

        /* We either have a new game or the user has died, either way we have to reset the board */
        if (board.stopped || New)
        {
            /*Temporarily stop advancing frames */
            frameTimer.stop();

            /* If user is dying ... */
            while (board.dying >0)
            {
                /* Play dying animation. */
                stepFrame(false);
            }

            /* Move all game elements back to starting positions and orientations */
            board.player.currDirection='U';
            board.player.direction='U';
            board.player.desiredDirection='U';
            board.player.x = 200;
            board.player.y = 300;
            board.ghost1.x = 180;
            board.ghost1.y = 180;
            board.ghost2.x = 200;
            board.ghost2.y = 180;
            board.ghost3.x = 220;
            board.ghost3.y = 180;
            board.ghost4.x = 220;
            board.ghost4.y = 180;
            Pacman.level = 1;

            /* Advance a frame to display main state*/
            board.repaint(0,0,600,600);

            /*Start advancing frames once again*/
            board.stopped=false;
            frameTimer.start();
        }
        /* Otherwise we're in a normal state, advance one frame*/
        else
        {
            repaint();
        }
    }

    /* Handles user key presses*/
    public void keyPressed(KeyEvent e)
    {
        /* Pressing a key in the title screen starts a game */
        if (board.titleScreen)
        {
            Player.changedInitPosition = false;
            board.titleScreen = false;
            return;
        }
        /* Pressing a key in the win screen or game over screen goes to the title screen */
        else if (board.winScreen || board.overScreen)
        {
            board.titleScreen = true;
            board.winScreen = false;
            board.overScreen = false;
            return;
        }


        /* Otherwise, key presses control the player! */
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                board.player.desiredDirection='L';
                break;
            case KeyEvent.VK_RIGHT:
                board.player.desiredDirection='R';
                break;
            case KeyEvent.VK_UP:
                board.player.desiredDirection='U';
                break;
            case KeyEvent.VK_DOWN:
                board.player.desiredDirection='D';
                break;
        }

        repaint();
    }

    /* This function detects user clicks on the menu items on the bottom of the screen */
    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    /* Main function simply creates a new pacman instance*/
    public static void main(String [] args)
    {
        Pacman c = new Pacman();
    }
}
