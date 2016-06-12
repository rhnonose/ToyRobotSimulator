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

    public static List<String> parse(File inputFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        List<String> commandList = new LinkedList<String>();
        String line;
        while((line = br.readLine()) != null){
            Matcher matcher = inputPattern.matcher(line);
            if(matcher.matches()){
                commandList.add(line);
            }
        }
        return commandList;
    }

}
