package LaiCode;

import java.util.*;

public class SpiralOrderTraverseII {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int M = matrix.length;
        int N = matrix[0].length;

        if (M == 0 || N == 0) {
            return res;
        }

        spiralHelper(matrix, 0, M, N, res);
        return res;
    }

    private void spiralHelper(int[][] matrix, int offset, int rowLength, int colLength, List<Integer> res) {
        //base case
        if (rowLength <= 0 || colLength <= 0) {
            return;
        } else if (rowLength == 1) {
            for(int i = offset; i < colLength + offset; i++) {
                res.add(matrix[offset][i]);
                return;
            }
        } else if (colLength == 1) {
            for (int i = offset; i < rowLength + offset; i++) {
                res.add(matrix[i][offset]);
                return;
            }
        } else {
            //top row
            for(int i = offset; i < colLength - 1 + offset; i++) {
                res.add(matrix[offset][i]);
            }
            //right col
            for (int i = offset; i < rowLength - 1 + offset; i++) {
                res.add(matrix[i][offset + colLength - 1]);
            }
            //bottom row
            for (int i = colLength - 1 + offset; i > offset; i--) {
                res.add(matrix[offset + rowLength - 1][i]);
            }
            //left col
            for (int i = rowLength - 1 + offset; i > offset; i--) {
                res.add(matrix[i][offset]);
            }
            spiralHelper(matrix, offset + 1, rowLength - 2, colLength - 2, res);
        }
    }


    public static void main(String[] args) {
        SpiralOrderTraverseII test = new SpiralOrderTraverseII();
        int[][] data = new int[][]{{1,2,3,4}};
        List<Integer> res = test.spiral(data);
        System.out.println(res.toString());

    }

}
