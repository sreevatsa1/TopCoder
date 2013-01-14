package misc.eightqueens;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 13/01/2013
 * Time: 23:03
 * To change this template use File | Settings | File Templates.
 */
public class EightQueensTest {
    @Test
    public void testBlockUnblockArea() throws Exception
    {
        int[][] expected =  {
                            {0,2,0,2},
                            {2,2,2,0},
                            {2,1,2,2},
                            {2,2,2,0}
                            };

        int[][] expected1 = {
                            {2,0,2,0},
                            {0,2,2,2},
                            {2,2,1,2},
                            {0,2,2,2}
                            };

        int[][] expected2 = {
                            {0,0,0,2,0,0,2,0},
                            {0,0,0,0,2,0,2,0},
                            {0,0,0,0,0,2,2,2},
                            {2,2,2,2,2,2,1,2},
                            {0,0,0,0,0,2,2,2},
                            {0,0,0,0,2,0,2,0},
                            {0,0,0,2,0,0,2,0},
                            {0,0,2,0,0,0,2,0}
                            };

        EightQueens eq = new EightQueens(4);
        eq.blockUnblockArea(2,1, true);
        assertEquals("testBlockUnblockArea", true, compare(expected, eq.board));

        EightQueens eq1 = new EightQueens(4);
        eq1.blockUnblockArea(2, 2, true);
        assertEquals("testBlockUnblockArea", true, compare(expected1, eq1.board));

        EightQueens eq2 = new EightQueens(8);
        eq2.blockUnblockArea(3,6, true);
        assertEquals("testBlockUnblockArea", true, compare(expected2, eq2.board));
    }

    private boolean compare(int[][] expected, int[][] result)
    {
        for(int i=0;i<expected[0].length;i++)
        {
            for(int j=0;j<expected[0].length;j++)
            {
                if(expected[i].length == result[i].length)
                {
                    if(expected[i][j] != result[i][j])
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
}
