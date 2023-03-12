package foodtruckfrenzy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;

public class SpriteLoader {

    private static Image _foodTruckUpImage;
    private static Image _foodTruckDownImage;
    private static Image _foodTruckLeftImage;
    private static Image _foodTruckRightImage;
    private static Image _copUpImage;
    private static Image _copDownImage;
    private static Image _copLeftImage;
    private static Image _copRightImage;
    private static Image _roadImage;
    private static Image _obstructionImage;
    private static Image _speedTrapImage;
    private static Image _potHoleImage;

    static {
            
        try {
            InputStream foodTruckUpStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckUp.png");
            InputStream foodTruckDownStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckDown.png");
            InputStream foodTruckLeftStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckLeft.png");
            InputStream foodTruckRightStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckRight.png");
            
            InputStream copUpStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/copCar.png");
            InputStream copDownStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/copCar.png");
            InputStream copLeftStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/copCar.png");
            InputStream copRightStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/copCar.png");
            
            InputStream roadStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/road.png");
            InputStream obstructionStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house.png");
            InputStream speedTrapStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/speedtrap.png");
            InputStream potHoleStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/pothole.png");

            _foodTruckUpImage = ImageIO.read(foodTruckUpStream);
            _foodTruckDownImage = ImageIO.read(foodTruckDownStream);
            _foodTruckLeftImage = ImageIO.read(foodTruckLeftStream);
            _foodTruckRightImage = ImageIO.read(foodTruckRightStream);
            
            _copUpImage = ImageIO.read(copUpStream);
            _copDownImage = ImageIO.read(copDownStream);
            _copLeftImage = ImageIO.read(copLeftStream);
            _copRightImage = ImageIO.read(copRightStream);

            _roadImage = ImageIO.read(roadStream);
            _obstructionImage = ImageIO.read(obstructionStream);
            _speedTrapImage = ImageIO.read(speedTrapStream);
            _potHoleImage = ImageIO.read(potHoleStream);

        } catch (Exception e) {
            System.err.println("Error when loading sprite files with SpriteLoader:");
            e.printStackTrace();
        }  
    }

    public static Image getImage(DrawableEnum type) {

        switch(type) {
            case FOODTRUCK_UP:
                return _foodTruckUpImage;
            case FOODTRUCK_DOWN:
                return _foodTruckDownImage;
            case FOODTRUCK_LEFT:
                return _foodTruckLeftImage;
            case FOODTRUCK_RIGHT:
                return _foodTruckRightImage;
            case COP_UP:
                return _copUpImage;
            case COP_DOWN:
                return _copDownImage;
            case COP_LEFT:
                return _copLeftImage;
            case COP_RIGHT:
                return _copRightImage;
            case ROAD:
                return _roadImage;
            case OBSTRUCTION:
                return _obstructionImage;
            case SPEED_TRAP:
                return _speedTrapImage;
            case POT_HOLE:
                return _potHoleImage;
            default:
                throw new IllegalArgumentException();
        }
    }
}
