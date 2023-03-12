package foodtruckfrenzy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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

    // private ImageIcon[] ingredientIcons = new ImageIcon[10];
    // private JLabel ingredientIcon1 = new JLabel();
    // private JLabel ingredientIcon2 = new JLabel();
    // private JLabel ingredientIcon3 = new JLabel();
    // private JLabel ingredientIcon4 = new JLabel();
    // private JLabel ingredientIcon5 = new JLabel();

    private Timer _timer;
    private int _minute;
    private int _second; 
    

    private FoodTruck player;

    
    
    public Scoreboard(FoodTruck player) {
        
        
        this.setLayout(new GridLayout(2, 4));

        this.add(_ingredientsLabel);
        this.add(_scoreLabel);
        this.add(_fineLabel);
        this.add(_timeLabel);
        this.add(_damageLabel);
        

        this.player = player;  
        _second = 00;
        _minute = 00;
        simpleTimer();
        this._timer.start();

        /* adding ingredient icons
        **/
        // ingredientIcon1.setIcon(ingredientIcons[1]);
        // ingredientIcon2.setIcon(ingredientIcons[2]);
        // ingredientIcon3.setIcon(ingredientIcons[3]);
        // ingredientIcon4.setIcon(ingredientIcons[4]);
        // ingredientIcon5.setIcon(ingredientIcons[5]);

    }

    
    public void update() {
    // scoreboard is updated based on players food trucks stats
        _ingredientsLabel.setText("Ingredients Collected: " + player.getIngredients());
        _damageLabel.setText("Damages: " + player.getDamage());
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


