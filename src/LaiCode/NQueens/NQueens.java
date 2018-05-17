package LaiCode.NQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        nqueensHelper(n, 0, comb, res);
        return res;
    }

    private void nqueensHelper(int n, int currRow, List<Integer> comb, List<List<Integer>> res) {
        //n = 1;cR =0
        if (currRow == n) {

            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!comb.contains(i) && check(comb, i)) {
                comb.add(i);

                nqueensHelper(n, currRow + 1, comb, res);
                comb.remove(comb.size() - 1);
            }
        }
    }

    private boolean check(List<Integer> comb, int candidate) {
        //x1: candidate	y1: comb.size() x2: comb.get(i) y2: i
        for (int i = 0; i < comb.size(); i++) {
            if (candidate + comb.size() == comb.get(i) + i || candidate - comb.size() == comb.get(i) - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens test = new NQueens();
        List<List<Integer>> res = test.nqueens(1);
        System.out.println(res);
    }
}
