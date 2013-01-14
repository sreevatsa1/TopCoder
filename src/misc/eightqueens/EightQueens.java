package misc.eightqueens;

import misc.Stack;
import org.apache.commons.lang3.ArrayUtils;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 13/01/2013
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */
public class EightQueens
{
    int [][] board;
    int dimension;
    int count;
    Stack<Pair> stack;
    LinkedList<Pair> currentlyFilled;

    public EightQueens(int dimension)
    {
        board = new int[dimension][dimension];
        this.dimension = dimension;
        this.count = 0;
        stack = new Stack<Pair>(100);
        currentlyFilled = new LinkedList<Pair>();
        fillArray(0);
    }

    public void solve()
    {
        for(int i=0;i<dimension;i++)
        {
            for(int j=0;j<dimension;j++)
            {
                if(board[i][j]!=1 && board[i][j]!=2)
                {
                    Pair p = new Pair(i,j);
                    currentlyFilled.add(p);
                    stack.add(p);
                    count++;
                    blockUnblockArea(i, j, true);
                    if(count==dimension)
                    {
                        return;
                    }
                    solve();
                }
            }
        }
        if(count!=dimension)
        {
            if(!stack.isEmpty())
            {
                Pair p = stack.remove();
                currentlyFilled.remove(p);
                blockUnblockArea(p.getRow(), p.getCol(), false);
                blockUnblockMulipleArea(true);
                count--;
            }
            else
            {
                currentlyFilled.clear();
                fillArray(0);
                count=0;
            }
            return;
        }
    }

    private void blockUnblockMulipleArea(boolean block)
    {
        for(Pair p:currentlyFilled)
        {
            blockUnblockArea(p.getRow(), p.getCol(), block);
        }
    }

    public void blockUnblockArea(int i, int j, boolean block)
    {
        int value;
        if(block)
            value = 2;
        else
            value = 0;


        //For blocking corresponding row and column
        for(int k=0;k<dimension;k++)
        {
            board[k][j] = value;
            board[i][k] = value;
        }

        int k=i-1;
        int l=j+1;
        for(;;k--,l++)
        {
            if(k>=0 && l<dimension)
            {
                board[k][l] = value;
            }
            else
            {
                break;
            }
        }

        k=i+1;
        l=j-1;
        for(;;k++,l--)
        {
            if(k<dimension && l>=0)
            {
                board[k][l] = value;
            }
            else
            {
                break;
            }
        }

        //
        k=i-1;
        l=j-1;
        for(;;k--,l--)
        {
            if(k>=0 && l >=0 )
            {
                board[k][l] = value;
            }
            else
            {
                break;
            }
        }

        k=i+1;
        l=j+1;
        for(;;k++,l++)
        {
            if(k<dimension && l<dimension)
            {
                board[k][l] = value;
            }
            else
            {
                break;
            }
        }
        if(block)
        {
            board[i][j] = 1;
        }
        else
        {
            board[i][j] = 0;
        }
    }

    public void fillArray(int value)
    {
        for(int i=0;i<dimension;i++)
        {
            for(int j=0;j<dimension;j++)
            {
                board[i][j] = value;
            }
        }
    }

    public void printBoard()
    {
        System.out.println("Printing board:");
        for(int i=0;i<dimension;i++)
        {
            System.out.print("[ ");
            for(int j=0;j<dimension;j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ]");
        }
    }

    public static void main(String[] args)
    {
        EightQueens eq = new EightQueens(12);
        eq.solve();
        eq.printBoard();
    }
}


