package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 12/01/2013
 * Time: 12:59
 * To change this template use File | Settings | File Templates.
 */
public class OddDivisors
{
    public long findSum(int N)
    {
        if(N==1)
        {
            return 1;
        }
        long sum = findSum(N-1);

        int divisor = oddDivisor(N);
        return sum + divisor;
    }

    public int oddDivisor(int N)
    {
        if(N%2==0 && ((N/2)%2) != 0 )
        {
            return N/2;
        }
        else if(N%2==0 && ((N/2)%2) == 0)
        {
            return oddDivisor(N/2);
        }
        else
            return N;
    }
}
