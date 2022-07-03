import java.lang.Runnable;

public class App {
    public static void main(String[] args) throws Exception {
        Q q=new Q();
        Producer producer=new Producer(q);
        Consumer consumer=new Consumer(q);

        // start the threads
        producer.thread.start();
        consumer.thread.start();

        System.out.println("Press Ctrl+c to stop");
    }
}

class Q {
    int n;
    boolean valueSet=false;

    synchronized int get() {
        while(!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        valueSet=false;
        System.out.println("Got: "+n);
        notify();
        return n;
    }

    synchronized void put(int n) {
        while(valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        valueSet=true;
        this.n=n;
        System.out.println("Put: "+n);
        notify();
    }
}

class Producer implements Runnable {
    Q q;
    Thread thread;

    Producer(Q q) {
        this.q=q;
        thread=new Thread(this, "Producer");
    }

    public void run() {
        int i=0;

        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    Thread thread;

    Consumer(Q q) {
        this.q=q;
        thread=new Thread(this, "Consumer");
    }

    public void run() {
        int i=0;

        while (true) {
            q.get();
        }
    }
}