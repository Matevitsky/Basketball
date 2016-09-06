/**
 * Created by Sergey on 05.09.16.
 */
public class Ball extends BaseObject {


    private double speed;

    private double direction;

    private double startX;
    private double startY;

    private boolean isFrozen;

    private static int[][] matrix = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0}

    };




    public Ball(int x, double y,double radius) {
        super(x, y, radius);
        startX = x;
        startY = y;


        this.speed = 4;

        this.isFrozen = true;
    }


    @Override
    public void move() {
        if (isFrozen()) {
            if (Basketball.game.getPlayer().isPlayerMovedLeft()) {
                moveLeft();
                checkBorders(3, Basketball.game.getWidth() - 2, 3, Basketball.game.getHeight() + 1);
            } else if (Basketball.game.getPlayer().isPlayerMovedRight()) {
                moveRight();
                checkBorders(x, Basketball.game.getWidth() - 2, 3, Basketball.game.getHeight() + 1);
            }
        }
        if (isFrozen()) {
            return;
        }
        y -= speed;


        checkRebound(1, Basketball.game.getWidth(), 1, Basketball.game.getHeight() + 5);
    }

    public void moveLeft() {
        x = x - 1;
    }

    public void moveRight() {
        x = x + 1;
    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawMatrix(x - radius + 1, y, matrix, 'B');
    }


    public void checkRebound(int minx, int maxx, int miny, int maxy) {


        if (y < miny) {
            y = miny + (miny - y);
            y = startY;
            x = startX;
            isFrozen = true;


        }
    }


    public boolean isFrozen() {
        return isFrozen;
    }

    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

   /* public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }*/

    public void start() {
        isFrozen = false;
        move();

    }

}
