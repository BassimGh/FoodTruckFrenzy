package foodtruckfrenzy.Helper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.DrawableEnum;
import foodtruckfrenzy.Drawable.BoardElement.BoardElement;
import foodtruckfrenzy.Drawable.BoardElement.Obstruction;
import foodtruckfrenzy.Drawable.BoardElement.Road;
import foodtruckfrenzy.Drawable.Item.Food;
import foodtruckfrenzy.Drawable.Item.Item;
import foodtruckfrenzy.Drawable.Item.PotHole;
import foodtruckfrenzy.Drawable.Item.Recipe;
import foodtruckfrenzy.Drawable.Item.SpeedTrap;
import foodtruckfrenzy.GameFramework.Grid;

public class BoardElementFactoryTest {
    private BoardElementFactory boardElementFactory;

    @BeforeEach                                         
    void setup() {
        boardElementFactory = new BoardElementFactory();
    }

    @Test                                                
    void testHorizontalRoadCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.H, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.HORIZONTAL_ROAD, road.getDrawableType());

        Road castedRoad = (Road) road;
        assertNull(castedRoad.getItem());
    }

    @Test                                                
    void testVerticalRoadCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.V, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.VERTICAL_ROAD, road.getDrawableType());

        Road castedRoad = (Road) road;
        assertNull(castedRoad.getItem());
    }

    @Test                                                
    void testFourWayCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.X, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.FOUR_WAY, road.getDrawableType());

        Road castedRoad = (Road) road;
        assertNull(castedRoad.getItem());
    }

    @Test                                                
    void testNorthWestCornerCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.U, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.NORTH_WEST_CORNER, road.getDrawableType());

        Road castedRoad = (Road) road;
        assertNull(castedRoad.getItem());
    }

    @Test                                                
    void testNorthEastCornerCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.I, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.NORTH_EAST_CORNER, road.getDrawableType());

        Road castedRoad = (Road) road;
        assertNull(castedRoad.getItem());
    }

    @Test                                                
    void testSouthEastCornerCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.J, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.SOUTH_EAST_CORNER, road.getDrawableType());

        Road castedRoad = (Road) road;
        assertNull(castedRoad.getItem());
    }

    @Test                                                
    void testSouthWestCornerCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.K, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.SOUTH_WEST_CORNER, road.getDrawableType());

        Road castedRoad = (Road) road;
        assertNull(castedRoad.getItem());
    }

    @Test                                                
    void testThreeWayNorthCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.N, 1, 2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.THREE_WAY_NORTH, road.getDrawableType());

        Road castedRoad = (Road) road;
        assertNull(castedRoad.getItem());
    }

    @Test                                                
    void testThreeWayEastCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.B, 1, 2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.THREE_WAY_EAST, road.getDrawableType());

        Road castedRoad = (Road) road;
        assertNull(castedRoad.getItem());
    }

    @Test                                                
    void testThreeWaySouthCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.M, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.THREE_WAY_SOUTH, road.getDrawableType());

        Road castedRoad = (Road) road;
        assertNull(castedRoad.getItem());
    }

    @Test                                                
    void testThreeWayWestCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.C, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.THREE_WAY_WEST, road.getDrawableType());

        Road castedRoad = (Road) road;
        assertNull(castedRoad.getItem());
    }

    @Test
    void testObstruction() {
        BoardElement obstruction = boardElementFactory.create(LayoutEnum.O, 1, 2);
        assertTrue(obstruction instanceof Obstruction);
        assertEquals(1, obstruction.getRow());
        assertEquals(2, obstruction.getCol());
        
    }

    @Test                                                
    void testHorizontalSpeedTrapCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.S, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.HORIZONTAL_ROAD, road.getDrawableType());

        Road castedRoad = (Road) road;
        Item item = castedRoad.getItem();
        assertTrue(item instanceof SpeedTrap);
        assertEquals(1, item.getRow());
        assertEquals(2, item.getCol());
    }

    @Test                                                
    void testHorizontalPotHoleCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.P, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.HORIZONTAL_ROAD, road.getDrawableType());

        Road castedRoad = (Road) road;
        Item item = castedRoad.getItem();
        assertTrue(item instanceof PotHole);
        assertEquals(1, item.getRow());
        assertEquals(2, item.getCol());
    }

    @Test                                                
    void testVerticalPotHoleCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.L, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.VERTICAL_ROAD, road.getDrawableType());

        Road castedRoad = (Road) road;
        Item item = castedRoad.getItem();
        assertTrue(item instanceof PotHole);
        assertEquals(1, item.getRow());
        assertEquals(2, item.getCol());
    }

    @Test                                                
    void testHorizontalFoodCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.F, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.HORIZONTAL_ROAD, road.getDrawableType());

        Road castedRoad = (Road) road;
        Item item = castedRoad.getItem();
        assertTrue(item instanceof Food);
        assertEquals(1, item.getRow());
        assertEquals(2, item.getCol());
    }

    @Test                                                
    void testVerticalFoodCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.R, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.VERTICAL_ROAD, road.getDrawableType());

        Road castedRoad = (Road) road;
        Item item = castedRoad.getItem();
        assertTrue(item instanceof Food);
        assertEquals(1, item.getRow());
        assertEquals(2, item.getCol());
    }

    @Test                                                
    void testHorizontalRecipeCreation() {
        BoardElement road = boardElementFactory.create(LayoutEnum.Q, 1,2);
        assertTrue(road instanceof Road);
        assertEquals(1, road.getRow());
        assertEquals(2, road.getCol());
        assertEquals(DrawableEnum.HORIZONTAL_ROAD, road.getDrawableType());

        Road castedRoad = (Road) road;
        Item item = castedRoad.getItem();
        assertTrue(item instanceof Recipe);
        assertEquals(1, item.getRow());
        assertEquals(2, item.getCol());
    }

    @Test
    void testIllegalArgumentExceptionTypeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            boardElementFactory.create(null, 1, 2);
        });
    }

    @Test
    void testIllegalArgumentExceptionRowLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            boardElementFactory.create(LayoutEnum.H, -1, 0);
        });
    }

    @Test
    void testIllegalArgumentExceptionColLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            boardElementFactory.create(LayoutEnum.H, 0, -1);
        });
    }

    @Test
    void testIllegalArgumentExceptionRowMoreThanMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            boardElementFactory.create(LayoutEnum.H, Grid.ROWS, 0);
        });
    }

    @Test
    void testIllegalArgumentExceptionColMoreThanMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            boardElementFactory.create(LayoutEnum.H, 0, Grid.COLS);
        });
    }

    @Test
    void testNullReturnTypeForDebuggin() {
        assertNull(boardElementFactory.create(LayoutEnum.NULL, 0, 0));
    }


}
