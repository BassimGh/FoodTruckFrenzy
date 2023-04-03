package foodtruckfrenzy.SecondaryUI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import foodtruckfrenzy.GameFramework.Scoreboard;

public class FrameTest {

    private Frame frame;
    private Screen screen;
    private Scoreboard scoreboard;
    
    @Before
    public void setup() {
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

    // @Test
    // public void testFrameCreation() {
    //     ScreenType screenType = ScreenType.TITLE;
    //     Frame frame = new Frame(screenType, scoreboard);
    //     Dimension expectedDimension = new Dimension(816,639);
    //     assertEquals(expectedDimension, frame.getSize());
    //     assertEquals("Food Truck Frenzy", frame.getTitle());
    //     assertTrue(frame.isVisible());
    // }

    
    @Test
    public void testTitleScreen() {
        Frame titleFrame = new Frame(ScreenType.TITLE, scoreboard);
        titleFrame.setVisible(false);
        assertEquals("Food Truck Frenzy", titleFrame.getTitle());
        assertTrue(titleFrame.getContentPane().getComponent(0) instanceof foodtruckfrenzy.SecondaryUI.TitleScreen);
    }
    

    @Test
    public void testGameWonScreen() {
        Frame gameWonFrame = new Frame(ScreenType.GAME_WON, scoreboard);
        gameWonFrame.setVisible(false);
        assertEquals("Game Won!", gameWonFrame.getTitle());
        assertTrue(gameWonFrame.getContentPane().getComponent(0) instanceof foodtruckfrenzy.SecondaryUI.GameWonScreen);
    }
    
    @Test
    public void testGameLostScreen() {
        Frame gameLostFrame = new Frame(ScreenType.GAME_LOST, scoreboard);
        gameLostFrame.setVisible(false);
        assertEquals("Game Lost!", gameLostFrame.getTitle());
        assertTrue(gameLostFrame.getContentPane().getComponent(0) instanceof foodtruckfrenzy.SecondaryUI.GameLostScreen);
    }

    // @Test
    // public void testFrameCentering() {
    //     Frame frame = new Frame(ScreenType.TITLE, scoreboard);
    //     Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    //     int expectedX = (screenDim.width - frame.getWidth()) / 2;
    //     int expectedY = (screenDim.height - frame.getHeight()) / 2 - 19;
    //     assertEquals(expectedX, frame.getLocation().x);
    //     assertEquals(expectedY, frame.getLocation().y);
    // }   
}
