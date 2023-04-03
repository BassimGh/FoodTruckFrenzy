package foodtruckfrenzy.Drawable.Item;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.DrawableEnum;

public class FoodTest {
    private Food food;

    @BeforeEach
    void setup() {
        food = new Food(1, 2);
    }

    @Test
    void testRow() {
        assertEquals(1, food.getRow());
    }

    @Test
    void testCol() {
        assertEquals(2, food.getCol());
    }

    @Test
    void testValueGreaterThanZero() {
        assertTrue(food.getValue() > 0);
    }

    @Test
    void testScoreTypeFood() {
        assertEquals(ScoreType.FOOD, food.getScoreType());
    }

    @Test
    void testDrawableTypeFood() {
        assertEquals(DrawableEnum.FOOD, food.getDrawableType());
    }
}
