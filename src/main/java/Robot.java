/**
 * Created by Rodrigo on 10/06/2016.
 */
public class Robot {

    private int x;
    private int y;
    private Direction facing;

    public Robot(int x, int y, Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }
}
