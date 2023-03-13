package foodtruckfrenzy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Scoreboard extends JPanel {

    /* components of the scoreboard 
    1. ingredients collected:  displayed as array of icons
    2. Damage:                 records damage inflicted from obstacles
    3. Speed Fines:            records speed fines from speed traps
    4. Time:                   records time elapsed
    5. Score:                  current score
    **/
    
    Font sbFont1 = new Font("Comic Sans MS", Font.PLAIN, 16);
    Font sbFont2 = new Font("Comic Sans MS", Font.PLAIN, 22);
    Font sbFont3 = new Font("Comic Sans MS", Font.BOLD, 40);
    // Font sbFont1 = new Font("Comic Sans MS", Font.PLAIN, 22);
    
    Color backGroundColor = new Color(54, 65, 79);
    
    private JPanel collectablesPanel = new JPanel();
    private JPanel scorePanel = new JPanel();
    private JPanel timePanel = new JPanel();
    
    private JLabel _scoreLabel = new JLabel("Score: ");
    private JLabel _scoreTotal = new JLabel();
    private JLabel _ingredientsLabel = new JLabel("Ingredients");
    private JLabel _recipesLabel = new JLabel("Recipes: ");
    private JLabel _damageLabel = new JLabel("Damage: "); 
    private JLabel _fineLabel = new JLabel("Fines: ");
    private JLabel _timeLabel = new JLabel("Time: 00:00");
    private JLabel _pauseInstructions = new JLabel("Press 'P' to pause");

    private int score;
    private int ingredientsFound;
    private int ingredientsDiscoverable;
    private int recipesFound;
    private int recipesDiscoverable;
    

    private Timer _timer;
    private int _minute;
    private int _second; 

    private boolean _paused = false;
    
    private FoodTruck player;

    public Scoreboard(FoodTruck player) {
        
        setLayout(new BorderLayout(10, 10));
        setBackground(backGroundColor);

        // left column-------- ingredients and recipes
        collectablesPanel.setLayout(new GridLayout(4, 1));
        collectablesPanel.setBackground(backGroundColor);
        _ingredientsLabel.setFont(sbFont1);
        _ingredientsLabel.setForeground(Color.WHITE);
        _recipesLabel.setFont(sbFont1);
        _recipesLabel.setForeground(Color.WHITE);
        _fineLabel.setFont(sbFont1);
        _fineLabel.setForeground(Color.WHITE);
        _timeLabel.setFont(sbFont1);
        _timeLabel.setForeground(Color.WHITE); 
        _damageLabel.setFont(sbFont1);
        _damageLabel.setForeground(Color.WHITE);

        collectablesPanel.add(_ingredientsLabel); 
        collectablesPanel.add(_recipesLabel);
        collectablesPanel.add(_fineLabel);
        collectablesPanel.add(_damageLabel);

        //Centre Column -------- Score
        scorePanel.setLayout(new FlowLayout());
        scorePanel.setBackground(backGroundColor);
        _scoreLabel.setFont(sbFont3);       
        _scoreLabel.setForeground(Color.WHITE);
        _scoreTotal.setFont(sbFont3);

        scorePanel.add(_scoreLabel);
        scorePanel.add(_scoreTotal);


        // Right Column -------- Time / Pause Instr.
        timePanel.setLayout(new GridLayout(2, 1, 10, 10));
        timePanel.setBackground(backGroundColor);
        _timeLabel.setFont(sbFont2);
        _timeLabel.setForeground(Color.WHITE);      
        _pauseInstructions.setFont(sbFont1);
        _pauseInstructions.setForeground(Color.WHITE);
    
        timePanel.add(_timeLabel);
        timePanel.add(_pauseInstructions);
        
        // adding 3 columns to scoreboard
        add(collectablesPanel, BorderLayout.WEST);
        add(scorePanel, BorderLayout.CENTER);
        add(timePanel, BorderLayout.EAST);
      
        this.player = player;  // assign player to fetch data from
        ingredientsDiscoverable = Food.getCount();
        recipesDiscoverable = Recipe.getCount();
        _second = 00;
        _minute = 00;
        simpleTimer();
        _timer.start();
    }

    
    public void update() {
        
        score = player.getScoreInt();
        ingredientsFound = player.getIngredientsFound();
        recipesFound = player.getRecipesFound();

        if(score < 0) {
            _scoreTotal.setForeground(Color.RED);
        }
        if (ingredientsFound == ingredientsDiscoverable) {
            _ingredientsLabel.setForeground(Color.GREEN);
        }
        if (recipesFound == recipesDiscoverable) {
            _recipesLabel.setForeground(Color.GREEN);
        }
        else {
            _scoreTotal.setForeground(Color.YELLOW);
        }
            _ingredientsLabel.setText("Ingredients: " + player.getIngredientsFound() + "/" + Food.getCount());
            _recipesLabel.setText("Recipes: " + player.getRecipesFound() + "/" + Recipe.getCount());
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


