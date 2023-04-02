package foodtruckfrenzy.Sprite;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.*;

import foodtruckfrenzy.Drawable.DrawableEnum;

public class SpriteLoaderTest {
    
    @Test
    void testAllDrawableEnumImageGetters() {
        for (DrawableEnum type : DrawableEnum.values()) {
            ImageIcon image = SpriteLoader.getImage(type);
            assertNotNull(image, "Failed to load image for DrawableEnum: " + type);
        }
    }
}
