package foodtruckfrenzy.SecondaryUI;

import org.junit.Before;
import org.junit.Test;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.mockito.Mockito.mock;

public class ScreenTest {
    private ImagePaths imagePaths;
    private ActionListener topListener;
    private ActionListener bottomListener;
    private Dimensions dimensions;
    private Screen screen;
    private JLabel backgroundLabel;
    private JPanel buttonPanel;
    private GridBagConstraints gbc;

    @Before
    public void setup() {
        imagePaths = new ImagePaths("youlose.png", "restart.png", "exit.png");
        topListener = mock(ActionListener.class);
        bottomListener = mock(ActionListener.class);
        dimensions = new Dimensions(800, 600);
        screen = new Screen(topListener, bottomListener, imagePaths, dimensions);
        backgroundLabel = new JLabel();
        buttonPanel = new JPanel();
        gbc = new GridBagConstraints();
    }

    @Test
    public void testImageLoading() {
        // Load the image files
        InputStream backgroundInputStream = Screen.class.getResourceAsStream("youlose.png");
        InputStream startInputStream = Screen.class.getResourceAsStream("restart.png");
        InputStream exitInputStream = Screen.class.getResourceAsStream("exit.png");
        BufferedImage backgroundImage = null;
        BufferedImage startImage = null;
        BufferedImage exitImage = null;
        try {
            backgroundImage = ImageIO.read(backgroundInputStream);
            startImage = ImageIO.read(startInputStream);
            exitImage = ImageIO.read(exitInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test that the images are not null
        assertNotNull(backgroundImage);
        assertNotNull(startImage);
        assertNotNull(exitImage);

        //Test that the image paths match
        assertEquals("youlose.png", imagePaths.getBackgroundPath());
        assertEquals("restart.png", imagePaths.getButton1Path());
        assertEquals("exit.png", imagePaths.getButton2Path());
    }

    @Test
    public void testConstructor() {
        Screen screen = new Screen(topListener, bottomListener, imagePaths, dimensions);
        assertEquals(foodtruckfrenzy.SecondaryUI.Screen.class, screen.getClass());
        assertEquals(GridBagLayout.class, screen.getLayout().getClass());
        assertEquals(1, screen.getComponentCount());
        assertEquals(JLabel.class, screen.getComponent(0).getClass());
        JLabel backgroundLabel = (JLabel) screen.getComponent(0);
        assertEquals(ImageIcon.class, backgroundLabel.getIcon().getClass());
        assertEquals(GridBagLayout.class, backgroundLabel.getLayout().getClass());
        JPanel buttonPanel = (JPanel) backgroundLabel.getComponent(0);
        assertEquals(GridBagLayout.class, buttonPanel.getLayout().getClass());
        assertEquals(2, buttonPanel.getComponentCount());
        assertEquals(JButton.class, buttonPanel.getComponent(0).getClass());
        assertEquals(JButton.class, buttonPanel.getComponent(1).getClass());
        JButton topButton = (JButton) buttonPanel.getComponent(0);
        JButton bottomButton = (JButton) buttonPanel.getComponent(1);
        assertEquals(ImageIcon.class, topButton.getIcon().getClass());
        assertEquals(ImageIcon.class, bottomButton.getIcon().getClass());
    }

    @Test
    public void testCreateBackground() {
        Screen screen = new Screen(topListener, bottomListener, imagePaths, dimensions);
        JLabel backgroundLabel = (JLabel) screen.getComponent(0);
        ImageIcon backgroundIcon = (ImageIcon) backgroundLabel.getIcon();
        assertNotNull(backgroundIcon);

        // Check if the background image has the correct dimensions
        assertEquals(dimensions.getWidth(), backgroundIcon.getIconWidth());
        assertEquals(dimensions.getHeight(), backgroundIcon.getIconHeight());

        screen.createBackground(backgroundLabel, gbc, buttonPanel);

        // Test that backgroundLabel has the correct layout
        assertTrue(backgroundLabel.getLayout() instanceof GridBagLayout);

        // Test that buttonPanel was added to backgroundLabel
        assertEquals(buttonPanel, backgroundLabel.getComponent(1));
    }

    @Test
    public void testCreateButtons() {
        // create a button panel to test
        JPanel buttonPanel = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        ActionListener topListener = mock(ActionListener.class);
        ActionListener bottomListener = mock(ActionListener.class);

        // call the method being tested
        Screen screen = new Screen(topListener, bottomListener, imagePaths, dimensions);
        screen.createButtons(buttonPanel, gbc, topListener, bottomListener);

        // verify that the button panel has the expected components
        assertEquals(2, buttonPanel.getComponentCount());
        assertTrue(buttonPanel.getComponent(0) instanceof JButton);
        assertTrue(buttonPanel.getComponent(1) instanceof JButton);
        JButton topButton = (JButton) buttonPanel.getComponent(0);
        JButton bottomButton = (JButton) buttonPanel.getComponent(1);
        assertEquals(ImageIcon.class, topButton.getIcon().getClass());
        assertEquals(ImageIcon.class, bottomButton.getIcon().getClass());
        assertEquals(topListener, topButton.getActionListeners()[0]);
        assertEquals(bottomListener, bottomButton.getActionListeners()[0]);
    }

    //Test that the resize function works
    @Test
    public void testResize() {
        // Create a test image with dimensions 100x100
        BufferedImage testImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

        // Resize the image to dimensions 50x50
        BufferedImage resizedImage = screen.resize(testImage, 50, 50);

        // Check if the dimensions of the resized image match the specified dimensions
        assertEquals(50, resizedImage.getWidth());
        assertEquals(50, resizedImage.getHeight());
    }
}

