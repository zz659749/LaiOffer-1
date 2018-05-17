package LaiOffer;

public class QuickSort {

        public int[] quickSort(int[] array) {

            if (array.length == 0 || array == null) {
                return array;
            }

            quickSort(array, 0, array.length - 1);
            return array;
        }

        private void quickSort(int[] array, int left, int right) {
            if (left >= right) {
                return;
            }

            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }

        private int partition(int[] array, int left, int right) {
            int pivot = left + (int)(Math.random() * (right - left));
            swap(array, pivot, right);

            int leftpt = left;
            int rightpt = right - 1;

            while (leftpt <= rightpt) {
                if (array[leftpt] < array[right]) {
                    leftpt++;
                } else if (array[rightpt] > array[right]) {
                    rightpt--;
                } else {
                    swap(array, leftpt++, rightpt--);
                }
            }
            swap(array, leftpt, right);
            return leftpt;
        }

        private void swap(int[] array, int left, int right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }


//    public static void main(String[] args) {
//        int[] test = {3,5,1,2,4,8};
//
//        QuickSort qs = new QuickSort();
//        int[] result = qs.quickSort(test);
//
//        for (int i = 0; i < result.length; i++ ) {
//            System.out.println(result[i]);
//        }
//    }

}
