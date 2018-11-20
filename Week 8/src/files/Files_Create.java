package files;

import java.io.*;

public class Files_Create {
    public static void main(String[] args) throws Exception {
        File myFile = new File("tweedle-myFile.txt");
        File myOutput = new File("tweedle-myOutput.txt");

        myFile.createNewFile();
        myOutput.createNewFile();
    }
}