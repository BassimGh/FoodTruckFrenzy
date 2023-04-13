package foodtruckfrenzy.GameFramework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

/**
 * The Scoreboard class is responsible for displaying the current score and game progress.
 * It contains components to display the ingredients and recipes collected, damage inflicted by obstacles, speed fines, time elapsed and the current score.
 */
public class Scoreboard extends JPanel {


    // ------------- Fonts and Colors ------------- //
    
    /**
     * Font used for small text in the score board.
     */
    private final static Font FONT_SMALL = new Font("Comic Sans MS", Font.PLAIN, 16);

    /**
     * Font used for medium-sized text in the score board.
     */
    private final static Font FONT_MEDIUM = new Font("Comic Sans MS", Font.PLAIN, 22);

    /**
     * Font used for large text in the score board.
     */
    private final static Font FONT_LARGE = new Font("Comic Sans MS", Font.BOLD, 44);

    /**
     * Background color for the score board.
     */
    private final static Color COLOR_BACKGROUND = new Color(54, 65, 79);

    /**
     * Color for displaying red elements in the score board.
     */
    private final static Color COLOR_RED = new Color(227, 0, 39);

    /**
     * Color for displaying yellow elements in the score board.
     */
    private final static Color COLOR_YELLOW = new Color(255, 240, 75);

    /**
     * Color for displaying green elements in the score board.
     */
    private final static Color COLOR_GREEN = new Color(80, 255, 90);

    /**
     * Color for displaying white elements in the score board.
     */
    private final static Color COLOR_WHITE = Color.WHITE;



    // ------------- Labels ------------- //
    
    /**
     * Label for displaying the player's score.
     */
    private JLabel _scoreLabel = new JLabel("Score: ");

    /**
     * Label for displaying the player's total accumulated score.
     */
    private JLabel _scoreTotal = new JLabel("0");

    /**
     * Label for displaying the number of ingredients found by the player.
     */
    private JLabel _ingredientsLabel = new JLabel("Ingredients Found:");

    /**
     * Label for displaying the number of recipes found by the player.
     */
    private JLabel _recipesLabel = new JLabel("Recipes Found:");

    /**
     * Label for displaying the amount of damage incurred by the player.
     */
    private JLabel _damageLabel = new JLabel("Damage:");

    /**
     * Label for displaying the fines incurred by the player.
     */
    private JLabel _fineLabel = new JLabel("Fines: ");

    /**
     * Label for displaying the elapsed time in the game.
     */
    private JLabel _timeLabel = new JLabel("Time:");

    /**
     * Label for displaying instructions on how to pause the game.
     */
    private JLabel _pauseInstructions = new JLabel("Press 'P' to pause");



    // ------------- Player Data ------------- //

    /**
     * Represents the player's total accumulated score.
     */
    private int score;

    /**
     * Represents the number of ingredients found by the player.
     */
    private int ingredientsFound;

    /**
     * Represents the number of discoverable ingredients in the game.
     */
    private int ingredientsDiscoverable;

    /**
     * Represents the number of recipes found by the player.
     */
    private int recipesFound;

    /**
     * Represents the number of discoverable recipes in the game.
     */
    private int recipesDiscoverable;

    /**
     * Represents the amount of damage incurred by the player.
     */
    private int damage;

    /**
     * Represents the fines incurred by the player.
     */
    private int fines;

    /**
     * Represents the elapsed time in the game.
     */
    private String timeElapsed;

    /**
     * Represents the pause state of the game.
     */
    private boolean _paused = false;

    /**
     * Timer object used to update the score board's timer.
     */
    private Timer _timer;

    /**
     * Represents the minute value in the timer.
     */
    private int _minute;

    /**
     * Represents the second value in the timer.
     */
    private int _second;


    
    /**
     * Constructs a new scoreboard panel for the given player object.
     * @param maxIngredients an integer representing the total ingredients discoverable on the map
     * @param maxRecipes an integer representing the total recipes discoverable on the map
     */
    public Scoreboard(int maxIngredients, int maxRecipes) {

        setLayout(new BorderLayout(10, 10));
        setBackground(COLOR_BACKGROUND);
    
        JPanel leftPanel = createLeftPanel();
        JPanel centerPanel = createCenterPanel();
        JPanel rightPanel = createRightPanel();
    
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
    
        ingredientsDiscoverable = maxIngredients;
        recipesDiscoverable = maxRecipes;

        updateScoreLabel(0);
        updateIngredientsLabel();
        updateRecipesLabel();
        updateFinesLabel();
        updateDamageLabel();
        
        simpleTimer();
        _timer.start();
    }
    

    /**
    Creates the left panel of the Scoreboard which displays the various statistics about the player.
    @return JPanel - the left panel of the Scoreboard
    */
    private JPanel createLeftPanel() {

        JPanel leftPanel = new JPanel(new GridLayout(4, 1));
        leftPanel.setBackground(COLOR_BACKGROUND);
    
        _ingredientsLabel.setFont(FONT_SMALL);
        _ingredientsLabel.setForeground(COLOR_WHITE);
        _recipesLabel.setFont(FONT_SMALL);
        _recipesLabel.setForeground(COLOR_WHITE);
        _fineLabel.setFont(FONT_SMALL);
        _fineLabel.setForeground(COLOR_WHITE);
        _timeLabel.setFont(FONT_SMALL);
        _timeLabel.setForeground(COLOR_WHITE);
        _damageLabel.setFont(FONT_SMALL);
        _damageLabel.setForeground(COLOR_WHITE);
    
        leftPanel.add(_ingredientsLabel);
        leftPanel.add(_recipesLabel);
        leftPanel.add(_fineLabel);
        leftPanel.add(_damageLabel);
    
        return leftPanel;
    }
    

    /**
    Creates the center panel of the game UI, which displays the player's score.
    The center panel is a JPanel with a FlowLayout and a white background.
    @return the JPanel object representing the center panel
    */
    private JPanel createCenterPanel() {

        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(COLOR_BACKGROUND);
    
        _scoreLabel.setFont(FONT_LARGE);
        _scoreLabel.setForeground(COLOR_WHITE);
        _scoreTotal.setFont(FONT_LARGE);
        _scoreTotal.setForeground(COLOR_WHITE);
    
        centerPanel.add(_scoreLabel);
        centerPanel.add(_scoreTotal);
    
        return centerPanel;
    }
    

    /**
    Creates and returns the right panel of the game scoreboard, which displays the remaining time and
    pause instructions.
    @return the right panel of the game scoreboard
    */
    private JPanel createRightPanel() {

        JPanel rightPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        rightPanel.setBackground(COLOR_BACKGROUND);
    
        _timeLabel.setFont(FONT_MEDIUM);
        _timeLabel.setForeground(COLOR_WHITE);
        _pauseInstructions.setFont(FONT_SMALL);
        _pauseInstructions.setForeground(COLOR_WHITE);
        
        rightPanel.add(_timeLabel);
        rightPanel.add(_pauseInstructions);
    
        return rightPanel;
    }

    /**
     * Updates the score label. If the score total is negative scoreboard label turns red. 
     * If the positive the label displays yellow.
     * @param score an integer represting the total score for the foodtruck player. 
     */
    private void updateScoreLabel(int score) {
        _scoreTotal.setText(Integer.toString(score));
        
        if(score < 0) {
            _scoreTotal.setForeground(COLOR_RED);
        }
        if (score > 0) {
            _scoreTotal.setForeground(COLOR_YELLOW);
        }
    
    }

    /**
     * 
     */
    private void updateFinesLabel() {
        // this.fines = fines;
        _fineLabel.setText("Speed Fines: " + fines);
    }

    /**
     * 
     */
    private void updateDamageLabel() {
        // this.damage = damage;
        _damageLabel.setText("Damages: " + damage);
    }

    /**
     * 
     */
    private void updateRecipesLabel() {
        // this.recipesFound = recipesFound;
        _recipesLabel.setText("Recipes: " + recipesFound + "/" + recipesDiscoverable);

        if (recipesFound == recipesDiscoverable) {
            _recipesLabel.setForeground(COLOR_GREEN);
        }
    }

    /**
     * 
     */
    private void updateIngredientsLabel() {
        // this.ingredientsFound = ingredientsFound;
        _ingredientsLabel.setText("Ingredients: " + ingredientsFound + "/" + ingredientsDiscoverable);

        if (ingredientsFound == ingredientsDiscoverable) {
            _ingredientsLabel.setForeground(COLOR_GREEN);
        }
    }

    
    /**
    * Sets up a simple timer to keep track of the time elapsed in the game.
    * The timer increments every second and updates the time elapsed on the scoreboard.
    */
    public void simpleTimer() {
        _timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!_paused) {
                _second++;
                    if (_second == 60) {
                        _minute++;
                        _second = 0;
                    }
                    // save and display the current time elapsed as (min : sec)
                    timeElapsed = String.format("%02d",_minute) + ":" + String.format("%02d", _second);
                    _timeLabel.setText("Time: " + timeElapsed);
                }
            }
        });
    }

   
    /**
     * Pauses the timer for the scoreboard. 
     */
    public void pauseTimer() {
        _paused = true;
    }

    /**
     * Returns if the timer is paused or not.
     * @return a boolean representing if timer is paused.
     */

    public boolean isTimerPaused() {
        return _paused;
    }

    /**
     * Resumes the timer for the scoreboard.
     */
    public void resumeTimer() {
        _paused = false;
    }

    /**
     * Restarts the timer for the scoreboard.
     */
    public void restartTimer() {
        _timer.restart();
    }
    
    
    /**
     * Returns the time elapsed during gameplay.
     * @return a string representing the elapsed time during gameplay. (min : sec) Example for 1 minute and 30 seconds elapsed:  "01 : 30".
     */
    public String getTime() {
        return timeElapsed;
    }

    /**
    * Increments the total number of ingredients found by the foodtruck player. 
    * Updates the ingredients found label.
    */
    public void addIngredientsFound() {
        ingredientsFound++;
        updateIngredientsLabel();
    }

    /**
     * Returns the number of ingredients found by the player.
     * @return an integer representing the number of ingredients found by the player.
     */
    public int getIngredientsFound() {
        return ingredientsFound;
    }

    /**
     * Increments the total number of recipes found by the foodtruck player. 
     * Updates the recipes found label.
     */
    public void addRecipesFound() {
        recipesFound++;
        updateRecipesLabel();
    }

    /**
     * Returns the number of recipes found by the player.
     * @return an integer representing the number of recipes found by the player.
     */
    public int getRecipesFound() {
        return recipesFound;
    }

    /**
     * Updates the damage property when new damage occurs.
     * Updates the damage label.
     * @param newDamage an int representing the new damage accumulated by the foodtruck player during gameplay.
     */
    public void addDamage(int newDamage) {
        damage += newDamage;
        updateDamageLabel();
    }

    /**
     * Returns the damage accumulated on the players foodtruck during gameplay.
     * @return an integer representing the negative score from accumulating damage.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Updates the fines property when new fines occur.
     * Updates the fines label.
     * @param newFines an int representing the new fines accumulated by the foodtruck player during gameplay. 
     */
    public void addFines(int newFines) {
        fines += newFines;
        updateFinesLabel();
    }

    /**
     * Returns the fines accumulated by the player during gameplay.
     * @return an integer representing the negative score from accumulating damage.
     */
    public int getFines() {
        return fines;
    }

    /**
     * Adds new score to the score property. 
     * Calls updateScore to update the scoreboard label.
     * @param newScore an int representing the new score accumulated by the foodtruck player during gameplay.
     */
    public void addScore(int newScore) {
        score += newScore;
        updateScoreLabel(score);
    }

    /**
     * Returns the total score accumulated by the player during gameplay.
     * @return an integer representing the total score accumulated by the player during gameplay.
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns the total number of ingredientsDiscoverable
     * @return an integer representing the total number of ingredients discoverable
     */
    public int getIngredientsDiscoverable() {
        return ingredientsDiscoverable;
    }

}

