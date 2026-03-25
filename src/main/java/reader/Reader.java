package reader;

import java.io.*;
import java.util.List;

public class Reader {

    public List<String> readFile() throws ReaderException {

        try(InputStream is = getClass().getClassLoader().getResourceAsStream("cities")) {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                return reader.readAllLines();
            }
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }
}
