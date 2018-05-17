package producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Q {
    private Queue<Integer> q;
    private final int limit;
    public Q(int limit) {
        this.q = new LinkedList<>();
        for (int i = 0; i < limit/2; i++) {
            q.offer(0);
        }
        this.limit = limit;
    }

    public int size() {
        return q.size();
    }

    public synchronized void put(Integer ele) {

        while (q.size() == limit) {
            try {
                System.out.println("顾客们在排队");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (q.size() == 0) {
            System.out.println("面包卖完了，大师傅们快来做面包");
            notifyAll();
        }
        q.offer(ele);
    }

    public synchronized Integer take() {

        while (q.size() == 0) {
            try {
                System.out.println("大师傅们在排队");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (q.size() == limit) {
            notifyAll();
            System.out.println("面包做满了！顾客们快来买啊！");
        }
        return q.poll();
    }
}
