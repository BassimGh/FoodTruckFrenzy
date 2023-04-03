package foodtruckfrenzy.Drawable.BoardElement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.DrawableEnum;

public class ObstructionTest {
    
    private BoardElement obstruction;

    @BeforeEach
    void setup() {
        obstruction = new Obstruction(1,2);
    }

    @Test
    void testRow() {
        assertEquals(1, obstruction.getRow());
    }

    @Test
    void testCol() {
        assertEquals(2, obstruction.getCol());
    }

    @Test
    void testType() {
        assertEquals(DrawableEnum.OBSTRUCTION, obstruction.getType());
    }

    @Test
    void testInteractThrows() {
        assertThrows(UnsupportedOperationException.class, () -> {
            obstruction.interact();
        });
    }
}
