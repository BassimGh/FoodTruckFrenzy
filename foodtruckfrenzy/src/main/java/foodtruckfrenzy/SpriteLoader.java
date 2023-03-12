package foodtruckfrenzy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

public class SpriteLoader {

    private static ArrayList<Image> _houseImages = new ArrayList<Image>();
    private static HashMap<DrawableEnum, Image> _imagesHashMap = new HashMap<>();

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
            
            InputStream speedTrapStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/speedtrap.png");
            InputStream potHoleStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/pothole.png");
            InputStream foodStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/food.png");

            InputStream house1Stream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house1.png");
            InputStream house2Stream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house2.png");
            InputStream house3Stream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house3.png");

            InputStream roadHorizontalStream = SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadHorizontal.png");


            _imagesHashMap.put(DrawableEnum.FOODTRUCK_UP, ImageIO.read(foodTruckUpStream));
            _imagesHashMap.put(DrawableEnum.FOODTRUCK_DOWN, ImageIO.read(foodTruckDownStream));
            _imagesHashMap.put(DrawableEnum.FOODTRUCK_RIGHT, ImageIO.read(foodTruckRightStream));
            _imagesHashMap.put(DrawableEnum.FOODTRUCK_LEFT, ImageIO.read(foodTruckLeftStream));
            
            _imagesHashMap.put(DrawableEnum.COP_UP, ImageIO.read(copUpStream));
            _imagesHashMap.put(DrawableEnum.COP_DOWN, ImageIO.read(copDownStream));
            _imagesHashMap.put(DrawableEnum.COP_RIGHT, ImageIO.read(copRightStream));
            _imagesHashMap.put(DrawableEnum.COP_LEFT, ImageIO.read(copLeftStream));

            _imagesHashMap.put(DrawableEnum.SPEED_TRAP, ImageIO.read(speedTrapStream));
            _imagesHashMap.put(DrawableEnum.POT_HOLE, ImageIO.read(potHoleStream));
            _imagesHashMap.put(DrawableEnum.FOOD, ImageIO.read(foodStream));

            _imagesHashMap.put(DrawableEnum.HORIZONTAL_ROAD, ImageIO.read(roadHorizontalStream));

            _houseImages.add(ImageIO.read(house1Stream));
            _houseImages.add(ImageIO.read(house2Stream));
            _houseImages.add(ImageIO.read(house3Stream));


        } catch (Exception e) {
            System.err.println("Error when loading sprite files with SpriteLoader:");
            e.printStackTrace();
        }  
    }

    public static Image getImage(DrawableEnum type) {

        if (type == DrawableEnum.OBSTRUCTION) {
            int randomNumber = random.nextInt(3);
            return _houseImages.get(randomNumber);
        }
    
        return _imagesHashMap.get(type);
    }
}
