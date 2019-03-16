package com.saz.sorter.gui;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainApp {

    public void show() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Post JDK 8 exercise");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setContentPane(new MainPanel());

            frame.pack();
            frame.setVisible(true);
        });

    }

    public static void main(String[] args) {
        new MainApp().show();
    }
}
