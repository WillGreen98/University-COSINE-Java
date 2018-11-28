package files;

import java.io.* ;

public class Random_Access {
    public static void main(String [] args) throws Exception {
        RandomAccessFile rand = new RandomAccessFile("/Users/will/Desktop/Programming/Java Projects/University-COSINE-Java/Week 8/tweedle-dum.txt", "r");

        byte buffer[] = new byte[100];

        // Experiment 8.1: Writes at a "random" location
        rand.seek((long)(Math.random() * 100));

        // Experiment 8.2: Write to a position beyond the current limit
        rand.seek(100000);

        rand.write(buffer);

        System.out.println(new String(buffer));
    }
}
