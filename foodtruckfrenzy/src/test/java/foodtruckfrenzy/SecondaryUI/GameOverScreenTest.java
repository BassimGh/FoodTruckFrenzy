package foodtruckfrenzy.SecondaryUI;

import static org.junit.Assert.assertEquals;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import foodtruckfrenzy.GameFramework.Scoreboard;


public class GameOverScreenTest {

    private GameOverScreen gameOverScreen;
    private ActionListener startListener;
    private ActionListener exitListener;
    private ImagePaths imagePaths;
    private Scoreboard scoreboard;

    @Before
    public void setup() {
        // Create a dummy ActionListener for the start button
        ActionListener startListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do nothing
            }
        };
        
        // Create a dummy ActionListener for the exit button
        ActionListener exitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do nothing
            }
        };


        // Create a dummy Scoreboard object
        scoreboard = mock(Scoreboard.class);
        // Define the expected values of the scoreboard's methods
        when(scoreboard.getIngredientsFound()).thenReturn(10);
        when(scoreboard.getRecipesFound()).thenReturn(5);
        when(scoreboard.getDamage()).thenReturn(20);
        when(scoreboard.getFines()).thenReturn(100);
        when(scoreboard.getScore()).thenReturn(500);
        when(scoreboard.getTime()).thenReturn("01:30");
        
        // Create an ImagePaths object with dummy image paths
        ImagePaths imagePaths = new ImagePaths("background.png", "restart.png", "exit.png");
        
        // Create a new GameOverScreen object for each test
        gameOverScreen = new GameOverScreen(startListener, exitListener, imagePaths, scoreboard);

    }

    @Test
    public void correctScoreboardValues() {
        int ingredientsFound = scoreboard.getIngredientsFound();
        int recipesFound = scoreboard.getRecipesFound();
        int damage = scoreboard.getDamage();
        int fines = scoreboard.getFines();
        int score = scoreboard.getScore();
        String time = scoreboard.getTime();

        assertEquals(10, ingredientsFound);
        assertEquals(5, recipesFound);
        assertEquals(20, damage);
        assertEquals(100, fines);
        assertEquals(500, score);
        assertEquals("01:30", time);
    }
}
