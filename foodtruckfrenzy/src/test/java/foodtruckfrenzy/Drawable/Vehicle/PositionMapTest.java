package foodtruckfrenzy.Drawable.Vehicle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PositionMapTest {
    PositionMap positionMap = new PositionMap();
    
    @Test
    void testPositionMap() {
        assertFalse(positionMap.contains(null));
        Position pos1 = new Position(0, 0, null);
        Position pos2 = new Position(1, 0, pos1);
        
        assertFalse(positionMap.contains(pos1));
        positionMap.put(pos1);
        assertTrue(positionMap.contains(pos1));

        assertFalse(positionMap.contains(pos2));
        positionMap.put(pos2);
        assertTrue(positionMap.contains(pos1));

        assertFalse(positionMap.contains(new Position(0, 1, null)));
        assertFalse(positionMap.contains(new Position(1, 1, null)));
        assertTrue(positionMap.contains(new Position(1, 0, pos1)));
        assertTrue(positionMap.contains(new Position(1, 0, null)));
        assertTrue(positionMap.contains(new Position(0, 0, null)));
    }
    
}
