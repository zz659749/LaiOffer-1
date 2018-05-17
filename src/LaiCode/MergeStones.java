package LaiCode;

public class MergeStones {
    public int minCost(int[] stones) {
        //sanity test
        if (stones.length == 1) {
            return stones[0];
        }

        //M[i][j] represents the moving cost of pile from ith to jth (all in one)
        int[][] M = new int[stones.length][stones.length];
        //base case: size = 0
        for (int i = 0; i < stones.length; i++) {
            M[i][i] = stones[i];
        }
        //induction rule
        //size = 2 - stones.length
        //M[i][j] = M[i][cut] + M[cut][j] (i <= cut <= j)
        for (int size = 1; size < stones.length; size++) {
            for (int i = 0; i < stones.length - size; i++) {
                for (int cut = i; cut < i + size; cut++) {
                    int currCut = M[i][cut] + M[cut + 1][i + size];
                    int a = M[i][cut];
                    int b = M[cut + 1][i + size];
                    int c = M[i][i+size];
                    if (M[i][i + size] == 0) {
                        M[i][i + size] = currCut;
                    } else {
                        M[i][i + size] = Math.min(M[i][i + size], currCut);
                    }
                }
            }
        }

        return M[0][M.length - 1];
    }

    public static void main(String[] args) {
        MergeStones test = new MergeStones();
        int[] data = new int[]{4,2,2,2,4};
        int cost = test.minCost(data);
        System.out.println(cost);
    }
}
