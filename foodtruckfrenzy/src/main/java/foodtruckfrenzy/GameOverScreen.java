package foodtruckfrenzy;

import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GameOverScreen extends Screen {
    public GameOverScreen(ActionListener startListener, ActionListener exitListener, String bgImagePath, String restartImagePath, String exitImagePath, Scoreboard scoreboard) {
        super(startListener, exitListener, bgImagePath, restartImagePath, exitImagePath);
  
        int ingredientsFound = scoreboard.getDamage();
        int recipesFound = scoreboard.getDamage();
        int damage = scoreboard.getDamage();
        int fines = scoreboard.getFines();
        int score = scoreboard.getScore();
        String time = scoreboard.getTime();


        // create JLabels to display the integer values
        JLabel scoresLabel1 = new JLabel("FOUND: " + Integer.toString(ingredientsFound) + " Ingredients & " + Integer.toString(recipesFound) + " Recipes " + "   TIME: " + time + "  " + "  DAMAGE: " + Integer.toString(damage) + "   FINES: " + Integer.toString(fines)  + "   SCORE: " + Integer.toString(score));

        // set font for the labels
        Font font = new Font("Arial", Font.BOLD, 16);
        scoresLabel1.setFont(font);
        

        // set the opaque property to false
        scoresLabel1.setOpaque(false);


        // add the labels to the panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0); // add some spacing between the buttons and labels
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy++;
        add(scoresLabel1, gbc);
        
    }
}
