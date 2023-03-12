package foodtruckfrenzy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class SpriteLoader {

    private static Image _foodTruckImage;
    private static Image _foodTruckUpImage;
    private static Image _foodTruckDownImage;
    private static Image _foodTruckLeftImage;
    private static Image _foodTruckRightImage;
    private static Image _roadImage;
    private static Image _obstructionImage;

    static {

        InputStream foodTruckStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruck.png");
        InputStream foodTruckUpStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckUp.png");
        InputStream foodTruckDownStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckDown.png");
        InputStream foodTruckLeftStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckLeft.png");
        InputStream foodTruckRightStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckRight.png");
        InputStream roadStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/road.png");
        InputStream obstructionStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house.png");

        try {
            _foodTruckImage = ImageIO.read(foodTruckStream);
            _foodTruckUpImage = ImageIO.read(foodTruckUpStream);
            _foodTruckDownImage = ImageIO.read(foodTruckDownStream);
            _foodTruckLeftImage = ImageIO.read(foodTruckLeftStream);
            _foodTruckRightImage = ImageIO.read(foodTruckRightStream);
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
            case FOODTRUCK_UP:
                return _foodTruckUpImage;
            case FOODTRUCK_DOWN:
                return _foodTruckDownImage;
            case FOODTRUCK_LEFT:
                return _foodTruckLeftImage;
            case FOODTRUCK_RIGHT:
                return _foodTruckRightImage;
            case ROAD:
                return _roadImage;
            case OBSTRUCTION:
                return _obstructionImage;
            default:
                throw new IllegalArgumentException();
        }
    }
}
