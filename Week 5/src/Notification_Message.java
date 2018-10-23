class Node {
    Node(String data) {
        this.data = data;
    }

    String data;
    Node next;
}

class Writer extends Thread {
    String name;
    volatile static Queue q = new Queue();

    void longDelay() {
        long delay = (long) (4000000000L * Math.random());
        for(long i = 0; i < delay; i++) {}
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            longDelay() ;
            q.add("message " + i + " from " + name);
        }
    }
}

class Reader extends Writer {
    public void run() {
        for(int i = 0; i < 10; i++) {
            longDelay();
            String m = q.rem();
            System.out.println("Reader " + name + " read " + m);
        }
    }
}


class Queue {
    private volatile Node front, back;

    synchronized void add(String data) {
        if(front != null) {
            back.next = new Node(data);
            back = back.next;
        } else {  // queue is empty
            front = new Node(data);
            back = front;
            notifyAll();
        }
    }

    synchronized String rem() {
        try {
            while (front == null)  {  // queue is empty
                wait();
            }
            String result = front.data;
            front = front.next;
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException("badness happened: ", e);
        }
    }
}




public class Notification_Message {
    public static void main(String[] args) throws Exception {

        Writer writer1 = new Writer();
        Writer writer2 = new Writer();

        Reader reader1 = new Reader();
        Reader reader2 = new Reader();

        writer1.name = "W1";
        writer2.name = "W2";

        reader1.name = "R1";
        reader2.name = "R2";

        reader1.start();
        reader2.start();
        writer1.start();
        writer2.start();

        writer1.join();
        writer2.join();
        reader1.join();
        reader2.join();
    }
}
