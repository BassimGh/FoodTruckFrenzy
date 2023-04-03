package foodtruckfrenzy.Drawable.Item;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.DrawableEnum;

public class GlitterTest {
    private Glitter glitter;

    @BeforeEach
    void setup() {
        glitter = new Glitter(1, 2);
    }

    @Test
    void testRow() {
        assertEquals(1, glitter.getRow());
    }

    @Test
    void testCol() {
        assertEquals(2, glitter.getCol());
    }

    @Test
    void testValueEqualsZero() {
        assertEquals(0, glitter.getValue());
    }

    @Test
    void testScoreTypeNull() {
        assertEquals(ScoreType.NULL, glitter.getScoreType());
    }

    @Test
    void testDrawableTypePickupGlitter() {
        assertEquals(DrawableEnum.PICKUP_GLITTER, glitter.getDrawableType());
    
    }
}
