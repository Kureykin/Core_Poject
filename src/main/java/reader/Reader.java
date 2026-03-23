package reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Reader {

    public List<String> readFile(String path) {
        return readFile(new File(path));
    }

    public List<String> readFile(File file) {

        try(FileReader reader = new FileReader(file)) {
            return reader.readAllLines();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
