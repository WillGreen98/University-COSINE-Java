package delay;

public class Delay {
    public static void main(String[] args) throws Exception {
        System.out.println("starting delay code");

        long start = System.currentTimeMillis();
        int delay = (int) (1000 * Math.random());
        Thread.sleep(delay);

        long end = System.currentTimeMillis();

        System.out.println("delay was " + (end - start) + " milliseconds.") ;
    }
}
