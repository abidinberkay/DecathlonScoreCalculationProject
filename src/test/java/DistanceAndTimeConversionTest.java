import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.DistanceAndTimeConvertingService;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

public class DistanceAndTimeConversionTest {

    DistanceAndTimeConvertingService distanceAndTimeConvertingService;

    @BeforeEach
    void init() { this.distanceAndTimeConvertingService = new DistanceAndTimeConvertingService(); }

    @DisplayName("Getting second")
    @Test
    public void getSecondTest() {
        String second = "12.61";
        BigDecimal bd = distanceAndTimeConvertingService.getSecond(second);
        assertEquals(bd, BigDecimal.valueOf(12.609999656677246));
    }

    @DisplayName("Getting centimetres")
    @Test
    public void getCentimetersTest() {
        BigDecimal bd = distanceAndTimeConvertingService.getCentimeters("100");
        assertEquals(bd.toString(), "10000.000000");
    }
}
