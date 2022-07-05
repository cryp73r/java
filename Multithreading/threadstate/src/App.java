import java.lang.Runnable;

public class App {
    public static void main(String[] args) throws Exception {
        CustomThread ct1=new CustomThread("One");
        CustomThread ct2=new CustomThread("Two");

        ct1.thread.start();
        ct2.thread.start();

        try {
            Thread.sleep(1000);
            ct1.mysuspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            ct1.myresume();
            System.out.println("Resuming thread One");
            ct2.mysuspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            ct2.myresume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        try {
            System.out.println("Waiting for threads to finish");
            ct1.thread.join();
            ct2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}

class CustomThread implements Runnable {
    String name;
    Thread thread;
    boolean suspendFlag;

    CustomThread(String threadName) {
        name=threadName;
        thread=new Thread(this, name);
        System.out.println("New Thread: "+thread);
        suspendFlag=false;
    }

    public void run() {
        try {
            for (int i=15; i>0; i--) {
                System.out.println(name+" : "+i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name+" interrupted");
        }
        System.out.println(name+" exiting");
    }

    synchronized void mysuspend() {
        suspendFlag=true;
    }

    synchronized void myresume() {
        suspendFlag=false;
        notify();
    }
}
