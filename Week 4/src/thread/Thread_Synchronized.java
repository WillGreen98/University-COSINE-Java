package thread;

class MyThread_Synchronized extends Thread {
    String name;
    static volatile int count;

    private synchronized static void increment() {
        int x = count;
        count = x + 1;
    }

    public void run() {
        for(int i = 0; i < 100000000; i++) {
            increment();
        }
    }
}

public class Thread_Synchronized {
    public static void main(String[] args) throws Exception {
        MyThread_Synchronized.count = 0;

        MyThread_Synchronized thread1 = new MyThread_Synchronized();
        MyThread_Synchronized thread2 = new MyThread_Synchronized();

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();

        System.out.println("MyThread.count = " + MyThread_Synchronized.count);
    }
}
