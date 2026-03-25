package reader;

import java.io.IOException;

public class ReaderException extends Exception {

    ReaderException(IOException e){
        super("Проблема зi считуванням файлу");
    }
}
