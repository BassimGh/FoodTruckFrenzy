package foodtruckfrenzy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

// TO DO
// recipes collected panel
// create progress bar or something to show how many items saved


public class Scoreboard extends JPanel {

    /* components of the scoreboard 
    1. ingredients collected:  displayed as array of icons
    2. Damage:                 records damage inflicted from obstacles
    3. Speed Fines:            records speed fines from speed traps
    4. Time:                   records time elapsed
    5. Score:                  current score
    **/
    Font infoFont = new Font("Arial", Font.BOLD, 18);
    Font damageFont = new Font("Arial", Font.BOLD, 18);
    
    Color backGroundColor = new Color(54, 65, 79);
    
    private JPanel collectablesPanel = new JPanel();
    private JPanel negativePointsPanel = new JPanel();
    private JPanel scorePanel = new JPanel();
    private JPanel clockPanel = new JPanel();
    
    private JLabel _scoreLabel = new JLabel("Score: ");
    private JLabel _scoreTotal = new JLabel();
    private JLabel _ingredientsLabel = new JLabel();
    private JLabel _recipesLabel = new JLabel("Recipes Collected: ");
    private JLabel _damageLabel = new JLabel("Damage: "); 
    private JLabel _fineLabel = new JLabel("Fines: ");
    private JLabel _timeLabel = new JLabel();

    // private JLabel _pauseInstructions = new JLabel("Press 'P' to pause");

    private Timer _timer;
    private int _minute;
    private int _second; 

    private boolean _paused = false;
    

    private FoodTruck player;

    
    
    public Scoreboard(FoodTruck player) {
        

        setLayout(new FlowLayout());

        collectablesPanel.setLayout(new GridLayout(2, 1));
        collectablesPanel.setBackground(backGroundColor);
        _ingredientsLabel.setFont(infoFont);
        _ingredientsLabel.setForeground(Color.WHITE);
        _recipesLabel.setFont(infoFont);
        _recipesLabel.setForeground(Color.WHITE);
        collectablesPanel.add(_ingredientsLabel);
        collectablesPanel.add(_recipesLabel);

        scorePanel.setLayout(new FlowLayout());
        scorePanel.setBackground(backGroundColor);
        _scoreLabel.setFont(infoFont);       
        _scoreLabel.setForeground(Color.WHITE);
        _scoreTotal.setFont(infoFont);
        _scoreTotal.setForeground(new Color(241, 215, 77)); // yellow
        scorePanel.add(_scoreLabel);
        scorePanel.add(_scoreTotal);

        negativePointsPanel.setLayout(new GridLayout(2, 1));
        negativePointsPanel.setBackground(backGroundColor);
        _fineLabel.setFont(infoFont);
        _fineLabel.setForeground(Color.WHITE);
        _timeLabel.setFont(infoFont);
        _timeLabel.setForeground(Color.WHITE); 
        _damageLabel.setFont(damageFont);
        _damageLabel.setForeground(Color.WHITE);
        negativePointsPanel.add(_fineLabel);
        negativePointsPanel.add(_damageLabel);

        clockPanel.setLayout(new FlowLayout());
        clockPanel.setBackground(backGroundColor);
        _timeLabel.setFont(infoFont);
        _timeLabel.setForeground(Color.RED);
        // _pauseInstructions.setFont(font);
        // _pauseInstructions.setForeground(Color.WHITE);
        clockPanel.add(_timeLabel);
        // clockPanel.add(_pauseInstructions);
        

        add(collectablesPanel);
        add(negativePointsPanel);
        add(scorePanel);
        add(clockPanel);

        
        setBackground(backGroundColor);
        this.player = player;  
        _second = 00;
        _minute = 00;
        simpleTimer();
        _timer.start();

    }

    
    public void update() {

        _ingredientsLabel.setText("Ingredients Collected: " + player.getIngredientsFound() + "/" + Food.getCount());
        _recipesLabel.setText("Recipes Found: " + player.getRecipesFound() + "/" + Recipe.getCount());
        _damageLabel.setText("Damages: " + player.getDamage());
        _fineLabel.setText("Speed Fines: " + player.getFines());
        _scoreTotal.setText(player.getScore());
    }


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
                    _timeLabel.setText("Time: " + String.format("%02d",_minute) + ":" + String.format("%02d", _second));
                }
            }
        });
    }


    public void startTimer() {
        _timer.start();
    }

    public void pauseTimer() {
        _paused = true;
    }

    public void resumeTimer() {
        _paused = false;
    }

    public void restartTimer() {
        _timer.restart();
    }

}


