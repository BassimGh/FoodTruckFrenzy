package foodtruckfrenzy;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {
    private static final int ROWS = 10; // Number of grid rows
    private static final int COLS = 10; // Number of grid columns
    protected static final int CELL_SIZE = 32; // Size of each grid cell
    private static final int FRAME_WIDTH = COLS * CELL_SIZE + 14;
    private static final int FRAME_HEIGHT = ROWS * CELL_SIZE + 37;
    private static final int TIMER_DELAY = 50; // Tick timer delay in milliseconds

    private static final Cell[][] grid = new Cell[ROWS][COLS];
    private static final Cell mainCharacterCell = new Cell(0, 0, new FoodTruck());

    private static Direction queuedDirection = Direction.NULL;
    public static void main(String[] args) {

        // Initialize grid with starting values
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = new Cell(i, j, ItemFactory.create(MapLayout.layout[i][j]));
            }
        }

        JFrame frame = new JFrame("Food Truck Frenzy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        final JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Loop which draws the entire grid
                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) {
                        grid[i][j].draw(g);
                    }
                }

                // Draw vehicles ontop of grid
                mainCharacterCell.draw(g);
            }
        };
        panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        queuedDirection = Direction.UP;
                        break;
                    case KeyEvent.VK_DOWN:
                        queuedDirection = Direction.DOWN;
                        break;
                    case KeyEvent.VK_LEFT:
                        queuedDirection = Direction.LEFT;
                        break;
                    case KeyEvent.VK_RIGHT:
                        queuedDirection = Direction.RIGHT;
                        break;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        Timer timer = new Timer(TIMER_DELAY, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                switch (queuedDirection) {
                    case UP:
                        moveMainCharacter(-1, 0);
                        break;
                    case DOWN:
                        moveMainCharacter(1, 0);
                        break;
                    case LEFT:
                        moveMainCharacter(0, -1);
                        break;
                    case RIGHT:
                        moveMainCharacter(0, 1);
                        break;
                    case NULL:
                        break;
                    default:
                        throw new IllegalStateException();
                }
                panel.repaint();
            }
        });

        panel.setFocusable(true);
        panel.requestFocusInWindow();

        timer.start();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void moveMainCharacter(int downRow, int downCol) {
        int newMainCharacterRow = mainCharacterCell.getRow() + downRow;
        int newMainCharacterCol = mainCharacterCell.getCol() + downCol;

        // Check if main character is at the edge of the screen
        if (newMainCharacterRow < 0 || newMainCharacterRow >= ROWS || newMainCharacterCol < 0 || newMainCharacterCol >= COLS) {
            return;
        }

        if ( grid[newMainCharacterRow][newMainCharacterCol].isObstruction()) {
            return;
        }

        mainCharacterCell.setRow(newMainCharacterRow);
        mainCharacterCell.setCol(newMainCharacterCol);
        queuedDirection = Direction.NULL;
    }
}