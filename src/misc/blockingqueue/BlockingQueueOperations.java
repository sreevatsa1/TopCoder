package misc.blockingqueue;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 13/01/2013
 * Time: 00:25
 * To change this template use File | Settings | File Templates.
 */
public class BlockingQueueOperations<E> implements Runnable
{
    boolean enqueue = false;
    BlockingQueue<E> bq;
    LinkedList<E> list;

    public BlockingQueueOperations(boolean enqueue, BlockingQueue<E> bq)
    {
        this.enqueue = enqueue;
        this.bq = bq;
        list = new LinkedList<E>();
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                if(enqueue)
                {
                    if(!list.isEmpty())
                    {
                        bq.enqueue(list.removeFirst());
                    }
                }
                else
                {
                    System.out.println("Dequeued element:" + bq.dequeue());
                }
                Thread.sleep(1000);
            }
            catch(InterruptedException ie)
            {
                System.out.println("Thread interrupted");
            }
        }
    }

    public void enqueue(E data)
    {
        list.add(data);
    }

    public static void main(String[] args)
    {
        BlockingQueue<Integer> bq = new BlockingQueue<Integer>(5);
        BlockingQueueOperations<Integer> bqEnqueue = new BlockingQueueOperations<Integer>(true, bq);
        BlockingQueueOperations<Integer> bqDequeue = new BlockingQueueOperations<Integer>(false, bq);
        new Thread(bqEnqueue).start();
        new Thread(bqDequeue).start();
        bqEnqueue.enqueue(10);
        bqEnqueue.enqueue(177);
        bqEnqueue.enqueue(345);
        bqEnqueue.enqueue(567);
        bqEnqueue.enqueue(124);
        bqEnqueue.enqueue(445);
    }
}
