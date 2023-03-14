package foodtruckfrenzy;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel {
    
    private Grid grid = new Grid();
    private final FoodTruck _mainCharacter;
    private final Cop _cop;

    public GamePanel() {

        // Initialize grid with starting values
        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLS; j++) {
                grid.setCell(i, j, BoardElementFactory.create(MapLayout.getElementAt(i, j), i, j));
            }
        }

        _mainCharacter = new FoodTruck(3, 0, grid);
        _cop = new Cop(15, 19, grid, _mainCharacter);
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
        _cop.draw(g2d);
    }

    public FoodTruck get_mainCharacter() {
        return _mainCharacter;
    }

    public Cop get_cop() {
        return _cop;
    }
}
