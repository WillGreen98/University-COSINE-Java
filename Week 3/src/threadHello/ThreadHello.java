package threadHello;

class MyThread extends Thread {
    String name;

    public void run() {
        System.out.println("Hello from thread " + name);
    }
}

public class ThreadHello {
    public static void main(String[] args) throws Exception {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.name = "A";
        thread2.name = "B";

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();
    }
}
