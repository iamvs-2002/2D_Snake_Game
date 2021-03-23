import javax.swing.*;
import java.awt.*;

public class GraphicsClass extends JPanel {
    public GraphicsClass(){

    }
    public void paint(Graphics g){

        //border of the game
        g.setColor(Color.WHITE);
        g.drawRect(12,12,760,640);

        //the game frame, if the background has some other color
//        g.setColor(Color.BLACK);
//        g.fillRect(13,13,758,638);
    }
}
