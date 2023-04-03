package foodtruckfrenzy.GameFramework;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

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

/*
 * This class is the logic behind the game
 * Creating a new instance of this class creates a new game with everything
 * Includes the Frame, all panels, the charactes and everything
 * Potentially should be refactored to a singleton object as only one of these should exist at a time
 */
public class Game {
    

    private final int TIMER_DELAY = 10; // in milliseconds

    private final GameFrame _frame;
    private final FoodTruck _mainCharacter;
    private final Timer _timer;
    private boolean _paused = false;
    private boolean _invincible = false;

    private int timerIndex;


    /*
     * Game constructor
     * Creates everything needed to run the game instance
     */
    public Game() {
        Grid grid = new Grid(new BoardElementFactory(), new MapLayout());
        Scoreboard scoreboard = new Scoreboard(grid.getIngredientsDiscoverable(), grid.getRecipesDiscoverable());
        VehicleSpawner spawner = new VehicleSpawner(grid, scoreboard);
        _mainCharacter = spawner.getFoodTruck();
        ArrayList<Cop> cops = spawner.getCops();
        GameConditions gameConditions = new GameConditions(cops, _mainCharacter);

        /**
         * Action listener for the pause menu which resumes the game on interaction
         */
        ActionListener resumeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resume();
            }
        };

        /**
         * Action listener for the pause menu which goes to the title screen on interaction
         */
        ActionListener restartListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game();
                game.startTimer();
                _frame.dispose();
            }
        };

        
        PauseScreen pausePanel = new PauseScreen(resumeListener, restartListener);
        GamePanel gamePanel = new GamePanel(grid, _mainCharacter, cops);
        KeyboardHandler keyboardHandler = new KeyboardHandler();
        _frame = new GameFrame(gamePanel, scoreboard, pausePanel);
        _frame.addKeyListener(keyboardHandler);
        
        /*
         * Game tick timer which controls all game running logic
         * Controls player movement and cop movement
         * Checks for win and loss condidions
         */
        timerIndex = 0;
        _timer = new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (keyboardHandler.invinciblePressed() && _invincible == false) {
                    _frame.setTitle("INVINCIBLE MODE ACTIVATED");
                    _invincible = true;
                } else if (keyboardHandler.invinciblePressed() && _invincible == true) {
                    _frame.setTitle("Food Truck Frenzy");
                    _invincible = false;
                }

                if (!_paused) {
                    if (keyboardHandler.pausePressed())
                        pause();

                    if (!_paused && gameConditions.checkWin()) {
                        win();
                    }

                    boolean moved = false;
                    if (keyboardHandler.upPressed() && !keyboardHandler.downPressed() && !moved && timerIndex % 5 == 0)
                        moved = _mainCharacter.moveUp();

                    if (keyboardHandler.downPressed() && !keyboardHandler.upPressed() && !moved && timerIndex % 5 == 0)
                        moved = _mainCharacter.moveDown();

                    if (keyboardHandler.leftPressed() && !keyboardHandler.rightPressed() && !moved && timerIndex % 5 == 0)
                        moved = _mainCharacter.moveLeft();
                        
                    if (keyboardHandler.rightPressed() && !keyboardHandler.leftPressed() && !moved && timerIndex % 5 == 0)
                        moved = _mainCharacter.moveRight();

                    timerIndex ++;
                    if (timerIndex > Integer.MAX_VALUE - 1)
                        timerIndex = 0;
                    
                    // Check if there is a loss of game after player movement
                    if (!_paused && gameConditions.checkLoss()) {
                        loss();
                    }

                    for (int i = 0; i < cops.size(); i++) {
                        if (timerIndex % (i * 2 + 8) == 0)
                            cops.get(i).chaseTruck();
                    }

                    // Check if there is a loss of game after cop movement
                    if (!_paused && gameConditions.checkLoss()) {
                        loss();
                    }

                    _frame.refresh();

                }
            }
        });
    }

    /**
     * Starts the game timer, effectively starting the game
     */
    public void startTimer() {
        _timer.start();
    }

    /**
     * Pauses the game and shows the pause menu 
     * While suspending the game loop through a boolean value update
     * Pauses scoreboard timer
     */
    private void pause() {
        _paused = true;
        _frame.showPauseScreen();
        _mainCharacter.getScoreboard().pauseTimer();
    }

    /**
     * Resumes the game and shows the game panel 
     * While resuming the game loop through a boolean value update
     * Resumes scoreboard timer
     */
    private void resume() {
        _paused = false;
        _frame.showGameScreen();
        _mainCharacter.getScoreboard().resumeTimer();
    }

    /**
     * Function to be called when the game ends in a loss
     * Kills the frame and timer
     * Shows a new GAME_LOST screen Frame
     * Sets paused to true to prevent further loop progression
     */
    private void loss() {

        if (_invincible)
            return;
        
        _paused = true;
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
    private void win() {
        _paused = true;
        _timer.stop();
        _frame.dispose();
        new Frame(ScreenType.GAME_WON, _mainCharacter.getScoreboard());
    }

}
