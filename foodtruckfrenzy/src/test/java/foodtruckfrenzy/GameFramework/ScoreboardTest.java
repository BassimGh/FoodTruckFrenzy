package foodtruckfrenzy.GameFramework;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ScoreboardTest {

    private Scoreboard scoreboard;

    @BeforeEach
    void setup() {
        scoreboard = new Scoreboard(0,0);
    }

    // Test that the scoreboard displays the correct score when the game starts.
    @Test
    void startupValues() {
        // check all values are 0
        assertEquals(0, scoreboard.getScore());
        assertEquals(0, scoreboard.getIngredientsFound());
        assertEquals(0, scoreboard.getRecipesFound());
        assertEquals(0, scoreboard.getFines());
        assertEquals(0, scoreboard.getDamage());
    }

    /* 
     * Testing setters and getters
     */
    @Test
    public void testScore() {
        scoreboard.addScore(100);
        assertEquals(100, scoreboard.getScore());
    }

    @Test
    public void testIngredients() {
        scoreboard.addIngredientsFound();
        assertEquals(1, scoreboard.getIngredientsFound());
    }

    @Test
    public void testRecipes() {
        scoreboard.addRecipesFound();
        assertEquals(1, scoreboard.getRecipesFound());
    }

    @Test
    public void testFines() {
        scoreboard.addFines(100);
        assertEquals(100, scoreboard.getFines());
    }

    @Test
    public void testDamages() {
        scoreboard.addDamage(100);
        assertEquals(100, scoreboard.getDamage());
    }

    @Test
    public void testPauseTimer() {
        assertFalse(scoreboard.isTimerPaused());
        scoreboard.pauseTimer();
        assertTrue(scoreboard.isTimerPaused());
    }

    /*
     * Testing Timer 
     */
    @Test
    void testResumeTimer() {
        scoreboard.pauseTimer();
        // make sure timer is paused
        assertTrue(scoreboard.isTimerPaused());
        
        scoreboard.resumeTimer();
        // make sure timer is no longer paused
        assertFalse(scoreboard.isTimerPaused());
    }
}

