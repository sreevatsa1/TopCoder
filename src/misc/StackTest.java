package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 12/01/2013
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class StackTest {
    @Test
    public void testAdd() throws Exception
    {
        Stack<Integer> s = new Stack<Integer>(10);
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        s.add(6);
        s.add(7);
        s.add(8);
        s.add(9);
        s.add(10);
        boolean result = s.add(11);
        assertEquals("testAdd", false, result);
    }

    @Test
    public void testRemove() throws Exception
    {
        Stack<Integer> s = new Stack<Integer>(10);
        s.add(1);
        s.add(2);
        s.add(3);
        long result = s.remove();
        assertEquals("testRemove", 3, result);
    }
}
