package threadHello;

class MyThread_Delay extends Thread {
    String name;

    public void run() {
        for(int i = 0; i < 10; i++) {
            delay();
            System.out.println("Hello from thread " + name);
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

public class ThreadHello_Delay {
    public static void main(String[] args) throws Exception {
        MyThread_Delay thread1 = new MyThread_Delay();
        MyThread_Delay thread2 = new MyThread_Delay();

        thread1.name = "A";
        thread2.name = "B";

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();
    }
}
