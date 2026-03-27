package game;

import game.frontend.*;
import reader.Reader;

import javax.swing.*;

public class AppLauncher {

    public static void main(String[] args) {
            Reader reader = new Reader();
            ComputerAnswerFinder finder = new ComputerAnswerFinder(reader);
            InputOutputManager manager = new InputOutputManager(finder);
            new StartWindow(manager);
    }
}
