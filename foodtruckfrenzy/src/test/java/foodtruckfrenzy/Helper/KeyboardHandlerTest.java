package foodtruckfrenzy.Helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class KeyboardHandlerTest {

    private KeyboardHandler keyboardHandler;

    @BeforeEach
    void setUp() {
        keyboardHandler = new KeyboardHandler();
    }

    @Test
    void testInitialKeysNotPressed() {
        assertFalse(keyboardHandler.upPressed());
        assertFalse(keyboardHandler.downPressed());
        assertFalse(keyboardHandler.leftPressed());
        assertFalse(keyboardHandler.rightPressed());
    }

    @Test
    void testUpPressedAndReleased() {
        KeyEvent mockedKey = Mockito.mock(KeyEvent.class);
        Mockito.when(mockedKey.getKeyCode()).thenReturn(KeyEvent.VK_UP);
        keyboardHandler.keyPressed(mockedKey);
        assertTrue(keyboardHandler.upPressed());
        keyboardHandler.keyReleased(mockedKey);
        assertFalse(keyboardHandler.upPressed());
    }

    @Test
    void testDownPressedAndReleased() {
        KeyEvent mockedKey = Mockito.mock(KeyEvent.class);
        Mockito.when(mockedKey.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);
        keyboardHandler.keyPressed(mockedKey);
        assertTrue(keyboardHandler.downPressed());
        keyboardHandler.keyReleased(mockedKey);
        assertFalse(keyboardHandler.downPressed());
    }

    @Test
    void testRightPressedAndReleased() {
        KeyEvent mockedKey = Mockito.mock(KeyEvent.class);
        Mockito.when(mockedKey.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
        keyboardHandler.keyPressed(mockedKey);
        assertTrue(keyboardHandler.rightPressed());
        keyboardHandler.keyReleased(mockedKey);
        assertFalse(keyboardHandler.rightPressed());
    }

    @Test
    void testLeftPressedAndReleased() {
        KeyEvent mockedKey = Mockito.mock(KeyEvent.class);
        Mockito.when(mockedKey.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        keyboardHandler.keyPressed(mockedKey);
        assertTrue(keyboardHandler.leftPressed());
        keyboardHandler.keyReleased(mockedKey);
        assertFalse(keyboardHandler.leftPressed());
    }

}
