import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;

public class SRCMain {

    // setting presidential candidates
    public static Candidate presidentCandidate0 = new Candidate("White Barbie", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\pres0Image.PNG"));
    public static Candidate presidentCandidate1 = new Candidate("Martin Dukes", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\pres1Image.PNG"));

    // setting secretarial candidates
    public static Candidate secretaryCandidate0 = new Candidate("Amos Blue", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\sec0Image.PNG"));
    public static Candidate secretaryCandidate1 = new Candidate("Wallace Brown", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\sec1Image.PNG"));
    public static Candidate secretaryCandidate2 = new Candidate("Latest Candid", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\sec0Image.PNG"));

    // setting treasurer candidates
    public static Candidate treasurerCandidate0 = new Candidate("James Caster", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\tre0Image.PNG"));
    public static Candidate treasurerCandidate1 = new Candidate("Spencer James", new ImageIcon("C:\\Users\\Hash\\IdeaProjects\\SRCVoteAPP\\src\\images\\tre1Image.PNG"));

    // setting presidential office
    public static Portfolio presidentialOffice = new Portfolio("SRC President");
    public static Portfolio secretarialOffice = new Portfolio("SRC Secretary");
    public static Portfolio treasurerOffice = new Portfolio("SRC Treasurer");

    private JPanel mainPane;
    private JCheckBox SRCPresidentCheckBox;
    private JCheckBox SRCSecretaryCheckBox;
    private JCheckBox SRCTreasurerCheckBox;
    private JButton toCandidatePane;
    private JPanel candidatesPane;
    private JPanel selectVoteOfficePane;
    private JLabel candidate0Icon;
    private JLabel candidate0Name;
    private JCheckBox candidate0Box;
    private JCheckBox candidate1Box;
    private JLabel candidate1Icon;
    private JLabel candidate1Name;
    private JButton backButton;
    private JButton nextButton;
    private JPanel confirmVotePane;
    private JLabel candidateNameConfirm;
    private JLabel candidateOfficeConfirm;
    private JButton cancelButton;
    private JButton voteButton;
    private JPanel voteAlertPane;
    private JLabel voteAlertMessage;
    private JButton OKButton;
    private JLabel alertImage;
    private JLabel confirmCandidateImage;
    private JPanel votingResultsPane;

    private JLabel can0VoteIcon;
    private JLabel can1VoteIcon;
    private JLabel can2VoteIcon;
    private JLabel can3VoteIcon;
    private JLabel can4VoteIcon;
    private JLabel can5VoteIcon;
    private JLabel can0VoteName;
    private JLabel can1VoteName;
    private JLabel can2VoteName;
    private JLabel can3VoteName;
    private JLabel can4VoteName;
    private JLabel can5VoteName;
    private JLabel can0VoteCount;
    private JLabel can1VoteCount;
    private JLabel can2VoteCount;
    private JLabel can3VoteCount;
    private JLabel can4VoteCount;
    private JLabel can5VoteCount;

    private JCheckBox candidate2Box;
    private JLabel candidate2Icon;
    private JLabel candidate2Name;
    private JLabel can6VoteCount;
    private JLabel can6VoteName;
    private JLabel can6VoteIcon;
    private JPanel helpPane;
    private JPanel addPortfolioPane;
    private JCheckBox userSidePortfolio0;
    private JCheckBox userSidePortfolio1;
    private JTextField portfolioName;
    private JButton addPortfolioButton;
    private JLabel errorLabel;
    private JButton viewAddedPortfolioButton;
    private JPanel addedPortFolioPane;
    private JCheckBox addedPortFolio0;
    private JCheckBox addedPortFolio1;
    private JCheckBox addedPortFolio2;
    private JButton button1;

    private JCheckBox selectedOffice;
    private JCheckBox selectedCandid;
    private String selectedCandidName;
    private JFrame confirmVoteFrame;
    private JFrame voteAlertFrame;
    private static JFrame frame;
    private JPanel currentPanel;

    private ImageIcon candidConfirmIcon;

    void enableCheckBoxes(int state, JCheckBox...jCheckBoxes) {
        for (JCheckBox checkBox : jCheckBoxes) {
            if (state == 0)
                checkBox.setEnabled(false);
            else
                checkBox.setEnabled(true);
        }
    }

    void enableLabels(int state, JLabel...jLabels) {
        for (JLabel jLabel : jLabels) {
            if (state == 0)
                jLabel.setEnabled(false);
            else
                jLabel.setEnabled(true);
        }
    }

    void selectCheckBoxes(int state, JCheckBox...jCheckBoxes) {
        for (JCheckBox checkBox : jCheckBoxes) {
            if (state == 0)
                checkBox.setSelected(false);
            else
                checkBox.setSelected(true);
        }
    }

    void enableButtons(int state, JButton...jButtons) {
        for (JButton jButton : jButtons) {
            if (state == 0)
                jButton.setEnabled(false);
            else
                jButton.setEnabled(true);
        }
    }

    void setCandidatesForVote(Candidate candidate0, Candidate candidate1, Candidate...candidates) {
        // setting the details of first candidate
        candidate0Icon.setIcon(candidate0.getCandidateImage()); // setting the icon of first candidate
        candidate0Name.setText(candidate0.getCandidateName()); // setting the name of the first candidate

        // setting the deatils of second candidate
        candidate1Icon.setIcon(candidate1.getCandidateImage()); // setting the icon of second candidate
        candidate1Name.setText(candidate1.getCandidateName()); // setting the name of the second candidate

        if (selectedOffice == SRCSecretaryCheckBox) {
            if (candidates.length != 0) {
                for (Candidate candidate : candidates) {
                    candidate2Icon.setIcon(candidate.getCandidateImage());
                    candidate2Name.setText(candidate.getCandidateName());
                }
                candidate2Box.setVisible(true);
                candidate2Name.setVisible(true);
                candidate2Icon.setVisible(true);
            }
        } else {
            candidate2Box.setVisible(false);
            candidate2Name.setVisible(false);
            candidate2Icon.setVisible(false);
        }
    }

    void swapView(JPanel panel0, JPanel...otherPanels) {
        panel0.setVisible(true);

        for (JPanel panel : otherPanels) {
            panel.setVisible(false);
        }
    }

    void confirmVote() {
        confirmVotePane.setVisible(true);

        confirmVoteFrame = new JFrame("Confirm Vote");
        candidateOfficeConfirm.setText(selectedOffice.getText() + "?");
        candidateNameConfirm.setText(selectedCandidName);
        confirmCandidateImage.setIcon(candidConfirmIcon);
        confirmVoteFrame.setContentPane(confirmVotePane);
        confirmVoteFrame.setSize(400, 200);
        confirmVoteFrame.setLocationRelativeTo(null);
        confirmVoteFrame.setVisible(true);

        confirmVoteFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
//                System.out.println("Window Opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
//                System.out.println("Window Closing");
            }

            @Override
            public void windowClosed(WindowEvent e) {
//                System.out.println("Window Closed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
//                System.out.println("Window Iconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
//                System.out.println("Window Deiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
//                System.out.println("Window Activated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //System.out.println("Window Deactivated");
                enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
                enableCheckBoxes(1, candidate0Box, candidate1Box, candidate2Box);
                enableButtons(1, backButton);
                selectCheckBoxes(0, candidate0Box, candidate1Box, candidate2Box);
            }
        });
    }

    void alertVoteSuccess() {
        voteAlertPane.setVisible(true);

        voteAlertFrame = new JFrame("Vote Success");
        voteAlertMessage.setText("Successfully Voted " + selectedCandidName + " as " + selectedOffice.getText() + "!");
        alertImage.setIcon(candidConfirmIcon);
        voteAlertFrame.setContentPane(voteAlertPane);
        voteAlertFrame.setSize(550, 190);
        voteAlertFrame.setAlwaysOnTop(true);
        voteAlertFrame.setLocationRelativeTo(null);
        voteAlertFrame.setVisible(true);
    }

    void viewVoteResults() {
        votingResultsPane.setVisible(true);

        JFrame viewResultsFrame = new JFrame("Voting Results");
        can0VoteIcon.setIcon(presidentCandidate0.getCandidateImage());
        can1VoteIcon.setIcon(presidentCandidate1.getCandidateImage());
        can2VoteIcon.setIcon(secretaryCandidate0.getCandidateImage());
        can3VoteIcon.setIcon(secretaryCandidate1.getCandidateImage());
        can4VoteIcon.setIcon(treasurerCandidate0.getCandidateImage());
        can5VoteIcon.setIcon(treasurerCandidate1.getCandidateImage());
        can6VoteIcon.setIcon(secretaryCandidate2.getCandidateImage());

        can0VoteName.setText(presidentCandidate0.getCandidateName());
        can1VoteName.setText(presidentCandidate1.getCandidateName());
        can2VoteName.setText(secretaryCandidate0.getCandidateName());
        can3VoteName.setText(secretaryCandidate1.getCandidateName());
        can4VoteName.setText(treasurerCandidate0.getCandidateName());
        can5VoteName.setText(treasurerCandidate1.getCandidateName());
        can6VoteName.setText(secretaryCandidate2.getCandidateName());

        can0VoteCount.setText(String.valueOf(presidentCandidate0.getNumberOfVotes()));
        can1VoteCount.setText(String.valueOf(presidentCandidate1.getNumberOfVotes()));
        can2VoteCount.setText(String.valueOf(secretaryCandidate0.getNumberOfVotes()));
        can3VoteCount.setText(String.valueOf(secretaryCandidate1.getNumberOfVotes()));
        can4VoteCount.setText(String.valueOf(treasurerCandidate0.getNumberOfVotes()));
        can5VoteCount.setText(String.valueOf(treasurerCandidate1.getNumberOfVotes()));
        can6VoteCount.setText(String.valueOf(secretaryCandidate2.getNumberOfVotes()));

        viewResultsFrame.setContentPane(votingResultsPane);
        viewResultsFrame.setSize(300, 530);
        viewResultsFrame.setAlwaysOnTop(true);
        viewResultsFrame.setLocationRelativeTo(null);
        viewResultsFrame.setVisible(true);
    }

    void showCheckBoxes(int state, JCheckBox...jCheckBoxes) {
        for (JCheckBox checkBox : jCheckBoxes) {
            if (state == 0)
                checkBox.setVisible(false);
            else
                checkBox.setVisible(true);
        }
    }

    void clearLabels(JLabel...jLabels) {
        for (JLabel label : jLabels) {
            label.setIcon(null);
            label.setText("");
        }
    }

    void backToHome() {
        enableCheckBoxes(1, SRCPresidentCheckBox, SRCSecretaryCheckBox, SRCTreasurerCheckBox, candidate0Box, candidate1Box, candidate2Box, userSidePortfolio0, userSidePortfolio1);
        selectCheckBoxes(0, SRCPresidentCheckBox, SRCSecretaryCheckBox, SRCTreasurerCheckBox, candidate0Box, candidate1Box, candidate2Box, userSidePortfolio0, userSidePortfolio1);
        enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
        clearLabels(candidate1Name, candidate0Icon, candidate1Icon, candidate2Name, candidate2Icon);
        showCheckBoxes(1, candidate0Box, candidate1Box);
        swapView(selectVoteOfficePane, candidatesPane);
        toCandidatePane.setEnabled(false);
        nextButton.setEnabled(false);
    }

    void viewHelpPane() {
        helpPane.setVisible(true);

        JFrame helpPaneFrame = new JFrame("Java2A Group 1");
        helpPaneFrame.setContentPane(helpPane);
        helpPaneFrame.setSize(450, 550);
        helpPaneFrame.setLocationRelativeTo(null);
        helpPaneFrame.setVisible(true);
    }

    void addPortfolio(JCheckBox jCheckBox, Portfolio portfolio) {
        jCheckBox.setVisible(true);
        try {
            jCheckBox.setText(portfolio.getPortfolioName());
        }
        catch (Exception exception) {
            String ErrorMessage = String.valueOf(exception);
        }

    }

    JMenuBar MenuBar() {

        JMenuBar menuBar = new JMenuBar(); // creating menu bar

        // creating menu
        JMenu fileMenu = new JMenu("File"); // creating the 'File' menu
        JMenu displayMenu = new JMenu("Display"); // creating the 'Display' menu
        JMenu helpMenu = new JMenu("Help"); // creating the 'Help' menu

        // creating menu items
        JMenuItem addItem = new JMenuItem("Add"); // creating the 'Add' menu item
        JMenuItem exitItem = new JMenuItem("Exit"); // creating the 'Exit' menu item

        // adding menu items to various menu
        fileMenu.add(addItem); // adding 'Add' menu item to 'File' menu
        fileMenu.add(exitItem); // adding 'Exit' menu item to 'File' menu

        // adding various menu to menu bar
        menuBar.add(fileMenu); // adding 'File' menu to 'Menu Bar'
        menuBar.add(displayMenu); // adding 'Display' menu to 'Menu Bar'
        menuBar.add(helpMenu); // adding 'Help' menu to 'Menu Bar'

        // adding action listener to exitItem
        exitItem.addActionListener(exitItemAction -> {
            System.exit(3);
        });

        // creating menu listener for 'Help' and 'Display' menu
        MenuListener menuListener = new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {

            }

            @Override
            public void menuDeselected(MenuEvent e) {
                if (e.getSource() == displayMenu) {
                    viewVoteResults();
                }
                else if (e.getSource() == helpMenu) {
                    viewHelpPane();
                }
            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        };


        MouseListener menuMouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == displayMenu)
                    swapView(votingResultsPane, addedPortFolioPane, addPortfolioPane, helpPane, selectVoteOfficePane, candidatesPane);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

        //displayMenu.addMenuListener(menuListener);
        displayMenu.addMouseListener(menuMouseListener);
        helpMenu.addMenuListener(menuListener);

        // adding action listener to addItem
        addItem.addActionListener(addItemAction -> {
            //displayAddPanel();
            swapView(addPortfolioPane,candidatesPane, selectVoteOfficePane);
        });

        return menuBar;
    }

    SRCMain() {

        candidatesPane.setVisible(false);
        confirmVotePane.setVisible(false);
        voteAlertPane.setVisible(false);
        votingResultsPane.setVisible(false);
        candidate2Box.setVisible(false);
        helpPane.setVisible(false);
        addedPortFolioPane.setVisible(false);
        addPortfolioPane.setVisible(false);
        frame.setJMenuBar(MenuBar());

        // setting the office checkboxes to the office names we set previously
        addPortfolio(SRCPresidentCheckBox, presidentialOffice);
        addPortfolio(SRCSecretaryCheckBox, secretarialOffice);
        addPortfolio(SRCTreasurerCheckBox, treasurerOffice);

        ActionListener SRCOffice = SRCOfficeCheckBoxes -> {
            if (SRCPresidentCheckBox.isSelected()) {
                enableCheckBoxes(0, SRCSecretaryCheckBox, SRCTreasurerCheckBox);
                selectedOffice = SRCPresidentCheckBox;
            }

            else if (SRCSecretaryCheckBox.isSelected()) {
                enableCheckBoxes(0, SRCPresidentCheckBox, SRCTreasurerCheckBox);
                selectedOffice = SRCSecretaryCheckBox;
            }

            else if (SRCTreasurerCheckBox.isSelected()) {
                enableCheckBoxes(0, SRCPresidentCheckBox, SRCSecretaryCheckBox);
                selectedOffice = SRCTreasurerCheckBox;
            }

            else {
                enableCheckBoxes(1, SRCPresidentCheckBox, SRCSecretaryCheckBox, SRCTreasurerCheckBox);
                selectCheckBoxes(0, SRCPresidentCheckBox, SRCSecretaryCheckBox, SRCTreasurerCheckBox);
                selectedOffice = null;
            }

            toCandidatePane.setEnabled(SRCPresidentCheckBox.isSelected() || SRCSecretaryCheckBox.isSelected() || SRCTreasurerCheckBox.isSelected());
        };

        SRCPresidentCheckBox.addActionListener(SRCOffice);
        SRCSecretaryCheckBox.addActionListener(SRCOffice);
        SRCTreasurerCheckBox.addActionListener(SRCOffice);

        toCandidatePane.addActionListener(toCandidatePaneBtn -> {
               if (selectedOffice == SRCPresidentCheckBox) {
                   setCandidatesForVote(presidentCandidate0, presidentCandidate1);
               }

               else if (selectedOffice == SRCSecretaryCheckBox) {
                   setCandidatesForVote(secretaryCandidate0, secretaryCandidate1, secretaryCandidate2);
               }

               else if (selectedOffice == SRCTreasurerCheckBox) {
                   setCandidatesForVote(treasurerCandidate0, treasurerCandidate1);
               }

               else if (selectedOffice == userSidePortfolio0 || selectedOffice == userSidePortfolio1) {
                   showCheckBoxes(0, candidate0Box, candidate1Box, candidate2Box);
                   candidate0Name.setText("No applicant here");
               }

            swapView(candidatesPane, selectVoteOfficePane);
        });

        backButton.addActionListener(backAction -> {
            backToHome();
        });

        ActionListener selectedCandidateAction = selectedCandidate -> {
            if (candidate0Box.isSelected()) {
                selectedCandid = candidate0Box;
                selectedCandidName = candidate0Name.getText();
                candidConfirmIcon = (ImageIcon) candidate0Icon.getIcon();
                enableLabels(0, candidate1Name, candidate2Name);
                enableCheckBoxes(0, candidate1Box, candidate2Box);
            }

            else if (candidate1Box.isSelected()) {
                selectedCandid = candidate1Box;
                selectedCandidName = candidate1Name.getText();
                candidConfirmIcon = (ImageIcon) candidate1Icon.getIcon();
                enableLabels(0, candidate0Name, candidate2Name);
                enableCheckBoxes(0, candidate0Box, candidate2Box);
            }

            else if (candidate2Box.isSelected()) {
                selectedCandid = candidate2Box;
                selectedCandidName = candidate2Name.getText();
                candidConfirmIcon = (ImageIcon) candidate2Icon.getIcon();
                enableLabels(0, candidate0Name, candidate1Name);
                enableCheckBoxes(0, candidate0Box, candidate1Box);
            }

            else {
                selectedCandid = null;
                selectedCandidName = null;
                candidConfirmIcon = null;
                enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
                enableCheckBoxes(1, candidate0Box, candidate1Box, candidate2Box);
            }

            nextButton.setEnabled(candidate0Box.isSelected() || candidate1Box.isSelected() || candidate2Box.isSelected());
        };

        candidate0Box.addActionListener(selectedCandidateAction);
        candidate1Box.addActionListener(selectedCandidateAction);
        candidate2Box.addActionListener(selectedCandidateAction);

        nextButton.addActionListener(nextButtonAction -> {
            enableLabels(0, candidate0Name, candidate1Name, candidate2Name);
            enableCheckBoxes(0, candidate0Box, candidate1Box, candidate2Box);
            enableButtons(0, backButton, nextButton);
            confirmVote();
        });

        cancelButton.addActionListener(cancelVoteAction -> {
            enableLabels(1, candidate0Name, candidate1Name, candidate2Name);
            enableCheckBoxes(1, candidate0Box, candidate1Box, candidate2Box);
            enableButtons(1, backButton);
            selectCheckBoxes(0, candidate0Box, candidate1Box, candidate2Box);
            confirmVoteFrame.setVisible(false);
        });

        voteButton.addActionListener(voteButtonAction -> {
            if (selectedCandid == candidate0Box) {
                if (selectedOffice == SRCPresidentCheckBox) { presidentCandidate0.setNumberOfVotes(presidentCandidate0.getNumberOfVotes() + 1); }
                else if (selectedOffice == SRCSecretaryCheckBox) { secretaryCandidate0.setNumberOfVotes(secretaryCandidate0.getNumberOfVotes() + 1); }
                else if (selectedOffice == SRCTreasurerCheckBox) { treasurerCandidate0.setNumberOfVotes(treasurerCandidate0.getNumberOfVotes() + 1); }
            }

            else if (selectedCandid == candidate1Box) {
                if (selectedOffice == SRCPresidentCheckBox) { presidentCandidate1.setNumberOfVotes(presidentCandidate1.getNumberOfVotes() + 1); }
                else if (selectedOffice == SRCSecretaryCheckBox) { secretaryCandidate1.setNumberOfVotes(secretaryCandidate1.getNumberOfVotes() + 1); }
                else if (selectedOffice == SRCTreasurerCheckBox) { treasurerCandidate1.setNumberOfVotes(treasurerCandidate1.getNumberOfVotes() + 1); }
            }

            else if (selectedCandid == candidate2Box) {
                secretaryCandidate2.setNumberOfVotes(secretaryCandidate2.getNumberOfVotes() + 1);
            }

            confirmVoteFrame.setVisible(false);
            alertVoteSuccess();
        });

        OKButton.addActionListener(e -> {
            voteAlertFrame.setVisible(false);
            backToHome();
        });

        portfolioName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                errorLabel.setText("");
            }
        });

        viewAddedPortfolioButton.addActionListener(viewAddedPortfolio -> {
            addPortfolio(addedPortFolio0, new Portfolio("Hello"));
            swapView(addedPortFolioPane, candidatesPane, selectVoteOfficePane);
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("ATU Electoral Commission");
        frame.setContentPane(new SRCMain().mainPane);
        //frame.setJMenuBar(new SRCMain().MenuBar());
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
