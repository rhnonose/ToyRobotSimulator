/**
 * Created by Rodrigo on 10/06/2016.
 */
public class Tabletop {

    private int x;
    private int y;
    private static final int ORIGIN_X = 0;
    private static final int ORIGIN_Y = 0;
    private Robot robot;

    public Tabletop(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void place(Robot robot) {
        if(robot.getX() >= ORIGIN_X && robot.getY() >= ORIGIN_Y && robot.getX() < x && robot.getY() < y){
            this.robot = robot;
        }
    }
}
