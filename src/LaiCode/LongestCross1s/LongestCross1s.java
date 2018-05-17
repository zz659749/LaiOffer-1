package LaiCode.LongestCross1s;

public class LongestCross1s {
    public int largest(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        //M[i][j] represents the largest consecutive 1s including i/j (we reuse this matrix four times)
        //global[i][j] store the min value of four M[i][j]

        int[][] M = new int[m][n];
        int[][] global = new int[m][n];

        //from left to right, outside i, inside j(0-n)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    global[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    global[i][j] = global[i][j - 1] + 1;
                }
            }
        }
        //from top to bottom, outside j, inside i(0-m)
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i == 0) {
                    M[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    M[i][j] = M[i - 1][j] + 1;
                }
                global[i][j] = Math.min(global[i][j], M[i][j]);
            }
        }
        //from right to left, outside i, inside j(n-0)
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    M[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    M[i][j] = M[i][j + 1] + 1;
                } else {
                    M[i][j] = 0;
                }
                global[i][j] = Math.min(global[i][j], M[i][j]);
            }
        }
        //from bottom to top, outside j, inside i(m-0)
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (i == m - 1) {
                    M[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    M[i][j] = M[i + 1][j] + 1;
                } else {
                    M[i][j] = 0;
                }
                global[i][j] = Math.min(global[i][j], M[i][j]);
            }
        }

        //for for to get the max
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, global[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestCross1s test = new LongestCross1s();
        int[][] matrix = {{0, 1, 0, 0}, {1, 1, 1, 1}, {0, 1, 0, 0}, {0, 1, 0, 0}};
        int res = test.largest(matrix);
        System.out.println(res);
    }
}
