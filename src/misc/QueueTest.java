package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 12/01/2013
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
public class QueueTest {
    @Test
    public void testEnqueue1() throws Exception
    {
        Queue<Integer> q = new Queue<Integer>(10);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(10);
        boolean result = q.enqueue(11);
        assertEquals("testEnqueue1", false, result);
    }

    @Test
    public void testDequeue1() throws Exception
    {
        Queue<Integer> q = new Queue<Integer>(10);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        Integer val = q.dequeue();
        assertEquals("testDequeu1", 1, val.longValue());
    }
}
