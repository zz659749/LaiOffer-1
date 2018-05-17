package LaiOffer;

public class KthSmallestInTwoSortedArray {
    public int kth(int[] a, int[] b, int k) {
        // Write your solution here
        if (a == null || a.length == 0 || b == null || b.length == 0 || a.length + b.length < k) {
            return -1;
        }

        return helper(a, b, 0, 0, k);
    }

    private int helper(int[] a, int[] b, int ap, int bp, int k) {
        //if ap, bp in range;
        if (ap > a.length) {
            return b[bp + k - 1];
        }
        if (bp > b.length) {
            return a[ap + k - 1];
        }

        if (k == 1) return Math.min(a[ap], b[bp]);
        int newk = k / 2;
        int aValue = 0;
        int bValue = 0;
        int newap = ap + newk - 1;
        int newbp = bp + newk - 1;
        if (newap >= a.length) {
            aValue = Integer.MAX_VALUE;
        }
        else if (newbp >= b.length) {
            bValue = Integer.MAX_VALUE;
        }
        else {
            aValue = a[newap];
            bValue = b[newap];
        }
        if (aValue < bValue) {
            return helper(a, b, newap, bp, k - newk);
        } else {
            return helper(a, b, ap, newbp, k - newk);
        }
    }
}
