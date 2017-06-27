package subtask1;

import java.util.Arrays;
import java.util.Collection;
import task.Board;
import solution.BoardFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

/**
 * class for running JUnit tests of the first task.
 */
@RunWith(Parameterized.class)
public class PublicBoardSizeTest {

    int width;
    int height;

    public PublicBoardSizeTest(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {1, 1},
            {1, 2},
            {2, 2},
            {10, 10},
            {10, 100},
            {100, 10},
            {1, 255},
            {255, 1},
            {255, 255}
        });
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
    public void checkBoardSize() {
        Board board = BoardFactory.newBoard(width, height);

        assertEquals(board.getWidth(), width);
        assertEquals(board.getHeight(), height);
    }
}
