package foodtruckfrenzy.SecondaryUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;


/**
 * The Screen class represents a JPanel that displays a background image and two buttons: a "resume" button and an "exit" button.
 * The buttons have custom images and behavior when clicked or hovered over. 
 * The background image and button images can be set through the constructor with a path to the image files.
 * The buttons have ActionListeners that can be passed in through the constructor, which will be triggered when the buttons are clicked.
 * The Screen class is the Parent class of all other UI screens such as TitleScreen, PauseScreen, GameOverDisplay and it's children: GameLostScreen and GameWonScreen
 * Protected Jbutton topButton represents the top button that will be displayed on the screen
 * Protected Jbutton bottomButton represents the bottom button that will be displayed on the screen
 */

public class Screen extends JPanel {
    /**
     * BufferedImage backgroundImage to be used to display the background image
     */
    protected BufferedImage backgroundImage;
    /**
     * BufferedImage startImage to be used for the start button
     */
    protected BufferedImage startImage;
    /**
     * BufferedImage exitImage to be used for the exit button
     */
    protected BufferedImage exitImage;
    /**
     * Button to be used for start or resume button
     */
    protected JButton topButton;
    /**
     * Button to be used for exit or restart button
     */
    protected JButton bottomButton;
    /**
     * dimensions object to set size of the desired screen
     */
    protected Dimensions dimensions;
    /**
     * imagePaths object to set the image paths of the background and buttons
     */
    protected ImagePaths imagePaths;

    /**
     * Constructs a new Screen object with the specified ActionListener objects and image paths.
     * @param topListener the listener to be notified when the top button (first) is pressed
     * @param bottomListener the listener to be notified when the bottom (second) button is pressed
     * @param imagePaths contains the paths to the background image file and the 2 button image files
     * @param dimensions the object that holds the specific width and height for the specific type of screen
     */

    public Screen(ActionListener topListener, ActionListener bottomListener, ImagePaths imagePaths, Dimensions dimensions) {
        /**
         * Loads the images from the given file paths and resizes them to the correct dimensions for background and the two buttons
         * @throws IOException if there is a read or resize error 
         */
        try {
            InputStream backgroundInputStream = Screen.class.getResourceAsStream(imagePaths.backgroundPath);
            InputStream startInputStream = Screen.class.getResourceAsStream(imagePaths.button1Path);
            InputStream exitInputStream = Screen.class.getResourceAsStream(imagePaths.button2Path);
            backgroundImage = ImageIO.read(backgroundInputStream);
            backgroundImage = resize(backgroundImage, dimensions.width, dimensions.height);
            startImage = ImageIO.read(startInputStream);
            startImage = resize(startImage, 100, 50);
            exitImage = ImageIO.read(exitInputStream);
            exitImage = resize(exitImage, 100, 50);

        } catch (IOException e) {
            System.out.println("Error loading background image:");
            e.printStackTrace();
        }

        /**
         * Sets the layout of the Screen to a GridBagLayout with specified constraints to be implemented.
         */
        setLayout(new GridBagLayout());

        /**
         * Initializes a GridBagConstraints object and implements specified constraints.
         */

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        /**
         * Creates a JLabel with an ImageIcon with the background image and adds it to the screen
         * Creates a JPanel with a GridBagLayout, with a transparent background
         * Creates the buttons using the createButtons() method
         */

        /**
         * creates a new JLabel and add an ImageIcon with the background image
         */
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        /**
         * creates the buttons 
         */
        createButtons(buttonPanel, gbc, topListener, bottomListener);
        

        /**
         * Sets the backgroundLabel constraints and adds the button panel to it
         * Sets the layout of the backgroundLabel
         * Created the background using the createBackground() method
         */

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;

        /**
         * creates the background label and displays the button panel over it
         */
        createBackground(backgroundLabel, gbc, buttonPanel);
    }

    /**
     * resizes the BufferedImage to the specified width and height
     * @param img image to be resized
     * @param width the specific width
     * @param height the specific height
     * @return the resized image
     */
    static BufferedImage resize(BufferedImage img, int width, int height) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }

    /**
     * Sets the GridBagConstraints and spaces the buttons apart
     * Creates a JButton with an ImageIcon containing the first button image and adds an ActionListener
     * Sets the size , removes the button border, removes the focus paint, and makes the content area painted on top of the button image
     * Adds a MouseAdapter to the button to change the border to blue when the mouse goes over the button and remove the border when it leaves the button
     * topListener ActionListener to be added to top button
     * button1Image Image to be added to the topButton
     * backgroundLabel the background image displayed on the screen
     * gbc GridBagConstrainsts used to set the layout of the buttonpanel and resumeButton
     * buttonPanel JPanel containing the resume button
     * topButton JButton used to start or resume the game
     * bottomListener ActionListener to be added to botton button
     * button2 Image to be added to the bottomButton
     * gbc GridBagConstrainsts used to set the layout of the  exitButton
     * buttonPanel JPanel containing the bottomButton
     * bottomButton JButton used to exit or restart the game
     * bottomButton has the same properties as topButtons except for the image and the listener and it is positioned underneath the topButton
     * @param buttonPanel the JPanel for the buttons 
     * @param gbc the gridBagConstraints for the buttons and background
     * @param backgroundLabel the JLabel for the background
     */

     protected void createBackground(JLabel backgroundLabel, GridBagConstraints gbc, JPanel buttonPanel) {
        add(backgroundLabel, gbc);
        /**
         * Sets the backgroundLabel constraints and adds the button panel to it
         * Sets the layout of the backgroundLabel
         */

        backgroundLabel.setLayout(new GridBagLayout());
        backgroundLabel.add(buttonPanel, gbc);
     }

     /**
      * This method creates two buttons on a JPanel with the provided GridBagConstraints and ActionListeners for top and bottom buttons.
      * @param buttonPanel button panel to display the screen buttons
      * @param gbc gridbagconstraints of the buttons
      * @param topListener the listener to be notified when the top (first) button is pressed
      * @param bottomListener the listener to be notified when the bottom (second) button is pressed
      */

    protected void createButtons(JPanel buttonPanel, GridBagConstraints gbc, ActionListener topListener, ActionListener bottomListener) {
        /**
         * makes the panel transparent
         */
        buttonPanel.setOpaque(false);
        /**
         * makes the panel background transparent
         */
        buttonPanel.setBackground(new Color(0, 0, 0, 0));

        /**
         * adds some spacing between the buttons
         */
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        /**
         * creates new button
         * resizes button
         * removes the button border
         * removes the focus paint
         * makes the content area painted directly on top of the button background
         */
        topButton = new JButton(new ImageIcon(startImage));
        topButton.addActionListener(topListener);
        topButton.setPreferredSize(new Dimension(100, 50));
        topButton.setBorder(null); 
        topButton.setFocusPainted(false); 
        topButton.setContentAreaFilled(false); 
        topButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                topButton.setBorder(new LineBorder(Color.BLUE, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                topButton.setBorder(null);
            }
        });
        buttonPanel.add(topButton, gbc);

        gbc.gridy++;

        /**
         * creates new button
         * resizes button
         * removes the button border
         * removes the focus paint
         * makes the content area painted directly on top of the button background
         */
        bottomButton = new JButton(new ImageIcon(exitImage));
        bottomButton.addActionListener(bottomListener);
        bottomButton.setPreferredSize(new Dimension(100, 50));
        bottomButton.setBorder(null); 
        bottomButton.setFocusPainted(false); 
        bottomButton.setContentAreaFilled(false); 
        bottomButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bottomButton.setBorder(new LineBorder(Color.BLUE, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bottomButton.setBorder(null);
            }
        });
        buttonPanel.add(bottomButton, gbc);

        /**
         * Sizes the buttons
         * Force displays the button panel and repaints the content
         */

        topButton.setPreferredSize(new Dimension(100, 50));
        bottomButton.setPreferredSize(new Dimension(100, 50));

        buttonPanel.setVisible(true);

        buttonPanel.revalidate();
        buttonPanel.repaint();
    }
}
