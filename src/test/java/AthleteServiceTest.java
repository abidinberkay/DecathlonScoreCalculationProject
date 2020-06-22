import model.Athlete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.AthleteService;

import static org.junit.jupiter.api.Assertions.*;

public class AthleteServiceTest {

    AthleteService athleteService;

    @BeforeEach
    void init() { this.athleteService = new AthleteService(); }

    @DisplayName("Number field for the Athlete is missing some fields")
    @Test
    public void numberOfFieldForAthleteIsMissing() {
        String row = "Jane Doe;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88";
        String expectedMessage = "The row [" + row + "] missing some fields, please check it";
        try {
            Athlete athlete = athleteService.createAthlete(row);
        } catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(),expectedMessage);
        }
    }

    @DisplayName("Number field for the Athlete is more than expected")
    @Test
    public void numberOfFieldForAthleteIsMoreThanExpected() {
        String row = "Jane Doe;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;33.88;33.88;33.88;33.88";
        String expectedMessage = "The row [" + row + "] has more than expected value, please check it";
        try {
            Athlete athlete = athleteService.createAthlete(row);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),expectedMessage);
        }
    }

    @DisplayName("Number field for the Athlete is correct")
    @Test
    public void numberOfFieldForAthleteIsCorrect() {
        String row = "Jane Doe;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;40.47";;
        Athlete athlete = athleteService.createAthlete(row);
        assert true;
    }
}
