package foodtruckfrenzy.SecondaryUI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class DimensionsTest {
    private Dimensions dimensions;

    @Before
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
    public void testConstructor() {
        Dimensions dim = new Dimensions(2,3);
        assertNotNull(dim);
    }
}
