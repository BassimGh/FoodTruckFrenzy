package foodtruckfrenzy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Scoreboard extends JPanel {

    /* components of the scoreboard 
    1. ingredients collected:  displayed as array of icons
    2. Damage:                 records damage inflicted from obstacles
    3. Speed Fines:            records speed fines from speed traps
    4. Time:                   records time elapsed
    5. Score:                  current score
    **/

    private JLabel _scoreLabel = new JLabel("Score: ");
    private JLabel _ingredientsLabel = new JLabel("Ingredients: ");
    private JLabel _damageLabel = new JLabel("Damage: "); 
    private JLabel _fineLabel = new JLabel("Fines: ");
    private JLabel _timeLabel = new JLabel();

    private Timer _timer;
    private int _minute;
    private int _second; 
    

    private FoodTruck player;

    
    public Scoreboard(FoodTruck player) {        
        this.player = player;  
        this.add(_ingredientsLabel);
        this.add(_damageLabel);
        this.add(_fineLabel);
        this.add(_scoreLabel);
        this.add(_timeLabel);

        _second = 00;
        _minute = 00;
        simpleTimer();
        this._timer.start();
        
    }

    
    public void update() {
    // scoreboard is updated based on players food trucks stats
        _ingredientsLabel.setText("Ingredients: " + player.getIngredients());
        _damageLabel.setText("Damage: " + player.getDamage());
        _fineLabel.setText("Speed Fines: " + player.getFines());
        _scoreLabel.setText("Score: " + player.getScore());
    }

    public void simpleTimer() {
        _timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _second++;
                if (_second == 60) {
                    _minute++;
                    _second = 0;
                }
                _timeLabel.setText("Time: " + String.format("%02d",_minute) + ":" + String.format("%02d", _second));
            }
        });
    }
    
}


