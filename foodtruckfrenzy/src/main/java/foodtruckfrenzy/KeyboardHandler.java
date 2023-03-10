package foodtruckfrenzy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {

    private boolean _upPressed = false;
    private boolean _downPressed = false;
    private boolean _rightPressed = false;
    private boolean _leftPressed = false;

    public boolean upPressed() {
        return _upPressed;
    }

    public boolean downPressed() {
        return _downPressed;
    }

    public boolean rightPressed() {
        return _rightPressed;
    }

    public boolean leftPressed() {
        return _leftPressed;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                _upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                _downPressed = true;
                break;
            case KeyEvent.VK_LEFT:
                _leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                _rightPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                _upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                _downPressed = false;
                break;
            case KeyEvent.VK_LEFT:
                _leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                _rightPressed = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}