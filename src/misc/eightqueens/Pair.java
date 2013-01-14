package misc.eightqueens;

/**
 * Created with IntelliJ IDEA.
 * User: sreevatsalakshmanan
 * Date: 13/01/2013
 * Time: 22:45
 * To change this template use File | Settings | File Templates.
 */
public class Pair
{
    private int row;
    private int col;

    public Pair(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (col != pair.col) return false;
        if (row != pair.row) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
