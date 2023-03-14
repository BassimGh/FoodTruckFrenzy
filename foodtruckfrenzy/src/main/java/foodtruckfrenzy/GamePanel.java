package foodtruckfrenzy;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    
    private Grid grid = new Grid();
    private final FoodTruck _mainCharacter;
    private final ArrayList<Cop> _cops = new ArrayList<>();

    public GamePanel() {

        // Initialize grid with starting values
        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLS; j++) {
                grid.setCell(i, j, BoardElementFactory.create(MapLayout.getElementAt(i, j), i, j));
            }
        }

        _mainCharacter = new FoodTruck(3, 0, grid);
        _cops.add(new Cop(8, 13, grid, _mainCharacter));
        _cops.add(new Cop(18, 3, grid, _mainCharacter));
        _cops.add(new Cop(15, 14, grid, _mainCharacter));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLS; j++) {
                grid.drawCell(i,j,g2d);
            }
        }
        _mainCharacter.draw(g2d);
        
        for (Cop cop : _cops) {
            cop.draw(g2d);
        }
    }

    public FoodTruck get_mainCharacter() {
        return _mainCharacter;
    }

    public ArrayList<Cop> get_cops() {
        return _cops;
    }
}
