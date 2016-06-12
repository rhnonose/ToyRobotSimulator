import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Rodrigo on 12/06/2016.
 */
public class SimulatorRunner {

    public static void main(String[] args) throws IOException {
        List<String> commandList = ToyRobotCommandParser.parse(new File("src/main/resources/input.txt"));
        List<String> reports = ToySimulatorRunner.runSimulator(commandList);
        System.out.println("------------ToyRobotSimulator------------");
        reports.stream().forEach(System.out::println);
        System.out.println("------------ToyRobotSimulator------------");
    }

}