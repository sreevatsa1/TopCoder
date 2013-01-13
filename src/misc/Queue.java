package misc;

import com.sun.org.apache.xml.internal.utils.ObjectPool;

import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 12/01/2013
 * Time: 16:10
 * To change this template use File | Settings | File Templates.
 */
public class Queue<E>
{
    LinkedList<E> list;
    int capacity;

    public Queue(int capacity)
    {
        list = new LinkedList<E>();
        this.capacity = capacity;
    }

    public boolean enqueue(E value)
    {
        if(list.size()==capacity)
        {
            return false;
        }
        return list.add(value);

    }

    public E dequeue()
    {
        return list.removeFirst();
    }
}
