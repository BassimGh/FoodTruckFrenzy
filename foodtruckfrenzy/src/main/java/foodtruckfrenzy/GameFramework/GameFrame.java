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

    private final int SCOREBOARD_HEIGHT = 100;
    private final int FRAME_WIDTH = Grid.COLS * Grid.CELL_SIZE;
    private final int FRAME_HEIGHT = Grid.ROWS * Grid.CELL_SIZE;
    
    private final JPanel _mainPanel;
    private final GamePanel _gamePanel;
    private final CardLayout _layout;


    /**
     * Constructor to create a new GameFrame object
     * @param mainCharacter FoodTruck object which is main character
     * @param grid Grid object for displayable grid
     * @param cops ArrayList of Cop objects
     * @param resumeListener ActionListener for on resume from pause
     * @param restartListener ActionListner for on restart from pause
     */
    public GameFrame(GamePanel gamePanel, Scoreboard scoreboardPanel, PauseScreen pausePanel) {
        super("Food Truck Frenzy");
        _gamePanel = gamePanel;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        scoreboardPanel.setPreferredSize(new Dimension(FRAME_WIDTH, SCOREBOARD_HEIGHT));
        
        _gamePanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
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
        _layout = (CardLayout) _mainPanel.getLayout();
        _layout.show(_mainPanel, "game");

        this.setFocusable(true);
        this.pack();
        this.setVisible(true);
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
        _layout.show(_mainPanel, "pause");
    }

    /**
     * Shows game screen by flipping card layout
     */
    void showGameScreen() {
        _layout.show(_mainPanel, "game");
    }

    GamePanel getGamePanel() {
        return _gamePanel;
    }

    CardLayout getCardLayout() {
        return _layout;
    }

    JPanel getMainPanel() {
        return _mainPanel;
    }



}
