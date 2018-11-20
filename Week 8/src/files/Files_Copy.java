package files;

import java.io.* ;

public class Files_Copy {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("N:/cosine/tweedle-dum.txt");
        FileOutputStream out = new FileOutputStream("N:/cosine/tweedle-dee.txt");

        byte buffer[] = new byte[100];

        int numBytesRead = in.read(buffer);

        while(numBytesRead > 0) {
            out.write(buffer, 0, numBytesRead);
            numBytesRead = in.read(buffer);
        }

        out.close();
        in.close();
    }
}