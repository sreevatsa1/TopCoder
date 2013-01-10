package recursion;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 10/01/2013
 * Time: 01:04
 * To change this template use File | Settings | File Templates.
 */
public class PermutationsTest {
    @Test
    public void testRotate1() throws Exception
    {
        Permutations p = new Permutations(new int[]{1,2});
        ArrayList<int[]> rotations = p.rotate(new int[]{1,2}, new ArrayList<int[]>());
        ArrayList<int[]> expected = new ArrayList<int[]>();
        expected.add(new int[]{1,2});
        expected.add(new int[]{2,1});

        if(rotations.size() != expected.size())
        {
            throw new AssertionError("Size does not match");
        }
        for(int i=0;i<rotations.size();i++)
        {
            assertArrayEquals(rotations.get(i), expected.get(i));
        }
    }

    @Test
    public void testRotate2() throws Exception
    {
        Permutations p = new Permutations(new int[]{1,2,3});
        ArrayList<int[]> rotations = p.rotate(new int[]{1,2,3}, new ArrayList<int[]>());
        ArrayList<int[]> expected = new ArrayList<int[]>();
        expected.add(new int[]{1,2,3});
        expected.add(new int[]{2,3,1});
        expected.add(new int[]{3,1,2});

        if(rotations.size() != expected.size())
        {
            throw new AssertionError("Size does not match");
        }
        for(int i=0;i<rotations.size();i++)
        {
            assertArrayEquals(rotations.get(i), expected.get(i));
        }
    }
}
