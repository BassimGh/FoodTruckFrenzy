package foodtruckfrenzy;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.Color;

public class Game {
    
    private final int SCOREBOARD_HEIGHT = 30;
    private final int FRAME_WIDTH = Grid.COLS * Grid.CELL_SIZE;
    private final int FRAME_HEIGHT = Grid.ROWS * Grid.CELL_SIZE;
    private final int TIMER_DELAY = 50; // Tick timer delay in milliseconds

    private final JFrame _frame;
    private final KeyboardHandler _keyboardHandler;
    private final Timer _timer;
    private final Scoreboard _scoreboardPanel;
    private final GamePanel _gamePanel;

    public Game() {
       
        _frame = new JFrame("Food Truck Frenzy");
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setResizable(true);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));

        _frame.setContentPane(contentPane);
        
        _gamePanel = new GamePanel();
        FoodTruck mainCharacter = _gamePanel.get_mainCharacter();
        Cop cop = _gamePanel.get_cop();

        _gamePanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        _gamePanel.setFocusable(true);
        _gamePanel.requestFocusInWindow();

        contentPane.add(_gamePanel, BorderLayout.CENTER);

        _keyboardHandler = new KeyboardHandler();
        _gamePanel.addKeyListener(_keyboardHandler);

        _scoreboardPanel = new Scoreboard(mainCharacter); 
        _scoreboardPanel.setPreferredSize(new Dimension(FRAME_WIDTH, SCOREBOARD_HEIGHT));

        _frame.getContentPane().setLayout(new BorderLayout());
        _frame.getContentPane().add(_scoreboardPanel, BorderLayout.NORTH);
        _frame.getContentPane().add(_gamePanel, BorderLayout.CENTER);
        _frame.pack();
        _frame.setVisible(true);
        // _frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        _timer = new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (_keyboardHandler.upPressed() && !_keyboardHandler.downPressed())
                    mainCharacter.moveUp();

                if (_keyboardHandler.downPressed() && !_keyboardHandler.upPressed())
                    mainCharacter.moveDown();

                if (_keyboardHandler.leftPressed() && !_keyboardHandler.rightPressed())
                    mainCharacter.moveLeft();
                    
                if (_keyboardHandler.rightPressed() && !_keyboardHandler.leftPressed())
                    mainCharacter.moveRight();

                cop.chaseTruck();
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
