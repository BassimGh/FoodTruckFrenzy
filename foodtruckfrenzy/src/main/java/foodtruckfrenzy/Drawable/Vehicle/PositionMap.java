package foodtruckfrenzy.Drawable.Vehicle;

import java.util.HashMap;

/**
 * PositionMap stores position objects to be used for the player tracking algorithm
 */
public class PositionMap {

    private final HashMap<String, Position> _container;

    /**
     * constructor to create a new position list, 
     * instantiates a new hash map for the container
     */
    public PositionMap() {
        _container = new HashMap<String, Position>();
    }
    /**
     * Checks if PositionList contains a Position with matching row and col
     * values as the input positoin
     * @return true if the input Position row and col match a Position in PositionList
    */
    public boolean contains(Position pos) {
        if (_container.isEmpty()) return false;
        
        return _container.containsKey(pos.generateKey());
    }

    /**
     * Add new position to the position list
     * @param position new position to be added
     */
    public void put(Position position) {
        _container.put(position.generateKey(), position);
    }
    
}
