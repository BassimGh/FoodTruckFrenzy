package foodtruckfrenzy.Helper;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyboardHandler class is responsible for listening to the keyboard input
 * This class keeps track of whether the up/W down/S left/A right/D are pressed down by the user
 */
public class KeyboardHandler implements KeyListener {

    /**
     * Boolean state of whether up is pressed or not.
     */
    private boolean _upPressed;

    /**
     * Boolean state of whether down is pressed or not.
     */
    private boolean _downPressed;

    /**
     * Boolean state of whether right is pressed or not.
     */
    private boolean _rightPressed;

    /**
     * Boolean state of whether left is pressed or not.
     */
    private boolean _leftPressed;

    /**
     * Boolean state of whether pause is pressed or not.
     */
    private boolean _pause;

    /**
     * Constructor to create a new KeyboardHandler object.
     * Takes in no parameters and sets all the button states to false.
     */
    public KeyboardHandler() {
        _upPressed = false;
        _downPressed = false;
        _rightPressed = false;
        _leftPressed = false;
        _pause = false;
    }

    /**
     * Returns whether up/W is pressed
     * @return true if up/W is pressed, false if not
     */
    public boolean upPressed() {
        return _upPressed;
    }

    /**
     * Returns whether down/S is pressed
     * @return true if down/S is pressed, false if not
     */
    public boolean downPressed() {
        return _downPressed;
    }

    /**
     * Returns whether right/D is pressed
     * @return true if right/D is pressed, false if not
     */
    public boolean rightPressed() {
        return _rightPressed;
    }

    /**
     * Returns whether left/A is pressed
     * @return true if left/A is pressed, false if not
     */
    public boolean leftPressed() {
        return _leftPressed;
    }

    /**
     * Returns whether p is pressed
     * @return true if p is pressed, false if not
     */
    public boolean pausePressed() {
        return _pause;
    }

    /**
     * Method invoked when a key is pressed
     * This updates the corresponding boolean values to true based on what keys are pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                _upPressed = true;
                break;
            case KeyEvent.VK_S:
                _downPressed = true;
                break;
            case KeyEvent.VK_A:
                _leftPressed = true;
                break;
            case KeyEvent.VK_D:
                _rightPressed = true;
                break;
            case KeyEvent.VK_P:
                _pause = true;
                break;
        }
    }

    /**
     * Method invoked when a key is released
     * This updates the corresponding boolean values to false based on what keys are released
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                _upPressed = false;
                break;
            case KeyEvent.VK_S:
                _downPressed = false;
                break;
            case KeyEvent.VK_A:
                _leftPressed = false;
                break;
            case KeyEvent.VK_D:
                _rightPressed = false;
                break;
            case KeyEvent.VK_P:
                _pause = false;
                break;
        }
    }

    /**
     * This method is not needed for this implementation but is required to be overriden
     */
    @Override
    public void keyTyped(KeyEvent e) {}
}