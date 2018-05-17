package LaiOffer;


public class BinarySearch {
    private int result = -1;
    public int binarySearch(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0 || target < array[0] || target > array[array.length - 1]) {
            return result;
        }
        binarySearch(array, 0, array.length - 1, target);
        return result;
    }

    private void binarySearch (int[] array, int left, int right, int target) {
        if (left >= right) {
            this.result = (array[left] == target) ? left : -1;
            return;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            this.result = mid;
            return;
        }
        else if (array[mid] > target){
            binarySearch(array, left, mid, target);
        }
        else {
            binarySearch(array, mid + 1, right, target);
        }
    }
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {1};
        int target = 2;
        int result = bs.binarySearch(arr, target);
        System.out.println(result);
    }
}
