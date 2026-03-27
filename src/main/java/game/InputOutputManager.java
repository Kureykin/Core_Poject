package game;

import game.frontend.GameWindow;

import javax.swing.*;

public class InputOutputManager {
    GameWindow window;
    static ComputerAnswerFinder compAnswer;

    InputOutputManager(ComputerAnswerFinder compAnswer) {
        this.compAnswer = compAnswer;
    }

    private void whoWin(String input, String compAnswer) {
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

    public String takePlayerInput(String input) {
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

    public void getStartGame() {
        window = new GameWindow(this);
        window.setVisible(true);
    }

}
