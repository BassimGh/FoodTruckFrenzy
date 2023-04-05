package foodtruckfrenzy.GameFramework;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;
import foodtruckfrenzy.Helper.BoardElementFactory;
import foodtruckfrenzy.Helper.KeyboardHandler;
import foodtruckfrenzy.Helper.LayoutEnum;
import foodtruckfrenzy.Helper.MapLayout;

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
    public void testHandleRestart() {
        GameFrame frame = game.getFrame();
        assertTrue(frame.isDisplayable());
        game.handleRestart();
        assertFalse(frame.isDisplayable());
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

    @Test
    void testMoveUpInteraction() {
        GameConditions gameCondtions = Mockito.mock(GameConditions.class);
        when(gameCondtions.checkRunning()).thenReturn(true);
        KeyboardHandler keyboardHandler = Mockito.mock(KeyboardHandler.class);
        when(keyboardHandler.upPressed()).thenReturn(true);

        BoardElementFactory boardElementFactory = new BoardElementFactory();
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        Mockito.when(mapLayout.getElementAt(Mockito.anyInt(), Mockito.anyInt())).thenReturn(LayoutEnum.R);

        FoodTruck foodTruck = spy(new FoodTruck(5, 5, new Grid(boardElementFactory, mapLayout), new Scoreboard(5, 5)));
        game.overrideGameConditions(gameCondtions);
        game.overrideKeyboardHandler(keyboardHandler);
        game.overrideFoodTruck(foodTruck);
        game.gameTick();

        verify(foodTruck, times(1)).moveUp();
    }
    
    @Test
    void testMoveDownInteraction() {
        GameConditions gameCondtions = Mockito.mock(GameConditions.class);
        when(gameCondtions.checkRunning()).thenReturn(true);
        KeyboardHandler keyboardHandler = Mockito.mock(KeyboardHandler.class);
        when(keyboardHandler.downPressed()).thenReturn(true);

        BoardElementFactory boardElementFactory = new BoardElementFactory();
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        Mockito.when(mapLayout.getElementAt(Mockito.anyInt(), Mockito.anyInt())).thenReturn(LayoutEnum.R);

        FoodTruck foodTruck = spy(new FoodTruck(5, 5, new Grid(boardElementFactory, mapLayout), new Scoreboard(5, 5)));
        game.overrideGameConditions(gameCondtions);
        game.overrideKeyboardHandler(keyboardHandler);
        game.overrideFoodTruck(foodTruck);
        game.gameTick();

        verify(foodTruck, times(1)).moveDown();
    }

    @Test
    void testMoveRightInteraction() {
        GameConditions gameCondtions = Mockito.mock(GameConditions.class);
        when(gameCondtions.checkRunning()).thenReturn(true);
        KeyboardHandler keyboardHandler = Mockito.mock(KeyboardHandler.class);
        when(keyboardHandler.rightPressed()).thenReturn(true);

        BoardElementFactory boardElementFactory = new BoardElementFactory();
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        Mockito.when(mapLayout.getElementAt(Mockito.anyInt(), Mockito.anyInt())).thenReturn(LayoutEnum.R);

        FoodTruck foodTruck = spy(new FoodTruck(5, 5, new Grid(boardElementFactory, mapLayout), new Scoreboard(5, 5)));
        game.overrideGameConditions(gameCondtions);
        game.overrideKeyboardHandler(keyboardHandler);
        game.overrideFoodTruck(foodTruck);
        game.gameTick();

        verify(foodTruck, times(1)).moveRight();
    }

    @Test
    void testMoveLeftInteraction() {
        GameConditions gameCondtions = Mockito.mock(GameConditions.class);
        when(gameCondtions.checkRunning()).thenReturn(true);
        KeyboardHandler keyboardHandler = Mockito.mock(KeyboardHandler.class);
        when(keyboardHandler.leftPressed()).thenReturn(true);

        BoardElementFactory boardElementFactory = new BoardElementFactory();
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        Mockito.when(mapLayout.getElementAt(Mockito.anyInt(), Mockito.anyInt())).thenReturn(LayoutEnum.R);

        FoodTruck foodTruck = spy(new FoodTruck(5, 5, new Grid(boardElementFactory, mapLayout), new Scoreboard(5, 5)));
        game.overrideGameConditions(gameCondtions);
        game.overrideKeyboardHandler(keyboardHandler);
        game.overrideFoodTruck(foodTruck);
        game.gameTick();

        verify(foodTruck, times(1)).moveLeft();
    }



}
