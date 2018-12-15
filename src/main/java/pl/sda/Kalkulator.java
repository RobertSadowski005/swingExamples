package pl.sda;

import javax.swing.*;

public class Kalkulator {
    private JPanel kalkulator;
    private JButton ClearButton;
    private JButton addingButton;
    private JButton sumButton;
    private JButton dotPeriodButton;
    private JButton a0Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton substractButton;
    private JButton divisionButton;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a1Button;
    private JButton multiplyButton;
    private JButton a6Button;
    private JButton a5Button;
    private JButton a4Button;
    private JTextField textField1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator");
        frame.setContentPane(new Kalkulator().kalkulator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
