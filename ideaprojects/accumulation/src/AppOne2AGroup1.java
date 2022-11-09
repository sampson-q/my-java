import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class AppOne2AGroup1 {
    private static JFrame frame;
    private JPanel framePanel;
    private JTextField integerTF;
    private JTextField accumulationTF;
    private int result = 0;
    private static int toggle = 0;

    public AppOne2AGroup1() {
        integerTF.addActionListener(e -> {
            try {
                int number = Integer.parseInt(integerTF.getText());
                result += number;
                accumulationTF.setText(String.valueOf(result));
                integerTF.setText("");
            } catch (Exception m) {
                accumulationTF.setText("Integer Required!");
                integerTF.setText("");
            }
        });
    }

    public static JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar(); // creating the menu bar

        // get the icon ready
        ImageIcon img = new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\AppOne2AGroup1\\src\\confused.png");

        // create the 'File' menu
        JMenu fileMenu = new JMenu("File");

        // create the menuItems for 'File' menu
        JMenuItem newItem = new JMenuItem("New", img); // creating the 'New' item
        JMenuItem saveAsItem = new JMenuItem("Save As"); // creating the 'Save As' item
        JMenuItem exitItem = new JMenuItem("Exit"); // creating the 'Exit' item

        // add the 'FileMenuItems' to the 'FileMenu'
        fileMenu.add(newItem); // adding the 'New' item to the 'File' menu
        fileMenu.add(saveAsItem); // adding the 'Save As' item to the 'File' menu
        fileMenu.addSeparator(); // adding the separator to the 'File' menu
        fileMenu.add(exitItem); // adding the 'Exit' item to the 'File' menu

        // create the 'Edit' menu
        JMenu editMenu = new JMenu("Edit");

        // create the menuItems for 'Edit' menu
        JMenuItem copyItem = new JMenuItem("Copy"); // creating the 'Copy' item
        JMenuItem pasteItem = new JMenuItem("Paste"); // creating the 'Paste' item

        // create 'Find' menu in 'Edit' menu
        JMenu findMenu = new JMenu("Find"); // creating another menu (Find) as an item in 'Edit' menu

        // create 'Find' menuItems
        JMenuItem replaceItem = new JMenuItem("Replace", img); //creating the 'Find' menu item
        JMenuItem findItem = new JMenuItem("Find"); // creating the 'Find' menu item

        // continue to create the rest of the 'Edit' menuItem
        JMenuItem preferenceItem = new JMenuItem("Preferences");

        // adding all elements of the 'Edit' menu item to the 'Edit' menu
        editMenu.add(copyItem); // adding the 'Copy' item to the 'Edit' menu
        editMenu.add(pasteItem); // adding the 'Paste' item to the 'Edit' menu
        editMenu.addSeparator(); // adding the separator to the 'Edit' menu

        // adding elements of the 'Find' menu to the 'Find' menu
        findMenu.add(findItem); // adding the 'Find' item to the 'Find' menu
        findMenu.add(replaceItem); // adding the 'Replace' item to the 'Find' menu

        // continue adding the rest of 'Edit' menu elements
        editMenu.add(findMenu); // adding the 'Find' menu to the 'Edit' menu
        editMenu.add(preferenceItem); // adding the 'Preferences' item to the 'Edit' menu

        // create the 'Help' menu
        JMenu helpMenu = new JMenu("Help"); // creating the 'Help' menu

        // creating the menuItems for 'Help' menu
        JMenuItem aboutItem = new JMenuItem("About"); // creating the 'About' item for the 'Help' menu

        // adding the 'Help' menu elements to the 'Help' menu
        helpMenu.add(aboutItem); // adding the 'About' item to the 'Help' menu

        // adding all the menus to the menu bar
        menuBar.add(fileMenu); // adding the 'File' menu to the menu bar
        menuBar.add(editMenu); // adding the 'Edit' menu to the menu bar
        menuBar.add(helpMenu); // adding the 'Help' menu to the menu bar

        // creating an ActionListener to handle the click on the 'Exit' menuItem in the 'File' menu
        exitItem.addActionListener(e -> System.exit(0));

        // creating an ActionListener to handle the click on the 'About' menuItem in the 'Help' menu
        aboutItem.addActionListener(e -> {
            JWindow copyRightWindow = new JWindow(frame);
            JPanel copyRightPanel = new JPanel();
            JLabel copyRightLabel = new JLabel("Copyright \251Group1, 2A");

            copyRightPanel.add(copyRightLabel);
            copyRightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            copyRightWindow.add(copyRightPanel);
            copyRightWindow.setLocationRelativeTo(null);
            copyRightWindow.setSize(160, 60);
            copyRightWindow.setVisible(true);

            copyRightWindow.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //copyRightWindow.setVisible(false);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    copyRightWindow.setVisible(false);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    //copyRightWindow.setVisible(false);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    //copyRightWindow.setVisible(false);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //copyRightWindow.setVisible(false);
                }
            });
        });

        // setting mnemonics for 'File' menu && 'File' menuItems
        fileMenu.setMnemonic(KeyEvent.VK_F);
        newItem.setMnemonic(KeyEvent.VK_N);
        saveAsItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_X);

        // setting mnemonics for 'Edit' menu && 'Edit' menuItems
        editMenu.setMnemonic(KeyEvent.VK_E);
        copyItem.setMnemonic(KeyEvent.VK_C);
        pasteItem.setMnemonic(KeyEvent.VK_P);
        findItem.setMnemonic(KeyEvent.VK_F);
        findMenu.setMnemonic(KeyEvent.VK_F);
        replaceItem.setMnemonic(KeyEvent.VK_R);
        preferenceItem.setMnemonic(KeyEvent.VK_P);

        // settings mnemonics for 'Help' menu && 'Help' menuItems
        helpMenu.setMnemonic(KeyEvent.VK_H);
        aboutItem.setMnemonic(KeyEvent.VK_A);

        // setting accelerators for 'File' menuItems
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));

        // setting accelerators for 'Edit' menuItems
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        findItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        replaceItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        preferenceItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));

        // setting accelerators for 'Help' menuItem
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_MASK));

        // setting the value of this function to the menu bar
        return menuBar;
    }

    public static void main(String[] args) {
        frame = new JFrame("AppOne2AGroup1");
        frame.setContentPane(new AppOne2AGroup1().framePanel);
        frame.setSize(550, 150);
        frame.setJMenuBar(createMenuBar());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
