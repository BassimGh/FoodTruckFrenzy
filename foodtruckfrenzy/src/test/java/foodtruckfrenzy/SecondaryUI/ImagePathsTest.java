package foodtruckfrenzy.SecondaryUI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class ImagePathsTest {
    private ImagePaths imagePaths;

    @Before
    public void setup() {
        imagePaths = new ImagePaths("backgroundPath", "button1path", "button2path");
    }

    @Test
    public void testGetBackgroundPath() {
        String actualPath = imagePaths.getBackgroundPath();
        String expectedPath = "backgroundPath";
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetButton1Path() {
        String actualPath = imagePaths.getButton1Path();
        String expectedPath = "button1path";
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetButton2Path() {
        String actualPath = imagePaths.getButton2Path();
        String expectedPath = "button2path";
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testConstructor() {
        ImagePaths paths = new ImagePaths("background.png", "button1.png", "button2.png");
        assertNotNull(paths);
    }
}
