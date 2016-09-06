/**
 * Created by Sergey on 05.09.16.
 */
public class Player extends BaseObject {

    private double speed = 1;
    private boolean playerMovedLeft;
    private boolean playerMovedRight;


    public Player(double x, double y) {
        super(x,y,3);
        speed = 1;
        playerMovedLeft = false;
        playerMovedRight = false;


    }



    private static int[][] matrix = {
            {0, 1, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0},
    };



    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'H');
    }

    @Override
    public void move() {
           if(playerMovedLeft) {
               x = x - speed;
           }
           if(playerMovedRight){
               x = x + speed;
           }

            checkBorders(radius, Basketball.game.getWidth() - radius + 1, 1, Basketball.game.getHeight() + 1);
        }

    public void moveLeft()
    {

        x  = x - 1;
       playerMovedLeft = true;
    }



    public void moveRight()
    {

      //  direction = 1;
        x  = x - 1;
        playerMovedRight = true;
    }

    public boolean isPlayerMovedLeft() {
        return playerMovedLeft;
    }

    public void setPlayerMovedLeft(boolean playerMovedLeft) {
        this.playerMovedLeft = playerMovedLeft;
    }

    public boolean isPlayerMovedRight() {
        return playerMovedRight;
    }

    public void setPlayerMovedRight(boolean playerMovedRight) {
        this.playerMovedRight = playerMovedRight;
    }
}

