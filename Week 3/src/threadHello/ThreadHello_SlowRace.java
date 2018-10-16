package threadHello;

class MyThread_SlowRace extends Thread {
    volatile static int count;
    String name;

    public void run() {
        for(int i = 0; i < 10; i++) {
            delay();
            int x = count;
            System.out.println("thread " + name + " read " + x);
            delay();
            count = x + 1;
            System.out.println("thread " + name + " wrote " + (x + 1));
        }
    }

    void delay() {
        int delay = (int) (1000 * Math.random());
        try {
            Thread.sleep(delay);
        } catch(Exception e) {
        }
    }
}

public class ThreadHello_SlowRace {
    public static void main(String[] args) throws Exception {
        MyThread_SlowRace.count = 0;

        MyThread_SlowRace thread1 = new MyThread_SlowRace();
        MyThread_SlowRace thread2 = new MyThread_SlowRace();

        thread1.name = "A";
        thread2.name = "B";

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();

        System.out.println("MyThread.count = " + MyThread_SlowRace.count);
    }
}
