package thread;

class MyThread_Lock extends Thread {
    String name;
    volatile static int count;
    volatile static boolean lock = false;

    private void delay() {
        int delay = (int) (1000 * Math.random());
        try {
            Thread.sleep(delay);
        } catch(Exception ignored) {
        }
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            delay();
            int x = count; // start of critical section

            lock = true;   // claim access to critical region

            delay(); // Experiment 2 => You will now probably find that the race condition has reappeared

            while(true) {
                if(!lock) break;
            }  // wait until lock is false

            System.out.println("Thread " + name + " read " + x);
            delay();
            count = x + 1;
            System.out.println("Thread " + name + " wrote " + (x + 1)); // end of critical section

            lock = false;  // release access to critical region
        }
    }
}

public class Thread_SlowRace_Lock {
    public static void main(String[] args) throws Exception {
        MyThread_Lock.count = 0;

        MyThread_Lock thread1 = new MyThread_Lock();
        MyThread_Lock thread2 = new MyThread_Lock();

        thread1.name = "A";
        thread2.name = "B";

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();

        System.out.println("MyThread.count = " + MyThread.count);
    }
}
