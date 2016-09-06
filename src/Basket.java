/**
 * Created by Sergey on 05.09.16.
 */
public class Basket extends BaseObject {

    private double speed = 1;

    private double direction = 1;

    private double dx;
    private double dy;
    private double center;

    public Basket(double x, double y, double speed, double radius) {
        super(x, y, radius);
        this.direction = direction;
        this.speed = speed;


    }


    private static int[][] matrix = {
            {0, 1, 1, 1,0},
            {1, 0, 0, 0,1},
            {1, 0, 0, 0,1},
            {0, 1, 1, 1,0},
            {0, 0, 0, 0,0},


    };

    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'B');
    }

    @Override
    public void move() {
        double dx = speed * direction;
        if (x > Basketball.game.getWidth()) {
            x = 0.0;
        } else {
            x = x + dx;
        }



    }


}
