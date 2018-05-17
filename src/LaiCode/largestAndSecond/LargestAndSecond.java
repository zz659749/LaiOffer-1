package LaiCode.largestAndSecond;

import LaiCode.LargestSubmatrixSurroundedBy1.LargestSubmatrixSurroundedBy1;

import java.util.*;

public class LargestAndSecond {
    public int[] largestAndSecond(int[] array) {

        Map<Integer, List<Integer>> data = new HashMap<>();
        List<Integer> candIndex = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            data.put(i, new ArrayList<Integer>());
            candIndex.add(i);
        }
        return compareHelper(array, candIndex, data);
    }

    private int[] compareHelper(int[] array, List<Integer> candIndex, Map<Integer, List<Integer>> data) {
        //base case
        if (candIndex.size() == 1) {
            int[] res = new int[2];
            int largestIndex = candIndex.get(0);
            res[0] = array[largestIndex];
            res[1] = getSecond(array, largestIndex, data);
            return res;
        }

        //induction rule
        int cand1 = 0;
        int cand2 = 0;
        int pointer = 0;
        if (candIndex.size() % 2 == 0) {
            while (pointer < candIndex.size()) {
                cand1 = candIndex.get(pointer++);
                cand2 = candIndex.get(pointer);
                compare(cand1, cand2, array, candIndex, data);
            }
        } else {
            while (pointer < candIndex.size() - 1) {
                cand1 = candIndex.get(pointer++);
                cand2 = candIndex.get(pointer);
                compare(cand1, cand2, array, candIndex, data);
            }
        }
        return compareHelper(array, candIndex, data);
    }

    private void compare(int cand1, int cand2, int[] array, List<Integer> candIndex, Map<Integer, List<Integer>> data) {
        if (array[cand1] < array[cand2]) {
            compareHelper(cand2, cand1, array, candIndex, data);
        } else {
            compareHelper(cand1, cand2, array, candIndex, data);
        }
    }

    private void compareHelper(int winner, int loser, int[] array, List<Integer> candIndex, Map<Integer, List<Integer>> data) {
        candIndex.remove(Integer.valueOf(loser));
        data.remove(loser);
        List<Integer> losers = data.get(winner);
        losers.add(array[loser]);
        data.put(winner, losers);
    }

    private int getSecond(int[] array, int largestIndex, Map<Integer, List<Integer>> data) {
        List<Integer> secCand = data.get(largestIndex);
        int second = Integer.MIN_VALUE;
        for (int cand : secCand) {
            second = Math.max(second, cand);
        }
        return second;
    }

    public static void main(String[] args) {
        LargestAndSecond test = new LargestAndSecond();
        int[] testData = new int[]{3, 5, 2, 2, 1, 6, 3, 4, 5};
        int[] res = test.largestAndSecond(testData);
        System.out.println(Arrays.toString(res));
    }

}
