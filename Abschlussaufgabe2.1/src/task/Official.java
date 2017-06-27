package task;

/**
 * Class representing an Official.
 *
 * Note, that new Official are created by the Board interface.
 */
public interface Official {
    /**
     * Enum for encoding Colors of Official's robes and hats.
     */
    enum Color {
        /**
         * The color red.
         */
        Red,
        /**
         * The color green.
         */
        Green,
        /**
         * The color blue.
         */
        Blue,
        /**
         * The color yellow.
         */
        Yellow,
        /**
         * The color black.
         */
        Black
    }

    /**
     * Return the Color of the Official's robe.
     * @return The Color of the Official's robe.
     */
    Color getRobe();

    /**
     * Return the Color of the Official's robe.
     * @return The Color of the Official's robe.
     */
    Color getHat();

    /**
     * Move the Official north as far as possible.
     * This means until there is either:
     * <ul>
     *  <li>a wall,</li>
     *  <li>another official,</li>
     *  <li>or a blocked square.</li>
     * </ul>
     */
    void moveNorth();

    /**
     * Move the Official east as far as possible.
     * This means until there is either:
     * <ul>
     *  <li>a wall,</li>
     *  <li>another official,</li>
     *  <li>or a blocked square.</li>
     * </ul>
     */
    void moveEast();

    /**
     * Move the Official south as far as possible.
     * This means until there is either:
     * <ul>
     *  <li>a wall,</li>
     *  <li>another official,</li>
     *  <li>or a blocked square.</li>
     * </ul>
     */
    void moveSouth();

    /**
     * Move the Official west as far as possible.
     * This means until there is either:
     * <ul>
     *  <li>a wall,</li>
     *  <li>another official,</li>
     *  <li>or a blocked square.</li>
     * </ul>
     */
    void moveWest();

}
