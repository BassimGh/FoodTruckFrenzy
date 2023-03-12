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
    private int second;

    private FoodTruck player;
    private String ingredients = "Potato!";
    private int damage;
    private int fines;
    private int time;
    private int score;

    
    
    public Scoreboard() {
        // TO DO: update food truck constructor 
        
        // this.player = new FoodTruck();
        this.add(ingredientsLabel);
        this.add(damageLabel);
        this.add(fineLabel);
        this.add(scoreLabel);
        this.add(timeLabel);

        second = 0;
        simpleTimer();
        this.timer.start();
        
    }

    public void update() {

        // scoreLabel.setText("Score: " + player.getScore());
    }

    public void setIngredients(String ingredient) {
        
        this.ingredients += ingredient + " ";
    
    }

    public String getIngredients() {
        
        return this.ingredients;
    
    }

    public void setDamage(int damage) {

        this.damage += damage;

    } 

    public int getDamage() {

        return this.damage;
    
    }

    public void setFines(int fine) {
        
        this.fines += fine;
    
    }

    public int getFines() {

        return this.fines;

    }

    public String getScore() {

        return Integer.toString(this.score);

    }

    public void calculateScore() {

        this.score = this.score - fines - damage;

    } 

    // add minutes and seconds
    public void simpleTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second++;
                timeLabel.setText("Timer Elapsed: " + second);
            }
            });
    }
    
}


