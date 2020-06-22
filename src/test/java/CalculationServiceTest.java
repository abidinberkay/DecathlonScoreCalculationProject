import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projectConstantsAndEnums.ScoreCalculationEnum;
import service.CalculationService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationServiceTest {

    CalculationService calculationService;

    @BeforeEach
    void init() { this.calculationService = new CalculationService();}

    @DisplayName("Score calculation test for Track Event")
    @Test
    public void testCalculationForTrackEvent() {
        BigDecimal scoreCalculate = ScoreCalculationEnum.SCE_MTS100.toDoCalculate("10");
        assertEquals(scoreCalculate, new BigDecimal("4758"));
    }

    @DisplayName("Score calculation test for Field Event")
    @Test
    public void testCalculationForFieldEvent() {
        BigDecimal scoreCalculate = ScoreCalculationEnum.SCE_LONGJUMP.toDoCalculate("5.00");
        assertEquals(new BigDecimal("382"), scoreCalculate);
    }
}
