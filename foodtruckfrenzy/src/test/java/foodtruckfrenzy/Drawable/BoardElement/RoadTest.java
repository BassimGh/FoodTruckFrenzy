package foodtruckfrenzy.Drawable.BoardElement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.Item.Food;
import foodtruckfrenzy.Drawable.Item.PotHole;
import foodtruckfrenzy.Drawable.Item.ScoreValue;

public class RoadTest {

    @Test
    void testNullItem() {
        BoardElement road = new Road(1,2,null,null);
        assertNull(road.interact());
    }

    @Test
    void testNegativeItem() {
        BoardElement road = new Road(1,2, new PotHole(1,2), null);
        ScoreValue ret = road.interact();
        assertNotNull(ret);
        assertTrue(ret.getValue() < 0);
        assertNotNull(road.interact());
    }

    @Test
    void testPositiveItem() {
        BoardElement road = new Road(1,2, new Food(1,2), null);
        ScoreValue ret = road.interact();
        assertNotNull(ret);
        assertTrue(ret.getValue() > 0);
        assertNull(road.interact());
    }
}
