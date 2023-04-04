package foodtruckfrenzy.Drawable.Vehicle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PositionTest {
    
    @Test
    public void testConstructor() {
        Position p1 = new Position(1, 2, null);
        assertEquals(1, p1.row);
        assertEquals(2, p1.col);
        assertEquals(null, p1.prev);

        Position p2 = new Position(3, 4, p1);
        assertEquals(3, p2.row);
        assertEquals(4, p2.col);
        assertEquals(p1, p2.prev);
    }
    
    @Test
    public void testGenerateKey() {
        Position p1 = new Position(1, 2, null);
        assertEquals("1_2", p1.generateKey());

        Position p2 = new Position(3, 4, p1);
        assertEquals("3_4", p2.generateKey());

        Position p3 = new Position(1, 2, null);
        assertEquals("1_2", p3.generateKey());
    }
    
}
