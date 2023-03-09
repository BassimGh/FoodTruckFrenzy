package foodtruckfrenzy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    private static final int ROWS = 5;
    private static final int COLS = 5;
    protected static final int CELL_SIZE = 50;
    private static final int FRAME_WIDTH = COLS * CELL_SIZE;
    private static final int FRAME_HEIGHT = ROWS * CELL_SIZE;

    private static final Cell[][] grid = new Cell[ROWS][COLS];
    private static final Cell redSquare = new Cell(0, 0, Color.RED);

    public static void main(String[] args) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = new Cell(i, j, Color.WHITE);
            }
        }

        JFrame frame = new JFrame("Grid");
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
                redSquare.draw(g);
            }
        };
        panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        moveRedSquare(-1, 0);
                        break;
                    case KeyEvent.VK_DOWN:
                        moveRedSquare(1, 0);
                        break;
                    case KeyEvent.VK_LEFT:
                        moveRedSquare(0, -1);
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveRedSquare(0, 1);
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

    private static void moveRedSquare(int dRow, int dCol) {
        int newRedRow = redSquare.getRow() + dRow;
        int newRedCol = redSquare.getCol() + dCol;
        if (newRedRow >= 0 && newRedRow < ROWS && newRedCol >= 0 && newRedCol < COLS) {
            redSquare.setRow(newRedRow);
            redSquare.setCol(newRedCol);
        }
    }
}