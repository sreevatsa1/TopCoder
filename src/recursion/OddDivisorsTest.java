package recursion;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 12/01/2013
 * Time: 13:03
 * To change this template use File | Settings | File Templates.
 */
public class OddDivisorsTest
{
    @Test
    public void testFindSum1() throws Exception
    {
        OddDivisors o = new OddDivisors();
        long sum = o.findSum(7);
        assertEquals("testFindSum1", 21, sum);
    }

    @Test
    public void testFindSum2() throws Exception
    {
        OddDivisors o = new OddDivisors();
        long sum = o.findSum(777);
        assertEquals("testFindSum2", 201537, sum);
    }

    @Test
    public void testOddDivisor1() throws Exception
    {
        OddDivisors o = new OddDivisors();
        int divisor = o.oddDivisor(7);
        assertEquals("testOddDivisor1", 7, divisor);
    }

    @Test
    public void testOddDivisor2() throws Exception
    {
        OddDivisors o = new OddDivisors();
        int divisor = o.oddDivisor(20);
        assertEquals("testOddDivisor2", 5, divisor);
    }

    @Test
    public void testOddDivisor3() throws Exception
    {
        OddDivisors o = new OddDivisors();
        int divisor = o.oddDivisor(210);
        assertEquals("testOddDivisor3", 105, divisor);
    }
}
