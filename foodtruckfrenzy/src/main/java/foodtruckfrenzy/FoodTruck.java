package foodtruckfrenzy;

public class FoodTruck extends Vehicle {

    // scoreboard attributes
    private int damage;
    private int fines;
    private int score;
    
    private int ingredientsFound, recipesFound;



    public FoodTruck(int row, int col, Grid grid) {
        super(row, col, grid, DrawableEnum.FOODTRUCK_RIGHT);
    }

    @Override
    public boolean moveUp() {
        boolean moved = super.moveUp();
        this.setType(DrawableEnum.FOODTRUCK_UP);

        if (moved)
            interact();

        return moved;
    }

    @Override
    public boolean moveDown() {
        boolean moved = super.moveDown();
        this.setType(DrawableEnum.FOODTRUCK_DOWN);

        if (moved)
            interact();

        return moved;
    }

    @Override
    public boolean moveRight() {
        boolean moved = super.moveRight();
        this.setType(DrawableEnum.FOODTRUCK_RIGHT);
        
        if (moved)
            interact();

        return moved;
    }

    @Override
    public boolean moveLeft() {
        boolean moved = super.moveLeft();
        this.setType(DrawableEnum.FOODTRUCK_LEFT);

        if (moved)
            interact();

        return moved;
    }

    private void interact() {
        ScoreValue scoreValue = this.getGrid().interact(this.getRow(), this.getCol());

        if (scoreValue == null) 
            return;

        int value = scoreValue.getValue();
        ScoreType scoreType = scoreValue.getScoreType();

        this.score += value;

        switch(scoreType) {
            case FOOD:
                ingredientsFound++;
                break;
            case DAMAGE:
                addDamage(value);
                break;
            case SPEED:
                addFines(value);
                break;
            case BONUS:
                recipesFound++;
                break;
            default:
                break;
        }

    }

    public int getIngredientsFound() {
       
        return this.ingredientsFound;
    
    }

    public int getRecipesFound() {

        return this.recipesFound;
    }

    public void addDamage(int damage) {

        this.damage -= damage;

    } 

    public int getDamage() {

        return this.damage;
    
    }

    public void addFines(int fine) {
        
        this.fines -= fine;
    
    }

    public int getFines() {

        return this.fines;

    }

    public String getScore() {

        return Integer.toString(this.score);

    }

    public int getScoreInt() {
        return this.score;
    }

    public void calculateScore() {

        this.score = this.score - fines - damage;

    } 



}
