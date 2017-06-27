package subtask1;

import task.Board;
import task.Official;
import solution.BoardFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test if placing Officials works as expected.
 */
public class PublicOfficialPlacementTest {

    Board board;

    public PublicOfficialPlacementTest() {
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
    public void simplePlacementTest() {
        board = BoardFactory.newBoard(15, 15);
        addOfficialChecked(0, 0, Official.Color.Red, Official.Color.Blue);
        addOfficialChecked(0, 1, Official.Color.Blue, Official.Color.Red);
        addOfficialChecked(0, 14, Official.Color.Red, Official.Color.Black);
    }

    private Official addOfficialChecked(int x, int y, Official.Color robe, Official.Color hat) {
        Official official = board.addOfficial(x, y, robe, hat);
        assertEquals(official, board.getOfficial(x, y));
        assertEquals(official, board.getOfficial(robe, hat));
        return official;
    }
}
