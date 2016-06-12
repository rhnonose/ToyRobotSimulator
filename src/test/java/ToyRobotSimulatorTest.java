import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

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

    public void placeRobotOnTabletop(){
        Tabletop tabletop = createTabletop();
        Robot robot = createRobot();
        Simulator simulator = new Simulator(tabletop);
        simulator.place(robot);
    }

    @Test
    public void turnRobot(){
        Tabletop tabletop = createTabletop();
        Robot robot = createRobot();
        Simulator simulator = new Simulator(tabletop);
        simulator.place(robot);
        simulator.turn(Rotation.LEFT);
        Assert.assertEquals(simulator.getRobot().getFacing(), Direction.WEST);
        simulator.turn(Rotation.LEFT);
        Assert.assertEquals(simulator.getRobot().getFacing(), Direction.SOUTH);
        simulator.turn(Rotation.LEFT);
        Assert.assertEquals(simulator.getRobot().getFacing(), Direction.EAST);
        simulator.turn(Rotation.LEFT);
        Assert.assertEquals(simulator.getRobot().getFacing(), Direction.NORTH);
        simulator.turn(Rotation.RIGHT);
        Assert.assertEquals(simulator.getRobot().getFacing(), Direction.EAST);
        simulator.turn(Rotation.RIGHT);
        Assert.assertEquals(simulator.getRobot().getFacing(), Direction.SOUTH);
        simulator.turn(Rotation.RIGHT);
        Assert.assertEquals(simulator.getRobot().getFacing(), Direction.WEST);
        simulator.turn(Rotation.RIGHT);
        Assert.assertEquals(simulator.getRobot().getFacing(), Direction.NORTH);
    }

    @Test
    public void moveRobot(){
        Tabletop tabletop = createTabletop();
        Robot robot = createRobot();
        Simulator simulator = new Simulator(tabletop);
        simulator.place(robot);
        simulator.move();
        Assert.assertEquals("Should stay in the same column", simulator.getRobot().getX(), 0);
        Assert.assertEquals("Should walk one row up", simulator.getRobot().getY(), 1);
        Assert.assertEquals("Should face same direction", simulator.getRobot().getFacing(), Direction.NORTH);
        simulator.move();
        Assert.assertEquals("Should stay in the same column", simulator.getRobot().getX(), 0);
        Assert.assertEquals("Should walk one row up", simulator.getRobot().getY(), 2);
        Assert.assertEquals("Should face same direction", simulator.getRobot().getFacing(), Direction.NORTH);
        simulator.turn(Rotation.RIGHT);
        simulator.move();
        Assert.assertEquals("Should walk one column east", simulator.getRobot().getX(), 1);
        Assert.assertEquals("Should stay in the same row", simulator.getRobot().getY(), 2);
        Assert.assertEquals("Should change direction to east", simulator.getRobot().getFacing(), Direction.EAST);
    }

    @Test
    public void ignoreInvalidMovement(){
        Tabletop tabletop = createTabletop();
        Robot robot = createRobot();
        Simulator simulator = new Simulator(tabletop);
        simulator.place(robot);
        simulator.turn(Rotation.LEFT);
        simulator.turn(Rotation.LEFT);
        simulator.move();
        Assert.assertEquals("Should stay in the same column", simulator.getRobot().getX(), 0);
        Assert.assertEquals("Should stay in the same row", simulator.getRobot().getY(), 0);
        Assert.assertEquals("Should change direction to south", simulator.getRobot().getFacing(), Direction.SOUTH);
    }

    @Test
    public void parseCommands() throws IOException {
        ToyRobotCommandParser parser = new ToyRobotCommandParser(new File("src/test/resources/example_a.txt"));
        parser.parse();
        List<String> commandList = parser.getCommandList();
        List<String> expected = Arrays.asList("PLACE 0,0,NORTH", "MOVE", "LEFT", "RIGHT", "REPORT");
        Assert.assertEquals("Should parse commands to strings", commandList, expected);
    }
}
