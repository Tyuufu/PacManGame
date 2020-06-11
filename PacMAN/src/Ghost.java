import javax.swing.*;
import java.util.Random;

public class Ghost extends Pacman implements Runnable{

    private Scene scene;
    Random random = new Random();

    public Ghost (int xAxis, int yAxis, String imagePath, boolean isAlive, Scene scene) {
        super(xAxis, yAxis, imagePath, isAlive);
        this.scene = scene;
    }

    public void kill()
    {

    }
    @Override
    public void run() {
        while (true)
        {
            try{
                Thread.sleep(random.nextInt(200));
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Thread interrupted");
                System.exit(1);
            }

                System.out.println (getxAxis () );
                setxAxis(getxAxis() + 5);
                scene.repaint();
            }
        }
    }

