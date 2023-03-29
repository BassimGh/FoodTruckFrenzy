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
 */

public class Screen extends JPanel {
    protected BufferedImage backgroundImage;
    protected BufferedImage startImage;
    protected BufferedImage exitImage;
    private JButton topButton;
    private JButton bottomButton;
    protected int width;
    protected int height;

    /**
     * Constructs a new Screen object with the specified ActionListener objects and image paths.
     * @param topListener the listener to be notified when the "resume" button is pressed
     * @param bottomListener the listener to be notified when the "exit" button is pressed
     * @param bgImagePath the path to the background image file
     * @param button1ImagePath the path to the "start" button image file
     * @param button2ImagePath the path to the "exit" button image file
     * @param width The Desired width of the display
     * @param height the Desired height of the display
     */

    /////////////////// Could change the input variable names to be more specific, and use enums for inputs for width and height instead of hard coding the dimensions////////////////////////////
    public Screen(ActionListener topListener, ActionListener bottomListener, String bgImagePath, String button1ImagePath, String button2ImagePath,int width,int height) {
        /**
         * Loads the images from the given file paths and resizes them to the correct dimensions for background and the two buttons
         * @throws IOException if there is a read or resize error 
         */
        try {
            InputStream backgroundInputStream = Screen.class.getResourceAsStream(bgImagePath);
            InputStream startInputStream = Screen.class.getResourceAsStream(button1ImagePath);
            InputStream exitInputStream = Screen.class.getResourceAsStream(button2ImagePath);
            backgroundImage = ImageIO.read(backgroundInputStream);
            backgroundImage = resize(backgroundImage, width, height);
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

        // creates a new JLabel and add an ImageIcon with the background image
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        

        ///////////////////////////////// Could have a button class //////////////////////////////
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

        createBackground(backgroundLabel, gbc, buttonPanel);

    }

    /**
     * resizes the BufferedImage to the specified width and height
     * @param img image to be resized
     * @param width the specific width
     * @param height the specific height
     * @return the resized image
     */
    private static BufferedImage resize(BufferedImage img, int width, int height) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }

    /**
     * @param buttonPanel the JPanel for the buttons 
     * @param gbc the gridBagConstraints for the buttons and background
     * @param backgroundLabel the JLabel for the background
     * @param topListener the listener to be notified when the first button is pressed
     * @param bottomListener the listener to be notified when the second button is pressed
     * Sets the GridBagConstraints and spaces the buttons apart
     * Creates a JButton with an ImageIcon containing the start image and adds an ActionListener
     * Sets the size , removes the button border, removes the focus paint, and makes the content area painted on top of the button image
     * Adds a MouseAdapter to the button to change the border to blue when the mouse goes over the button and remove the border when it leaves the button
     * resumeListener ActionListener to be added to resume button
     * startImage Image to be added to the resumeButton
     * backgroundLabel the background image displayed on the screen
     * gbc GridBagConstrainsts used to set the layout of the buttonpanel and resumeButton
     * buttonPanel JPanel containing the resume button
     * resumeButton JButton used to resume the game
     * exitListener ActionListener to be added to exit button
     * exitImage Image to be added to the exitButton
     * gbc GridBagConstrainsts used to set the layout of the  exitButton
     * buttonPanel JPanel containing the exit button
     * exitButton JButton used to exit the game
     * exitButton has the same properties as resumeButtons except for the image and the listener and it is positioned underneath the resumeButton
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

    protected void createButtons(JPanel buttonPanel, GridBagConstraints gbc, ActionListener topListener, ActionListener bottomListener) {
        buttonPanel.setOpaque(false); // makes the panel transparent
        buttonPanel.setBackground(new Color(0, 0, 0, 0)); // makes the panel background transparent

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0); // adds some spacing between the buttons
        gbc.anchor = GridBagConstraints.CENTER;

        topButton = new JButton(new ImageIcon(startImage));
        topButton.addActionListener(topListener);
        topButton.setPreferredSize(new Dimension(100, 50));
        topButton.setBorder(null); // removes the button border
        topButton.setFocusPainted(false); // removes the focus paint
        topButton.setContentAreaFilled(false); // makes the content area painted directly on top of the button background
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
        bottomButton = new JButton(new ImageIcon(exitImage));
        bottomButton.addActionListener(bottomListener);
        bottomButton.setPreferredSize(new Dimension(100, 50));
        bottomButton.setBorder(null); // remove the button border
        bottomButton.setFocusPainted(false); // remove the focus paint
        bottomButton.setContentAreaFilled(false); // make the content area painted directly on top of the button background
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

        topButton.setPreferredSize(new Dimension(100, 50));
        bottomButton.setPreferredSize(new Dimension(100, 50));

        buttonPanel.setVisible(true); // force display the panel

        buttonPanel.revalidate();
        buttonPanel.repaint();
    }
}
