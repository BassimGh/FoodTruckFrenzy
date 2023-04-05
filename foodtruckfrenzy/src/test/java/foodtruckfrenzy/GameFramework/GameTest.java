package foodtruckfrenzy.GameFramework;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import foodtruckfrenzy.Helper.KeyboardHandler;

public class GameTest {
    private Game game;


    @BeforeEach
    public void setup() {
        game = spy(new Game());
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

    @Test
    void testPausePressed() {
        KeyboardHandler keyboardHandler = Mockito.mock(KeyboardHandler.class);
        when(keyboardHandler.pausePressed()).thenReturn(true);

        game.overrideKeyboardHandler(keyboardHandler);
        game.gameTick();

        verify(game, times(1)).handlePause();
    }

    @Test
    void testLossConditionTrueOne() {
        GameConditions gameCondtions = Mockito.mock(GameConditions.class);
        when(gameCondtions.checkLoss()).thenReturn(true);
        when(gameCondtions.checkRunning()).thenReturn(true);

        game.overrideGameConditions(gameCondtions);
        game.gameTick();

        verify(game, times(1)).handleLoss();
    }

    @Test
    void testLossConditionTrueTwo() {
        GameConditions gameCondtions = Mockito.mock(GameConditions.class);
        when(gameCondtions.checkLoss()).thenReturn(false).thenReturn(true);
        when(gameCondtions.checkRunning()).thenReturn(true);

        game.overrideGameConditions(gameCondtions);
        game.gameTick();

        verify(game, times(1)).handleLoss();
    }

    @Test
    void testWinConditionTrue() {
        GameConditions gameCondtions = Mockito.mock(GameConditions.class);
        when(gameCondtions.checkWin()).thenReturn(true);
        when(gameCondtions.checkRunning()).thenReturn(true);

        game.overrideGameConditions(gameCondtions);
        game.gameTick();

        verify(game, times(1)).handleWin();
    }



}
