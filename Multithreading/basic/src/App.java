import java.lang.Runnable;

public class App {
    public static void main(String[] args) throws Exception {
        CustomThread ct1=new CustomThread("One");
        CustomThread ct2=new CustomThread("Two");
        CustomThread ct3=new CustomThread("Three");

        // start the thread
        ct1.thread.start();
        ct2.thread.start();
        ct3.thread.start();

        try {
            // wait for other threads to finish
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interuppted");
        }
        System.out.println("Main Thread Exiting");
    }
}

class CustomThread implements Runnable {
    String name;
    Thread thread;

    CustomThread(String threadName) {
        name=threadName;
        thread=new Thread(this, name);
        System.out.println("New thread: "+name);
    }

    public void run() {
        try {
            for (int i=5; i>0; i--) {
                System.out.println(name+" : "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name+ " Interrupted");
        }
        System.out.println(name+" exiting");
    }
}