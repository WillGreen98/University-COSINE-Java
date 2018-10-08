package exercise;

class MyThread extends Thread {
    volatile static Queue q;
    String name;

    public void run() {
        for(int i = 0; i < 1000000; i++) {
            q.add("message " + i);
            System.out.println("Thread " + name + " added message " + i);
        }
    }
}

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
    }
}


class Queue {
    volatile Node front, back;

    public void add(String data) {
        if(front != null) {
            back.next = new Node(data);
            back = back.next;
        } else {
            front = new Node(data);
            back = front;
        }
    }

    public String rem() {
        String result = null;
        if(front != null)  {
            result = front.data;
            front   = front.next;
        }
        return result;
    }
}

public class QueueRace {
    public static void main(String[] args) throws Exception {
        MyThread.q = new Queue();

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
