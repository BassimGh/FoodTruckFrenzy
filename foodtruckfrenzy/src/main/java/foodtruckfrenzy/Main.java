package foodtruckfrenzy;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    private static final int ROWS = 10;
    private static final int COLS = 10;
    protected static final int CELL_SIZE = 32;
    private static final int FRAME_WIDTH = COLS * CELL_SIZE + 15;
    private static final int FRAME_HEIGHT = ROWS * CELL_SIZE + 25;

    private static final Cell[][] grid = new Cell[ROWS][COLS];
    private static final Cell mainCharacterCell = new Cell(0, 0, new MainCharacter());

    public static void main(String[] args) {

        
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
                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) {
                        grid[i][j].draw(g);
                    }
                }
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
                        moveMainCharacter(-1, 0);
                        break;
                    case KeyEvent.VK_DOWN:
                        moveMainCharacter(1, 0);
                        break;
                    case KeyEvent.VK_LEFT:
                        moveMainCharacter(0, -1);
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveMainCharacter(0, 1);
                        break;
                }
                panel.repaint();
            }

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        panel.setFocusable(true);
        panel.requestFocusInWindow();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void moveMainCharacter(int downRow, int downCol) {
        int newMainCharacterRow = mainCharacterCell.getRow() + downRow;
        int newMainCharacterCol = mainCharacterCell.getCol() + downCol;

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