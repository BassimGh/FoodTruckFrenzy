package foodtruckfrenzy.SecondaryUI;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import foodtruckfrenzy.GameFramework.Scoreboard;

public class GameOverScreenTest {

    private GameOverScreen gameOverScreen;
    private ActionListener startListener;
    private ActionListener exitListener;
    private ImagePaths imagePaths;
    private Scoreboard scoreboard;

    @BeforeEach
    public void setup() {
        startListener = mock(ActionListener.class);
        exitListener = mock(ActionListener.class);
        imagePaths = new ImagePaths("background.png", "restart.png", "exit.png");


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

    @Test
    public void testGameOverScreen() {
        GameOverScreen gameOverScreen = new GameOverScreen(startListener, exitListener, imagePaths, scoreboard);

        // Check that the final scores were correctly displayed
        JLabel scoresLabel = (JLabel) gameOverScreen.getComponent(1);
        assertEquals("FOUND: 10 Ingredients & 5 Recipes    TIME: 01:30    DAMAGE: 20   FINES: 100   SCORE: 500", scoresLabel.getText());
    }
}
