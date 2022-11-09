import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass {
    private JTextField textField1;
    private JButton a7Button;
    private JButton a8Button;
    private JButton ACButton;
    private JButton DELButton;
    private JButton a9Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton xButton;
    private JButton button10;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton button14;
    private JButton button15;
    private JButton a0Button;
    private JButton button17;
    private JButton x10Button;
    private JButton ansButton;
    private JButton button20;
    private JPanel mainPanel;

    // constructor here
    MainClass() {
        a7Button.addActionListener(a7Action -> textField1.setText(textField1.getText() + "7"));
        a8Button.addActionListener(a7Action -> textField1.setText(textField1.getText() + "8"));
        a7Button.addActionListener(a7Action -> textField1.setText(textField1.getText() + "7"));
        a7Button.addActionListener(a7Action -> textField1.setText(textField1.getText() + "7"));
        a7Button.addActionListener(a7Action -> textField1.setText(textField1.getText() + "7"));
        a7Button.addActionListener(a7Action -> textField1.setText(textField1.getText() + "7"));
        a7Button.addActionListener(a7Action -> textField1.setText(textField1.getText() + "7"));
        a7Button.addActionListener(a7Action -> textField1.setText(textField1.getText() + "7"));
        a7Button.addActionListener(a7Action -> textField1.setText(textField1.getText() + "7"));
        a7Button.addActionListener(a7Action -> textField1.setText(textField1.getText() + "7"));
    }

    // main class here
    public static void main(String[] args) {
        JFrame frame = new JFrame("Standard Calculator");
        frame.setContentPane(new MainClass().mainPanel);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
