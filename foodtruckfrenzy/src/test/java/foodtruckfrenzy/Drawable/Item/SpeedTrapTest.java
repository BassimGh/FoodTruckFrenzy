package foodtruckfrenzy.Drawable.Item;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.DrawableEnum;

public class SpeedTrapTest {
    private SpeedTrap speedtrap;

    @BeforeEach
    void setup() {
        speedtrap = new SpeedTrap(1, 2);
    }

    @Test
    void testRow() {
        assertEquals(1, speedtrap.getRow());
    }

    @Test
    void testCol() {
        assertEquals(2, speedtrap.getCol());
    }

    @Test
    void testValueLessThanZero() {
        assertTrue(speedtrap.getValue() < 0);
    }

    @Test
    void testScoreTypeSpeed() {
        assertEquals(ScoreType.SPEED, speedtrap.getScoreType());
    }

    @Test
    void testDrawableTypeSpeedTrap() {
        assertEquals(DrawableEnum.SPEED_TRAP, speedtrap.getDrawableType());
    }
}
