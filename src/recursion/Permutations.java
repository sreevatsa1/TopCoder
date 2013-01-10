package recursion;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 06/01/2013
 * Time: 23:55
 * To change this template use File | Settings | File Templates.
 */
public class Permutations {

    public HashSet<Integer[]> combinations;
    public int[] input;
    public Permutations(int[] input)
    {
        combinations = new HashSet<Integer[]>();
        this.input = input;
    }
    public static void main(String[] args)
    {
        Permutations p = new Permutations(new int[]{1,2,3,4,5});
        p.printAll(p.input);
        System.out.println("No. of combinations:" + p.combinations.size());
        for(Integer[] comb:p.combinations)
        {
            System.out.println(Arrays.toString(comb));
//            System.out.print("[ ");
//            for(int c:comb)
//            {
//                System.out.print(c + "\t");
//            }
//            System.out.println(" ]");
        }
    }

    public void printAll(int[] c)
    {
        if(addToCombinations(c))
        {
            combinations.add(ArrayUtils.toObject(c));
        }

        for(int i=2;i<=c.length;i++)
        {
            int[] x1 = ArrayUtils.subarray(c, 0, i);
            ArrayList<int[]> rotations = new ArrayList<int[]>();
            rotations = rotate(x1, rotations);
            for(int[] rotation:rotations)
            {
                int[] full = ArrayUtils.addAll(rotation, ArrayUtils.subarray(c, i, c.length));
                if(addToCombinations(full))
                {
                    combinations.add(ArrayUtils.toObject(full));
                }
                else
                {
                    continue;
                }
                printAll(full);
            }
        }
    }

    public ArrayList<int[]> rotate(int c[], ArrayList<int[]> rotations)
    {
        if(rotations.size() > 0)
        {
            int[] orig = rotations.get(0);
            if(Arrays.equals(c, orig))
            {
                return rotations;
            }
        }
        rotations.add(c);
        while(true)
        {
            int[] p1 = ArrayUtils.subarray(c, 0, 1);
            int[] p2 = ArrayUtils.subarray(c, 1, c.length);
            int[] p = ArrayUtils.addAll(p2, p1);
            rotate(p, rotations);
            break;
        }
        return rotations;
    }

    private boolean addToCombinations(int[] c)
    {
        for(Integer[] comb:combinations)
        {
            if(Arrays.equals(comb, ArrayUtils.toObject(c)))
                return false;
        }
        return true;
    }
}
