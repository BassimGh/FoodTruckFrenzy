package foodtruckfrenzy;

public class FoodTruck extends Drawable {

    private int SPEED = 1;
    private Grid _grid;


    // scoreboard attributes
    private String ingredients = "Potato!";
    private int damage;
    private int fines;
    private int score;
    

    public FoodTruck(int row, int col, Grid grid) {
        super(row, col, DrawableEnum.FOODTRUCK);
        _grid = grid;
    }

    public void moveUp() {
        int newRow = this.getRow() - SPEED;

        if (newRow < 0) { return; }

        if (_grid.isObstruction(newRow, this.getCol())) { return; }

        this.setRow(newRow);
    }

    public void moveDown() {
        int newRow = this.getRow() + SPEED;

        if (newRow >= _grid.getRows()) { return; }

        if (_grid.isObstruction(newRow, this.getCol())) { return; }

        this.setRow(newRow);
    }

    public void moveRight() {
        int newCol = this.getCol() + SPEED;

        if (newCol >= _grid.getCols()) { return; }

        if (_grid.isObstruction(this.getRow(), newCol)) { return; }

        this.setCol(newCol);
    }

    public void moveLeft() {
        int newCol = this.getCol() - SPEED;

        if (newCol < 0 ) { return; }

        if (_grid.isObstruction(this.getRow(), newCol)) { return; }

        this.setCol(newCol);
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
