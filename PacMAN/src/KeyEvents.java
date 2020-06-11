import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEvents implements KeyListener {

    private Pacman pacman;
    private Scene scene;
    private String right = "img//pacmanright.jpg";
    private String left = "img//pacmanleft.jpg";
    private String up = "img//pacmanup.jpg";
    private String down = "img//pacmandown.jpg";
    private String lastMove = "";
    private int Yincrement = 0;
    private int Xincrement = 0;

    private int speed = 5;

    public KeyEvents(Pacman pacman, Scene scene)
    {
        this.scene = scene;
        this.pacman = pacman;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        switch(keyEvent.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                Xincrement = -4;
                pacman.setImagePath(left);
                lastMove = left;
                break;

            case KeyEvent.VK_RIGHT:
                Xincrement = 4;
                pacman.setImagePath(right);
                lastMove = right;
                break;

            case KeyEvent.VK_UP:
                Yincrement = -4;
                pacman.setImagePath (up);
                lastMove = up;
                break;

            case KeyEvent.VK_DOWN:
                Yincrement = 4;
                pacman.setImagePath (down);
                lastMove = down;
                break;
        }

        pacman.setxAxis (pacman.getxAxis () + Xincrement);
        pacman.setyAxis (pacman.getyAxis () + Yincrement);
        Xincrement = 0;
        Yincrement = 0;
        scene.repaint ();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
