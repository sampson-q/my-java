import javax.swing.*;

public class Calculator {
    private JTextField answerTextField;
    private JPanel framePanel;
    private JRadioButton onRadioButton;
    private JRadioButton offRadioButton;
    private JButton backSpaceButton;
    private JButton clearAllButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton divisionButton;
    private JButton multiplyButton;
    private JButton sixButton;
    private JButton fiveButton;
    private JButton fourButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton minusButton;
    private JButton plusButton;
    private JButton equalSignButton;
    private JButton pointButton;
    private JButton zeroButton;

    private String operand;
    private double answer;

    public Calculator() {
        oneButton.addActionListener(oneButtonAction -> {
            answerTextField.setText(answerTextField.getText() + "1");
            System.out.println();
        });

        plusButton.addActionListener(plusButtonAction -> {
            answerTextField.setText(answerTextField.getText() + "+");
        });

        twoButton.addActionListener(twoButtonAction -> {
            answerTextField.setText(answerTextField.getText() + "2");
        });

        equalSignButton.addActionListener(equalSignButtonAction -> {
            //answer = Integer.parseInt(answerTextField.getText());
            System.out.println(answerTextField.getText());
            //System.out.println(5 + 1);
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App Six");
        frame.setContentPane(new Calculator().framePanel);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
