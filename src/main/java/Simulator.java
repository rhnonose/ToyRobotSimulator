/**
 * Created by Rodrigo on 10/06/2016.
 */
public class Simulator {
    private Tabletop tabletop;
    private Robot robot;

    public Simulator(Tabletop tabletop) {
        this.tabletop = tabletop;
    }

    public void place(Robot robot) {
        if(robot.getX() >= tabletop.ORIGIN_X && robot.getY() >= tabletop.ORIGIN_Y &&
           robot.getX() < tabletop.getX() && robot.getY() < tabletop.getY()){
            this.robot = robot;
        }
    }
}
