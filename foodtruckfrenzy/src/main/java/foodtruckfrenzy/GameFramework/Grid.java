package foodtruckfrenzy.GameFramework;

import java.awt.Graphics2D;

import foodtruckfrenzy.Drawable.BoardElement.BoardElement;
import foodtruckfrenzy.Drawable.BoardElement.Obstruction;
import foodtruckfrenzy.Drawable.Item.ScoreValue;
import foodtruckfrenzy.Helper.BoardElementFactory;
import foodtruckfrenzy.Helper.LayoutEnum;
import foodtruckfrenzy.Helper.MapLayout;

/**
 * Grid class is an object which acts as a game grid
 * This object will store a 2d array of BoardElements in a predetermined size which can be set and updated accordingly
 * The class provides methods to retrieve, set, and interact with BoardElements on the grid, and to draw cells on the graphics context.
 */
public class Grid {

    public final static int ROWS = 20; // Number of grid rows
    public final static int COLS = 41; // Number of grid columns
    public final static int CELL_SIZE = 32; // Size of each grid cell

    private int _ingredientsDiscoverable;
    private int _recipesDiscoverable;
    
    private BoardElement[][] _grid;

    /**
     * Construtor for the Grid class
     * Initliazes a new BoardElement 2d array at ROWS x COLS
     * Fills the grid up with elements from Map Layout
     */
    public Grid(BoardElementFactory boardElementFactory, MapLayout mapLayout) {
        _ingredientsDiscoverable = 0;
        _recipesDiscoverable = 0;

        _grid = new BoardElement[ROWS][COLS];
        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLS; j++) {

                LayoutEnum currLayout = mapLayout.getElementAt(i, j); 
                _grid[i][j] = boardElementFactory.create(currLayout, i, j);

                if (currLayout == LayoutEnum.R || currLayout == LayoutEnum.F)
                    _ingredientsDiscoverable++;

                if (currLayout == LayoutEnum.Q)
                    _recipesDiscoverable++;
                
            }
        }
    }

    /**
     * Returns the BoardElement requested
     * @param row row of requested BoardElement
     * @param col column of requested BoardElement
     * @return requested BoardElement object
     */
    public BoardElement getCell(int row, int col) {
        return _grid[row][col];
    }

    /**
     * Calls the draw method on the specified BoardElement
     * @param row row of specified BoardElement
     * @param col column of specified BoardElement
     * @param g2d Graphics2D object which corresponds to the grid to be passed to the draw method
     */
    public void drawCell(int row, int col, Graphics2D g2d) {
        _grid[row][col].draw(g2d);
    }

    /**
     * Checks if the specified row and column is an obstruction
     * @param row row of specified BoardElement
     * @param col column of specified BoardElement
     * @return true is specified row and column of grid is an obstruction, false if not
     */
    public boolean isObstruction(int row, int col) {
        return _grid[row][col] instanceof Obstruction;
    }

    /**
     * Calls the interact() ethod of the specified BoardElement
     * @param row row of specified BoardElement
     * @param col column of specified BoardElement
     * @return value returned by the BoardElement's interact() method
     */
    public ScoreValue interact(int row, int col) {
        return getCell(row, col).interact();
    }

    /**
     * Returns the total amount of recipes that are present on the grid
     * @return int of total recipes on the grid
     */
    public int getRecipesDiscoverable() {
        return _recipesDiscoverable;
    }

    /**
     * Returns the total amount of foods that are present on the grid
     * @return int of total foods on the grid
     */
    public int getIngredientsDiscoverable() {
        return _ingredientsDiscoverable;
    }

}
