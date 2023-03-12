package foodtruckfrenzy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

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
    private static Image _speedTrapImage;
    private static Image _potHoleImage;
    private static Image _foodImage;

    private static ArrayList<Image> _houseImages = new ArrayList<Image>();

    private static Random random = new Random();
    
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
            InputStream speedTrapStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/speedtrap.png");
            InputStream potHoleStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/pothole.png");
            InputStream foodStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/food.png");

            InputStream house1Stream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house1.png");
            InputStream house2Stream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house2.png");
            InputStream house3Stream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house3.png");

            _foodTruckUpImage = ImageIO.read(foodTruckUpStream);
            _foodTruckDownImage = ImageIO.read(foodTruckDownStream);
            _foodTruckLeftImage = ImageIO.read(foodTruckLeftStream);
            _foodTruckRightImage = ImageIO.read(foodTruckRightStream);
            
            _copUpImage = ImageIO.read(copUpStream);
            _copDownImage = ImageIO.read(copDownStream);
            _copLeftImage = ImageIO.read(copLeftStream);
            _copRightImage = ImageIO.read(copRightStream);

            _roadImage = ImageIO.read(roadStream);
            _speedTrapImage = ImageIO.read(speedTrapStream);
            _potHoleImage = ImageIO.read(potHoleStream);
            _foodImage = ImageIO.read(foodStream);

            _houseImages.add(ImageIO.read(house1Stream));
            _houseImages.add(ImageIO.read(house2Stream));
            _houseImages.add(ImageIO.read(house3Stream));


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
                int randomNumber = random.nextInt(3);
                return _houseImages.get(randomNumber);
            case SPEED_TRAP:
                return _speedTrapImage;
            case POT_HOLE:
                return _potHoleImage;
            case FOOD:
                return _foodImage;
            default:
                throw new IllegalArgumentException();
        }
    }
}
