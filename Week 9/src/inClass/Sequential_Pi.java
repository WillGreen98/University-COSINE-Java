package inClass;

public class Sequential_Pi {
    public static void main(String[] args) {
        double sum = 0.0;
        int numSteps = 10000000;

        double step = 1.0 / (double) numSteps;
        long startTime = System.currentTimeMillis();

        for(int i = 0 ; i < numSteps ; i++) {
            double x = (i + 0.5) * step;
            sum += 4.0 / (1.0 + x * x);
        }

        double pi = step * sum;
        long endTime = System.currentTimeMillis();

        System.out.println("Value of pi: " + pi);
        System.out.println("Calculated in " + (endTime - startTime) + " milliseconds");
    }
}