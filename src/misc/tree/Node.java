package misc.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 12/01/2013
 * Time: 20:04
 * To change this template use File | Settings | File Templates.
 */
public class Node<E>
{
    private E value;
    private LinkedList<Node> children;

    public Node(E value)
    {
        this.value = value;
        children = new LinkedList<Node>();
    }

    public void connect(Node n)
    {
        this.children.add(n);
    }

    public void setValue(E value)
    {
        this.value = value;
    }

    public E getValue()
    {
        return this.value;
    }

    public List<Node> getAllChildren()
    {
        return this.children;
    }

    public void removeChild(Node child)
    {
        for(Node c:children)
        {
            if(child.equals(c))
            {
                children.remove(c);
                return;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (children != null ? !children.equals(node.children) : node.children != null) return false;
        if (value != null ? !value.equals(node.value) : node.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}
