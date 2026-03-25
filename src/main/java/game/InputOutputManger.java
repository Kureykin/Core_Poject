package game;

import game.frontend.GameWindow;

import javax.swing.*;

public class InputOutputManger {
    static GameWindow window;
    static ComputerAnswerFinder compAnswer = new ComputerAnswerFinder();

    private static void whoWin(String input, String compAnswer) {
        if(input.equals("здаюсь")) {
            JOptionPane.showMessageDialog(null, "Ви програли");
            window.dispose();
            System.exit(0);
        } else if (compAnswer.equals("Немає назви")) {
            JOptionPane.showMessageDialog(null, "Ви виграли");
            window.dispose();
            System.exit(0);
        }
    }

    public static String takePlayerInput(String input) {
        String computerAnswer;
        if(!input.isBlank()) {
            computerAnswer = compAnswer.computersTurn(input.toUpperCase().strip());

            whoWin(input, computerAnswer);
        }
        else {
            JOptionPane.showMessageDialog(null, "Write your name of city");
            computerAnswer = "";
        }

        return computerAnswer;
    }

    public static void getStartGame() {
        window = new GameWindow();
        window.setVisible(true);
    }

}
