import fileProcesses.ProcessFile;
import model.Athlete;
import service.AthleteService;

import java.util.List;

/**
 * @author Berkay Simsek
 * @date 22/06/2020
 */
public class Decathlon {

    public static void main(String[] args) {
        String inputFilePath = "src\\main\\resources\\results.csv";
        String outputFilePath = "src\\main\\resources\\";
        if (args.length != 2 && args.length != 0) {
            System.out.println("Number of parameters is wrong. Do not send any parameter for default file locations 'src/main/resources' or send 2 parameters for input file path and output file path respectively");
        }
        if (args.length == 2) {
            inputFilePath = args[0];
            outputFilePath = args[1];
        }

        try {
            ProcessFile pf = new ProcessFile();
            List<String> fileRows = pf.readFile(inputFilePath);
            List<Athlete> athletes = (new AthleteService()).getAthletesWithResults(fileRows);
            pf.generateXmlFile(athletes, outputFilePath);
            System.out.println("Decathlon score report is generated and can be found at path: " + outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
