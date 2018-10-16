package semaphore;

import java.util.concurrent.*;

class MyThread extends Thread {
    String name;
    volatile static int count;
    private static Semaphore mySemaphore = new Semaphore(1);

    private void delay() {

        int delay = (int) (1000 * Math.random());
        try {
            Thread.sleep(delay);
        } catch(Exception ignored) {
        }
    }

    public void run() {
        try {
            for(int i = 0; i < 10; i++) {
                delay();

                mySemaphore.acquire();  // P - decrease semaphore

                int x = count;
                System.out.println("Thread " + name + " read " + x);
                delay();
                count = x + 1;
                System.out.println("Thread " + name + " wrote " + (x + 1));

                mySemaphore.release();  // V - increase semaphore
            }
        } catch(Exception ignored) {}
    }
}

public class Thread_Semaphore {
    public static void main(String[] args) throws Exception {
        MyThread.count = 0;

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.name = "A";
        thread2.name = "B";

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();

        System.out.println("MyThread.count = " + MyThread.count);
    }
}
