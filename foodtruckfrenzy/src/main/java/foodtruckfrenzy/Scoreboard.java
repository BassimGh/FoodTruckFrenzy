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
import java.awt.Color;


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
    Font font = new Font("Arial", Font.BOLD, 18);
    Color backGroundColor = new Color(54, 65, 79);
    
    private JPanel ingredientsPanel = new JPanel();
    private JPanel scorePanel = new JPanel();
    private JPanel negativePointsPanel = new JPanel();
    
    private JLabel _scoreLabel = new JLabel("Score: ");
    private JLabel _scoreTotal = new JLabel();
    private JLabel _ingredientsLabel = new JLabel("Ingredients: ");
    private JLabel _ingredientsIcons = new JLabel("");
    private JLabel _damageLabel = new JLabel("Damage: "); 
    private JLabel _fineLabel = new JLabel("Fines: ");
    private JLabel _timeLabel = new JLabel();

    
 
     private ImageIcon[] foodIcons = new ImageIcon[10];
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
                
        this.setLayout(new GridLayout(1, 4));

        this.ingredientsPanel.setLayout(new GridLayout(2, 1));
        this.ingredientsPanel.setBackground(backGroundColor);
        this._ingredientsLabel.setFont(font);
        this._ingredientsLabel.setForeground(Color.WHITE);
        this._ingredientsIcons.setFont(font);
        this._ingredientsIcons.setForeground(Color.WHITE);
        this.ingredientsPanel.add(_ingredientsLabel);
        this.ingredientsPanel.add(_ingredientsIcons);

        this.scorePanel.setLayout(new GridLayout(2, 1));
        this.scorePanel.setBackground(backGroundColor);
        this._scoreLabel.setFont(font);       
        this._scoreLabel.setForeground(Color.WHITE);
        this._scoreTotal.setFont(font);
        this._scoreTotal.setForeground(new Color(241, 215, 77)); // yellow
        this.scorePanel.add(_scoreLabel);
        this.scorePanel.add(_scoreTotal);

        this.negativePointsPanel.setLayout(new GridLayout(2, 1));
        this.negativePointsPanel.setBackground(backGroundColor);
        this._fineLabel.setFont(font);
        this._fineLabel.setForeground(Color.WHITE);
        this._timeLabel.setFont(font);
        this._timeLabel.setForeground(Color.WHITE); 
        this._damageLabel.setFont(font);
        this._damageLabel.setForeground(Color.WHITE);
        this.negativePointsPanel.add(_fineLabel);
        this.negativePointsPanel.add(_damageLabel);
        

        this.add(ingredientsPanel);
        this.add(scorePanel);
        this.add(negativePointsPanel);
        this.add(_timeLabel);

        
        this.setBackground(backGroundColor);
        this.player = player;  
        this._second = 00;
        this._minute = 00;
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

    
    public void buildIconPanel() {

        // creates an icon panel
        // adds icons to the panel of food that has been caught
        // addds panel to the scoreboard

        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(new GridLayout(1, 20));
        // ImageIcon icon = new ImageIcon();
        JLabel iconLabel = new JLabel(player.getIngredients());
        this.add(iconLabel);
    }

    public void update() {
    // scoreboard is updated based on players food trucks stats
        _ingredientsIcons.setText("" + player.getIngredients());
        // buildIconPanel();
        _damageLabel.setText("Damages: " + player.getDamage());
        _fineLabel.setText("Speed Fines: " + player.getFines());
        _scoreTotal.setText(player.getScore());
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


