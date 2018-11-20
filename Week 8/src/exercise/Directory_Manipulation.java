package exercise;

import java.io.File;

public class Directory_Manipulation {
    public static void main(String[] args) {
        File file = new File("non_existing_dir/someDir");
        System.out.println(file.mkdir()); // Will yield false
        System.out.println(file.mkdirs()); // Will yield true
    }
}
