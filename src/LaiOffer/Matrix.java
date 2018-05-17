package LaiOffer;


public class Matrix {
    public int[] matrix(int[][] matrix, int target) {
        int[] res = new int[] {-1, -1};
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int m = mid / col;
            int n = mid % col;

            if (matrix[m][n] == target) {
                res[0] = m;
                res[1] = n;
                return res;
            } else if (matrix[m][n] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] data = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 9, 10}};
        Matrix test = new Matrix();
        int[] res = test.matrix(data, 0);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
