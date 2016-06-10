import org.junit.Test;

/**
 * Created by Rodrigo on 10/06/2016.
 */
public class ToyRobotSimulatorTest {

    public Tabletop createTabletop(){
        return new Tabletop(5, 5);
    }

    public Robot createRobot(){
        return new Robot(0, 0, Direction.NORTH);
    }

    @Test
    public void placeRobotOnTabletop(){
        Tabletop tabletop = createTabletop();
        Robot robot = createRobot();
        tabletop.place(robot);
    }
}
