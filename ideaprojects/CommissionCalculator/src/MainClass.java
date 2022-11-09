import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class MainClass {
    private JTextField totalSalesTF;
    private JTextField percentageTF;
    private JButton calculateButton;
    private JTextField commissionTF;
    private JButton resetButton;
    private JPanel framePanel;

    private int commission;

    MainClass() {
        resetButton.addActionListener(resetAction -> {
            percentageTF.setText("");
            totalSalesTF.setText("");
            commissionTF.setText("");
            commission = 0;
        });

        calculateButton.addActionListener(calculateAction -> {
            try {
                if (Objects.equals(percentageTF.getText(), "") || Objects.equals(totalSalesTF.getText(), ""))
                    commissionTF.setText("Fill all fields");

                else {
                    int percentage = Integer.parseInt(percentageTF.getText());
                    int totalSales = Integer.parseInt(totalSalesTF.getText());
                    commission += (totalSales * percentage);

                    commissionTF.setText(String.valueOf(commission));
                }
            } catch (Exception exception) {
                commissionTF.setText("Provide Integers");
            }
        });

        KeyListener textFieldsKeyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (commissionTF.getText().equals("Fill all fields") || commissionTF.getText().equals("Provide Integers"))
                    commissionTF.setText(String.valueOf(commission));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        percentageTF.addKeyListener(textFieldsKeyListener);
        totalSalesTF.addKeyListener(textFieldsKeyListener);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Commission Calculator");
        frame.setContentPane( new MainClass().framePanel);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
