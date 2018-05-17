package LaiCode.ArrayHopperII;

public class ArrayHopperII {
    public int minJump(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        //M[i] represents how many min jumps it need from 0 to i
        int[] M = new int[array.length];
        //base case
        M[0] = 0;
        //induction rule:
        //M[i] = (min) M[j] + array[j]			if j + array[j] >= i
        //M[i] = -1										otherwise

        for (int i = 1; i < array.length; i++) {
            M[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (M[j] == -1) {
                    break;
                }
                if (j + array[j] >= i) {
                    if (M[i] == -1) {
                        M[i] = M[j] + 1;
                    } else {
                        M[i] = Math.min(M[j] + 1, M[i]);
                    }
                }
            }
        }
        return M[array.length - 1];
    }

    public static void main(String[] args) {
        ArrayHopperII test = new ArrayHopperII();
        int[] data = new int[]{2, 1, 0, 3, 1};
        int res = test.minJump(data);
        System.out.println(res);

    }
}
