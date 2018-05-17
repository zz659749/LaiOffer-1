package producerConsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args) {
        Q q = new Q(8);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            threads.add(new Thread(new Producer(q)));
        }
        for (int i = 0; i < 20; i++) {
            threads.add(new Thread(new Consumer(q)));
        }
        for (Thread t : threads) {
            t.start();
        }
    }
}
