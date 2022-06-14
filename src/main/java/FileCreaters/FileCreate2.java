package FileCreaters;

import java.io.File;
import java.io.IOException;

public class FileCreate2 {

    File file = new File("task3.sql");

    private void create() throws IOException {
        file.createNewFile();
    }

    public File getFile() {
        return file;
    }

}
