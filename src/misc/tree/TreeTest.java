package misc.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.prefs.NodeChangeEvent;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 12/01/2013
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
public class TreeTest {
    @Test
    public void testAdd() throws Exception
    {
        Tree<Integer> t = new Tree<Integer>();
        Node<Integer> n = new Node<Integer>(1);
        t.add(null, n);
        Node root = t.getRootNode();
        assertEquals("testAdd", n, root);
    }

    @Test
    public void testRemoveChild() throws Exception
    {
        Tree<Integer> t = new Tree<Integer>();
        Node<Integer> n = new Node<Integer>(1);
        Node<Integer> nChild1 = new Node<Integer>(2);
        Node<Integer> nChild2 = new Node<Integer>(3);
        t.add(null, n);
        t.add(n,nChild1);
        t.add(n, nChild2);
        t.removeChild(n, nChild2);

        List<Node> expected = new LinkedList<Node>();
        expected.add(nChild1);

        List<Node> children = t.getRootNode().getAllChildren();
        assertEquals("testRemoveChild", expected, children);
    }

    @Test
    public void testGetRootNode() throws Exception
    {
        Tree<Integer> t = new Tree<Integer>();
        Node<Integer> n = new Node<Integer>(1);
        t.add(null, n);
        Node root = t.getRootNode();
        assertEquals("testGetRootNode", n, root);
    }

    @Test
    public void testContains() throws Exception
    {
        Tree<Integer> t = new Tree<Integer>();
        Node<Integer> root = generateTree(8,3);
        t.add(null, root);
        boolean result = t.contains(4);
        assertEquals("testContains", true, result);
    }

    @Test
    public void testBfsSearch() throws Exception
    {
        Tree<Integer> t = new Tree<Integer>();
        Node<Integer> root = generateTree(8,3);
        t.add(null, root);
        boolean result = t.bfs(4);
        assertEquals("testBfsSearch", true, result);
    }

    @Test
    public void testBfs() throws Exception
    {
        Tree<Integer> t = new Tree<Integer>();
        Node<Integer> root = generateTree(8,3);
        t.add(null, root);
        t.bfs();
        //assertEquals("testBfs", true, result);
    }

    @Test
    public void testDfs() throws Exception
    {
        Tree<Integer> t = new Tree<Integer>();
        Node<Integer> root = generateTree(8,3);
        t.add(null, root);
        t.dfs();
    }

    private Node<Integer> generateTree(int noOfNodes, int levels)
    {
        int nodesPerLevel = Math.abs((noOfNodes-1)/(levels-1));
        int count = 1;
        Node<Integer> root = new Node<Integer>(count);
        Node<Integer> parent = root;
        Node<Integer> parentNext = root;

        for(int i=0;i<(levels-1);i++)
        {
            for(int j=0;j<nodesPerLevel;j++)
            {
                Node<Integer> child = new Node<Integer>(++count);
                parent.connect(child);
                parentNext = child;
            }

            nodesPerLevel = noOfNodes-1-nodesPerLevel;
            parent = parentNext;
        }
        return root;
    }
}
