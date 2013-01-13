package misc.tree;

import misc.Queue;
import misc.Stack;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 12/01/2013
 * Time: 20:03
 * To change this template use File | Settings | File Templates.
 */
public class Tree<T>
{
    Node<T> root;
    public Tree()
    {

    }

    public void add(Node<T> parent,  Node<T> child)
    {
        if(parent==null)
        {
            root = child;
        }
        else
        {
            parent.connect(child);
        }
    }

    public void removeChild(Node<T> parent, Node<T> child)
    {
        if(parent==null)
        {
            throw new IllegalArgumentException("Parent cannot be null");
        }
        else
        {
            parent.removeChild(child);
        }
    }

    public Node getRootNode()
    {
        return this.root;
    }

    public boolean contains(T data)
    {
        if(root!=null)
        {
            return containsHelper(data, root);
        }
        return false;
    }

    private boolean containsHelper(T data, Node c)
    {
        if(c.getValue().equals(data))
        {
            return true;
        }
        else
        {
            for(Node child:(List<Node>)c.getAllChildren())
            {
                boolean result = containsHelper(data, child);
                if(result)
                {
                    return true;
                }
                else
                {
                    continue;
                }
            }
        }
        return false;
    }

    public boolean bfs(T data)
    {
        Queue<Node> queue = new Queue<Node>(100);
        if(root!=null)
        {
            if(root.getValue().equals(data))
            {
                return true;
            }
            else
            {
                queue.enqueue(root);
                return bfsHelper(data, queue);
            }
        }
        return false;
    }

    private boolean bfsHelper(T data,Queue<Node> queue)
    {
        Node c = queue.dequeue();
        if(c!=null && c.getValue().equals(data))
        {
            return true;
        }
        else
        {
            for(Node child:(List<Node>)c.getAllChildren())
            {
                if(child.getValue().equals(data))
                {
                    return true;
                }
                else
                {
                    queue.enqueue(child);
                }
            }
        }
        return false;
    }

    public void bfs()
    {
        Queue<Node> queue = new Queue<Node>(100);
        if(root!=null)
        {
            queue.enqueue(root);
            bfsHelper(queue);
        }
    }

    private void bfsHelper(Queue<Node> queue)
    {
        if(queue.isEmpty())
            return;

        Node c = queue.dequeue();
        if(c!=null)
        {
            System.out.print(c.getValue());
        }

        for(Node child:(List<Node>)c.getAllChildren())
        {
            queue.enqueue(child);
        }
        bfsHelper(queue);
    }

    public void dfs()
    {
        Stack<Node> stack = new Stack<Node>(100);
        if(root!=null)
        {
            stack.add(root);
            dfsHelper(stack);
        }
    }

    private void dfsHelper(Stack<Node> stack)
    {
        if(stack.isEmpty())
            return;

        Node c = stack.remove();
        if(c!=null)
        {
            System.out.print(c.getValue());
        }

        for(Node child:(List<Node>)c.getAllChildren())
        {
            stack.add(child);
        }
        dfsHelper(stack);
    }
}
