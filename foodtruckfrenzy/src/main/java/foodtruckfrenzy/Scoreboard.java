package foodtruckfrenzy;

public class Scoreboard {

    private String ingredients;
    private int damage;
    private int fines;
    private int score;

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


