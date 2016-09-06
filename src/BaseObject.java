/**
 * Created by Sergey on 05.09.16.
 */
public abstract class BaseObject {

    protected double x ;
    protected double y ;
    protected double radius;


    protected BaseObject(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }



    public abstract void draw(Canvas canvas);

    public abstract void move();

    //Check if the object are crossed
    public boolean isIntersec(BaseObject o){
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius+1   , o.radius);
        return destination <= destination2;
    }

    public void checkBorders(double minx, double maxx, double miny, double maxy)
    {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }
}
