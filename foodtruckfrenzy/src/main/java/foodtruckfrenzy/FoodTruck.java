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
    public boolean moveUp() {
        boolean moved = super.moveUp();
        this.setType(DrawableEnum.FOODTRUCK_UP);

        if (moved)
            this.getGrid().interact(this.getRow(), this.getCol());

        return moved;
    }

    @Override
    public boolean moveDown() {
        boolean moved = super.moveDown();
        this.setType(DrawableEnum.FOODTRUCK_DOWN);

        if (moved)
            this.getGrid().interact(this.getRow(), this.getCol());

        return moved;
    }

    @Override
    public boolean moveRight() {
        boolean moved = super.moveRight();
        this.setType(DrawableEnum.FOODTRUCK_RIGHT);
        
        if (moved)
            this.getGrid().interact(this.getRow(), this.getCol());

        return moved;
    }

    @Override
    public boolean moveLeft() {
        boolean moved = super.moveLeft();
        this.setType(DrawableEnum.FOODTRUCK_LEFT);

        if (moved)
            this.getGrid().interact(this.getRow(), this.getCol());

        return moved;
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
