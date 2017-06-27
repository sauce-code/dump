package subtask1;

import task.Board;
import solution.BoardFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test placement of walls
 */
public class PublicWallPlacementTest {

    public PublicWallPlacementTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 1000)
    public void testPlacementNorth() {
        Board board = BoardFactory.newBoard(2, 2);
        board.addWallNorth(0, 0);
        assertTrue(board.hasWallNorth(0, 0));
        assertTrue(board.hasWallSouth(0, 1));

        assertFalse(board.hasWallSouth(0, 0));
        assertFalse(board.hasWallEast(0, 0));
        assertFalse(board.hasWallWest(0, 0));
        assertFalse(board.hasWallNorth(0, 1));
        assertFalse(board.hasWallNorth(1, 0));
        assertFalse(board.hasWallNorth(1, 1));
    }

    @Test(timeout = 1000)
    public void testPlacementEast() {
        Board board = BoardFactory.newBoard(2, 2);
        board.addWallEast(0, 0);
        assertTrue(board.hasWallWest(1, 0));
        assertTrue(board.hasWallEast(0, 0));

        assertFalse(board.hasWallNorth(0, 0));
        assertFalse(board.hasWallSouth(0, 0));
        assertFalse(board.hasWallWest(0, 0));
        assertFalse(board.hasWallEast(0, 1));
        assertFalse(board.hasWallEast(1, 0));
        assertFalse(board.hasWallEast(1, 1));
    }

    @Test(timeout = 1000)
    public void testPlacementSouth() {
        Board board = BoardFactory.newBoard(2, 2);
        board.addWallSouth(0, 1);
        assertTrue(board.hasWallSouth(0, 1));
        assertTrue(board.hasWallNorth(0, 0));

        assertFalse(board.hasWallNorth(0, 1));
        assertFalse(board.hasWallEast(0, 1));
        assertFalse(board.hasWallWest(0, 1));
        assertFalse(board.hasWallSouth(0, 0));
        assertFalse(board.hasWallSouth(1, 0));
        assertFalse(board.hasWallSouth(1, 1));
    }

    @Test(timeout = 1000)
    public void testPlacementWest() {
        Board board = BoardFactory.newBoard(2, 2);
        board.addWallWest(1, 0);
        assertTrue(board.hasWallWest(1, 0));
        assertTrue(board.hasWallEast(0, 0));

        assertFalse(board.hasWallNorth(1, 0));
        assertFalse(board.hasWallEast(1, 0));
        assertFalse(board.hasWallSouth(1, 0));
        assertFalse(board.hasWallWest(1, 1));
        assertFalse(board.hasWallWest(0, 0));
        assertFalse(board.hasWallWest(0, 1));
    }
}