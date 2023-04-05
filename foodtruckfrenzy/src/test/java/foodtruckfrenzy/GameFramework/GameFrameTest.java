package foodtruckfrenzy.GameFramework;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.swing.JPanel;
import java.awt.Component;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import foodtruckfrenzy.SecondaryUI.PauseScreen;

public class GameFrameTest {
    private GamePanel gamePanel;
    private Scoreboard scoreboardPanel;
    private PauseScreen pauseScreen;
    private GameFrame gameFrame;


    @BeforeEach
    void setup() {
        gamePanel = spy(new GamePanel(null, null, null));
        scoreboardPanel = new Scoreboard(0, 0);
        pauseScreen = new PauseScreen(null, null);
        gameFrame = new GameFrame(gamePanel, scoreboardPanel, pauseScreen);
    }

    @AfterEach
    void close() {
        gameFrame.dispose();
    }

    @Test
    void testGameFrameCreation() {
        assertNotNull(gameFrame);
        assertEquals(gamePanel, gameFrame.getMainPanel().getComponent(0));
        assertEquals(pauseScreen, gameFrame.getMainPanel().getComponent(1));
    }

    @Test
    void testShowPauseScreen() {
        gameFrame.showPauseScreen();
        Component visibleComponent = gameFrame.getMainPanel().getComponents()[getVisibleComponentIndex(gameFrame.getMainPanel())];
        assertEquals(pauseScreen, visibleComponent);
    }

    @Test
    void testShowGameScreen() {
        gameFrame.showGameScreen();
        Component visibleComponent = gameFrame.getMainPanel().getComponents()[getVisibleComponentIndex(gameFrame.getMainPanel())];
        assertEquals(gamePanel, visibleComponent);
    }

    @Test
    void testRefresh() {
        GameFrame gameFrame = new GameFrame(gamePanel, scoreboardPanel, pauseScreen);
        Mockito.reset(gamePanel);
        gameFrame.refresh();
        verify(gamePanel, times(1)).repaint();
}

    int getVisibleComponentIndex(JPanel mainPanel) {
        for (int i = 0; i < mainPanel.getComponentCount(); i++) {
            if (mainPanel.getComponent(i).isVisible()) {
                return i;
            }
        }
        return -1;
    }
}
