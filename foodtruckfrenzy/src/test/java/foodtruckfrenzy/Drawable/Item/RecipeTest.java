package foodtruckfrenzy.Drawable.Item;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class RecipeTest {
    @BeforeEach
    void setup() {
        new Recipe(0, 0);
    }

    @Test
    void testGetCount() {
        assertTrue(Recipe.getCount() > 0);
    }
    @Test
    void testResetCount() {
        Recipe.resetCount();
        assertEquals(0, Recipe.getCount());
    }
}
