package inClass;

public class Parallel_Pi extends Thread {
    double sum;
    int begin, end;

    static int numSteps = 1000000;
    static double step = 1.0 / (double) numSteps;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        Parallel_Pi thread1 = new Parallel_Pi();
        Parallel_Pi thread2 = new Parallel_Pi();
        Parallel_Pi thread3 = new Parallel_Pi();
        Parallel_Pi thread4 = new Parallel_Pi();

        thread1.begin = 0;
        thread2.begin = numSteps / 2;
        thread3.begin = numSteps;
        thread4.begin = numSteps;

        thread1.end = numSteps / 2;
        thread2.end = numSteps;
        thread3.end = numSteps;
        thread4.end = numSteps;

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        double pi = step * (thread1.sum + thread2.sum + thread3.sum + thread4.sum);

        long endTime = System.currentTimeMillis();

        System.out.println("Value of pi: " + pi);
        System.out.println("Calculated in " + (endTime - startTime) + " milliseconds");
    }

    public void run() {
        sum = 0.0;

        for(int i = begin ; i < end ; i++) {
            double x = (i + 0.5) * step;
            sum += 4.0 / (1.0 + x * x);
        }
    }
}