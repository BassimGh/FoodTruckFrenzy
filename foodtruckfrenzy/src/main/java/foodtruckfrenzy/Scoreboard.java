package foodtruckfrenzy;

public class Scoreboard {

    private String ingredients;
    private int damage;
    private int fines;
    private int score;

    public void setIngredients(String ingredient) {
        
        ingredients += ingredient + " ";
    
    }

    public String getIngredients() {
        
        return ingredients;
    
    }

    public void setDamage(int damage) {

        this.damage += damage;

    } 

    public int getDamage() {

        return damage;
    
    }

    public void setFines(int fine) {
        
        fines += fine;
    
    }

    public int getFines() {

        return fines;

    }

    public int getScore() {

        return score;

    }

    public void calculateScore() {

        score = score - fines - damage;
        
    } 
}


