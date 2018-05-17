package LaiOffer;

public class KClosest {
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return null;
        }
        if (k == 0) {
            return new int[]{};
        }
        int closest = findClosest(array, target);
        int[] res = findK(array, target, k, closest);
        return res;
    }

    private int findClosest(int[] array, int target) {
        int left = 0;
        int mid = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.abs(target - array[left]) - Math.abs(target - array[right]) > 0 ? right : left;
    }

    private int[] findK(int[] array, int target, int k, int closest) {
        int[] res = new int[k];
        res[0] = array[closest];
        int lp = closest--;
        int rp = closest++;
        int pointer = 1;
        while (pointer < k) {
            if (lp >= 0 && rp < array.length) {
                res[pointer++] = Math.abs(target - array[lp]) - Math.abs(target - array[rp]) > 0 ? array[rp++] : array[lp--];
            } else if (lp >= 0) {
                res[pointer++] = array[lp--];
            } else {
                res[pointer++] = array[rp++];
            }
        }
        return res;
    }
}
