import java.lang.Runnable;

public class App {
    public static void main(String[] args) throws Exception {
        CallMe target=new CallMe();
        Caller ob1=new Caller(target, "One");
        Caller ob2=new Caller(target, "Two");
        Caller ob3=new Caller(target, "Three");

        // start the thread
        ob1.thread.start();
        ob2.thread.start();
        ob3.thread.start();

        // wait for threads to finish
        try {
            ob1.thread.join();
            ob2.thread.join();
            ob3.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}

class CallMe {
    void call(String message) {
        System.out.print("["+message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String message;
    CallMe target;
    Thread thread;

    public Caller(CallMe targ, String msg) {
        target=targ;
        message=msg;
        thread=new Thread(this);
    }

    // synchronized calls to call
    public void run() {
        synchronized(target) {
            target.call(message);
        }
    }
}
