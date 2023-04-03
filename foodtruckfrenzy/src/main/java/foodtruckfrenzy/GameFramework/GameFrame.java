package foodtruckfrenzy.GameFramework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import foodtruckfrenzy.Drawable.Vehicle.Cop;
import foodtruckfrenzy.Drawable.Vehicle.FoodTruck;
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
    private final Scoreboard _scoreboardPanel;
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
    public GameFrame(FoodTruck mainCharacter, Grid grid, ArrayList<Cop> cops, ActionListener resumeListener, ActionListener restartListener) {
        super("Food Truck Frenzy");

        _mainPanel = new JPanel(new CardLayout());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);


        JPanel gameAndScorePane = new JPanel(new BorderLayout());
        gameAndScorePane.setBackground(Color.BLACK);
        gameAndScorePane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));

        _gamePanel = new GamePanel(grid, mainCharacter, cops);
        _gamePanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        _gamePanel.setBackground(new Color(54, 65, 79));

        _scoreboardPanel = new Scoreboard(mainCharacter); 
        _scoreboardPanel.setPreferredSize(new Dimension(FRAME_WIDTH, SCOREBOARD_HEIGHT));

        mainCharacter.setScoreboard(_scoreboardPanel);

        gameAndScorePane.add(_gamePanel, BorderLayout.CENTER);
        gameAndScorePane.add(_scoreboardPanel, BorderLayout.NORTH);

        _mainPanel.add(gameAndScorePane, "game");


        JPanel pausePanel = new PauseScreen(resumeListener, restartListener);

        _mainPanel.add(pausePanel, "pause");
        this.setContentPane(_mainPanel);
        _layout = (CardLayout) _mainPanel.getLayout();
        _layout.show(_mainPanel, "game");

        this.setFocusable(true);
        this.pack();
        this.setVisible(true);
    }

    /**
     * To be called on timer update
     * Repains game panel
     * Updates scoreboard
     */
    void refresh() {
        _gamePanel.repaint();
        _scoreboardPanel.update(); 
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

    /**
     * Returns scoreboard panel
     * @return returns scoreboard panel
     */
    Scoreboard getScoreboard() {
        return _scoreboardPanel;
    }
}
