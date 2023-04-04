package foodtruckfrenzy.GameFramework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import foodtruckfrenzy.Drawable.BoardElement.BoardElement;
import foodtruckfrenzy.Helper.BoardElementFactory;
import foodtruckfrenzy.Helper.LayoutEnum;
import foodtruckfrenzy.Helper.MapLayout;

class GridTest {

    @Test
    public void testGetCell() {
        BoardElementFactory boardElementFactory = Mockito.mock(BoardElementFactory.class);
        MapLayout mapLayout = new MapLayout();
        BoardElement mockElement = Mockito.mock(BoardElement.class);
        Mockito.when(boardElementFactory.create(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockElement);
        Grid grid = new Grid(boardElementFactory, mapLayout);

        for (int i = 0; i<Grid.ROWS; i++) {
            for (int j = 0; j<Grid.COLS; j++) {
                assertEquals(mockElement, grid.getCell(i, j));
            }
        }
    }

    @Test
    public void testIsObstructionTrue() {
        BoardElementFactory boardElementFactory = new BoardElementFactory();
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        Mockito.when(mapLayout.getElementAt(Mockito.anyInt(), Mockito.anyInt())).thenReturn(LayoutEnum.O);
        Grid grid = new Grid(boardElementFactory, mapLayout);
    
        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLS; j++) {
                assertTrue(grid.isObstruction(i, j));
            }
        }
    }

    @Test
    public void testIsObstructionFalseHorizontal() {
        BoardElementFactory boardElementFactory = new BoardElementFactory();
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        Mockito.when(mapLayout.getElementAt(Mockito.anyInt(), Mockito.anyInt())).thenReturn(LayoutEnum.R);
        Grid grid = new Grid(boardElementFactory, mapLayout);
    
        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLS; j++) {
                assertFalse(grid.isObstruction(i, j));
            }
        }
    }

    @Test
    public void testIsObstructionFalseVertical() {
        BoardElementFactory boardElementFactory = new BoardElementFactory();
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        Mockito.when(mapLayout.getElementAt(Mockito.anyInt(), Mockito.anyInt())).thenReturn(LayoutEnum.V);
        Grid grid = new Grid(boardElementFactory, mapLayout);
    
        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLS; j++) {
                assertFalse(grid.isObstruction(i, j));
            }
        }
    }

    @Test
    public void testIngredientsDiscoverableZero() {
        BoardElementFactory boardElementFactory = new BoardElementFactory();
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        Mockito.when(mapLayout.getElementAt(Mockito.anyInt(), Mockito.anyInt())).thenReturn(LayoutEnum.NULL);
        Grid grid = new Grid(boardElementFactory, mapLayout);

        assertEquals(0, grid.getIngredientsDiscoverable());
    }

    @Test
    public void testIngredientsDiscoverableMax() {
        BoardElementFactory boardElementFactory = new BoardElementFactory();
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        Mockito.when(mapLayout.getElementAt(Mockito.anyInt(), Mockito.anyInt())).thenReturn(LayoutEnum.F);
        Grid grid = new Grid(boardElementFactory, mapLayout);

        assertEquals(Grid.COLS * Grid.ROWS, grid.getIngredientsDiscoverable());
    }

    @Test
    public void testRecipesDiscoverableZero() {
        BoardElementFactory boardElementFactory = new BoardElementFactory();
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        Mockito.when(mapLayout.getElementAt(Mockito.anyInt(), Mockito.anyInt())).thenReturn(LayoutEnum.NULL);
        Grid grid = new Grid(boardElementFactory, mapLayout);

        assertEquals(0, grid.getRecipesDiscoverable());
    }


    @Test
    public void testRecipesDiscoverableMax() {
        BoardElementFactory boardElementFactory = new BoardElementFactory();
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        Mockito.when(mapLayout.getElementAt(Mockito.anyInt(), Mockito.anyInt())).thenReturn(LayoutEnum.Q);
        Grid grid = new Grid(boardElementFactory, mapLayout);

        assertEquals(Grid.COLS * Grid.ROWS, grid.getRecipesDiscoverable());
    }
}

