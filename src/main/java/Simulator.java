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
        if(isInsideTabletop(robot)){
            this.robot = robot;
        }
    }

    public void turn(Rotation rotation){
        switch (robot.getFacing()) {
            case NORTH:
                if(rotation.equals(Rotation.LEFT))
                    robot.setFacing(Direction.WEST);
                else
                    robot.setFacing(Direction.EAST);
                break;
            case SOUTH:
                if(rotation.equals(Rotation.LEFT))
                    robot.setFacing(Direction.EAST);
                else
                    robot.setFacing(Direction.WEST);
                break;
            case WEST:
                if(rotation.equals(Rotation.LEFT))
                    robot.setFacing(Direction.SOUTH);
                else
                    robot.setFacing(Direction.NORTH);
                break;
            case EAST:
                if(rotation.equals(Rotation.LEFT))
                    robot.setFacing(Direction.NORTH);
                else
                    robot.setFacing(Direction.SOUTH);
                break;
            default:

        }
    }

    private boolean isInsideTabletop(Robot robot) {
        return tabletop.getX() > robot.getX() && robot.getX() >= tabletop.ORIGIN_X &&
               tabletop.getY() > robot.getY() && robot.getY() >= tabletop.ORIGIN_Y;
    }

    public void move() {
        Robot newRobot;
        switch (robot.getFacing()){
            case NORTH:
                newRobot = new Robot(this.robot.getX(), this.robot.getY() + 1, this.robot.getFacing());
                if(isInsideTabletop(newRobot)){
                    robot = newRobot;
                }
                break;
            case SOUTH:
                newRobot = new Robot(this.robot.getX(), this.robot.getY() - 1, this.robot.getFacing());
                if(isInsideTabletop(newRobot)){
                    robot = newRobot;
                }
                break;
            case WEST:
                newRobot = new Robot(this.robot.getX() - 1, this.robot.getY(), this.robot.getFacing());
                if(isInsideTabletop(newRobot)){
                    robot = newRobot;
                }
                break;
            case EAST:
                newRobot = new Robot(this.robot.getX() + 1, this.robot.getY(), this.robot.getFacing());
                if(isInsideTabletop(newRobot)){
                    robot = newRobot;
                }
                break;
        }
    }

    public Robot getRobot() {
        return robot;
    }
}
