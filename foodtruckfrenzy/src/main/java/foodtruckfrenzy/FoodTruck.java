package foodtruckfrenzy;

public class FoodTruck extends Vehicle {

    // scoreboard attributes
    private String ingredients = "Potato!";
    private int damage;
    private int fines;
    private int score;
    


    public FoodTruck(int row, int col, Grid grid) {
        super(row, col, grid, DrawableEnum.FOODTRUCK_RIGHT);
    }

    @Override
    public void moveUp() {
        super.moveUp();
        //interaction here
    }

    @Override
    public void moveDown() {
        super.moveDown();
        //interaction here
    }

    @Override
    public void moveRight() {
        super.moveRight();
        //interaction here
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        //interaction here
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
