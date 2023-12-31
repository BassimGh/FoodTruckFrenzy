package foodtruckfrenzy.GameFramework;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;
import foodtruckfrenzy.Helper.BoardElementFactory;
import foodtruckfrenzy.Helper.KeyboardHandler;
import foodtruckfrenzy.Helper.MapLayout;
import foodtruckfrenzy.Helper.VehicleSpawner;
import foodtruckfrenzy.SecondaryUI.Frame;
import foodtruckfrenzy.SecondaryUI.PauseScreen;
import foodtruckfrenzy.SecondaryUI.ScreenType;

/**
 * This class is the logic behind the game
 * Creating a new instance of this class creates a new game with everything
 * Includes the Frame, all panels, the charactes and everything
 * Potentially should be refactored to a singleton object as only one of these should exist at a time
 */
public class Game {

    private final int TIMER_DELAY = 10; // in milliseconds

    private final GameFrame _frame;
    private FoodTruck _mainCharacter;
    private final ArrayList<Cop> _cops;
    private final Timer _timer;
    private GameConditions _gameConditions;
    private KeyboardHandler _keyboardHandler;

    private int timerIndex;


    /**
     * Game constructor
     * Creates everything needed to run the game instance
     */
    public Game() {
        Grid grid = new Grid(new BoardElementFactory(), new MapLayout());
        Scoreboard scoreboard = new Scoreboard(grid.getIngredientsDiscoverable(), grid.getRecipesDiscoverable());
        VehicleSpawner spawner = new VehicleSpawner(grid, scoreboard);
        _mainCharacter = spawner.getFoodTruck();
        _cops = spawner.getCops();
        _gameConditions = new GameConditions(_cops, _mainCharacter);

        /**
         * Action listener for the pause menu which resumes the game on interaction
         */
        ActionListener resumeListener = e -> handleResume();

        /**
         * Action listener for the pause menu which restarts the game on interaction
         */
        ActionListener restartListener = e -> handleRestart();

        PauseScreen pausePanel = new PauseScreen(resumeListener, restartListener);
        GamePanel gamePanel = new GamePanel(grid, _mainCharacter, _cops);
        _keyboardHandler = new KeyboardHandler();
        _frame = new GameFrame(gamePanel, scoreboard, pausePanel);
        _frame.addKeyListener(_keyboardHandler);
        _frame.setVisible(true);
        
 
        timerIndex = 0;
        _timer = new Timer(TIMER_DELAY, e -> gameTick());
        _timer.start();
    }

    /*
     * gameTick controls all game running logic
     * Controls player movement and cop movement
     * Checks for win and loss condidions
     */
    void gameTick() {
        _frame.refresh();

        if (_gameConditions.checkRunning()) {
            if (_keyboardHandler.pausePressed())
                handlePause();

            if (_gameConditions.checkWin()) {
                handleWin();
                return;
            }

            boolean moved = false;
            if (_keyboardHandler.upPressed() && !_keyboardHandler.downPressed() && !moved && timerIndex % 5 == 0)
                moved = _mainCharacter.moveUp();

            if (_keyboardHandler.downPressed() && !_keyboardHandler.upPressed() && !moved && timerIndex % 5 == 0)
                moved = _mainCharacter.moveDown();

            if (_keyboardHandler.leftPressed() && !_keyboardHandler.rightPressed() && !moved && timerIndex % 5 == 0)
                moved = _mainCharacter.moveLeft();
                
            if (_keyboardHandler.rightPressed() && !_keyboardHandler.leftPressed() && !moved && timerIndex % 5 == 0)
                moved = _mainCharacter.moveRight();

            timerIndex = (timerIndex + 1) % Integer.MAX_VALUE;
            
            // Check if there is a loss of game after player movement
            if (_gameConditions.checkLoss()) {
                handleLoss();
                return;
            }

            for (int i = 0; i < _cops.size(); i++) {
                if (timerIndex % (i * 2 + 8) == 0)
                    _cops.get(i).chaseTruck();
            }

            // Check if there is a loss of game after cop movement
            if (_gameConditions.checkLoss()) {
                handleLoss();
                return;
            }
        }
    }

    /**
     * Pauses the game and shows the pause menu 
     * While suspending the game loop through a boolean value update
     * Pauses scoreboard timer
     */
    void handlePause() {
        _gameConditions.pause();
        _frame.showPauseScreen();
        _mainCharacter.getScoreboard().pauseTimer();
    }

    /**
     * Resumes the game and shows the game panel 
     * While resuming the game loop through a boolean value update
     * Resumes scoreboard timer
     */
    void handleResume() {
        _gameConditions.resume();
        _frame.showGameScreen();
        _mainCharacter.getScoreboard().resumeTimer();
    }

    /**
     * Restarts the game
     * Creates a new instance of game and starts it
     * disposes of current game frame
     */
    void handleRestart() {
        new Game();
        _frame.dispose();
    }

    /**
     * Function to be called when the game ends in a loss
     * Kills the frame and timer
     * Shows a new GAME_LOST screen Frame
     * Sets paused to true to prevent further loop progression
     */
    void handleLoss() {
        _timer.stop();
        _frame.dispose();
        new Frame(ScreenType.GAME_LOST, _mainCharacter.getScoreboard());
    }

    /**
     * Function to be called when the game ends in a win
     * Kills the frame and timer
     * Shows a new GAME_WON screen Frame
     * Sets paused to true to prevent further loop progression
     */
    void handleWin() {
        _timer.stop();
        _frame.dispose();
        new Frame(ScreenType.GAME_WON, _mainCharacter.getScoreboard());
    }

    /**
     * Get the GameConditions manager object for this game instance
     * @return GameConditions object for this game instance
     */
    GameConditions getGameConditions() {
        return _gameConditions;
    }

    /**
     * Force closes the game
     * Terminates the timer
     * Disposes of the frame
     */
    void forceClose() {
        _timer.stop();
        _frame.dispose();
    }

    /**
     * For testing purposes, overrides the keyboard handler
     * @param keyboardHandler to override the keyboard handler
     */
    void overrideKeyboardHandler(KeyboardHandler keyboardHandler) {
        _keyboardHandler = keyboardHandler;
    }

    /**
     * For testing purposes, overrides the game conditions
     * @param gameConditions to override the game conditions
     */
    void overrideGameConditions(GameConditions gameConditions) {
        _gameConditions = gameConditions;
    }

    /**
     * For testing purposes, overrides the food truck
     * @param foodTruck to override the food truck
     */
    void overrideFoodTruck(FoodTruck foodTruck) {
        _mainCharacter = foodTruck;
    }

    GameFrame getFrame() {
        return _frame;
    }

}
