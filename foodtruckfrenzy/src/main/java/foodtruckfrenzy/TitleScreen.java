package foodtruckfrenzy;

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

public class TitleScreen extends JPanel {
    private BufferedImage backgroundImage;
    private BufferedImage startImage;
    private BufferedImage exitImage;
    private JButton startButton;
    private JButton exitButton;

    public TitleScreen(ActionListener startListener, ActionListener exitListener) {
        try {
            InputStream backgroundInputStream = TitleScreen.class.getResourceAsStream("/foodtruckfrenzy/background.png");
            InputStream startInputStream = TitleScreen.class.getResourceAsStream("/foodtruckfrenzy/start.png");
            InputStream exitInputStream = TitleScreen.class.getResourceAsStream("/foodtruckfrenzy/exit.png");

            backgroundImage = ImageIO.read(backgroundInputStream);
            backgroundImage = resize(backgroundImage, 800, 600);
            startImage = ImageIO.read(startInputStream);
            exitImage = ImageIO.read(exitInputStream);

        } catch (IOException e) {
            System.err.println("Error loading image");
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

        startButton = new JButton(new ImageIcon(startImage));
        startButton.addActionListener(startListener);
        startButton.setPreferredSize(new Dimension(100, 50));
        startButton.setBorder(null); // remove the button border
        startButton.setFocusPainted(false); // remove the focus paint
        startButton.setContentAreaFilled(false); // make the content area painted directly on top of the button background
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setBorder(new LineBorder(Color.BLUE, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setBorder(null);
            }
        });
        buttonPanel.add(startButton, gbc);

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

        
        startButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setPreferredSize(new Dimension(100, 50));

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
