package pl.sda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorldWindow {


    private JPanel mainPanel;
    private JButton button1;
    private JTextField clickMeTextField;

    public HelloWorldWindow() {
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Kliknięto przycisk");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorldWindow");
        frame.setContentPane(new HelloWorldWindow().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(333,111,500,300);
        frame.pack();
        frame.setVisible(true);
//
    }
}
