package foodtruckfrenzy;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStream;

public class PauseScreen extends JPanel {
    private BufferedImage backgroundImage;
    private BufferedImage resumeImage;
    private BufferedImage exitImage;
    private JButton resumeButton;
    private JButton exitButton;

    public PauseScreen(ActionListener resumeListener, ActionListener exitListener) {
        try {
            InputStream backgroundInputStream = TitleScreen.class.getResourceAsStream("/foodtruckfrenzy/background.png");
            InputStream resumeInputStream = TitleScreen.class.getResourceAsStream("/foodtruckfrenzy/resume.png");
            InputStream exitInputStream = TitleScreen.class.getResourceAsStream("/foodtruckfrenzy/exit.png");

            backgroundImage = ImageIO.read(backgroundInputStream);
            backgroundImage = resize(backgroundImage, 800, 600); // resize the image to fit the entire PauseScreen window
            resumeImage = ImageIO.read(resumeInputStream);
            exitImage = ImageIO.read(exitInputStream);
        } catch (IOException e) {
            System.err.println("Error loading background image:");
            e.printStackTrace();
        }

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        // create a new JLabel and add an ImageIcon with the background image
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        add(backgroundLabel, gbc);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false); // make the panel transparent
        buttonPanel.setBackground(new Color(0, 0, 0, 0)); // make the panel background transparent

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0); // add some spacing between the buttons
        gbc.anchor = GridBagConstraints.CENTER;

        resumeButton = new JButton(new ImageIcon(resumeImage));
        resumeButton.addActionListener(resumeListener);
        resumeButton.setPreferredSize(new Dimension(100, 50));
        resumeButton.setBorder(null); // remove the button border
        resumeButton.setFocusPainted(false); // remove the focus paint
        resumeButton.setContentAreaFilled(false); // make the content area painted directly on top of the button background
        resumeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                resumeButton.setBorder(new LineBorder(Color.BLUE, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resumeButton.setBorder(null);
            }
        });
        buttonPanel.add(resumeButton, gbc);

        gbc.gridy++;
        exitButton = new JButton(new ImageIcon(exitImage));
        exitButton.addActionListener(exitListener);
        exitButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setBorder(null); // remove the button border
        exitButton.setFocusPainted(false); // remove the focus paint
        exitButton.setContentAreaFilled(false); // make the content area painted directly on top of the button background
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setBorder(new LineBorder(Color.BLUE, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setBorder(null);
            }
        });
        buttonPanel.add(exitButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;

        backgroundLabel.setLayout(new GridBagLayout());
        backgroundLabel.add(buttonPanel, gbc);

        
        resumeButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setPreferredSize(new Dimension(100, 50));
        this.setBackground(Color.BLACK);

        buttonPanel.setVisible(true); // force display the panel

        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    // resize a BufferedImage to the specified width and height
    private static BufferedImage resize(BufferedImage img, int width, int height) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}
