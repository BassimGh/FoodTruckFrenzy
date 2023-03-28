package foodtruckfrenzy.GameFramework;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.*;

import foodtruckfrenzy.Main;
import foodtruckfrenzy.Drawable.Item.Food;
import foodtruckfrenzy.Drawable.Item.Recipe;
import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;
import foodtruckfrenzy.Helper.KeyboardHandler;
import foodtruckfrenzy.Helper.VehicleSpawner;
import foodtruckfrenzy.SecondaryUI.Frame;
import foodtruckfrenzy.SecondaryUI.ScreenType;

/*
 * This class is the logic behind the game
 * Creating a new instance of this class creates a new game with everything
 * Includes the Frame, all panels, the charactes and everything
 * Potentially should be refactored to a singleton object as only one of these should exist at a time
 */
public class Game {
    

    private final int TIMER_DELAY = 75; // in milliseconds

    private final GameFrame _frame;
    private final Timer _timer;
    private final FoodTruck _mainCharacter;
    private boolean _paused = false;

    private int timerIndex;

    /*
     * Game constructor
     * Creates everything needed to run the game instance
     */
    public Game() {
        Food.resetCount();
        Recipe.resetCount();

        Grid grid = new Grid();

        VehicleSpawner spawner = new VehicleSpawner(grid);
        _mainCharacter = spawner.getFoodTruck();
        ArrayList<Cop> cops = spawner.getCops();

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
                Main.main(null);
                _frame.dispose();
            }
        };

        KeyboardHandler keyboardHandler = new KeyboardHandler();
        _frame = new GameFrame(_mainCharacter, grid, cops, resumeListener, restartListener);
        _frame.addKeyListener(keyboardHandler);
        _frame.requestFocusInWindow();

        cops.get(0).getDirections();

        /*
         * Game tick timer which controls all game running logic
         * Controls player movement and cop movement
         * Checks for win and loss condidions
         */
        timerIndex = 0;
        _timer = new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!_paused) {
                    if (keyboardHandler.pause())
                        pause();

                    boolean moved = false;
                    if (keyboardHandler.upPressed() && !keyboardHandler.downPressed() && !moved)
                        moved = _mainCharacter.moveUp();

                    if (keyboardHandler.downPressed() && !keyboardHandler.upPressed() && !moved)
                        moved = _mainCharacter.moveDown();

                    if (keyboardHandler.leftPressed() && !keyboardHandler.rightPressed() && !moved)
                        moved = _mainCharacter.moveLeft();
                        
                    if (keyboardHandler.rightPressed() && !keyboardHandler.leftPressed() && !moved)
                        moved = _mainCharacter.moveRight();

                    timerIndex ++;
                    if (timerIndex > Integer.MAX_VALUE - 1)
                        timerIndex = 0;
                    
                    // Check if there is a collision after player movement
                    if (!_paused && checkCopCharacterCollision(cops, _mainCharacter)) {
                        loss();
                    }

                    // for (Cop cop : cops) {
                    //     cop.trackTruck();
                    // }

                    if (timerIndex % 2 == 0) {
                        cops.get(0).chaseTruck();
                        cops.get(1).chaseTruck();
                    }

                    if (timerIndex % 3 == 0) {
                        cops.get(2).chaseTruck();
                    }

                    // Check if there is a collision after cop movement
                    if (!_paused && checkCopCharacterCollision(cops, _mainCharacter)) {
                        loss();
                    }

                    _frame.refresh();

                    if (!_paused && _mainCharacter.getScoreInt() < 0) {
                        loss();
                    }

                    if (!_paused && checkWinCondition(_mainCharacter)) {
                        win();
                    }

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
     */
    private void pause() {
        _paused = true;
        _frame.showPauseScreen();
    }

    /**
     * Resumes the game and shows the game panel 
     * While resuming the game loop through a boolean value update
     */
    private void resume() {
        _paused = false;
        _frame.showGameScreen();
    }

    /**
     * Function to be called when the game ends in a loss
     * Kills the frame and timer
     * Shows a new GAME_LOST screen Frame
     * Sets paused to true to prevent further loop progression
     */
    private void loss() {
        _paused = true;
        _timer.stop();
        _frame.dispose();
        new Frame(ScreenType.GAME_LOST, _frame.getScoreboard());
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
        new Frame(ScreenType.GAME_WON, _frame.getScoreboard());
    }

    /**
     * checks if the specified FoodTruck object is in the same grid location as any of the Cop objects in the specified array
     * @param cops Cop object ArrayList
     * @param foodTruck FoodTruck object to check collisons
     * @return true if there is a collison between the foodTruck or any Cop in the array, false if not or if an argument is null
     */
    private boolean checkCopCharacterCollision(ArrayList<Cop> cops, FoodTruck foodTruck) {
        
        if (cops == null || foodTruck == null)
            return false;

        for (Cop cop : cops)
            if (cop.getCol() == foodTruck.getCol() && cop.getRow() == foodTruck.getRow())
                return true;
        
        return false;
    }

    /**
     * Check win condition for the game, if foodTruck collected all Food items in the system and is on tile row 16, column 40
     * @param foodTruck foodTruck corresponding to player being checked for a win
     * @return true if there is a successful win, otherwise false
     */
    private boolean checkWinCondition(FoodTruck foodTruck) {
        return foodTruck.getCol() == 40 && foodTruck.getRow() == 16 && foodTruck.getIngredientsFound() >= Food.getCount();
    }

}
