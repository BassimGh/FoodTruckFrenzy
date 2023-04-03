package foodtruckfrenzy.Drawable.Item;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.DrawableEnum;

public class RecipeTest {
    private Recipe recipe;

    @BeforeEach
    void setup() {
        recipe = new Recipe(1, 2);
    }

    @Test
    void testRow() {
        assertEquals(1, recipe.getRow());
    }

    @Test
    void testCol() {
        assertEquals(2, recipe.getCol());
    }

    @Test
    void testValueGreaterThanZero() {
        assertTrue(recipe.getValue() > 0);
    }

    @Test
    void testScoreTypeBonus() {
        assertEquals(ScoreType.BONUS, recipe.getScoreType());
    }

    @Test
    void testDrawableTypeRecipe() {
        assertEquals(DrawableEnum.RECIPE, recipe.getDrawableType());
    }
}
