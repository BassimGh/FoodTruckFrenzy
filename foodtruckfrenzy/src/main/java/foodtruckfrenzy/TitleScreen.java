package foodtruckfrenzy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class TitleScreen extends JPanel {

    private JButton startButton;
    private JButton exitButton;

    public TitleScreen(ActionListener startListener, ActionListener exitListener) {
        setBackground(Color.BLUE);

        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(new EmptyBorder(50, 0, 50, 0)); // add some spacing

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0); // add some spacing between the buttons

        startButton = new JButton("Start");
        startButton.addActionListener(startListener);
        buttonPanel.add(startButton, gbc);

        gbc.gridy++;
        exitButton = new JButton("Exit");
        exitButton.addActionListener(exitListener);
        buttonPanel.add(exitButton, gbc);

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}
