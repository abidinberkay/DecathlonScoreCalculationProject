import fileProcesses.ProcessFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.NoSuchFileException;
import java.util.List;

public class FileProcessServiceTest {

    ProcessFile processFile;

    @BeforeEach
    void init() {
        this.processFile = new ProcessFile();
    }

    @DisplayName("Check row number while reading input file")
    @Test
    public void readInputFileRowNumber() throws Exception {
        String inputFilePath = "src\\test\\resources\\testResults.csv";
        List<String> rows = processFile.readFile(inputFilePath);
        assertEquals(rows.size(), 6);
    }
}
