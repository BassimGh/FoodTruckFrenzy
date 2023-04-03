package foodtruckfrenzy.SecondaryUI;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Dimension;

import foodtruckfrenzy.GameFramework.Scoreboard;

public class FrameTest {

    private Frame frame;
    private Screen screen;
    private Scoreboard scoreboard;
    
    @BeforeEach
    public void setUp() {
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
        
    }

    @Test
    public void testFrameCreation() {
        ScreenType screenType = ScreenType.TITLE;
        Frame frame = new Frame(screenType, scoreboard);
        Dimension expectedDimension = new Dimension(810,639);
        int tolerance = 15; //15 pixel margin of error to make up for differences between devices
        assertAll("frame",
        () -> assertTrue(frame.isVisible()),
        () -> assertEquals("Food Truck Frenzy", frame.getTitle()),
        () -> assertTrue(frame.getSize().width >= expectedDimension.width - tolerance && 
                        frame.getSize().width <= expectedDimension.width + tolerance),
        () -> assertTrue(frame.getSize().height >= expectedDimension.height - tolerance && 
                        frame.getSize().height <= expectedDimension.height + tolerance)
    );
    }

    
    @Test
    public void testTitleScreen() {
        Frame titleFrame = new Frame(ScreenType.TITLE, scoreboard);
        titleFrame.setVisible(false);
        assertEquals("Food Truck Frenzy", titleFrame.getTitle());
        assertTrue(titleFrame.getContentPane().getComponent(0) instanceof TitleScreen);
    }
    

    @Test
    public void testGameWonScreen() {
        Frame gameWonFrame = new Frame(ScreenType.GAME_WON, scoreboard);
        gameWonFrame.setVisible(false);
        assertEquals("Game Won!", gameWonFrame.getTitle());
        assertTrue(gameWonFrame.getContentPane().getComponent(0) instanceof GameWonScreen);
    }
    
    @Test
    public void testGameLostScreen() {
        Frame gameLostFrame = new Frame(ScreenType.GAME_LOST, scoreboard);
        gameLostFrame.setVisible(false);
        assertEquals("Game Lost!", gameLostFrame.getTitle());
        assertTrue(gameLostFrame.getContentPane().getComponent(0) instanceof GameLostScreen);
    }
    
}
