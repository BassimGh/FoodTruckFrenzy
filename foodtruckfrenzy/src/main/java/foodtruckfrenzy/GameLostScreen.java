package foodtruckfrenzy;

import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class GameLostScreen extends Screen {

    public GameLostScreen(ActionListener startListener, ActionListener exitListener, int ingredientsFound, int recipesFound, int damage, int fines, int score) {
        super(startListener, exitListener, "youlose.png", "restart.png", "exit.png");

        // create JLabels to display the integer values
        JLabel ingredientsFoundLabel = new JLabel("Ingredients found: " + Integer.toString(ingredientsFound));
        JLabel recipesFoundLabel = new JLabel("Recipes found: " + Integer.toString(recipesFound));
        JLabel damageLabel = new JLabel("Damage taken: " + Integer.toString(damage));
        JLabel finesLabel = new JLabel("Fines received: $" + Integer.toString(fines));
        JLabel scoreLabel = new JLabel("Total score: " + Integer.toString(score));

        // set font for the labels
        Font font = new Font("Arial", Font.BOLD, 16);
        ingredientsFoundLabel.setFont(font);
        recipesFoundLabel.setFont(font);
        damageLabel.setFont(font);
        finesLabel.setFont(font);
        scoreLabel.setFont(font);

        // add the labels to the panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0); // add some spacing between the buttons and labels
        gbc.anchor = GridBagConstraints.CENTER;
        add(ingredientsFoundLabel, gbc);
        
        gbc.gridy++;
        add(recipesFoundLabel, gbc);
        
        gbc.gridy++;
        add(damageLabel, gbc);
        
        gbc.gridy++;
        add(finesLabel, gbc);
        
        gbc.gridy++;
        add(scoreLabel, gbc);
    }
}