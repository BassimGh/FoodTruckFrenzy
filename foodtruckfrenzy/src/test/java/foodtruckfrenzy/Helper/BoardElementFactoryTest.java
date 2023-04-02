package foodtruckfrenzy.Helper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.BoardElement.BoardElement;
import foodtruckfrenzy.Drawable.BoardElement.Road;

public class BoardElementFactoryTest {
    BoardElementFactory boardElementFactory;

    @BeforeEach                                         
    void setUp() {
        boardElementFactory = new BoardElementFactory();
    }

    @Test                                                
    void testHorizontalRoad() {
        BoardElement road = boardElementFactory.create(LayoutEnum.H, 0,0);
        assertTrue(road instanceof Road);
        assertEquals(0, road.getRow());
        assertEquals(0, road.getCol());
    }

}
