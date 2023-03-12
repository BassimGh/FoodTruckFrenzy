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


    private JLabel scoreLabel = new JLabel("Score: ");
    private JLabel ingredientsLabel = new JLabel("Ingredients: ");
    private JLabel damageLabel = new JLabel("Damage: "); 
    private JLabel fineLabel = new JLabel("Fines: ");
    private JLabel timeLabel = new JLabel();

    private Timer timer;
    private int minute;
    private int second; 
    

    private FoodTruck player;
    private String ingredients = "Potato!";
    private int damage;
    private int fines;
    private int score;

    
    public Scoreboard(FoodTruck player) {        
        this.player = player;  
        this.add(ingredientsLabel);
        this.add(damageLabel);
        this.add(fineLabel);
        this.add(scoreLabel);
        this.add(timeLabel);

        second = 00;
        minute = 00;
        simpleTimer();
        this.timer.start();
        
    }

    
    public void update() {
    // scoreboard is updated based on players food trucks stats
        ingredientsLabel.setText("Ingredients: " + player.getIngredients());
        damageLabel.setText("Damage: " + player.getDamage());
        fineLabel.setText("Fines: " + player.getFines());
        scoreLabel.setText("Score: " + player.getScore());

    }

   
    // add minutes and seconds
    public void simpleTimer() {

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second++;
                if (second == 60) {
                    minute++;
                    second = 0;
                }
                timeLabel.setText("Time: " + String.format("%02d",minute) + ":" + String.format("%02d", second));
            }
            });
    }
    
}


