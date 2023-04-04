package foodtruckfrenzy.GameFramework;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setup() {
        game = new Game();
    }

    @Test
    public void testHandlePause() {
        game.startTimer();
        game.handlePause();
        assertFalse(game.getGameConditions().checkRunning());
    }

    @Test
    public void testHandleResume() {
        game.startTimer();
        game.handlePause();
        assertFalse(game.getGameConditions().checkRunning());

        game.handleResume();
        assertTrue(game.getGameConditions().checkRunning());
    }
}
