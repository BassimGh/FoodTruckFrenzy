package foodtruckfrenzy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {
    static final int ROWS = 20; // Number of grid rows
    static final int COLS = 25; // Number of grid columns
    static final int CELL_SIZE = 32; // Size of each grid cell
    private static final int SCOREBOARD_HEIGHT = 25;
    private static final int FRAME_WIDTH = COLS * CELL_SIZE + 14;
    private static final int FRAME_HEIGHT = ROWS * CELL_SIZE + SCOREBOARD_HEIGHT + 37;
    private static final int TIMER_DELAY = 50; // Tick timer delay in milliseconds

    private static final Cell[][] grid = new Cell[ROWS][COLS];
    private static final Cell mainCharacterCell = new Cell(0, 0, new FoodTruck());

    private static boolean upPressed = false;
    private static boolean downPressed = false;
    private static boolean rightPressed = false;
    private static boolean leftPressed = false;
    public static void main(String[] args) {

        // Initialize grid with starting values
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = new Cell(i, j, BoardElementFactory.create(MapLayout.layout[i][j]));
            }
        }

        JFrame frame = new JFrame("Food Truck Frenzy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        final JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g.create();
                
                // Loop which draws the entire grid
                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) {
                        grid[i][j].draw(g2d);
                    }
                }

                // Draw vehicles ontop of grid
                mainCharacterCell.draw(g2d);
            }
        };
        panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        upPressed = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        downPressed = true;                        
                        break;
                    case KeyEvent.VK_LEFT:
                        leftPressed = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightPressed = true;
                        break;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        upPressed = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        downPressed = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        leftPressed = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightPressed = false;
                        break;
                }
            }
        });

        Timer timer = new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (upPressed)
                    moveMainCharacter(-1, 0);
                if (downPressed)
                    moveMainCharacter(1, 0);
                if (leftPressed)
                    moveMainCharacter(0, -1);
                if (rightPressed)
                    moveMainCharacter(0, 1);
                panel.repaint();
            }
        });

        JPanel scoreboardPanel = new JPanel();
        scoreboardPanel.setPreferredSize(new Dimension(FRAME_WIDTH, SCOREBOARD_HEIGHT));
        JLabel scoreLabel = new JLabel("Score: 0");
        scoreboardPanel.add(scoreLabel);
        
        panel.setFocusable(true);
        panel.requestFocusInWindow();

        timer.start();

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(scoreboardPanel, BorderLayout.NORTH);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
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
    }
}