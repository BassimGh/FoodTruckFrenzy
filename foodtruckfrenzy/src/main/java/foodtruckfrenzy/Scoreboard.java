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
    Font sbFont3 = new Font("Comic Sans MS", Font.BOLD, 44);
    
    Color backGroundColor = new Color(54, 65, 79);
    Color red = new Color(227, 0, 39);
    Color yellow = new Color(255, 240, 75);
    Color starCommandBlue = new Color(0, 123, 184);
    Color green = new Color(80, 255, 90);
    Color white = Color.WHITE;
    
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
    private int damage;
    private int fines;
    private String timeElapsed;
    

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
        _ingredientsLabel.setForeground(white);
        _recipesLabel.setFont(sbFont1);
        _recipesLabel.setForeground(white);
        _fineLabel.setFont(sbFont1);
        _fineLabel.setForeground(white);
        _timeLabel.setFont(sbFont1);
        _timeLabel.setForeground(white); 
        _damageLabel.setFont(sbFont1);
        _damageLabel.setForeground(white);

        collectablesPanel.add(_ingredientsLabel); 
        collectablesPanel.add(_recipesLabel);
        collectablesPanel.add(_fineLabel);
        collectablesPanel.add(_damageLabel);

        //Centre Column -------- Score
        scorePanel.setLayout(new FlowLayout());
        scorePanel.setBackground(backGroundColor);
        _scoreLabel.setFont(sbFont3);       
        _scoreLabel.setForeground(white);
        _scoreTotal.setFont(sbFont3);
        _scoreTotal.setForeground(white);

        scorePanel.add(_scoreLabel);
        scorePanel.add(_scoreTotal);


        // Right Column -------- Time / Pause Instr.
        timePanel.setLayout(new GridLayout(2, 1, 10, 10));
        timePanel.setBackground(backGroundColor);
        _timeLabel.setFont(sbFont2);
        _timeLabel.setForeground(white);      
        _pauseInstructions.setFont(sbFont1);
        _pauseInstructions.setForeground(white);
    
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
        damage = player.getDamage();
        fines = player.getFines();

        if(score < 0) {
            _scoreTotal.setForeground(red);
        }
        if (score > 0) {
            _scoreTotal.setForeground(yellow);
        }
        if (ingredientsFound == ingredientsDiscoverable) {
            _ingredientsLabel.setForeground(green);
        }
        if (recipesFound == recipesDiscoverable) {
            _recipesLabel.setForeground(green);
        }
            _ingredientsLabel.setText("Ingredients: " + ingredientsFound + "/" + ingredientsDiscoverable);
            _recipesLabel.setText("Recipes: " + recipesFound + "/" + recipesDiscoverable);
            _damageLabel.setText("Damages: " + damage);
            _fineLabel.setText("Speed Fines: " + fines);
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
                    timeElapsed = String.format("%02d",_minute) + ":" + String.format("%02d", _second);
                    _timeLabel.setText("Time: " + timeElapsed);
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


    public int getIngredientsFound() {
        return ingredientsFound;
    }

    public int getRecipesFound() {
        return recipesFound;
    }

    public int getDamage() {
        return damage;
    }

    public int getFines() {
        return fines;
    }

    public int getScore() {
        return score;
    }

    public String getTime() {
        return timeElapsed;
    }



}

