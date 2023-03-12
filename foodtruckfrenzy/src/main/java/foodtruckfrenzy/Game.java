package foodtruckfrenzy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;

public class Game {
    
    private Grid grid = new Grid();

    private final int SCOREBOARD_HEIGHT = 30;
    private final int FRAME_WIDTH = grid.getCols() * grid.getCellSize();
    private final int FRAME_HEIGHT = grid.getRows() * grid.getCellSize();
    private final int TIMER_DELAY = 50; // Tick timer delay in milliseconds
    private final FoodTruck mainCharacter = new FoodTruck(0, 0, grid);

    private final JFrame _frame;
    private final JPanel _gamePanel;
    private final KeyboardHandler _keyboardHandler;
    private final Timer _timer;
    private final JPanel _scoreboardPanel;

    private Scoreboard scoreboard = new Scoreboard();


    public Game() {
       
        // Initialize grid with starting values
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                grid.setCell(i, j, BoardElementFactory.create(MapLayout.getElementAt(i, j), i, j));
            }
        }

        _frame = new JFrame("Food Truck Frenzy");
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setResizable(true);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10)); // add black border with a width of 10 pixels

        _frame.setContentPane(contentPane);
        
        

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
                mainCharacter.draw(g2d);
            }
        };
        _gamePanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        contentPane.add(_gamePanel, BorderLayout.CENTER);
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

        
        
        
        JLabel scoreLabel = new JLabel(scoreboard.getScore());
        JLabel ingredientLabel = new JLabel()
        _scoreboardPanel.add(scoreLabel);
        
        _gamePanel.setFocusable(true);
        _gamePanel.requestFocusInWindow();

        _frame.getContentPane().setLayout(new BorderLayout());
        _frame.getContentPane().add(_scoreboardPanel, BorderLayout.NORTH);
        _frame.getContentPane().add(_gamePanel, BorderLayout.CENTER);
        _frame.pack();
        _frame.setVisible(true);
        _frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public void startTimer() {
        _timer.start();
    }

    public void stopTimer() {
        _timer.stop();
    }
}
