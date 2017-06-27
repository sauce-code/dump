package task;

/**
 * Models the board of a board game. This class provides methods for adding
 * elements to the board, such as walls, blocks and officials.
 * Furthermore it allows querying of information from the board.
 *
 * A board is always rectangular and has a height and a width. The squares are
 * layed out on the board in a rectangular grid. The parts of coordinates along
 * the width of the board are usually indicated by an x. The parts of
 * coordinates along the height of the board are indicated by a y.
 */
public interface Board {

    /**
     * Returns the number of squares on the board in the direction of the x-axis.
     *
     * @return The width of the board. This value is always strictly positive.
     */
    int getWidth();

    /**
     * Returns the number of squares on the board in the direction of the y-axis.
     * @return The height of the board. This value is always strictly positive.
     */
    int getHeight();

    /**
     * Method for creating new Officials at the position (x,y), with a robe of
     * Color robe and a hat of Color hat.
     *
     * If the specified position is already occupied or if an Official with the
     * same robe and hat combination has already been added, the method throws
     * an IllegalArgumentException. The state of the board does not change in
     * this case.
     *
     * After calling this method, calling getOfficial(robe, hat) for the same
     * values of robe and hat should alway return the same Official that the
     * initial call to getOfficial() returned, unless an Exception occured.
     *
     * Similarly, after calling this method, calling getOfficial(x, y) for the
     * same values of x and y, should return the newly created Official, unless
     * it has been moved away by any of the move methods in the Offical
     * interface or unless an Exception occured.
     *
     * @param x The x-axis offset of the Official.
     * @param y The y-axis offset of the Official.
     * @param robe The color of the Official's robe.
     * @param hat The color of the Official's hat.
     * @return The newly created Official.
     * @throws IllegalArgumentException If the specified Official cannot be
     * added at the specified position.
     *
     */
    Official addOfficial(int x, int y, Official.Color robe, Official.Color hat);

    /**
     * Block the square at location (x,y) so that Officials cannot move to the
     * square or pass the square.
     *
     * @param x The x-axis offset where the block should be added.
     * @param y The y-axis offset where the block should be added.
     * @throws IllegalArgumentException If the block cannot be added at the
     * specified position.
     */
    void addBlock(int x, int y);

    /**
     * Mark the wall north of (x,y) as solid.
     *
     * Walls stop movement in both directions, from (x,y) to (x,y+1) and from
     * (x,y+1) to (x,y).
     *
     * @param x The x-axis offset of the square immediately south of the wall
     * to be added.
     * @param y The y-axis offset of the square immediately south of the wall
     * to be added.
     * @throws IllegalArgumentException If x or y is not a valid index for the
     * current board.
     */
    void addWallNorth(int x, int y);

    /**
     * Similar to addWallNorth.
     *
     * @param x The x-axis offset of the square immediately west of the wall
     * to be added.
     * @param y The y-axis offset of the square immediately west of the wall
     * to be added.
     * @throws IllegalArgumentException If x or y is not a valid index for the
     * current board.
     */
    void addWallEast(int x, int y);

    /**
     * Similar to addWallNorth.
     *
     * @param x The x-axis offset of the square immediately north of the wall
     * to be added.
     * @param y The y-axis offset of the square immediately north of the wall
     * to be added.
     * @throws IllegalArgumentException If x or y is not a valid index for the
     * current board.
     */
    void addWallSouth(int x, int y);

    /**
     * Similar to addWallNorth.
     *
     * @param x The x-axis offset of the square immediately east of the wall
     * to be added.
     * @param y The y-axis offset of the square immediately east of the wall
     * to be added.
     * @throws IllegalArgumentException If x or y is not a valid index for the
     * current board.
     */
    void addWallWest(int x, int y);

    /**
     * Return the Official at position x, y.
     *
     * @return The Official at position (x,y), or null if there is none.
     * @param x The x-axis offset of the square.
     * @param y The y-axis offset of the square.
     * @throws IllegalArgumentException If x or y is not a valid index for the
     * current board.
     */
    Official getOfficial(int x, int y);

    /**
     * Return the Official with robe Color robe and hat Color hat.
     * @param robe The color of the robe.
     * @param hat The color of the hat.
     * @return The Official with the requested colors, or null if there is none.
     */
    Official getOfficial(Official.Color robe, Official.Color hat);

    /**
     * Returns true if there is a block at position (x,y). Return false
     * otherwise.
     *
     * @param x The x-axis offset of the square.
     * @param y The y-axis offset of the square.
     * @return True if there is a block, false if there is no block.
     * @throws IllegalArgumentException If x or y is not a valid index for the
     * current board.
     */
    boolean hasBlock(int x, int y);

    /**
     * Returns true if there is a wall north of the square at (x,y).
     *
     * @param x The x-axis offset of the square.
     * @param y The y-axis offset of the square.
     * @return true, if there is a wall, false otherwise.
     * @throws IllegalArgumentException If x or y is not a valid index for the
     * current board.
     */
    boolean hasWallNorth(int x, int y);

    /**
     * Returns true if there is a wall east of the square at (x,y).
     *
     * @param x The x-axis offset of the square.
     * @param y The y-axis offset of the square.
     * @return true, if there is a wall, false otherwise.
     * @throws IllegalArgumentException If x or y is not a valid index for the
     * current board.
     */

    boolean hasWallEast(int x, int y);
    /**
     * Returns true if there is a wall south of the square at (x,y).
     *
     * @param x The x-axis offset of the square.
     * @param y The y-axis offset of the square.
     * @return true, if there is a wall, false otherwise.
     * @throws IllegalArgumentException If x or y is not a valid index for the
     * current board.
     */

    boolean hasWallSouth(int x, int y);
    /**
     * Returns true if there is a wall west of the square at (x,y).
     *
     * @param x The x-axis offset of the square.
     * @param y The y-axis offset of the square.
     * @return true, if there is a wall, false otherwise.
     * @throws IllegalArgumentException If x or y is not a valid index for the
     * current board.
     */

    boolean hasWallWest(int x, int y);

    /**
     * Return the minimum number of moves necessary to move official from its
     * current position to the position indicated by x and y without moving
     * other officials in between.
     *
     * @param official The Official for which distance calculation is requested.
     * @param x The x-axis offset of the coordinate to which the distance of
     * offical is requested.
     * @param y The y-axis offset of the coordinate to which the distance of
     * official is requested.
     * @return The minimum number of moves necessary to move official to (x,y),
     * or Integer.MAX_VALUE, if the official cannot reach the specified
     * position, without moving other Officials first.
     */
    int getDistance(Official official, int x, int y);
}