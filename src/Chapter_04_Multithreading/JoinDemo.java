package Chapter_04_Multithreading;
public class JoinDemo implements Runnable {
    public void run() {
        System.out.println("Thread started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new JoinDemo());
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread finished");
    }
}