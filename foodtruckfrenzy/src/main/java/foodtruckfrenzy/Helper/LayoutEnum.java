package foodtruckfrenzy.Helper;

/**
 * Enum which contains the shorthand codes for all the board elements which can be created
 * These elements are to be read from the layout.csv file and translated using the board element factory
 */
public enum LayoutEnum {
    /**
     * Specifies no layout. Used for testing purposes.
     */
    NULL,

    /**
     * Horizontal Road
     */
    H,

    /**
     * Vertical Road
     */
    V,

    /**
     * Four-Way Intersection
     */
    X,

    /**
     * North-West Corner
     */
    U,

    /**
     * North-East Corner
     */
    I,

    /**
     * South-East Corner
     */
    J,

    /**
     * South-West Corner
     */
    K,
    
    /**
     * North Three-Way Intersection
     */
    N,

    /**
     * East Three-Way Intersection
     */
    B,

    /**
     * South Three-Way Intersection
     */
    M,

    /**
     * West Three-Way Intersection
     */
    C,

    /**
     * Obstruction/House
     */
    O,

    /**
     * Horizontal Road with Speed Trap
     */
    S,

    /**
     * Horiztonal Road with Pot Hole
     */
    P,

    /**
     * Vertical Road with Pot Hole
     */
    L,

    /**
     * Horizontal Road with Food
     */
    F,

    /**
     * Vertical Road with Food
     */
    R,

    /**
     * Horizontal Road with Recipe/Bonus Item
     */
    Q
}
