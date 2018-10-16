package petersonAlgorithm;

class MyThread extends Thread {
    int id;
    String name;
    volatile static int count;

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

            beginCriticalSection();

            int x = count;
            System.out.println("Thread " + name + " read " + x);
            delay();
            count = x + 1;
            System.out.println("Thread " + name + " wrote " + (x + 1));

            endCriticalSection();
        }
    }

    // Peterson's algorithm
    private volatile static int turn;
    private volatile static boolean[] interested = new boolean[2];

    private void beginCriticalSection() {
        interested[id] = true;
        int jd = 1 - id;
        turn = jd;
        while(true) {
            if (!(interested[jd] & turn == jd)) break;
        }
    }

    private void endCriticalSection() {
        interested[id] = false;
    }
}

public class Petersons_Algorithm {
    public static void main(String[] args) throws Exception {
        MyThread.count = 0;

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.name = "A";
        thread2.name = "B";

        thread1.id = 0;
        thread2.id = 1;

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("MyThread.count = " + MyThread.count);
    }
}
