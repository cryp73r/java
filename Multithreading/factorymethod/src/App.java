import java.lang.Runnable;

public class App {
    public static void main(String[] args) throws Exception {
        CustomThread ct1=CustomThread.createAndStart("One");
        System.out.println("Thread created: "+ct1);
    }
}

class CustomThread implements Runnable {
    String name;
    Thread thread;

    CustomThread(String threadName) {
        name=threadName;
        thread=new Thread(this, name);
    }

    // this is factory method
    public static CustomThread createAndStart(String threadName) {
        CustomThread ct=new CustomThread(threadName);
        ct.thread.start();
        return ct;
    }

    public void run() {
        System.out.println("Thread terminated successfully");
    }
}
