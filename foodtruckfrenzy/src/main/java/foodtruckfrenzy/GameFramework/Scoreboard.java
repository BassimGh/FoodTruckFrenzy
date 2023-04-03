package foodtruckfrenzy.GameFramework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

import foodtruckfrenzy.Drawable.Item.Food;
import foodtruckfrenzy.Drawable.Item.Recipe;

/**
 * The Scoreboard class is responsible for displaying the current score and game progress.
 * It contains components to display the ingredients and recipes collected, damage inflicted by obstacles, speed fines, time elapsed and the current score.
 */
public class Scoreboard extends JPanel {

    // Fonts and Colors for the Score Board
    private final static Font FONT_SMALL = new Font("Comic Sans MS", Font.PLAIN, 16);
    private final static Font FONT_MEDIUM = new Font("Comic Sans MS", Font.PLAIN, 22);
    private final static Font FONT_LARGE = new Font("Comic Sans MS", Font.BOLD, 44);
    
    private final static Color COLOR_BACKGROUND = new Color(54, 65, 79); 
    private final static Color COLOR_RED = new Color(227, 0, 39);
    private final static Color COLOR_YELLOW = new Color(255, 240, 75);
    private final static Color COLOR_GREEN = new Color(80, 255, 90);
    private final static Color COLOR_WHITE = Color.WHITE;
    

    // Labels for the ScoreBoard Data
    private JLabel _scoreLabel = new JLabel("Score: ");
    private JLabel _scoreTotal = new JLabel("0");
    private JLabel _ingredientsLabel = new JLabel("Ingredients Found:");
    private JLabel _recipesLabel = new JLabel("Recipes Found:");
    private JLabel _damageLabel = new JLabel("Damage:"); 
    private JLabel _fineLabel = new JLabel("Fines: ");
    private JLabel _timeLabel = new JLabel("Time:");
    private JLabel _pauseInstructions = new JLabel("Press 'P' to pause");


    //Scoreboard Data & Game State
    private int score;
    private int ingredientsFound;
    private int ingredientsDiscoverable;
    private int recipesFound;
    private int recipesDiscoverable;
    private int damage;
    private int fines;
    private String timeElapsed;
    private boolean _paused = false;   


    // Timer object that updates the Scoreboards Timer
    private Timer _timer;
    private int _minute;
    private int _second; 


    /**
     * Constructs a new scoreboard panel for the given player object.
     * @param player the player object to associate with this scoreboard
     */
    public Scoreboard() {

        setLayout(new BorderLayout(10, 10));
        setBackground(COLOR_BACKGROUND);
    
        JPanel leftPanel = createLeftPanel();
        JPanel centerPanel = createCenterPanel();
        JPanel rightPanel = createRightPanel();
    
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
    
        ingredientsDiscoverable = Food.getCount();
        recipesDiscoverable = Recipe.getCount();

        updateScore(0);
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
     * 
     * @param score
     */
    private void updateScore(int score) {
        this.score = score;
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
    * 
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
     * 
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
     * 
     * @param newDamage
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
     * 
     * @param newFines
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

    public void addScore(int newScore) {
        score += newScore;
        updateScore(score);
    }

    /**
     * Returns the total score accumulated by the player during gameplay.
     * @return an integer representing the total score accumulated by the player during gameplay.
     */
    public int getScore() {
        return score;
    }

}

