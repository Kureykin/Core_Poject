package game.frontend;

import game.AppLauncher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class StartWindow {

    private final JFrame frame;

    public StartWindow() {
        frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(760, 490, 400, 100);
        frame.setContentPane(panelConfig());
        frame.setVisible(true);
        }

    private JLabel textConfig() {
        JLabel text = new JLabel("Ласкаво просимо до гри!!!");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setSize(200,60);

        return text;
    }

    private JButton buttonConfig() {
        JButton startButton = new JButton("Старт!!");
        startButton.setSize(80,30);
        startButton.setVerticalAlignment(SwingConstants.CENTER);
        startButton.setLocation(233, 15);
        startButton.addActionListener(new StartButtonAction());

        return startButton;
    }

    private JPanel panelConfig() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(textConfig());
        panel.add(buttonConfig());

        panel.setVisible(true);

        return panel;
    }

    private class StartButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);

            AppLauncher.getStartGame();
        }
    }



}
