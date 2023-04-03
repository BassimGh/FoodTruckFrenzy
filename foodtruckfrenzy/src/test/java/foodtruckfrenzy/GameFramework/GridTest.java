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

        BoardElement result = grid.getCell(0, 0);
        assertEquals(mockElement, result);
    }

    @Test
    public void testIsObstructionTrue() {
        BoardElementFactory boardElementFactory = Mockito.mock(BoardElementFactory.class);
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        BoardElement mockElement = Mockito.mock(Obstruction.class);
        Mockito.when(boardElementFactory.create(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockElement);
        Grid grid = new Grid(boardElementFactory, mapLayout);

        assertTrue(grid.isObstruction(0, 0));
    }

    @Test
    public void testIsObstructionFalse() {
        BoardElementFactory boardElementFactory = Mockito.mock(BoardElementFactory.class);
        MapLayout mapLayout = Mockito.mock(MapLayout.class);
        BoardElement mockElement = Mockito.mock(Road.class);
        Mockito.when(boardElementFactory.create(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockElement);
        Grid grid = new Grid(boardElementFactory, mapLayout);

        assertFalse(grid.isObstruction(0, 0));
    }

}

