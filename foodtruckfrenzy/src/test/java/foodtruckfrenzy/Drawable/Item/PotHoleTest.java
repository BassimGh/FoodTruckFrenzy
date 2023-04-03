package foodtruckfrenzy.Drawable.Item;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.DrawableEnum;

public class PotHoleTest {
    private PotHole pothole;

    @BeforeEach
    void setup() {
        pothole = new PotHole(1, 2);
    }

    @Test
    void testRow() {
        assertEquals(1, pothole.getRow());
    }

    @Test
    void testCol() {
        assertEquals(2, pothole.getCol());
    }

    @Test
    void testValueLessThanZero() {
        assertTrue(pothole.getValue() < 0);
    }

    @Test
    void testScoreTypeDamage() {
        assertEquals(ScoreType.DAMAGE, pothole.getScoreType());
    }

    @Test
    void testDrawableTypePotHole() {
        assertEquals(DrawableEnum.POT_HOLE, pothole.getDrawableType());
    }
}
