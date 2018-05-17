package LaiOffer;
import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
        MergeSort a = new MergeSort();
        int [] array = new int[]{2, 0, 1, 3};
        a.mergeSort(array);
        System.out.print(Arrays.toString(array));
    }

    public int[] mergeSort(int[] array) {
        if (array == null) {
            return array;
        }
        int[] helper = new int [array.length];
        mergeSort(array, helper, 0, (array.length-1));
        return array;
    }
    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if(left == right) {
            return;
        }
        int mid = left + (right - left) / 2;

        mergeSort(array, helper,left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);

    }

    private void merge(int[] array,int[] helper, int left, int mid, int right) {
        for (int i=left; i <= right; i++) {
            helper[i] = array[i];
        }
        int pointer = left;
        int leftIndex = left;
        int rightIndex = mid+1;
        while (leftIndex <= mid && rightIndex<= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[pointer++] = helper[leftIndex++];
            }
            else {
                array[pointer++] = helper[rightIndex++];
            }

        }
        while (leftIndex <= mid) {
            array[pointer++] = helper[leftIndex++];
        }

    }

}
