package files;

import java.io.*;

public class File_Read {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("tweedle-dum.txt");

        byte buffer[] = new byte[100];

        int numBytesRead = in.read(buffer);

        // Experiment 3
        // System.out.println(new String(buffer));

        // Experiment 4
        while(numBytesRead > 0) {
            System.out.print(new String(buffer, 0, numBytesRead));
            numBytesRead = in.read(buffer);

            in.close();
        }
    }
}
