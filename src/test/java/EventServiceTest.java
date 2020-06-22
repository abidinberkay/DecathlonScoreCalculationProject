import model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.EventService;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class EventServiceTest {

    EventService eventService;

    @BeforeEach
    void init() { this.eventService = new EventService();
    }

    @DisplayName("Creating event")
    @Test
    public void createEvent() {
        String athleteScore = "12.61";
        Event event = eventService.createEvent(athleteScore);
        assertEquals(event.getScore(), BigDecimal.valueOf(536));
        assertEquals(event.getActivityName(), "100 Mts");
        assertEquals(event.getResult(), "12.61");
    }
}
