package exercise.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copier {
    private void copy(FileInputStream in, FileOutputStream out) throws FileNotFoundException, IOException {
        byte buffer [] = new byte [100] ;
        int numBytesRead = in.read(buffer) ;
        while(numBytesRead > 0) {
            out.write(buffer, 0, numBytesRead) ;
            numBytesRead = in.read(buffer) ;
        }

        out.close();
        in.close();
    }

    private void jumpInto(File file, File copyDir) throws FileNotFoundException, IOException {
        System.out.println(file.getAbsolutePath());

        if (file.isDirectory()) {
            File newCopyDir = new File(copyDir.getAbsolutePath() + "/" + file.getName());
            newCopyDir.mkdirs();
            File[] items = file.listFiles();

            for(File item : items) this.jumpInto(item, newCopyDir);
        } else if(file.isFile()) {
            FileInputStream in = new FileInputStream(file.getAbsolutePath());
            FileOutputStream out = new FileOutputStream(copyDir + file.getName());
            copy(in, out);
        }
    }

    public static void main(String[] args) throws IOException {
        Copier example = new Copier();

        File dir = new File("/Desktop/Programming/Java Projects/University-COSINE-Java/Week 8/src/exercise/copy");
        File copyDir = new File("/Desktop/Programming/Java Projects/University-COSINE-Java/Week 8/src/exercise/copy");

        System.out.println("Copy of: " + copyDir);

        example.jumpInto(dir,copyDir);

    }
}


