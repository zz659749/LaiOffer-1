package LaiOffer;


import java.util.Arrays;

public class TestHeapify {


    public static void main(String[] args) {
        int[] data = {19, 7, 6, 1, 9, 3, 2};

        Heapify h2 = new Heapify(data);
        h2.heapify();
        System.out.println(Arrays.toString(h2.getArray()));
        h2.update(0, 20);
        System.out.println(Arrays.toString(h2.getArray()));

//        Heapify h = new Heapify(10);
//
//        h.offer(8);
//        h.offer(5);
//
//        h.offer(6);
//        h.offer(1);
//        h.offer(17);
//        h.offer(19);
//        h.offer(11);
//        System.out.println(Arrays.toString(h.getArray()));
//        System.out.println(h.size());
//        int size = h.size();
//        for (int i = 0; i< size; i++) {
//            System.out.println(h.poll());
//        }

    }
}
