package subtask1;

import java.util.ArrayList;
import java.util.Collection;
import task.Board;
import solution.BoardFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Create boards of different sizes and place blocks in the corners of those.
 * Also check that the rest of the board doesn't change, when a block is placed.
 */
@RunWith(Parameterized.class)
public class PublicBlockPlacementTest {

    private int width;
    private int height;
    private int x;
    private int y;

    Board board;

    public PublicBlockPlacementTest(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> list = new ArrayList<Object[]>();

        // test various board sizes
        int[][] sizes = new int[][] {
            {1, 1},
            {1, 10},
            {10, 1},
            {10, 10},
            {2, 255},
            {255, 2},
            {255, 255}
        };

        // test all four corners, maybe we should test more here
        for (int test = 0; test != sizes.length; ++test) {
            int[] in = sizes[test];
            list.add(new Object[] {in[0], in[1], 0, 0});
            list.add(new Object[] {in[0], in[1], in[0] - 1, 0});
            list.add(new Object[] {in[0], in[1], 0, in[1] - 1});
            list.add(new Object[] {in[0], in[1], in[0] - 1, in[1] - 1});
        }

        return (Collection<Object[]>) list;
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        board = BoardFactory.newBoard(width, height);
    }

    @After
    public void tearDown() {
        board = null;
    }

    @Test(timeout = 1000)
    public void testPlacement() {
        System.out.println("Testing block placement for (" + x + "," + y + ") on (" + width + "x" + height + ")");
        board.addBlock(x, y);

        // check that the block got placed
        assertTrue(board.hasBlock(x, y));

        // check that everything else didn't change
        for (int j = 0; j != board.getHeight(); ++j) {
            for (int i = 0; i != board.getWidth(); ++i) {
                if (i != x || j != y) {
                    assertFalse(board.hasBlock(i, j));
                }
            }
        }
    }
}