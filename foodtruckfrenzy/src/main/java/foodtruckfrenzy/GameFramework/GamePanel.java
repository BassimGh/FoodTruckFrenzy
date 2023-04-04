package foodtruckfrenzy.GameFramework;

import javax.swing.JPanel;

import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * GamePanel class is the visual aspect of the game
 * This class creates all the FoodTruck, Cop, BoardElements and places them on the grid
 * This class reads from the MapLayout
 */
class GamePanel extends JPanel {
    
    private final Grid _grid;
    private final FoodTruck _mainCharacter;
    private final ArrayList<Cop> _cops;

    /**
     * GamePanel constructor which does all the creation of the FoodTruck, Cop, BoardElements
     * Initializes and places them on the grid
     * @param grid Game grid object to be displayed
     * @param mainCharacter Food Truck object to be displayed
     * @param cops ArrayList of Cop object to display all these cops in the list
     */
    public GamePanel(Grid grid, FoodTruck mainCharacter, ArrayList<Cop> cops) {
        _grid = grid;
        _mainCharacter = mainCharacter;
        _cops = cops;
    }

    /**
     * Override the JPanel paint component to be called when the panel repaints
     * @param g Graphics object corresponding to the grid
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLS; j++) {
                _grid.drawCell(i,j,g2d);
            }
        }
        _mainCharacter.draw(g2d);
        
        for (Cop cop : _cops) {
            cop.draw(g2d);
        }
    }

    /**
     * Gets the grid stored in the GamePanel
     * @return Grid stored in the GamePanel
     */
    Grid getGrid() {
        return _grid;
    }
    
    /**
     * Gets the ArrayList of Cop objects in the GamePanel
     * @return ArrayList<Cop> in the GamePanel
     */
    ArrayList<Cop> getCops() {
        return _cops;
    }

    /**
     * Gets the main character in the GamePanel
     * @return FoodTruck for the main character in the GamePanel
     */
    FoodTruck getFoodTruck() {
        return _mainCharacter;
    }
}
