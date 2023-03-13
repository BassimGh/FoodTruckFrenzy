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
    Font smolBoiFont = new Font("Comic Sans MS", Font.PLAIN, 22);
    Font bigBoiFont = new Font("Comic Sans MS", Font.BOLD, 40);
    // Font smallerFont = new Font("Comic Sans MS", Font.PLAIN, 22);
    
    Color backGroundColor = new Color(54, 65, 79);
    
    private JPanel collectablesPanel = new JPanel();
    private JPanel negativePointsPanel = new JPanel();
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

    private Timer _timer;
    private int _minute;
    private int _second; 

    private boolean _paused = false;
    

    private FoodTruck player;

    
    
    public Scoreboard(FoodTruck player) {
        

        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // added border for debugging
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
 
        // left column-------- ingredients and recipess
        collectablesPanel.setLayout(new GridLayout(2, 2, 25, 8));
        collectablesPanel.setBackground(backGroundColor);
        _ingredientsLabel.setFont(smolBoiFont);
        _ingredientsLabel.setForeground(Color.WHITE);
        _recipesLabel.setFont(smolBoiFont);
        _recipesLabel.setForeground(Color.WHITE);
        //centre left--------- damage and fines
        negativePointsPanel.setLayout(new GridLayout(2, 1, 25, 16));
        negativePointsPanel.setBackground(backGroundColor);
        _fineLabel.setFont(smolBoiFont);
        _fineLabel.setForeground(Color.WHITE);
        _timeLabel.setFont(smolBoiFont);
        _timeLabel.setForeground(Color.WHITE); 
        _damageLabel.setFont(smolBoiFont);
        _damageLabel.setForeground(Color.WHITE);
        // negativePointsPanel.add(_fineLabel);
        // negativePointsPanel.add(_damageLabel);
        collectablesPanel.add(_ingredientsLabel);
        collectablesPanel.add(_fineLabel);
        collectablesPanel.add(_recipesLabel);
        collectablesPanel.add(_damageLabel);


        
        //Centre Column -------- Score
        scorePanel.setLayout(new FlowLayout());
        scorePanel.setBackground(backGroundColor);
        _scoreLabel.setFont(bigBoiFont);       
        _scoreLabel.setForeground(Color.WHITE);
        _scoreTotal.setFont(bigBoiFont);


        // Right Column -------- Time / Pause Instr.
        timePanel.setLayout(new GridLayout(2, 1, 10, 10));
        timePanel.setBackground(backGroundColor);
        _timeLabel.setFont(smolBoiFont);
        _timeLabel.setForeground(Color.WHITE);
        scorePanel.add(_scoreLabel);
        scorePanel.add(_scoreTotal);
        timePanel.add(_timeLabel);
        _pauseInstructions.setFont(smolBoiFont);
        _pauseInstructions.setForeground(Color.WHITE);
        timePanel.add(_pauseInstructions);
        
        gbc.gridx = 0; // first column
        gbc.gridy = 0; // first row
        gbc.anchor = GridBagConstraints.WEST; // left align   
        // gbc.insets = new Insets(10, 0, 10, 20); 
        add(collectablesPanel, gbc);

        // add(negativePointsPanel);
        gbc.gridx = 1; // second column
        gbc.anchor = GridBagConstraints.CENTER; // centre align 
        // gbc.insets = new Insets(10, 10, 10, 10);
        add(scorePanel, gbc);

        gbc.gridx = 2; // third column
        gbc.anchor = GridBagConstraints.EAST; // right align
        // gbc.insets = new Insets(10, 20, 10, 0);
        add(timePanel, gbc);

        
        setBackground(backGroundColor);
        this.player = player;  
        _second = 00;
        _minute = 00;
        simpleTimer();
        _timer.start();

    }

    
    public void update() {
        
        int score = player.getScoreInt();
        if(score < 0) {
            _scoreTotal.setForeground(Color.RED);
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


