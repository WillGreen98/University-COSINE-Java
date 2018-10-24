package notification;

import java.util.concurrent.*;

class MyThreadI extends Thread {
    static Semaphore flag = new Semaphore(0);  // initialize to 0

    void delay() {
        int delay = (int) (1000 * Math.random());
        try {
            Thread.sleep(delay);
        } catch(Exception ignored) {
        }
    }


    public void run() {
        try {
            delay();

            System.out.println("Thread I signalling");

            flag.release();  // V(flag)
        } catch(Exception ignored) {}
    }

}

class MyThreadJ extends MyThreadI {
    public void run() {
        try {
            delay();

            System.out.println("Thread J starting to wait");

            flag.acquire();  // P(flag)

            System.out.println("Thread J finished waiting");
        } catch(Exception ignored) {}
    }

}

public class Notification {
    public static void main(String[] args) throws Exception {
        MyThreadI thread1 = new MyThreadI();
        MyThreadJ thread2 = new MyThreadJ();

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();
    }
}