package foodtruckfrenzy.Helper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import java.awt.event.KeyEvent;

class KeyboardHandlerTest {

    private KeyboardHandler keyboardHandler;

    @BeforeEach
    void setup() {
        keyboardHandler = new KeyboardHandler();
    }

    @Test
    void testInitialKeysNotPressed() {
        assertFalse(keyboardHandler.upPressed());
        assertFalse(keyboardHandler.downPressed());
        assertFalse(keyboardHandler.leftPressed());
        assertFalse(keyboardHandler.rightPressed());
        assertFalse(keyboardHandler.pausePressed());
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

    @Test
    void testPausePressedAndReleased() {
        KeyEvent mockedKey = Mockito.mock(KeyEvent.class);
        Mockito.when(mockedKey.getKeyCode()).thenReturn(KeyEvent.VK_P);
        keyboardHandler.keyPressed(mockedKey);
        assertTrue(keyboardHandler.pausePressed());
        keyboardHandler.keyReleased(mockedKey);
        assertFalse(keyboardHandler.pausePressed());
    }

}
