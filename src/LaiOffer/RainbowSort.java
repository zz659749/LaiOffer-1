package LaiOffer;

public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        // Write your solution here.
        if(array == null || array.length == 0){
            return array;
        }

        int neg = 0;
        int zero = 0;
        int one = array.length - 1;

        while (zero <= one) {
            if (array[zero] < 0) {
                swap(array, neg++, zero++);
            } else if (array[zero] == 0) {
                zero++;
            }
            else {
                swap(array, zero, one--);
            }
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] test = {1,0,0,-1,0,1,-1,0,-1};

        RainbowSort rs = new RainbowSort();
        int[] result = rs.rainbowSort(test);

        for (int i = 0; i < result.length; i++ ) {
            System.out.println(result[i]);
        }
    }
}
