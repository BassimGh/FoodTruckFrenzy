package foodtruckfrenzy.GameFramework;

import javax.swing.*;
import java.awt.*;
import foodtruckfrenzy.SecondaryUI.PauseScreen;

/**
 * This class creates and displays all the different panels in the application
 * Accepts in main character, cops and grid to be added to the respetive panels
 * This frame is setup as follows:
 * CardLayout mainPanel which is the content pane
 * CardLayout mainPanel contains the gameAndScorePanel
 * CardLayout mainPanel contains the pausePanel
 * gameAndScorePanel contains the gamePanel and scoreboardPanel
 * KeyBoard listner is attached to the gamePanel which is given focus
 * On start, flip CardLaout mainPanel to gameAndScorePanel
 * On pause, flip CardLayout mainPanel to pausePanel
 * On resume, flip CardLaout mainPanel back to gameAndScorePanel
 */
public class GameFrame extends JFrame {

    /**
     * Constant height of the scoreboard panel.
     */
    private final int SCOREBOARD_HEIGHT = 100;
    /**
     * Constant width of the game panel.
     */
    private final int GAME_WIDTH = Grid.COLS * Grid.CELL_SIZE;
    /**
     * Constant height of the game panel.
     */
    private final int GAME_HEIGHT = Grid.ROWS * Grid.CELL_SIZE;
    
    /**
     * Panel which contains the game/score and pause panels.
     */
    private final JPanel _mainPanel;
    /**
     * Game panel which contains all the game objects to be displayed.
     */
    private final GamePanel _gamePanel;
    /**
     * Card layout manager for flipping between game/score and pause panels.
     */
    private final CardLayout _layoutManager;

    /**
     * Constructor to create a new GameFrame object.
     * Game Frame object takes in the three panels and sets up the displays.
     * @param gamePanel GamePanel object which contains the game objects.
     * @param scoreboardPanel Scoreboard object to be displayed alongside the game.
     * @param pausePanel PauseScreen secondary UI panel which is to be displayed on pause.
     */
    public GameFrame(GamePanel gamePanel, Scoreboard scoreboardPanel, PauseScreen pausePanel) {
        super("Food Truck Frenzy");
        _gamePanel = gamePanel;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        scoreboardPanel.setPreferredSize(new Dimension(GAME_WIDTH, SCOREBOARD_HEIGHT));
        
        _gamePanel.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        _gamePanel.setBackground(new Color(54, 65, 79));

        JPanel gameAndScorePane = new JPanel(new BorderLayout());
        gameAndScorePane.setBackground(Color.BLACK);
        gameAndScorePane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        gameAndScorePane.add(_gamePanel, BorderLayout.CENTER);
        gameAndScorePane.add(scoreboardPanel, BorderLayout.NORTH);

        _mainPanel = new JPanel(new CardLayout());
        _mainPanel.add(gameAndScorePane, "game");
        _mainPanel.add(pausePanel, "pause");
        this.setContentPane(_mainPanel);
        _layoutManager = (CardLayout) _mainPanel.getLayout();
        _layoutManager.show(_mainPanel, "game");

        this.setFocusable(true);
        this.pack();
        this.requestFocusInWindow();
    }

    /**
     * To be called on timer update
     * Repains game panel
     * Updates scoreboard
     */
    void refresh() {
        _gamePanel.repaint();
    }

    /**
     * Shows pause screen by flipping card layout
     */
    void showPauseScreen() {
        _layoutManager.show(_mainPanel, "pause");
    }

    /**
     * Shows game screen by flipping card layout
     */
    void showGameScreen() {
        _layoutManager.show(_mainPanel, "game");
    }

    /**
     * Getter for the content pane main panel
     * @return JPanel main panel
     */
    JPanel getMainPanel() {
        return _mainPanel;
    }
}
