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
        Assert.assertEquals("Should rotate", simulator.report(), "0,0,WEST");
        simulator.turn(Rotation.LEFT);
        Assert.assertEquals("Should rotate", simulator.report(), "0,0,SOUTH");
        simulator.turn(Rotation.LEFT);
        Assert.assertEquals("Should rotate", simulator.report(), "0,0,EAST");
        simulator.turn(Rotation.LEFT);
        Assert.assertEquals("Should rotate", simulator.report(), "0,0,NORTH");
        simulator.turn(Rotation.RIGHT);
        Assert.assertEquals("Should rotate", simulator.report(), "0,0,EAST");
        simulator.turn(Rotation.RIGHT);
        Assert.assertEquals("Should rotate", simulator.report(), "0,0,SOUTH");
        simulator.turn(Rotation.RIGHT);
        Assert.assertEquals("Should rotate", simulator.report(), "0,0,WEST");
        simulator.turn(Rotation.RIGHT);
        Assert.assertEquals("Should rotate", simulator.report(), "0,0,NORTH");
    }

    @Test
    public void moveRobot(){
        Tabletop tabletop = createTabletop();
        Robot robot = createRobot();
        Simulator simulator = new Simulator(tabletop);
        simulator.place(robot);
        simulator.move();
        Assert.assertEquals("Should walk one row up", simulator.report(), "0,1,NORTH");
        simulator.move();
        Assert.assertEquals("Should walk one row up", simulator.report(), "0,2,NORTH");
        simulator.turn(Rotation.RIGHT);
        simulator.move();
        Assert.assertEquals("Should walk one row up", simulator.report(), "1,2,EAST");
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
        Assert.assertEquals("Should walk one row up", simulator.report(), "0,0,SOUTH");
    }

    @Test
    public void parseCommands() throws IOException {
        ToyRobotCommandParser parser = new ToyRobotCommandParser(new File("src/test/resources/example_a.txt"));
        parser.parse();
        List<String> commandList = parser.getCommandList();
        List<String> expected = Arrays.asList("PLACE 0,0,NORTH", "MOVE", "LEFT", "RIGHT", "REPORT");
        Assert.assertEquals("Should parse commands to strings", commandList, expected);
    }

    @Test
    public void runExampleB() throws IOException {
        ToyRobotCommandParser parser = new ToyRobotCommandParser(new File("src/test/resources/example_B.txt"));
        parser.parse();
        List<String> commandList = parser.getCommandList();
        List<String> expected = Arrays.asList("PLACE 0,0,NORTH", "LEFT", "REPORT");
        Assert.assertEquals("Should parse commands to strings", commandList, expected);
        parser.runSimulator();
    }

    @Test
    public void runExampleC() throws IOException {
        ToyRobotCommandParser parser = new ToyRobotCommandParser(new File("src/test/resources/example_c.txt"));
        parser.parse();
        List<String> commandList = parser.getCommandList();
        List<String> expected = Arrays.asList("PLACE 1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT");
        Assert.assertEquals("Should parse commands to strings", commandList, expected);
        parser.runSimulator();
    }
}
