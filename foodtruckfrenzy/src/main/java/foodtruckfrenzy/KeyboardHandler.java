package foodtruckfrenzy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {

    private boolean _upPressed = false;
    private boolean _downPressed = false;
    private boolean _rightPressed = false;
    private boolean _leftPressed = false;
    private boolean _pause = false;

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

    public boolean pause() {
        return _pause;
    }

    public void resetKeys() {
        _upPressed = false;
        _downPressed = false;
        _rightPressed = false;
        _leftPressed = false;
        _pause = false;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                _upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                _downPressed = true;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                _leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                _rightPressed = true;
                break;
            case KeyEvent.VK_P:
                _pause = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                _upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                _downPressed = false;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                _leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                _rightPressed = false;
                break;
            case KeyEvent.VK_P:
                _pause = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}