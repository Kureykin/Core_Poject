package game.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.InputOutputManger;


public class GameWindow extends JFrame {

    private JLabel computerAnswer;
    private JTextField answerField;


    public GameWindow() {
        super("Мiста");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBounds(760, 290, 400, 400);

        super.setContentPane(panelForming());
    }

    private JLabel titleConfig() {
        JLabel gameTitle = new JLabel("МICТА");
        gameTitle.setFont(new Font("Console", Font.BOLD, 50));
        gameTitle.setSize(400,50);
        gameTitle.setHorizontalAlignment(SwingConstants.CENTER);

        return gameTitle;
    }

    private JLabel hitToInputConfig() {
        return new JLabel("Напиши iм´я мiста: ");
    }

    private JButton buttonConfig() {
        JButton button = new JButton("Надiслати");
        button.addActionListener(new SandEvent());

        return button;
    }

    private JPanel panelForming() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(20,90));
        panel.setVisible(true);
        layoutConfig(panel);

        return panel;
    }

    private Container containerConfig() {
        Container containerCenter = new Container();
        containerCenter.setLayout(new GridLayout(2,2,20,10));

        computerAnswer = new JLabel("Комп´ютер: ");
        answerField = new JTextField();

        containerCenter.add(hitToInputConfig());
        containerCenter.add(answerField);
        containerCenter.add(computerAnswer);
        containerCenter.add(buttonConfig());

        return containerCenter;
    }

    private void layoutConfig(JPanel panel) {
        JPanel leftPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        panel.add(rightPanel, BorderLayout.EAST);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(containerConfig(), BorderLayout.CENTER);
        panel.add(titleConfig(), BorderLayout.NORTH);
    }


    private class SandEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            computerAnswer.setText("Комп´ютер: " + InputOutputManger.takePlayerInput(answerField.getText()));
        }
    }
}
