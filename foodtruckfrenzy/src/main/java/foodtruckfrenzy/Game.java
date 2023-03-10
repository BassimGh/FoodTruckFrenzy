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

public class Game {
    
    private Grid grid = new Grid();

    private final int SCOREBOARD_HEIGHT = 25;
    private final int FRAME_WIDTH = grid.getCols() * grid.getCellSize() + 14;
    private final int FRAME_HEIGHT = grid.getRows() * grid.getCellSize() + SCOREBOARD_HEIGHT + 37;
    private final int TIMER_DELAY = 50; // Tick timer delay in milliseconds
    private final Vehicle mainCharacter = new FoodTruck(0, 0, grid);

    private final JFrame _frame;
    private final JPanel _gamePanel;
    private final KeyboardHandler _keyboardHandler;
    private final Timer _timer;
    private final JPanel _scoreboardPanel;


    public Game() {
       
        MapLayout layout = new MapLayout(grid.getRows(), grid.getCols());
        // Initialize grid with starting values
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                grid.setCell(i, j, BoardElementFactory.create(layout.getElementAt(i, j), i, j, grid));
            }
        }

        _frame = new JFrame("Food Truck Frenzy");
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        _gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                for (int i = 0; i < grid.getRows(); i++) {
                    for (int j = 0; j < grid.getCols(); j++) {
                        grid.drawCell(i,j,g2d);
                    }
                }
                mainCharacter.drawImage(g2d, grid.getCellSize());
            }
        };
        _gamePanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        _keyboardHandler = new KeyboardHandler();
        _gamePanel.addKeyListener(_keyboardHandler);

        _timer = new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (_keyboardHandler.upPressed())
                    mainCharacter.moveUp();
                if (_keyboardHandler.downPressed())
                    mainCharacter.moveDown();
                if (_keyboardHandler.leftPressed())
                    mainCharacter.moveLeft();
                if (_keyboardHandler.rightPressed())
                    mainCharacter.moveRight();
                _gamePanel.repaint();
            }
        });

        _scoreboardPanel = new JPanel();
        _scoreboardPanel.setPreferredSize(new Dimension(FRAME_WIDTH, SCOREBOARD_HEIGHT));
        JLabel scoreLabel = new JLabel("Score: 0");
        _scoreboardPanel.add(scoreLabel);
        
        _gamePanel.setFocusable(true);
        _gamePanel.requestFocusInWindow();

        _frame.getContentPane().setLayout(new BorderLayout());
        _frame.getContentPane().add(_scoreboardPanel, BorderLayout.NORTH);
        _frame.getContentPane().add(_gamePanel, BorderLayout.CENTER);
        _frame.pack();
        _frame.setVisible(true);

    }

    public void startTimer() {
        _timer.start();
    }

    public void stopTimer() {
        _timer.stop();
    }
}
