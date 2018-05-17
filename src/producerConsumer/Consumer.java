package producerConsumer;

public class Consumer implements Runnable{
    Q q;
    public Consumer(Q q) {
        super();
        this.q = q;
    }

    @Override
    public void run() {
        q.take();
        System.out.println("顾客买走一个面包");
        int size = q.size();
        for (int i = 0; i < size; i++) {
            System.out.print("M ");
        }
        System.out.println();
    }
}
