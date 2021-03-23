import javax.swing.*;
import java.awt.*;

public class GraphicsClass extends JPanel {

    //length of snake along x and y axis
    private int[] snake_x_length = new int[500];
    private int[] snake_y_length = new int[500];

    //length of snake initially
    private int lengthOfSnake = 3;

    //variables to check the direction of motion
    private boolean up=false, down=false, left=false, right=false;

    //image icons for the snake
    private ImageIcon upmouth,downmouth,leftmouth,rightmouth,snakebody,food;

    //for the speed
    private Timer timer;
    private int DELAY  = 100;

    //number of moves initially =0
    private int moves = 0;

    public GraphicsClass(){

    }
    public void paint(Graphics g){

        //border of the game
        g.setColor(Color.WHITE);
        g.drawRect(12,12,760,640);

        //the game frame, if the background has some other color
//        g.setColor(Color.BLACK);
//        g.fillRect(13,13,758,638);


        //initial postion of snake
        if (moves==0)
        {
            snake_x_length[0] = 100;
            snake_x_length[1] = 75;
            snake_x_length[2] = 50;
            snake_y_length[0] = 100;
            snake_y_length[1] = 100;
            snake_y_length[2] = 100;

            //initially the mouth is towards right
            rightmouth = new ImageIcon("rightmouth.png");
            rightmouth.paintIcon(this,g,snake_x_length[0],snake_y_length[0]);
        }



        //drawing the snake
        for (int i=0;i<lengthOfSnake;i++){
            //mouth is at position 0
            if (i==0 && right){
                //right mouth
                rightmouth = new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this,g,snake_x_length[i],snake_y_length[i]);
            }
            if (i==0 && left){
                //left mouth
                leftmouth = new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this,g,snake_x_length[i],snake_y_length[i]);
            }
            if (i==0 && up){
                //up mouth
                upmouth = new ImageIcon("upmouth.png");
                upmouth.paintIcon(this,g,snake_x_length[i],snake_y_length[i]);
            }
            if (i==0 && down){
                //down mouth
                downmouth = new ImageIcon("downmouth.png");
                downmouth.paintIcon(this,g,snake_x_length[i],snake_y_length[i]);
            }
            else{
                //snake body
                snakebody = new ImageIcon("snakebody.png");
                snakebody.paintIcon(this,g,snake_x_length[i],snake_y_length[i]);
            }
        }
        g.dispose();

    }
}
