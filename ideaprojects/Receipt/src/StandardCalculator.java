import javax.swing.*;

public class StandardCalculator {
    private JTextField screenTF;
    private JButton button1;
    private JRadioButton offRadioButton;
    private JRadioButton onRadioButton;
    private JButton ACButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton button5;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton button9;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton button13;
    private JButton a0Button;
    private JButton button15;
    private JButton button16;
    private JButton button17;
    private JPanel mainPanel;

    private void offButtons() {
        a7Button.setEnabled(false);
        a8Button.setEnabled(false);
        a9Button.setEnabled(false);
    }

    private void onButtons() {
        a7Button.setEnabled(true);
        a8Button.setEnabled(true);
        a9Button.setEnabled(true);
    }

    public StandardCalculator() {
        onRadioButton.setSelected(true);

        offRadioButton.addItemListener(offItemListener -> offButtons());
        onRadioButton.addItemListener(onItemListener -> onButtons());

        a7Button.addActionListener(a7ButtonAction -> screenTF.setText(screenTF.getText() + "7"));
        a8Button.addActionListener(a8ButtonAction -> screenTF.setText(screenTF.getText() + "8"));
        a9Button.addActionListener(a9ButtonAction -> screenTF.setText(screenTF.getText() + "9"));

        button1.addActionListener(deleteButtonAction -> {
            int length = screenTF.getText().length();
            int newLength = length - 1;
            String temp;

            if (length > 0) {
                StringBuilder backSpace = new StringBuilder(screenTF.getText());
                backSpace.deleteCharAt(newLength);
                temp = backSpace.toString();
                screenTF.setText(temp);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Standard Calculator");
        frame.setContentPane(new StandardCalculator().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
