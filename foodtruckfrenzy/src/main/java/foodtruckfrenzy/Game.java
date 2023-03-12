package foodtruckfrenzy;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.Color;

public class Game {
    
    private final int SCOREBOARD_HEIGHT = 100;
    private final int FRAME_WIDTH = Grid.COLS * Grid.CELL_SIZE;
    private final int FRAME_HEIGHT = Grid.ROWS * Grid.CELL_SIZE;
    private final int TIMER_DELAY = 75; // Tick timer delay in milliseconds

    private final JFrame _frame;
    private final KeyboardHandler _keyboardHandler;
    private final Timer _timer;
    private final JPanel _mainPanel;
    private final Scoreboard _scoreboardPanel;
    private final GamePanel _gamePanel;
    private final CardLayout _layout;
    private boolean _paused = false;

    public Game() {
    
        _mainPanel = new JPanel(new CardLayout());

        _frame = new JFrame("Food Truck Frenzy");
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setResizable(true);

        JPanel gameAndScorePane = new JPanel(new BorderLayout());
        gameAndScorePane.setBackground(Color.BLACK);
        gameAndScorePane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));

        _gamePanel = new GamePanel();
        FoodTruck mainCharacter = _gamePanel.get_mainCharacter();
        Cop cop = _gamePanel.get_cop();

        _gamePanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        _gamePanel.setFocusable(true);
        _gamePanel.requestFocusInWindow();

        _scoreboardPanel = new Scoreboard(mainCharacter); 
        _scoreboardPanel.setPreferredSize(new Dimension(FRAME_WIDTH, SCOREBOARD_HEIGHT));

        _keyboardHandler = new KeyboardHandler();
        _gamePanel.addKeyListener(_keyboardHandler);

        gameAndScorePane.add(_gamePanel, BorderLayout.CENTER);
        gameAndScorePane.add(_scoreboardPanel, BorderLayout.NORTH);

        _mainPanel.add(gameAndScorePane, "game");

        ActionListener resumeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resume();
            }
        };

        ActionListener restartListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.main(null);
                _frame.dispose();
            }
        };
        JPanel pausePanel = new PauseScreen(resumeListener, restartListener);

        _mainPanel.add(pausePanel, "pause");
        _frame.setContentPane(_mainPanel);
        _layout = (CardLayout) _mainPanel.getLayout();
        _layout.show(_mainPanel, "game");

        _frame.pack();
        _frame.setVisible(true);
        // _frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        _timer = new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!_paused) {
                    if (_keyboardHandler.pause())
                        pause();

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
            }
        });

    }

    public void startTimer() {
        _timer.start();
    }

    public void pause() {
        _keyboardHandler.resetKeys();
        _paused = true;
        _layout.show(_mainPanel, "pause");

        _gamePanel.setFocusable(true);
        _gamePanel.requestFocusInWindow();
    }

    public void resume() {
        _paused = false;
        _layout.show(_mainPanel, "game");
        _gamePanel.setFocusable(true);
        _gamePanel.requestFocusInWindow();
    }
}
