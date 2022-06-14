package FileCreaters;

import java.io.File;
import java.io.IOException;

public class FileCreate3 {

    File file = new File("task4.sql");

    private void create() throws IOException {
        file.createNewFile();
    }

    public File getFile() {
        return file;
    }

}
