package files;

import java.io.* ;

public class Files_Write {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("tweedle-dee.txt");
        String text = "Shoes and ships and sealing wax.";

        byte buffer[] = text.getBytes();

        out.write(buffer);
        out.close();
    }
}