package foodtruckfrenzy.GameFramework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import foodtruckfrenzy.Drawable.BoardElement.BoardElement;
import foodtruckfrenzy.Drawable.BoardElement.Obstruction;
import foodtruckfrenzy.Drawable.BoardElement.Road;
import foodtruckfrenzy.Helper.BoardElementFactory;
import foodtruckfrenzy.Helper.MapLayout;

class GridTest {

    @Test
    public void testGetCell() {
        BoardElementFactory boardElementFactory = Mockito.mock(BoardElementFactory.class);
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
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
        BoardElementFactory boardElementFactory = Mockito.mock(BoardElementFactory.class);
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        BoardElement mockElement = Mockito.mock(Obstruction.class);
        Mockito.when(boardElementFactory.create(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockElement);
        Grid grid = new Grid(boardElementFactory, mapLayout);

        for (int i = 0; i<Grid.ROWS; i++) {
            for (int j = 0; j<Grid.COLS; j++) {
                assertTrue(grid.isObstruction(i, j));
            }
        }
    }

    @Test
    public void testIsObstructionFalse() {
        BoardElementFactory boardElementFactory = Mockito.mock(BoardElementFactory.class);
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        BoardElement mockElement = Mockito.mock(Road.class);
        Mockito.when(boardElementFactory.create(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockElement);
        Grid grid = new Grid(boardElementFactory, mapLayout);

        for (int i = 0; i<Grid.ROWS; i++) {
            for (int j = 0; j<Grid.COLS; j++) {
                assertFalse(grid.isObstruction(i, j));
            }
        }
    }

    @Test
    public void testIngredientsDiscoverableZero() {
        BoardElementFactory boardElementFactory = Mockito.mock(BoardElementFactory.class);
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        BoardElement mockElement = Mockito.mock(Road.class);
        Mockito.when(boardElementFactory.create(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockElement);
        Grid grid = new Grid(boardElementFactory, mapLayout);

        assertEquals(0, grid.getIngredientsDiscoverable());
    }

    @Test
    public void testRecipesDiscoverableZero() {
        BoardElementFactory boardElementFactory = Mockito.mock(BoardElementFactory.class);
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        BoardElement mockElement = Mockito.mock(Road.class);
        Mockito.when(boardElementFactory.create(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockElement);
        Grid grid = new Grid(boardElementFactory, mapLayout);

        assertEquals(0, grid.getRecipesDiscoverable());
    }

}

