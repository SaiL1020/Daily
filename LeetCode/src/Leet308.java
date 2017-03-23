/**
 * Created by sail on 12/14/16.
 * 2D BIT
 */
public class Leet308 {
    int[][] tree, nums;
    int m, n;
    public Leet308(int[][] matrix) {
        m = matrix.length;
        n = m == 0 ? 0 : matrix[0].length;
        if (m == 0 || n == 0) return;
        tree = new int[m + 1][n + 1];
        nums = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                update(i, j, matrix[i][j]);
    }

    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int diff = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= m; i += (i & -i))
            for (int j = col + 1; j <= n; j += (j & -j))
                tree[i][j] += diff;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2 + 1, col2 + 1) - sum(row1, col2 + 1) - sum(row2 + 1, col1) + sum(row1, col1);
    }

    private int sum(int row, int col) {
        int ret = 0;
        for (int i = row; i > 0; i -= (i & -i))
            for (int j = col; j > 0; j -= (j & -j))
                ret += tree[i][j];
        return ret;
    }
}
