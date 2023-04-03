package foodtruckfrenzy.SecondaryUI;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DimensionsTest {
    private Dimensions dimensions;

    @BeforeEach
    public void setup() {
        dimensions = new Dimensions(10,15);
    }

    @Test
    public void testGetHeight() {
        int actualHeight = dimensions.getHeight();
        int expectedHeight = 15;
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    public void testGetWidth() {
        int actualWidth = dimensions.getWidth();
        int expectedWidth = 10;
        assertEquals(expectedWidth, actualWidth);
    }

    @Test
    public void testDimensions() {
        Dimensions dim = new Dimensions(2,3);
        assertNotNull(dim);
    }
}
