package solution;

import task.Board;

/**
 * Factory method for creating a new BoardImpl object.
 */
final public class BoardFactory {
    private BoardFactory() {
    }

    /**
     * Create a new Board object of the specified width and height.
     *
     * Note that this might throw an IllegalArgumentException if the board size
     * is negative.
     * @param width The desired width of the newly generated board.
     * @param height The desired height of the newly generated board.
     * @return The newly generated board.
     */
    public static Board newBoard(int width, int height) {
        throw new UnsupportedOperationException("Bitte anpassen!");
    }
}
