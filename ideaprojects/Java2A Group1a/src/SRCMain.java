import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class SRCMain {
    private JPanel mainPanel;
    private JPanel homePanel;
    private JPanel resultsPanel;
    private JPanel helpPanel;
    private JPanel addPanel;

    private static JFrame frame;

    // creating the menus
    JMenu fileMenu = new JMenu("File"); // creating the file menu
    JMenu displayMenu = new JMenu("Display"); // creating the display menu
    JMenu helpMenu = new JMenu("Help"); // creating the help menu

    JMenuItem exitItem = new JMenuItem("🚪 Exit"); // creating the exit item
    JMenuItem addItem = new JMenuItem("➕ Add"); // creating the add item

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar(); // creating the menu bar

        // creating the menu items


        JMenuItem displayItem = new JMenuItem("Display"); // creating the display item

        // adding 'file' menu items to 'file' menu
        fileMenu.add(addItem);
        fileMenu.add(exitItem);

        // adding 'display' menu items to 'display' menu items
        displayMenu.add(displayItem);

        // adding the menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(displayMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }

    void swapPanels(JPanel panel0, JPanel panel1) {
        panel0.setVisible(false);
        panel1.setVisible(true);
    }

    SRCMain() {
        resultsPanel.setVisible(false);
        helpPanel.setVisible(false);
        addPanel.setVisible(false);

        // setting up the candidates
        Candidate presCand0 = new Candidate("Victor Nana", new ImageIcon()); // first presidential candidate
        Candidate presCand1 = new Candidate("Jamal DripLord", new ImageIcon()); // second presidential candidate

        Candidate secCand0 = new Candidate("Osborn Osborn", new ImageIcon()); // first secretarial candidate
        Candidate secCand1 = new Candidate("Oye Oye", new ImageIcon()); // second secretarial candidate
        Candidate secCand2 = new Candidate("Paul George", new ImageIcon()); // third secretarial candidate

        Candidate treCand0 = new Candidate("Someone Someone0", new ImageIcon()); // first treasure candidate
        Candidate treCand1 = new Candidate("Someone Someone1", new ImageIcon()); // second treasure candidate

        // setting up the portfolios
        Portfolio SRCPresident = new Portfolio("SRC President"); // presidential portfolio
        Portfolio SRCSecretary = new Portfolio("SRC Secretary"); // secretarial portfolio
        Portfolio SRCTreasurer = new Portfolio("SRC Treasurer"); // treasurer portfolio

        exitItem.addActionListener(exitItemAction -> {
            System.exit(3);
        });

        addItem.addActionListener(addItemAction -> {
            resultsPanel.setVisible(true);
            homePanel.setVisible(false);
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("ATU Electoral Commission");
        frame.setJMenuBar(new SRCMain().createMenuBar());
        frame.setContentPane(new SRCMain().mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}