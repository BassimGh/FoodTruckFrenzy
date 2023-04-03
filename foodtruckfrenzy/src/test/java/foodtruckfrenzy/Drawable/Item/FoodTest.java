package foodtruckfrenzy.Drawable.Item;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class FoodTest {
    @BeforeEach
    void setup() {
        new Food(0, 0);
    }

    @Test
    void testGetCount() {
        assertTrue(0 < Food.getCount());
    }
    
    @Test
    void testResetCount() {
        Food.resetCount();
        assertEquals(0, Food.getCount());
    }
}