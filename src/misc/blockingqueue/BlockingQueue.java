package misc.blockingqueue;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 12/01/2013
 * Time: 23:52
 * To change this template use File | Settings | File Templates.
 */
public class BlockingQueue<E>
{
    LinkedList<E> list;
    int capacity;

    public BlockingQueue(int capacity)
    {
        list = new LinkedList<E>();
        this.capacity = capacity;
    }

    public synchronized boolean enqueue(E value) throws InterruptedException
    {
        if(list.size()==capacity)
        {
            System.out.println("Queue is full. Please wait.");
            wait();
            System.out.println("One or more items have been dequeued. Your item will be added now.");
        }
        System.out.println("Adding to queue:" + value.toString());
        notifyAll();
        return list.add(value);
    }

    public synchronized E dequeue() throws InterruptedException
    {
        if(isEmpty())
        {
            System.out.println("Waiting for data to come in...");
            wait();
            System.out.println("Data has come in!!!");
        }
        notifyAll();
        return list.removeFirst();
    }

    public synchronized boolean isEmpty()
    {
        return list.isEmpty();
    }
}
