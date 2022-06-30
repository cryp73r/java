import java.lang.Runnable;

public class App {
    public static void main(String[] args) throws Exception {
        CustomThread ct1=new CustomThread("One");
        CustomThread ct2=new CustomThread("Two");
        CustomThread ct3=new CustomThread("Three");

        // start thread
        ct1.thread.start();
        ct2.thread.start();
        ct3.thread.start();

        System.out.println("Thread One is alive: "+ct1.thread.isAlive());
        System.out.println("Thread Two is alive: "+ct2.thread.isAlive());
        System.out.println("Thread Three is alive: "+ct3.thread.isAlive());

        // wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish");
            ct1.thread.join();
            ct2.thread.join();
            ct3.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}

class CustomThread implements Runnable {
    String name;
    Thread thread;

    CustomThread(String threadName) {
        name=threadName;
        thread=new Thread(this, name);
        System.out.println("New Thread: "+thread);
    }

    public void run() {
        try {
            for (int i=5; i>0; i--) {
                System.out.println(name+" : "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
        System.out.println(name+" exiting");
    }
}