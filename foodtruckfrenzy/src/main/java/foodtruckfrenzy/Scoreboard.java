package foodtruckfrenzy;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
    private JLabel timeLabel = new JLabel("Time: ");

    private String ingredients = "Potato!";
    private int damage;
    private int fines;
    private int time;
    private int score;
    
    public Scoreboard() {
        
        this.add(scoreLabel);
        this.add(ingredientsLabel);
        this.add(damageLabel);
        this.add(fineLabel);
        this.add(timeLabel);

        
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
}


