import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        //setting the frame
        JFrame jFrame = new JFrame();
        jFrame.setTitle("2D Snake Game");
        jFrame.setBackground(Color.BLACK);
        jFrame.setBounds(300,30,800,700);
        jFrame.setResizable(false);
        jFrame.setFont(Font.getFont(Font.SANS_SERIF));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        //adding object of GraphicsClass as a component to the frame
        GraphicsClass graphicsClass = new GraphicsClass();
        jFrame.add(graphicsClass);

    }
}
