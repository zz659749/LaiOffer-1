package LaiOffer.TopKFreqWords;
import java.util.*;

public class TopK {
    public String[] topKFrequent(String[] combo, int k) {
// Write your solution here
        if (combo.length == 0) {
            return new String[0];
        }
        HashMap<String, Integer> map = new HashMap<>();
        //step1: get map of <word, count> for combo.
        for (String word : combo) {
            int count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }

        //step2: make a maxHeap;
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(map.size(), new MaxHeapComparator());

        //step3: pass map into maxHeap;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        //step4: poll out top k into a String[]
        if (maxHeap.size() < k) {
            k = maxHeap.size();
        }
        String[] res = new String[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }


        return res;


    }
}
