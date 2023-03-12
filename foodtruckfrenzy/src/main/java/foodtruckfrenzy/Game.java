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
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Color;

public class Game {
    
    private Grid grid = new Grid();

    private final int SCOREBOARD_HEIGHT = 30;
    private final int FRAME_WIDTH = Grid.COLS * Grid.CELL_SIZE;
    private final int FRAME_HEIGHT = Grid.ROWS * Grid.CELL_SIZE;
    private final int TIMER_DELAY = 50; // Tick timer delay in milliseconds
    private final FoodTruck mainCharacter = new FoodTruck(0, 0, grid);

    private final JFrame _frame;
    private final JPanel _gamePanel;
    private final KeyboardHandler _keyboardHandler;
    private final Timer _timer;
    private final Scoreboard _scoreboardPanel;


// game constructor
    public Game() {
       
        // Initialize grid with starting values
        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLS; j++) {
                grid.setCell(i, j, BoardElementFactory.create(MapLayout.getElementAt(i, j), i, j));
            }
        }

        // create new title frame
        _frame = new JFrame("Food Truck Frenzy");
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setResizable(true);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10)); // add black border with a width of 10 pixels

        _frame.setContentPane(contentPane);
        
        // create panel for the map
        _gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                for (int i = 0; i < Grid.ROWS; i++) {
                    for (int j = 0; j < Grid.COLS; j++) {
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

  
        _scoreboardPanel = new Scoreboard(mainCharacter); 
    
        _scoreboardPanel.setPreferredSize(new Dimension(FRAME_WIDTH, SCOREBOARD_HEIGHT));

        // JLabel scoreLabel = new JLabel("Score: " + scoreboard.getScore(), SwingConstants.LEFT);
        // JLabel ingredientLabel = new JLabel("Ingredients: " + scoreboard.getIngredients(), SwingConstants.CENTER);
        
        // _scoreboardPanel.add(ingredientLabel); 
        // _scoreboardPanel.add(scoreLabel);
        
        _gamePanel.setFocusable(true);
        _gamePanel.requestFocusInWindow();

        _frame.getContentPane().setLayout(new BorderLayout());
        _frame.getContentPane().add(_scoreboardPanel, BorderLayout.NORTH);
        _frame.getContentPane().add(_gamePanel, BorderLayout.CENTER);
        _frame.pack();
        _frame.setVisible(true);
        _frame.setExtendedState(JFrame.MAXIMIZED_BOTH);



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
                _scoreboardPanel.update(); 
            }
        });

    }

    public void startTimer() {
        _timer.start();
    }

    public void stopTimer() {
        _timer.stop();
    }
}
