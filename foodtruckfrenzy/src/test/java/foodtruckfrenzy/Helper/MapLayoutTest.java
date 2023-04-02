package foodtruckfrenzy.Helper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import foodtruckfrenzy.GameFramework.Grid;

public class MapLayoutTest {
    
    private MapLayout mapLayout;

    @BeforeEach
    void setUp() {
        mapLayout = new MapLayout();
    }

    @Test
    void testGetElementAtEachNotNull() {
        for (int row = 0; row < Grid.ROWS; row++) {
            for (int col = 0; col < Grid.COLS; col++) {
                LayoutEnum element = mapLayout.getElementAt(row, col);
                assertNotNull(element, "Element at row " + row + ", col " + col + " is null");
            }
        }
    }
}
