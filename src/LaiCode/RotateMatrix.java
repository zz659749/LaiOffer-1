package LaiCode;

import java.util.Arrays;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        // Write your solution here.
        if (matrix.length == 0) {
            return;
        }
        rotateHelper(matrix, matrix.length, 0);
    }

    private void rotateHelper(int[][] matrix, int currLength, int offset) {
        //base case
        if (currLength <= 1) {
            return;
        }

        //induction rule
        //top row matrix[offset][offset + i]
        //left col matrix[currLength - 1 - offset - i][offset]
        //bottom row matrix[currLength - 1 - offset][currLength - 1 - offset - i]
        //right col matrix[offset + i][currLength - 1 - offset]
        for (int i = 0; i < currLength - 1; i++) {
            int temp = matrix[offset][offset + i];
            int temp1 = matrix[currLength - 1 + offset - i][offset];
            int temp2 = matrix[currLength - 1 + offset][currLength - 1 + offset - i];
            int temp3 = matrix[offset + i][currLength - 1 + offset];
            matrix[offset][offset + i] = matrix[currLength - 1 + offset - i][offset];
            matrix[currLength - 1 + offset - i][offset] = matrix[currLength - 1 + offset][currLength - 1 + offset - i];
            matrix[currLength - 1 + offset][currLength - 1 + offset - i] = matrix[offset + i][currLength - 1 + offset];
            matrix[offset + i][currLength - 1 + offset] = temp;
        }
        rotateHelper(matrix, currLength - 2, offset + 1);
    }

    public static void main(String[] args) {
        RotateMatrix test = new RotateMatrix();
        int[][] data = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        test.rotate(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(Arrays.toString(data[i]));

        }
    }
}
