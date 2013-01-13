package misc;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 12/01/2013
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 */
public class Stack<E>
{
    LinkedList<E> list;
    int capacity;

    public Stack(int capacity)
    {
        this.list = new LinkedList<E>();
        this.capacity = capacity;
    }

    public boolean add(E element)
    {
        if(list.size()==capacity)
        {
            return false;
        }
        return list.add(element);
    }

    public E remove()
    {
        return list.removeLast();
    }
}
