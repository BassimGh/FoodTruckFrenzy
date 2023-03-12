package foodtruckfrenzy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

public class SpriteLoader {

    private static ArrayList<Image> _houseImages = new ArrayList<Image>();
    private static HashMap<DrawableEnum, Image> _imagesHashMap = new HashMap<>();

    private static Random random = new Random();
    
    static {
            
        try {

            _imagesHashMap.put(DrawableEnum.FOODTRUCK_UP, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckUp.png")));
            _imagesHashMap.put(DrawableEnum.FOODTRUCK_DOWN, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckDown.png")));
            _imagesHashMap.put(DrawableEnum.FOODTRUCK_RIGHT, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckRight.png")));
            _imagesHashMap.put(DrawableEnum.FOODTRUCK_LEFT, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/foodtruckLeft.png")));
            
            _imagesHashMap.put(DrawableEnum.COP_UP, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/copCar.png")));
            _imagesHashMap.put(DrawableEnum.COP_DOWN, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/copCar.png")));
            _imagesHashMap.put(DrawableEnum.COP_RIGHT, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/copCar.png")));
            _imagesHashMap.put(DrawableEnum.COP_LEFT, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/copCar.png")));

            _imagesHashMap.put(DrawableEnum.SPEED_TRAP, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/speedtrap.png")));
            _imagesHashMap.put(DrawableEnum.POT_HOLE, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/pothole.png")));
            _imagesHashMap.put(DrawableEnum.FOOD, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/food.png")));

            _houseImages.add(ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house1.png")));
            _houseImages.add(ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house2.png")));
            _houseImages.add(ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/house3.png")));

            _imagesHashMap.put(DrawableEnum.HORIZONTAL_ROAD, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadHorizontal.png")));
            _imagesHashMap.put(DrawableEnum.VERTICAL_ROAD, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadVertical.png")));
            _imagesHashMap.put(DrawableEnum.FOUR_WAY_INTERSECT, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadFourWay.png")));

            _imagesHashMap.put(DrawableEnum.SOUTH_EAST_CORNER, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadSouthEastCorner.png")));
            _imagesHashMap.put(DrawableEnum.SOUTH_WEST_CORNER, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadSouthWestCorner.png")));
            _imagesHashMap.put(DrawableEnum.NORTH_EAST_CORNER, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadNorthEastCorner.png")));
            _imagesHashMap.put(DrawableEnum.NORTH_WEST_CORNER, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadNorthWestCorner.png")));
            
            _imagesHashMap.put(DrawableEnum.THREE_WAY_NORTH, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadThreeWayNorth.png")));
            _imagesHashMap.put(DrawableEnum.THREE_WAY_EAST, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadThreeWayEast.png")));
            _imagesHashMap.put(DrawableEnum.THREE_WAY_SOUTH, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadThreeWaySouth.png")));
            _imagesHashMap.put(DrawableEnum.THREE_WAY_WEST, ImageIO.read(SpriteLoader.class.getResourceAsStream("/foodtruckfrenzy/roadThreeWayWest.png")));

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
