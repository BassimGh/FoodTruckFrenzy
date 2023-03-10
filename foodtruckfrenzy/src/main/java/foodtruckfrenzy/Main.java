package foodtruckfrenzy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {


    static final Grid grid = new Grid();

    private static final int SCOREBOARD_HEIGHT = 25;
    private static final int FRAME_WIDTH = grid.getCols() * grid.getCellSize() + 14;
    private static final int FRAME_HEIGHT = grid.getRows() * grid.getCellSize() + SCOREBOARD_HEIGHT + 37;
    private static final int TIMER_DELAY = 50; // Tick timer delay in milliseconds
    private static final Vehicle mainCharacter = new FoodTruck(0, 0);

    public static void main(String[] args) {

        MapLayout layout = new MapLayout(grid.getRows(), grid.getCols());
        // Initialize grid with starting values
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                grid.setCell(i, j, BoardElementFactory.create(layout.getElementAt(i, j), i, j));
            }
        }

        JFrame frame = new JFrame("Food Truck Frenzy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        final JPanel gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                for (int i = 0; i < grid.getRows(); i++) {
                    for (int j = 0; j < grid.getCols(); j++) {
                        grid.drawCell(i,j,g2d);
                    }
                }
                mainCharacter.draw(g2d, grid.getCellSize());
            }
        };
        gamePanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        KeyboardHandler keyboardHandler = new KeyboardHandler();
        gamePanel.addKeyListener(keyboardHandler);

        Timer timer = new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyboardHandler.upPressed())
                    moveMainCharacter(-1, 0);
                if (keyboardHandler.downPressed())
                    moveMainCharacter(1, 0);
                if (keyboardHandler.leftPressed())
                    moveMainCharacter(0, -1);
                if (keyboardHandler.rightPressed())
                    moveMainCharacter(0, 1);
                gamePanel.repaint();
            }
        });

        JPanel scoreboardPanel = new JPanel();
        scoreboardPanel.setPreferredSize(new Dimension(FRAME_WIDTH, SCOREBOARD_HEIGHT));
        JLabel scoreLabel = new JLabel("Score: 0");
        scoreboardPanel.add(scoreLabel);
        
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        timer.start();

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(scoreboardPanel, BorderLayout.NORTH);
        frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private static void moveMainCharacter(int downRow, int downCol) {
        int newMainCharacterRow = mainCharacter.getRow() + downRow;
        int newMainCharacterCol = mainCharacter.getCol() + downCol;

        // Check if main character is at the edge of the screen
        if (newMainCharacterRow < 0 || newMainCharacterRow >= grid.getRows() || newMainCharacterCol < 0 || newMainCharacterCol >= grid.getCols()) { return; }

        if ( grid.isObstruction(newMainCharacterRow, newMainCharacterCol)) { return; }

        mainCharacter.setRow(newMainCharacterRow);
        mainCharacter.setCol(newMainCharacterCol);
    }
}