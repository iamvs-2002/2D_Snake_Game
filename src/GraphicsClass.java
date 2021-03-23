import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GraphicsClass extends JPanel implements KeyListener, ActionListener {

    //position of snake along x and y axis
    private int[] snake_x_length = new int[500];
    private int[] snake_y_length = new int[500];

    //position of food
    private int[] food_x_pos = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600};
    private int[] food_y_pos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575};

    //length of snake initially
    private int lengthOfSnake = 3;

    //food position
    private Random random=new Random();
    private int x = random.nextInt(24);
    private int y = random.nextInt(21);

    //variables to check the direction of motion
    private boolean up=false, down=false, left=false, right=false;

    //image icons for the snake
    private ImageIcon upmouth,downmouth,leftmouth,rightmouth,snakebody,food;

    //for the speed
    private Timer timer;
    private int DELAY  = 100;

    //number of moves initially =0
    private int moves = 0;

    private int scores=0;

    public GraphicsClass()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(DELAY,this);
        timer.start();
    }
    public void paint(Graphics g){

        //border of the game
        g.setColor(Color.WHITE);
        g.drawRect(24,24,651,627);

        //the game frame
        g.setColor(Color.BLACK);
        g.fillRect(25,25,650,625);

        //show scores and length of snake
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial",Font.PLAIN,18));


        //border for score panel
        g.setColor(Color.BLACK);
        g.drawRect(24,652,651,101);

        //the game frame
        g.setColor(Color.BLACK);
        g.fillRect(25,653,650,100);


        g.setColor(Color.WHITE);
        g.drawString("Scores: "+scores, 50,680);
        g.drawString("Length: "+lengthOfSnake, 555,680);


        //initial position of snake
        if (moves==0)
        {
            snake_x_length[0] = 100;
            snake_x_length[1] = 75;
            snake_x_length[2] = 50;
            snake_y_length[0] = 100;
            snake_y_length[1] = 100;
            snake_y_length[2] = 100;

            //initially the mouth is towards right
            rightmouth = new ImageIcon("assets\\rightmouth.png");
            rightmouth.paintIcon(this,g,snake_x_length[0],snake_y_length[0]);
        }

        //drawing the snake
        for (int i=0;i<lengthOfSnake;i++){
            //mouth is at position 0
            if (i==0 && right){
                //right mouth
                rightmouth = new ImageIcon("assets\\rightmouth.png");
                rightmouth.paintIcon(this,g,snake_x_length[i],snake_y_length[i]);
            }
            if (i==0 && left){
                //left mouth
                leftmouth = new ImageIcon("assets\\leftmouth.png");
                leftmouth.paintIcon(this,g,snake_x_length[i],snake_y_length[i]);
            }
            if (i==0 && up){
                //up mouth
                upmouth = new ImageIcon("assets\\upmouth.png");
                upmouth.paintIcon(this,g,snake_x_length[i],snake_y_length[i]);
            }
            if (i==0 && down){
                //down mouth
                downmouth = new ImageIcon("assets\\downmouth.png");
                downmouth.paintIcon(this,g,snake_x_length[i],snake_y_length[i]);
            }
            else{
                //snake body
                snakebody = new ImageIcon("assets\\snakebody.png");
                snakebody.paintIcon(this,g,snake_x_length[i],snake_y_length[i]);
            }
        }

        //drawing the food
        food = new ImageIcon("assets\\food.png");
        food.paintIcon(this,g,food_x_pos[x],food_y_pos[y]);

        //updating the length and position of food when head collides with food
        if (food_x_pos[x]==snake_x_length[0] && food_y_pos[y]==snake_y_length[0]){
            lengthOfSnake++;
            scores++;
            x = random.nextInt(24);
            y = random.nextInt(21);
        }

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        //from actionlistener interface
        //starts when the timer begins

        int i;
        //checking direction
        if (right){
            System.out.println(moves);
            for (i=lengthOfSnake-1; i>=0; i--){
                //shifting the current position to next position
                snake_y_length[i+1] = snake_y_length[i];
            }

            for (i=lengthOfSnake; i>=0; i--){
                //if head, shift head by 25
                if (i==0){
                    snake_x_length[i]=snake_x_length[i]+25;
                }
                else{
                    snake_x_length[i] = snake_x_length[i-1];
                }
                if (snake_x_length[i]>650){
                    snake_x_length[i]=25;
                }
            }

            repaint();
        }
        else if (left){
            System.out.println(moves);
            for (i=lengthOfSnake-1; i>=0; i--){
                //shifting the current position to next position
                snake_y_length[i+1] = snake_y_length[i];
            }

            for (i=lengthOfSnake; i>=0; i--){
                //if head, shift head by 25
                if (i==0){
                    snake_x_length[i]=snake_x_length[i]-25;
                }
                else{
                    snake_x_length[i] = snake_x_length[i-1];
                }

                if (snake_x_length[i]<25){
                    snake_x_length[i]=650;
                }
            }

            repaint();
        }
        else if (up){
            System.out.println(moves);
            for (i=lengthOfSnake-1; i>=0; i--){
                //shifting the current position to next position
                snake_x_length[i+1] = snake_x_length[i];
            }

            for (i=lengthOfSnake; i>=0; i--){
                //if head, shift head by 25
                if (i==0){
                    snake_y_length[i]=snake_y_length[i]-25;
                }
                else{
                    snake_y_length[i] = snake_y_length[i-1];
                }

                if (snake_y_length[i]<25){
                    snake_y_length[i]=625;
                }
            }

            repaint();
        }
        else if (down){
            System.out.println(moves);
            for (i=lengthOfSnake-1; i>=0; i--){
                //shifting the current position to next position
                snake_x_length[i+1] = snake_x_length[i];
            }

            for (i=lengthOfSnake; i>=0; i--){
                //if head, shift head by 25
                if (i==0){
                    snake_y_length[i]=snake_y_length[i]+25;
                }
                else{
                    snake_y_length[i] = snake_y_length[i-1];
                }

                if (snake_y_length[i]>625){
                    snake_y_length[i]=25;
                }
            }

            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //checking which key is pressed: up, down, left, right

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            //restart
            moves=0;
            scores=0;
            lengthOfSnake=3;
            repaint();
        }


        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_KP_RIGHT){
            System.out.println(moves);
            //right key is pressed
            moves++;
            if (!left)
                right=true;
            else{
                left=true;
                right=false;
            }
            up=false;
            down=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_KP_LEFT){
            //right key is pressed
            moves++;
            if (!right)
                left=true;
            else{
                left=false;
                right=right;
            }
            up=false;
            down=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_KP_UP){
            //right key is pressed
            moves++;
            if (!down)
                up=true;
            else{
                down=true;
                up=false;
            }
            left=false;
            right=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_KP_DOWN){
            //right key is pressed
            moves++;
            if (!up)
                down=true;
            else{
                up=true;
                down=false;
            }
            left=false;
            right=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
