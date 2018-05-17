package LaiCode.LargestSubmatrixSurroundedBy1;

public class LargestSubmatrixSurroundedBy1 {
    private int largestSurround1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];
        int res = 0;

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m || j == n) {
                    continue;
                }
                if (matrix[i][j] == 1) {
                    left[i][j] = left[i][j + 1] + 1;
                    up[i][j] = up[i + 1][j] + 1;
                    int maxLength = Math.min(left[i][j], up[i][j]);
                    for (int r = maxLength; r > 0; r--) {
                        if (left[i + r - 1][j] >= r && up[i][j + r - 1] >= r) {
                            res = Math.max(res, r);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println();

        print(left);
        System.out.println();
        print(up);
        return res;
    }

    public static void main(String[] args) {
        LargestSubmatrixSurroundedBy1 test = new LargestSubmatrixSurroundedBy1();
        int[][] data = new int[][]{{0, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
        test.print(data);
        int res = test.largestSurround1(data);
        System.out.println(res);
    }

    private void print(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
