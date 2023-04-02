package foodtruckfrenzy.Helper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.GameFramework.Grid;

public class MapLayoutTest {
    
    @Test
    void testMapLayoutObjectCreation() {
        MapLayout mapLayout = new MapLayout();
        assertNotNull(mapLayout, "Failed to initialize MapLayout");
    }

    @Test
    void testGetElementAtEachNotNull() {
        MapLayout mapLayout = new MapLayout();
        for (int row = 0; row < Grid.ROWS; row++) {
            for (int col = 0; col < Grid.COLS; col++) {
                LayoutEnum element = mapLayout.getElementAt(row, col);
                assertNotNull(element, "Element at row " + row + ", col " + col + " is null");
            }
        }
    }
}
