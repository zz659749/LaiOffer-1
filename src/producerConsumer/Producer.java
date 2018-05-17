package producerConsumer;

public class Producer implements Runnable{
    Q q;
    public Producer(Q q) {
        super();
        this.q = q;
    }

    @Override
    public void run() {
        q.put(0);
        System.out.println("大师傅做了一个面包!");
        int size = q.size();
        for (int i = 0; i < size; i++) {
            System.out.print("M ");
        }
        System.out.println();
    }
}
