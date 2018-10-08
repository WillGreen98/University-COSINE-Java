package threadHello;

class MyThread_Race extends Thread {
    volatile static int count;

    public void run() {
        for(int i = 0; i < 1000000000; i++) {

            // Experiment 4
            // int x = count;
            // count = x + 1;

            // Experiment 5
            count++;
        }
    }
}

public class ThreadHello_Race {
    public static void main(String[] args) throws Exception {
        MyThread_Race.count = 0;

        MyThread_Race thread1 = new MyThread_Race();
        MyThread_Race thread2 = new MyThread_Race();

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();

        System.out.println("MyThread.count = " + MyThread_Race.count);
    }
}
