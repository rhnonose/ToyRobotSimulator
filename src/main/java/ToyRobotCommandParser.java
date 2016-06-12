import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rodrigo on 12/06/2016.
 */
public class ToyRobotCommandParser {

    private final static Pattern inputPattern = Pattern.compile("((MOVE|RIGHT|LEFT|REPORT){1}|PLACE \\d,\\d,(NORTH|SOUTH|EAST|WEST))");
    private final File inputFile;
    private List<String> commandList;

    public ToyRobotCommandParser(File file) {
        inputFile = file;
    }

    public void parse() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;
        commandList = new LinkedList<String>();
        while((line = br.readLine()) != null){
            Matcher matcher = inputPattern.matcher(line);
            if(matcher.matches()){
                commandList.add(line);
            }
        }
    }

    private final static Pattern placePattern = Pattern.compile("PLACE (\\d),(\\d),(NORTH|SOUTH|EAST|WEST)");

    public void runSimulator() {
        Simulator simulator = new Simulator(new Tabletop(5, 5));
        for(String command : commandList){
            Matcher matcher = placePattern.matcher(command);
            if(matcher.matches()){
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                String direction = matcher.group(3);
                Robot robot = new Robot(x, y, Direction.valueOf(direction));
                simulator.place(robot);
            } else {
                if("MOVE".equals(command)){
                  simulator.move();
                } else if("REPORT".equals(command)){
                    System.out.println(simulator.report());
                } else {
                    simulator.turn(Rotation.valueOf(command));
                }
            }
        }
    }

    public List<String> getCommandList() {
        return commandList;
    }
}
