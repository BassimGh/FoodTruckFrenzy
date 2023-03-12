package foodtruckfrenzy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class SpriteLoader {

    private static Image _foodTruckImage;
    private static Image _roadImage;
    private static Image _obstructionImage;

    static {

        try {
            InputStream foodTruckStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruck.png");
            InputStream roadStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/road.png");
            InputStream obstructionStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house.png");
            
            _foodTruckImage = ImageIO.read(foodTruckStream);
            _roadImage = ImageIO.read(roadStream);
            _obstructionImage = ImageIO.read(obstructionStream);

        } catch (IOException e) {
            e.printStackTrace();
        }  
    }

    public static Image getImage(DrawableEnum type) {

        switch(type) {
            case FOODTRUCK:
                return _foodTruckImage;
            case ROAD:
                return _roadImage;
            case OBSTRUCTION:
                return _obstructionImage;
            default:
                throw new IllegalArgumentException();
        }
    }
}
