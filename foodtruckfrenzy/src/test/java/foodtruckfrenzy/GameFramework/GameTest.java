package foodtruckfrenzy.GameFramework;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setup() {
        game = new Game();
    }

    @AfterEach
    public void close() {
        game.forceClose();
    }

    @Test
    public void testHandlePause() {
        game.handlePause();
        assertFalse(game.getGameConditions().checkRunning());
    }

    @Test
    public void testHandleResume() {
        game.handlePause();
        assertFalse(game.getGameConditions().checkRunning());

        game.handleResume();
        assertTrue(game.getGameConditions().checkRunning());
    }
}
