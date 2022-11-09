package com.fourthApplication;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AppFour {
    private JPanel framePanel;
    private JToolBar northToolBar;
    private JPanel optionsPanel;
    private JRadioButton colorBkgrndRdioBtn;
    private JRadioButton plainBkgrndRdioBtn;
    private JRadioButton imageBkgrndRdioBtn;
    private JCheckBox boldFntChkBox;
    private JCheckBox italicFntChkBox;
    private JComboBox fontColorComboBox;
    private JLabel fontColorLabel;
    private JButton closeButton;
    private JScrollPane contentScrollPane;
    private JTextPane contentTextPane;
    private JPanel southPanel;
    private JLabel lineCountLabel;
    private JLabel countValueLabel;
    private JLabel fontSizeLabel;
    private JSlider fontSlider;
    private JSeparator backGrndSeparator;
    private JSeparator fontSeparator;

    private int fontSize = 12;

    public AppFour() {
        ButtonGroup rdioBtnsGrp = new ButtonGroup();

        rdioBtnsGrp.add(colorBkgrndRdioBtn);
        rdioBtnsGrp.add(plainBkgrndRdioBtn);
        rdioBtnsGrp.add(imageBkgrndRdioBtn);

        plainBkgrndRdioBtn.setSelected(true);

        closeButton.addActionListener(e -> System.exit(0));

        fontColorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String colorSelected = fontColorComboBox.getSelectedItem().toString();
                String colorSelected = String.valueOf(fontColorComboBox.getSelectedItem());

                if (colorSelected.equals("Blue")) { contentTextPane.setForeground(Color.BLUE); }
                else if (colorSelected.equals("Red")) { contentTextPane.setForeground(Color.RED); }
                else if (colorSelected.equals("Green")) { contentTextPane.setForeground(Color.GREEN); }
                else if (colorSelected.equals("Pink")) { contentTextPane.setForeground(Color.PINK); }
                else { contentTextPane.setForeground(Color.BLACK); }
            }
        });

        boldFntChkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (boldFntChkBox.isSelected()) {
                    if (italicFntChkBox.isSelected()) { contentTextPane.setFont(new Font(null, Font.BOLD | Font.ITALIC, fontSize)); }
                    else { contentTextPane.setFont(new Font(null, Font.ITALIC, fontSize)); }
                } else { contentTextPane.setFont(new Font(null, Font.PLAIN, fontSize)); }
            }
        });

        italicFntChkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (italicFntChkBox.isSelected()) {
                    if (boldFntChkBox.isSelected()) { contentTextPane.setFont(new Font(null, Font.ITALIC | Font.BOLD, fontSize)); }
                    else { contentTextPane.setFont(new Font(null, Font.ITALIC, fontSize)); }
                }
                else if (boldFntChkBox.isSelected()) { contentTextPane.setFont(new Font(null, Font.BOLD, fontSize)); }
                else { contentTextPane.setFont(new Font(null, Font.PLAIN, fontSize)); }
            }
        });

        // font slider ChangeListener
        fontSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                fontSize = source.getValue();

                if (boldFntChkBox.isSelected()) {
                    if (italicFntChkBox.isSelected()) { contentTextPane.setFont(new Font(null, Font.BOLD | Font.ITALIC, fontSize)); }
                    else { contentTextPane.setFont(new Font(null, Font.ITALIC, fontSize)); }
                } else { contentTextPane.setFont(new Font(null, Font.PLAIN, fontSize)); }

                if (italicFntChkBox.isSelected()) {
                    if (boldFntChkBox.isSelected()) { contentTextPane.setFont(new Font(null, Font.ITALIC | Font.BOLD, fontSize)); }
                    else { contentTextPane.setFont(new Font(null, Font.ITALIC, fontSize)); }
                }
                else if (boldFntChkBox.isSelected()) { contentTextPane.setFont(new Font(null, Font.BOLD, fontSize)); }
                else { contentTextPane.setFont(new Font(null, Font.PLAIN, fontSize)); }
            }
        });

        // ItemListener for radio buttons
        ItemListener radioListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (plainBkgrndRdioBtn.isSelected()) {
                    contentTextPane.setBackground(Color.WHITE);
                }
                else if (colorBkgrndRdioBtn.isSelected()) {
                    JColorChooser chooseColor = new JColorChooser();
                    Color colorPicked = JColorChooser.showDialog(null, "Pick background color", chooseColor.getColor());
                    contentTextPane.setBackground(colorPicked);
                }
            }
        };
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AppFour");
        frame.setContentPane(new AppFour().framePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 100, 850, 350);
        frame.setVisible(true);
    }
}
