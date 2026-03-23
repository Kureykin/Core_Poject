package game.frontend;

import game.AppLauncher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class StartWindow {

    private final JFrame frame = new JFrame("Welcome");

    public StartWindow() {
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(760, 490, 400, 100);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel text = new JLabel("Welcome to the game!!!");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setSize(200,60);
        JButton startButton = new JButton("Start!!");
        startButton.setSize(80,30);
        startButton.setVerticalAlignment(SwingConstants.CENTER);
        startButton.setLocation(233, 15);
        startButton.addActionListener(new StartButtonAction());

        panel.add(text);
        panel.add(startButton);

        panel.setVisible(true);

        frame.setContentPane(panel);
        frame.setVisible(true);
        }

    private class StartButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);

            AppLauncher.getStartGame();
        }
    }



}
