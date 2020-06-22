package fileProcesses;

import model.Athlete;
import model.OutputXmlFileData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProcessFile {

    public ProcessFile() {
    }

    public List<String> readFile(String inputFilePath) throws Exception {
        List<String> rows = new ArrayList<String>();
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(inputFilePath));
            lines.forEach(line -> {
                if (line != null && line.trim().length() > 1) {
                    rows.add(line);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("There is a problem while reading input file");
        } finally {
            if (lines != null) {
                lines.close();
            }
        }
        return rows;
    }

    public void generateXmlFile(List<Athlete> athletes, String outputFilePath) throws Exception {
        OutputXmlFileData fileData = new OutputXmlFileData();
        fileData.setAthletes(athletes);
        File file = new File(outputFilePath + "Decathlon Score Report.xml");
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(OutputXmlFileData.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(fileData, file);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new Exception("There is a problem while generating result report");
        }
    }
}
