
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TicTacToeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TicTacToeTest
{
    /**
     * Default constructor for test class TicTacToeTest
     */
    public TicTacToeTest()
    {
    }
 
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    

    
    /*
    @Test
    public void turnTest()
    {
        assertEquals("O", TicTacToe.turn(15));
        assertEquals("X", TicTacToe.turn(16));
    }
    */
    
    @Test
    public void drawBoardTest() {
        assertEquals(" null | null | null \n---|---|---\n null | null | null \n---|---|---\n null | null | null ", TicTacToe.drawBoard());
        TicTacToe.initBoard();
        assertEquals(" 1 | 2 | 3 \n---|---|---\n 4 | 5 | 6 \n---|---|---\n 7 | 8 | 9 ", TicTacToe.drawBoard());
        
        TicTacToe.board = new String[] {"X", "O", "X", "O", "X", "O", "X", "O", "X"};
        assertEquals(" X | O | X \n---|---|---\n O | X | O \n---|---|---\n X | O | X ", TicTacToe.drawBoard());
    }
    
    // TODO fix seting value with dot notation
    
    
}



