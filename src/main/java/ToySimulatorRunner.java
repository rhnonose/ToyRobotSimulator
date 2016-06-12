import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rodrigo on 12/06/2016.
 */
public class ToySimulatorRunner {

    private final static Pattern placePattern = Pattern.compile("PLACE (\\d),(\\d),(NORTH|SOUTH|EAST|WEST)");

    public static void runSimulator(List<String> commandList) {
        Simulator simulator = new Simulator(new Tabletop(5, 5));
        for(String command : commandList){
            Matcher matcher = placePattern.matcher(command);
            if(matcher.matches()){
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                String direction = matcher.group(3);
                Robot robot = new Robot(x, y, Direction.valueOf(direction));
                simulator.place(robot);
                continue;
            }
            if("MOVE".equals(command)){
                simulator.move();
                continue;
            }
            if("REPORT".equals(command)){
                System.out.println(simulator.report());
                continue;
            }
            simulator.turn(Rotation.valueOf(command));
        }
    }
}
