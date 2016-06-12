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

    public List<String> getCommandList() {
        return commandList;
    }
}
